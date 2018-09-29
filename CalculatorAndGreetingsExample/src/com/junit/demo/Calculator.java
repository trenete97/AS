package com.junit.demo;


public class Calculator {
		  
		 public double multiply(double a, double b) {
		  return a * b;
		 }
		 
		 public double suma(double a, double b) {
			  return a + b;
			 }
		 
		 public double resta(double a, double b) {
			  return a - b;
		 	}
		  
		 public double divide(double a, double n) { 
		  if(zero(n)) {
		   throw new ArithmeticException();
		  }
		  return a / n;
		 }

		private boolean zero(double n) {
			return n == 0;
		} 
		 public int factorial(int n) {
			  int res = 1;
			  if(zero(n)) return 1;
			  else if (n > 0){
				  for (int i = 2; i <= n; ++i) res *= i;
			  }
			  else throw new ArithmeticException();
			  return res;
		 	}
		}
