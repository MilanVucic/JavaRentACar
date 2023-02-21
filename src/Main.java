public class Main {
    // Additional HW:
    // Reverse the words in a given string.
    // hello there i am from serbia
    // serbia from am i there hello

    // In a given array of Strings, find the longest common prefix.
    // {ape, apple, application} -> ap
    // {max, maximum, maximus} -> max
    public static void main(String[] args) {
        System.out.println(isPalindrome2("abccba"));
        System.out.println(isPalindrome2("abcdfghjjhgfdcba"));
    }

    // Check if a string is a palindrome.
    private static boolean isPalindrome(String input) {
        // manam
        input = input.toLowerCase();
        String reversed = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed += input.charAt(i);
        }

        return input.equals(reversed);
    }
    // Check if a string is a palindrome (better)
    private static boolean isPalindrome2(String input) {
        input = input.toLowerCase();

        // 0123456789 -> length = 10
        // 0 - 9 -> ... 0 <> 9
        // 1 - 8 ->     1 <> 9-1
        // 2 -> 7 ...   2 <> 9-2
        for (int i = 0; i < input.length() / 2; i++) {
            char firstLetter = input.charAt(i);
            char lastLetter = input.charAt(input.length() - 1 - i);
            if (firstLetter != lastLetter) {
                return false;
            }
        }

        return true;
    }
}