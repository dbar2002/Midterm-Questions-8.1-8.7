//8.4 Power Set: Write a method to return all subsets of a set.

import java.util.ArrayList;
import java.util.List;

public class PowerSet {
    public static List<List<Integer>> getSubsets(List<Integer> set) {
        List<List<Integer>> allSubsets = new ArrayList<>();
        generateSubsets(set, 0, new ArrayList<Integer>(), allSubsets);
        return allSubsets;
    }

    private static void generateSubsets(List<Integer> set, int index, List<Integer> currentSubset, List<List<Integer>> allSubsets) {
        if (index == set.size()) {
            allSubsets.add(new ArrayList<>(currentSubset));
            return;
        }

        // Include the current element in the subset
        currentSubset.add(set.get(index));
        generateSubsets(set, index + 1, currentSubset, allSubsets);

        // Exclude the current element from the subset
        currentSubset.remove(currentSubset.size() - 1);
        generateSubsets(set, index + 1, currentSubset, allSubsets);
    }

    public static void main(String[] args) {
        List<Integer> inputSet = new ArrayList<>();
        inputSet.add(1);
        inputSet.add(2);
        inputSet.add(3);

        List<List<Integer>> subsets = getSubsets(inputSet);

        for (List<Integer> subset : subsets) {
            System.out.print("{ ");
            for (int num : subset) {
                System.out.print(num + " ");
            }
            System.out.println("}");
        }
    }
}
