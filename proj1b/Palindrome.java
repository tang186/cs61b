public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> ans = new ArrayDeque<>();
        for (int i = 0; i < word.length(); i++) {
            ans.addLast(word.charAt(i));
        }
        return ans;
    }
    public boolean isPalindrome(String word) {
        /**Deque<Character> d = wordToDeque(word);
        while (d.size() > 1) {
            if (d.removeFirst() != d.removeLast()) {
                return false;
            }
        }*/

        if (word.length() <= 1) {
            return true;
        }
        for (int i = 0; i < ((int) (word.length() / 2)); i++) {
            if (word.charAt(i) != word.charAt(word.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
    public boolean isPalindrome(String word, CharacterComparator cc) {
        /**Deque<Character> d = wordToDeque(word);
        while (d.size() > 1) {
            if (!cc.equalChars(d.removeFirst(), d.removeLast())) {
                return false;
            }
        }*/

        if (word.length() <= 1) {
            return true;
        }
        for (int i = 0; i < ((int) (word.length() / 2)); i++) {
            if (!cc.equalChars(word.charAt(i), word.charAt(word.length() - i - 1))) {
                return false;
            }
        }
        return true;
    }
}
