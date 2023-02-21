import java.util.StringTokenizer;

public class Lesson10 {
    // Additional HW
    // Compress a string using the following rule: aaabcccccdd = a3bc5d2
    public static void main(String[] args) {
        String[] array = new String[]{"max", "maximum", "maximus"};
        String[] array2 = new String[]{"applexx", "applex", "applexication"};
        String[] array3 = new String[]{"ape", "apee", "aplication"};
        System.out.println(isLongestCommonPrefix01(array3));
        System.out.println(longestCommonPrefix(array3));
    }

    // In a given array of Strings, find the longest common prefix.
    // {ape, apple, application} -> ap
    // {maximum, maximus, max} -> max
    // {abc, something, whatever}
    private static String longestCommonPrefix(String[] words) {
        String shortest = words[0];
        for (int i = 1; i < words.length; i++) {
            if (words[i].length() < shortest.length()) {
                shortest = words[i];
            }
        }
        while (true) {
            boolean foundMismatch = false;
            for (int i = 0; i < words.length; i++) {
                if (!words[i].startsWith(shortest)) {
                    shortest = shortest.substring(0, shortest.length() - 1);
                    foundMismatch = true;
                    break;
                }
            }
            if (!foundMismatch) {
                return shortest;
            }
        }
    }

    public static String isLongestCommonPrefix01(String[] strs) {

        for (int i = 0; i < strs[0].length(); i++) {
            char a = strs[0].charAt(i);
            for (int j = 0; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != a) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    private static void stringFormat() {
        String name = "Milan";
        int age = 29;
        double height = 184.23123123213123;
        System.out.println("Name: " + name + " age: " + age + " height: " + height);
        System.out.println(String.format("Name: %s age: %d height: %.2f", name, age, height));
    }

    private static boolean isPalindrome(String output) {
        StringBuilder sb = new StringBuilder(output);
        String normal = sb.toString();
        return normal.equals(sb.reverse().toString());
    }

    private static void stringTokenizerExample() {
        String sentence = "this is a sentence";
        String[] words = sentence.split(" ");
        System.out.println(words[2]);
        StringTokenizer stringTokenizer = new StringTokenizer(sentence, " ");
        while (stringTokenizer.hasMoreTokens()) {
            System.out.println(stringTokenizer.nextToken());
        }
    }
    // Number systems

    // 0123456789 -> decimal
    // 01 -> binary

    // 29068 = 2 * 10000 + 9 * 1000 + 0 * 100 + 6 * 10 + 8 * 1
    // 43210
    // = 2 * 10^4 + 9 * 10^3 + 0 * 10^2 + 6 * 10^1 + 8 * 10^0

    // 110 -> 1 * 2^2 + 1 * 2^1 + 0 * 2^0 = 6
    // 210

    // 11010 = 2 + 8 + 16 = 26

    // 1 2 4 8 16 32 64
    // 25 -> 16 + 9 -> 16 + 8 + 1
    // 11001

    // 0123456789ABCDEF -> 16 is our base
    // 1 16 256 ...
    // 65 -> 4 * 16 + 1 -> 41
    // 162 -> 16 * 10 -> A2
}
