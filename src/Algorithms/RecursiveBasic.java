package Algorithms;

/**
 * 
 * @apiSpec Head Recursive: the 1st statement of the function is the recursive call
 *          Tail Recursive: the last statement of the function is the recursive call
 *          Middle recursive: in the middle is the recursive call.
 * @author Darren Zhao Xie
 * @date Apr 19, 2020 Created
 *
 */
public class RecursiveBasic {

    // Fibonacci list sum
    public int fibonacci(int n) {
        if(n <= 2) return 1;
        return fibonacci(n-1) + fibonacci(n-2);
    }
    
    // Factorial: Head Recursive
    public int factorial(int n) {
        if(n == 1) return 1;
        return n * factorial(n - 1);
    }
    
    // Factorial: Tail Recursive - to enable the compiler to minimize stack
    public int factorialTail(int n) {
        if(n == 0) return 1;
        return factorialRecursive(n, 1);
    }
    
    // tool for factorialTail()
    public int factorialRecursive(int currNum, int sum) {
        if(currNum == 1) return sum;
        return factorialRecursive(currNum - 1, sum * currNum);
    }

    // GCD - Greatest Common Divisor
    public int gcd(int p, int q) {
        if(q == 0) return p;
        return gcd(q, p%q);
    }
}
