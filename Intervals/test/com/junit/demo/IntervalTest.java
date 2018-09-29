package com.junit.demo;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
 
public class IntervalTest {
 
 private Interval i;
  
 @Before
 public void setUp() throws Exception {
  i = new Interval(1,2,3,44);
 }
 
 @After
 public void tearDown() throws Exception {
  i = null;
 }
 
 @Test(expected = ArithmeticException.class)
 public void testmin() {
	 i = new Interval(1,2,3,444);
 }
 
 @Test(expected = ArithmeticException.class)
 public void testhores() {
	 i = new Interval(1,2,30,44);
 }
 @Test(expected = ArithmeticException.class)
 public void testhoresJust() {
	 i = new Interval(1,2,24,1);
 }
 @Test(expected = ArithmeticException.class)
 public void testhoraanterior() {
	 i = new Interval(3,2,1,44);
 }
 @Test
 public void testhoraanteriortemps() {
	 int r = i.temps(2,4,1,1);
 }
 @Test(expected = ArithmeticException.class)
 public void testmintemps() {
	 int r = i.temps(1,2,3,444);
 }
 
 @Test(expected = ArithmeticException.class)
 public void testhorestemps() {
	 int r = i.temps(1,2,30,44);
 }
 @Test(expected = ArithmeticException.class)
 public void testhoresJusttemps() {
	 int r = i.temps(1,2,24,1);
 }
 @Test
 public void testBetemps() {
	 int r = i.temps(2,4,5,10);
	 assertEquals(186,r,0);
 }

 @Test(expected = ArithmeticException.class)
 public void testminperdiode() {
	 String r = i.periode(1,2,3,444);
 }
 
 @Test(expected = ArithmeticException.class)
 public void testhoresperiode() {
	 String r = i.periode(1,2,30,44);
 }
 @Test(expected = ArithmeticException.class)
 public void testhoresJustperdiode() {
	 String r = i.periode(1,2,24,1);
 }
 @Test
 public void testMatiperiode() {
	 String r = i.periode(8,4,10,10);
	 assertEquals("Matí",r,0);
 }
 @Test
 public void testMesdunperiode() {
	 String r = i.periode(8,4,22,10);
	 assertEquals("Més d'un periode",r,0);
 }
 @Test
 public void testTardaperiode() {
	 String r = i.periode(13,4,15,10);
	 assertEquals("Tarda",r,0);
 }
 @Test
 public void testNitperiode() {
	 String r = i.periode(22,4,1,10);
	 assertEquals("Nit",r,0);
 }
 @Test
 public void testanteriorperiode() {
	 String r = i.periode(23,4,22,10);
	 assertEquals("Més d'un periode",r,0);
 }
}
