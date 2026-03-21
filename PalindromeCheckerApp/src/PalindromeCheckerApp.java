import java.util.*;

// Palindrome Checker Class
class PalindromeChecker {
    private String str;

    // Constructor
    public PalindromeChecker(String str) {
        this.str = str;
    }

    // Getter
    public String getString() {
        return str;
    }

    // Setter
    public void setString(String str) {
        this.str = str;
    }

    // Normalize string
    private String normalize() {
        return str.replaceAll("\\s+", "").toLowerCase();
    }

    // Two-pointer method
    public boolean checkPalindrome() {
        String s = normalize();
        int left = 0, right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }

    // Stack method
    public boolean checkUsingStack() {
        String s = normalize();
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray())
            stack.push(c);

        for (char c : s.toCharArray()) {
            if (c != stack.pop())
                return false;
        }
        return true;
    }
}

// Main Class (Renamed)
public class PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        PalindromeChecker checker = new PalindromeChecker(input);

        // Two-pointer result
        if (checker.checkPalindrome())
            System.out.println("Palindrome (Two Pointer)");
        else
            System.out.println("Not Palindrome (Two Pointer)");

        // Stack result
        if (checker.checkUsingStack())
            System.out.println("Palindrome (Stack)");
        else
            System.out.println("Not Palindrome (Stack)");

        sc.close();
    }
}