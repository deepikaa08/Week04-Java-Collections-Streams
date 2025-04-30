import java.util.*;
import java.util.stream.Collectors;

public class BookRecommendationSystem {

    public static class Book {
        private String title;
        private String author;
        private String genre;
        private double rating;

        public Book(String title, String author, String genre, double rating) {
            this.title = title;
            this.author = author;
            this.genre = genre;
            this.rating = rating;
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        public String getGenre() {
            return genre;
        }

        public double getRating() {
            return rating;
        }

        @Override
        public String toString() {
            return "Book{title='" + title + "', rating=" + rating + "}";
        }
    }

    public static class BookRecommendation {
        private String title;
        private double rating;

        public BookRecommendation(String title, double rating) {
            this.title = title;
            this.rating = rating;
        }

        public double getRating() {
            return rating;
        }

        @Override
        public String toString() {
            return "BookRecommendation{title='" + title + "', rating=" + rating + "}";
        }
    }

    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
                new Book("Dune", "Frank Herbert", "Science Fiction", 4.5),
                new Book("Neuromancer", "William Gibson", "Science Fiction", 4.2),
                new Book("The Hobbit", "J.R.R. Tolkien", "Fantasy", 4.7),
                new Book("Foundation", "Isaac Asimov", "Science Fiction", 4.8),
                new Book("Hyperion", "Dan Simmons", "Science Fiction", 4.6),
                new Book("1984", "George Orwell", "Dystopian", 4.1),
                new Book("The Martian", "Andy Weir", "Science Fiction", 4.9),
                new Book("Brave New World", "Aldous Huxley", "Dystopian", 3.9),
                new Book("Fahrenheit 451", "Ray Bradbury", "Dystopian", 4.0),
                new Book("The Left Hand of Darkness", "Ursula K. Le Guin", "Science Fiction", 4.3),
                new Book("The Three-Body Problem", "Liu Cixin", "Science Fiction", 4.7)
        );

        List<Book> filteredBooks = books.stream()
                .filter(book -> "Science Fiction".equals(book.getGenre()) && book.getRating() > 4.0)
                .collect(Collectors.toList());

        List<BookRecommendation> bookRecommendations = filteredBooks.stream()
                .map(book -> new BookRecommendation(book.getTitle(), book.getRating()))
                .collect(Collectors.toList());

        List<BookRecommendation> sortedBookRecommendations = bookRecommendations.stream()
                .sorted(Comparator.comparing(BookRecommendation::getRating).reversed())
                .collect(Collectors.toList());

        int pageSize = 5;
        int pageNumber = 1; // for example, getting the first page
        List<BookRecommendation> paginatedResult = getPaginatedResults(sortedBookRecommendations, pageSize, pageNumber);

        System.out.println("Top 10 Book Recommendations (Page " + pageNumber + "):");
        paginatedResult.forEach(System.out::println);
    }

    public static List<BookRecommendation> getPaginatedResults(List<BookRecommendation> sortedList, int pageSize, int pageNumber) {
        int totalBooks = sortedList.size();
        int totalPages = (int) Math.ceil((double) totalBooks / pageSize); // Calculate total pages

        if (pageNumber > totalPages || pageNumber <= 0) {
            System.out.println("Invalid page number. Returning empty list.");
            return Collections.emptyList();
        }

        int fromIndex = (pageNumber - 1) * pageSize;
        int toIndex = Math.min(fromIndex + pageSize, totalBooks); // Ensure toIndex doesn't exceed the list size

        return sortedList.subList(fromIndex, toIndex);
    }
}
