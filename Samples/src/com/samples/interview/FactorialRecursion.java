package com.samples.interview;

public class FactorialRecursion {

	public static void main(String[] args) {
		System.out.println(factorial(5));
	}
	
	public static int factorial(int n) {
		int k=0;
		if (n>=1) {
			k = n * factorial (n-1);			
		} else {
			return 1;
		}
		return k;
	}

}
