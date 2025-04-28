import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringUtility {
    public static String reverse(String str){
        if(str == null)
            return null;
        return new StringBuilder(str).reverse().toString();
    }
    public static boolean isPalindrome(String str){
        if(str == null)
            return false;
        String reversed = reverse(str);
        return str.equals(reversed);
    }
    public static String toUpperCase(String str){
        if(str == null)
            return null;
        return str.toUpperCase();
    }

    @Test
    public void testReverse(){
        assertEquals("cba", reverse("abc"));
        assertEquals("", reverse(""));
        assertNull(reverse(null));
    }

    @Test
    public void testIsPalindrome(){
        assertTrue(isPalindrome("madam"));
        assertTrue(isPalindrome("racecar"));
        assertFalse(isPalindrome("hello"));
        assertFalse(isPalindrome(null));
    }

    @Test
    public void testToUpperCase(){
        assertEquals("HELLO", toUpperCase("hello"));
        assertEquals("", toUpperCase(""));
        assertNull(reverse(null));
    }
}
