public class PalindromeCheckerApp {

    static boolean isPalindrome(String str, int start, int end) {
        // Base condition
        if (start >= end)
            return true;

        // Check mismatch
        if (str.charAt(start) != str.charAt(end))
            return false;

        // Recursive call
        return isPalindrome(str, start + 1, end - 1);
    }

    public static void main(String[] args) {
        String str = "racecar";

        if (isPalindrome(str, 0, str.length() - 1))
            System.out.println("Palindrome");
        else
            System.out.println("Not Palindrome");
    }
}