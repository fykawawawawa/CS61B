import org.junit.Test;
import static org.junit.Assert.*;

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
        assertEquals("persiflage", actual);
    }

    static CharacterComparator offByOne = new OffByOne();

    @Test
    public void testIsPalindrome(){
//        Deque d = palindrome.wordToDeque('cat');
//        String actual ="";
//        for(int i=0;i<'cat'.length();i++){
//            actual += d.removeFirst();
//        }
        boolean test1 = palindrome.isPalindrome("acba");
        assertTrue(test1);
        boolean test2 = palindrome.isPalindrome("flake",offByOne);
        assertTrue(test2);
    }
    //Uncomment this class once you've created your Palindrome class.
}
