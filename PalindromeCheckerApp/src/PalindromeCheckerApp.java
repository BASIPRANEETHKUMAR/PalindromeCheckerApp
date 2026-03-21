import java.util.*;

// Strategy Interface
interface PalindromeStrategy {
    boolean check(String str);
}

// Stack Strategy
class StackStrategy implements PalindromeStrategy {
    public boolean check(String str) {
        String s = str.replaceAll("\\s+", "").toLowerCase();
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

// Deque Strategy
class DequeStrategy implements PalindromeStrategy {
    public boolean check(String str) {
        String s = str.replaceAll("\\s+", "").toLowerCase();
        Deque<Character> deque = new LinkedList<>();

        for (char c : s.toCharArray())
            deque.addLast(c);

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast())
                return false;
        }
        return true;
    }
}

// Context Class
class PalindromeChecker {
    private PalindromeStrategy strategy;

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean checkPalindrome(String str) {
        return strategy.check(str);
    }
}

// Main Class
public class PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        PalindromeChecker checker = new PalindromeChecker();

        // Choose strategy dynamically
        System.out.println("Choose method: 1-Stack  2-Deque");
        int choice = sc.nextInt();

        if (choice == 1)
            checker.setStrategy(new StackStrategy());
        else
            checker.setStrategy(new DequeStrategy());

        // Execute
        if (checker.checkPalindrome(input))
            System.out.println("Palindrome");
        else
            System.out.println("Not Palindrome");

        sc.close();
    }
}