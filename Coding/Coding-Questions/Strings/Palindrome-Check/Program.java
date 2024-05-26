class Program {
	public static boolean isPalindrome(String str){
		return isPalindrome(str, 0);
	}
	
	public static boolean isPalindrome(String str, int left){
		// Get the index of the right end
		int right = str.length() - 1 - left;
		
		// If any mismatch is found, the string is not a palindrome
		if(str.charAt(left) != str.charAt(right)){
			return false;
		}
		
		// If both left and right have met or crossed,that means all checks have passed
		// The string is a palindrome
		if(left >= right){
			return true;
		} else {
			// Otherwise, continue to check
			return isPalindrome(str, ++left);
		}
	}
}