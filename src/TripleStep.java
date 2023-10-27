//8.1 Triple Step: A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3
//steps at a time. Implement a method to count how many possible ways the child can run up the
//stairs.

public class TripleStep {
    public static int countWays(int n) {
        if (n < 0) {
            return 0;
        } else if (n <= 1) {
            return 1;
        } else {
            int[] memo = new int[n + 1];
            memo[0] = 1;
            memo[1] = 1;
            memo[2] = 2;

            for (int i = 3; i <= n; i++) {
                memo[i] = memo[i - 1] + memo[i - 2] + memo[i - 3];
            }

            return memo[n];
        }
    }

    public static void main(String[] args) {
        int n = 5; // Change this to the desired number of steps
        int ways = countWays(n);
        System.out.println("Number of ways to reach the " + n + "th step: " + ways);
    }
}
