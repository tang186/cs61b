import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        CharacterComparator cc = new OffByOne();
        assertEquals("persiflage", actual);

        assertFalse(palindrome.isPalindrome("cat"));
        assertTrue(palindrome.isPalindrome("echoohce"));

        assertFalse(palindrome.isPalindrome("echoohce", cc));
        assertTrue(palindrome.isPalindrome("flake", cc));

    }
    //Uncomment this class once you've created your Palindrome class.
}
