//8.5 Recursive Multiply: Write a recursive function to multiply two positive integers without using the
//*operator.You can use addition, subtraction, and bit shifting, but you should minimize the number
//of those operations.

public class RecursiveMultiply {
    public static int multiply(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        } else if (b < 0) {
            return -multiply(a, -b);
        } else {
            return multiplyHelper(a, b);
        }
    }

    private static int multiplyHelper(int a, int b) {
        if (b == 1) {
            return a;
        } else if (b % 2 == 0) {
            int halfProduct = multiplyHelper(a, b >> 1);
            return halfProduct + halfProduct;
        } else {
            int halfProduct = multiplyHelper(a, b >> 1);
            return halfProduct + halfProduct + a;
        }
    }

    public static void main(String[] args) {
        int a = 5;
        int b = 4;
        int result = multiply(a, b);
        System.out.println(a + " * " + b + " = " + result);
    }
}
