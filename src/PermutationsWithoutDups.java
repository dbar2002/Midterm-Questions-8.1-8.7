//8.7 Permutations without Dups: Write a method to compute all permutations of a string of unique characters.

import java.util.ArrayList;
import java.util.List;

public class PermutationsWithoutDups {
    public static List<String> getPermutations(String str) {
        List<String> permutations = new ArrayList<>();
        generatePermutations("", str, permutations);
        return permutations;
    }

    private static void generatePermutations(String prefix, String remaining, List<String> permutations) {
        int n = remaining.length();
        if (n == 0) {
            permutations.add(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                String before = remaining.substring(0, i);
                String after = remaining.substring(i + 1);
                char current = remaining.charAt(i);
                generatePermutations(prefix + current, before + after, permutations);
            }
        }
    }

    public static void main(String[] args) {
        String input = "abc"; // Change this to your input string
        List<String> result = getPermutations(input);

        System.out.println("Permutations of " + input + ":");
        for (String permutation : result) {
            System.out.println(permutation);
        }
    }
}

