import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat {

    static class DateFormatter {
        public static String formatDate(String inputDate) throws ParseException {
            SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
            inputFormat.setLenient(false); // strict parsing

            SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");

            Date date = inputFormat.parse(inputDate);
            return outputFormat.format(date);
        }
    }


    @Test
    public void testValidDate() throws ParseException {
        assertEquals("25-12-2023", DateFormatter.formatDate("2023-12-25"));
        assertEquals("01-01-2000", DateFormatter.formatDate("2000-01-01"));
    }

    @Test
    public void testInvalidDateFormat() {
        assertThrows(ParseException.class, () -> {
            DateFormatter.formatDate("12/25/2023");
        });

        assertThrows(ParseException.class, () -> {
            DateFormatter.formatDate("25-12-2023");
        });

        assertThrows(ParseException.class, () -> {
            DateFormatter.formatDate("2023/12/25");
        });
    }

    @Test
    public void testInvalidLogicalDate() {
        assertThrows(ParseException.class, () -> {
            DateFormatter.formatDate("2023-02-30"); // invalid day
        });

        assertThrows(ParseException.class, () -> {
            DateFormatter.formatDate("abcd-ef-gh"); // non-numeric
        });
    }
}
