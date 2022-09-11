import static org.junit.Assert.*;
import org.junit.Test;

public class TestOffByN {
    static OffByN offBy4 = new OffByN(4);
    @Test
    public void testCharacterComparator(){
        boolean test = offBy4.equalChars('c','a');
        assertTrue(test);
    }
}
