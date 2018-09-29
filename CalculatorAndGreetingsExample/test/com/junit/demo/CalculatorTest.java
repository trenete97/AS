package com.junit.demo;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
 
public class CalculatorTest {
 
 private Calculator calc;
  
 @Before
 public void setUp() throws Exception {
  calc = new Calculator();
 }
 
 @After
 public void tearDown() throws Exception {
  calc = null;
 }
 
 @Test
 public void testMultiply() {
  double result = calc.multiply(2.5, 100);
  assertEquals(250, result, 0);
 }
 
 @Test
 public void testDivide() {
  double result = calc.divide(100, 10);
  assertEquals(10, result, 0);
   
 }
 
 @Test
 public void testDivideWithTolerance() {
  double result = calc.divide(345, 100);
  assertEquals(3.4, result, 0.1);
   
 }
 @Test
 public void testResta() {
  double result = calc.resta(345, 100);
  assertEquals(245, result, 1);
   
 }
 @Test
 public void testRestaNeg() {
	  double result = calc.resta(345, 500);
	  assertEquals(-155, result, 1);
	   
	 }
 @Test
 public void testSuma() {
  double result = calc.suma(345, 100);
  assertEquals(445, result, 1);
   
 }
 @Test
 public void testSumaNeg() {
  double result = calc.suma(-345, 100);
  assertEquals(-245, result, 1);
   
 }
  
 @Test(expected = ArithmeticException.class)
 public void testDivideByZero() {
  calc.divide(100.5, 0);
 }
 @Test
 public void factorial0() {
	 int result = calc.factorial(0);
	 assertEquals(1, result, 1);
	}
 
 @Test
 public void factorial() {
	 int result = calc.factorial(5);
	 assertEquals(120, result, 1);
	}
 @Test(expected = ArithmeticException.class)
 public void factorialNeg() {
  calc.factorial(-5);
 }
}
