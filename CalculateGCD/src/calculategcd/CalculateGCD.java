/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculategcd;

import java.util.LinkedList;

/**
 *
 * @author mexxw
 */
public class CalculateGCD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int testOneA = 1771;
        int testOneB = 4531;
        int result = gcdEuclidian(testOneA,testOneB);
        System.out.format("Euclid: The GCD of %d and %d is %d.\n",testOneA,testOneB,result);
        result = gcdPrimes(testOneA,testOneB);
        System.out.format("PrimeFactors: The GCD of %d and %d is %d.\n",testOneA,testOneB,result);
        //
        int testTwoA = 867;
        int testTwoB = 1967;
        result = gcdEuclidian(testTwoA,testTwoB);
        System.out.format("Euclid: The GCD of %d and %d is %d.\n",testTwoA,testTwoB,result);
        result = gcdPrimes(testTwoA,testTwoB);
        System.out.format("PrimeFactors: The GCD of %d and %d is %d.\n",testTwoA,testTwoB,result);
        //
        int testThreeA = 42;
        int testThreeB = 84;
        result = gcdEuclidian(testThreeA,testThreeB);
        System.out.format("Euclid: The GCD of %d and %d is %d.\n",testThreeA,testThreeB,result);
        result = gcdPrimes(testThreeA,testThreeB);
        System.out.format("PrimeFactors: The GCD of %d and %d is %d.\n",testThreeA,testThreeB,result);
        //
        int testFourA = 75;
        int testFourB = 125;
        result = gcdEuclidian(testFourA,testFourB);
        System.out.format("Euclid: The GCD of %d and %d is %d.\n",testFourA,testFourB,result);
        result = gcdPrimes(testFourA,testFourB);
        System.out.format("PrimeFactors: The GCD of %d and %d is %d.\n",testFourA,testFourB,result);       
    }
    /**
     * calculates the gcd of two numbers with the euclidian algorithm
     * @param testOneA
     * @param testOneB
     * @return integer representing the gcd of a and b
     */
    private static int gcdEuclidian(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcdEuclidian(b,a%b);
    }
    /**
     * calculates the gcd of two numbers with the prime factors
     * @param testOneA
     * @param testOneB
     * @return integer representing the gcd of a and b
     */
    private static int gcdPrimes(int a, int b) {
        LinkedList<Integer> factorsA = new LinkedList<>();
        LinkedList<Integer> factorsB = new LinkedList<>();
        int divider = 2;
        while(a >1){
            if (a%divider == 0) {
                a /= divider;
                factorsA.add(divider);
            }
            else {
                divider = getNextPrime(divider);
            }
        }
        divider = 2;
        while(b >1){
            if (b%divider == 0) {
                b /= divider;
                factorsB.add(divider);
            }
            else {
                divider = getNextPrime(divider);
            }
        }
        int iterator = 0;
        int gcd = 1;
        while(iterator < factorsA.size())
        {
            if (factorsB.contains(factorsA.get(iterator))) {
                gcd *= factorsA.get(iterator);
                factorsB.removeFirstOccurrence(factorsA.get(iterator));
                factorsA.remove(iterator);
            }
            else{
                iterator++;
            }
        }
        return gcd;
    }
    /**
     * gets the next greater prime number
     * @param prime
     * @return returns the next greater prime numbe
     */
    private static int getNextPrime(int prime) {
        int newPrime = prime+1;
        while(!isPrime(newPrime)){
            newPrime++;
        }
        return newPrime;
    }
    /**
     * checks if an int is prime
     * @param newPrime
     * @return true, if int is prime,false when not
     */
    private static boolean isPrime(int newPrime) {
        for (int i = 2; i <= newPrime / 2; i++){
            if (newPrime % i == 0) {
                return false;
            }
        }
        return true;
    }
}
