import org.junit.Test;
import static org.junit.Assert.*;
public class TestOffByN {
    static CharacterComparator offBy4 = new OffByN(4); 
    
    @Test
    public void testOffBy4() {
        assertTrue(offBy4.equalChars('a', 'e'));
        assertTrue(offBy4.equalChars('i', 'e'));
        assertTrue(offBy4.equalChars('i', 'm'));
        assertTrue(offBy4.equalChars('m', 'q'));
        assertFalse(offBy4.equalChars('a', 'q'));
        assertFalse(offBy4.equalChars('a', 'z'));
        assertFalse(offBy4.equalChars('a', 'p'));
        assertFalse(offBy4.equalChars('a', 'o'));
    }
}
