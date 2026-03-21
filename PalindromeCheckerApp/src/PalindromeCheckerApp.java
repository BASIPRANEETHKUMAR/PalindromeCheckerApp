import java.util.*;

public class PalindromeCheckerApp {

    // Normalize string (remove spaces & lowercase)
    static String normalize(String str) {
        return str.replaceAll("\\s+", "").toLowerCase();
    }

    // Method 1: Two-pointer
    static boolean twoPointer(String str) {
        String s = normalize(str);
        int left = 0, right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }

    // Method 2: Stack
    static boolean usingStack(String str) {
        String s = normalize(str);
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray())
            stack.push(c);

        for (char c : s.toCharArray()) {
            if (c != stack.pop())
                return false;
        }
        return true;
    }

    // Method 3: Deque
    static boolean usingDeque(String str) {
        String s = normalize(str);
        Deque<Character> deque = new LinkedList<>();

        for (char c : s.toCharArray())
            deque.addLast(c);

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast())
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Two Pointer Timing
        long start1 = System.nanoTime();
        boolean res1 = twoPointer(input);
        long end1 = System.nanoTime();

        // Stack Timing
        long start2 = System.nanoTime();
        boolean res2 = usingStack(input);
        long end2 = System.nanoTime();

        // Deque Timing
        long start3 = System.nanoTime();
        boolean res3 = usingDeque(input);
        long end3 = System.nanoTime();

        // Display Results
        System.out.println("\n--- Performance Comparison ---");

        System.out.println("Two Pointer: " + (res1 ? "Palindrome" : "Not Palindrome"));
        System.out.println("Execution Time: " + (end1 - start1) + " ns");

        System.out.println("\nStack: " + (res2 ? "Palindrome" : "Not Palindrome"));
        System.out.println("Execution Time: " + (end2 - start2) + " ns");

        System.out.println("\nDeque: " + (res3 ? "Palindrome" : "Not Palindrome"));
        System.out.println("Execution Time: " + (end3 - start3) + " ns");

        sc.close();
    }
}