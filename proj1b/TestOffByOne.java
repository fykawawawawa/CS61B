import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void testCharacterComparator(){
//        int diff = 'l'-'k';
//        System.out.println(diff);
        assertTrue(offByOne.equalChars('k','l'));
    }
    // Uncomment this class once you've created your CharacterComparator interface and OffByOne class.

}
