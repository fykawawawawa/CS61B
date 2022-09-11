public class Palindrome {
    public Deque<Character> wordToDeque(String word){
        Deque<Character> myDeque = new LinkedListDeque<Character>();
        for(int i=0;i<word.length();i++){
            myDeque.addLast(word.charAt(i));
        }
        return myDeque;
    }
    public boolean isPalindrome(String word) {
        //iteration
        Deque<Character> wordDeque = wordToDeque(word);
        if (wordDeque.size() == 0)
            return false;
        while (wordDeque.size() != 0 && wordDeque.size() != 1) {
            if (wordDeque.getFirst() != wordDeque.getLast())
                return false;
            wordDeque.removeFirst();
            wordDeque.removeLast();
        }
        return true;
    }
        //recursion
//        Deque<Character> wordDeque =wordToDeque(word);
//        if(wordDeque.size()==0)
//            return false;
//        return isPalindromeHelper(wordDeque);
//
//    }
//    public boolean isPalindromeHelper(Deque<Character> wordDeque){
//        if(wordDeque.size()==0 ||wordDeque.size()==1)
//            return true;
//        if(wordDeque.getFirst()==wordDeque.getLast()){
//            wordDeque.removeFirst();
//            wordDeque.removeLast();
//            return isPalindromeHelper(wordDeque);
//        }
//        return false;
//    }
    public boolean isPalindrome(String word, CharacterComparator cc){
        int length=word.length();
        if(length==0)
            return false;
        for(int i=0;i<length/2;i++){
            if(!cc.equalChars(word.charAt(i),word.charAt(length-1-i))){
                return false;
            }
        }
        return true;
    }
}
