import java.util.*;

class Program {
    public static String longestPalindromicSubstring(String str){
        String longestPalindrome = "";

        for(int i = 0; i < str.length(); i++){
            // Odd-length palindromes: treat each character as the center
            String oddPalindrome = expandSymmetricalSides(str, i, i);
            if(oddPalindrome.length() > longestPalindrome.length()){
                longestPalindrome = oddPalindrome;
            }

            // Even-length palindromes: treat the gap between consecutive characters as the center
            if(i + 1 < str.length()){
                String evenPalindrome = expandSymmetricalSides(str, i, i + 1);
                if(evenPalindrome.length() > longestPalindrome.length()){
                    longestPalindrome = evenPalindrome;
                }
            }
        }

        return longestPalindrome;
    }

    // Helper method to find out the possible longest palindrome
    private static String expandSymmetricalSides(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }

    // Main method
    public static void main(String[] args){
        String inputString = "abaxyzzyxf";
        String longestPalindrome = longestPalindromicSubstring(inputString);
        System.out.println(longestPalindrome);
    }
}
