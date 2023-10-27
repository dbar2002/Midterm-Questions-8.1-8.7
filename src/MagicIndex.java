//8.3 A magic index in an array A [ 0 ••• n -1] is defined to be an index such that A[ i] =
//i. Given a sorted array of distinct integers, write a method to find a magic index, if one exists, in
//array A.
//FOLLOW UP
//What if the values are not distinct?

public class MagicIndex {
    public static int findMagicIndexDistinct(int[] arr) {
        return findMagicIndexDistinct(arr, 0, arr.length - 1);
    }

    public static int findMagicIndexDistinct(int[] arr, int start, int end) {
        if (end < start) {
            return -1; // No magic index found
        }

        int mid = (start + end) / 2;
        int midValue = arr[mid];

        if (mid == midValue) {
            return mid; // Magic index found
        } else if (midValue > mid) {
            // Search the left half of the array
            return findMagicIndexDistinct(arr, start, mid - 1);
        } else {
            // Search the right half of the array
            return findMagicIndexDistinct(arr, mid + 1, end);
        }
    }

    public static void main(String[] args) {
        int[] arr = {-10, -5, 2, 2, 2, 3, 4, 7, 9, 12, 13};
        int magicIndex = findMagicIndexDistinct(arr);
        if (magicIndex != -1) {
            System.out.println("Magic index is at " + magicIndex);
        } else {
            System.out.println("No magic index found.");
        }
    }

}
