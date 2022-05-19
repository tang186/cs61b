import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void testEqualChars() {
        assertTrue(offByOne.equalChars('a', 'b'));
        assertTrue(offByOne.equalChars('c', 'd'));
        assertTrue(offByOne.equalChars('j', 'k'));
        assertTrue(offByOne.equalChars('m', 'n'));
        assertFalse(offByOne.equalChars('a', 'd'));
        assertFalse(offByOne.equalChars('v', 'h'));
        assertFalse(offByOne.equalChars('j', 'm'));
        assertFalse(offByOne.equalChars('d', 'o'));
        assertFalse(offByOne.equalChars('d', 'd'));
    }
}
