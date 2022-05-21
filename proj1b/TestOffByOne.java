import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void testEqualChars() {
        assertTrue(offByOne.equalChars('A', 'B'));
        assertTrue(offByOne.equalChars('&', '%'));
        assertTrue(offByOne.equalChars('j', 'k'));
        assertTrue(offByOne.equalChars('M', 'N'));
        assertFalse(offByOne.equalChars('A', 'd'));
        assertFalse(offByOne.equalChars(' ', 'h'));
        assertFalse(offByOne.equalChars('J', 'm'));
        assertFalse(offByOne.equalChars('&', '('));
        assertFalse(offByOne.equalChars('d', 'd'));
        assertFalse(offByOne.equalChars('a', 'd'));
        assertFalse(offByOne.equalChars('A', 'M'));
    }
}
