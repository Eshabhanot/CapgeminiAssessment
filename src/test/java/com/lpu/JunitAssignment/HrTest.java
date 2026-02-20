package com.lpu.JunitAssignment;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class HrTest {
 Hr h = new Hr();
 
 
 @Test
 void testNormalSalary() {
	 assertEquals(53000,h.calculateSalary(50000, 5000, 2000));
 }
 
 
 @Test
 void testZeroBonusCase() {
	 assertEquals(38000,h.calculateSalary(40000, 0, 2000));
 }
 
 @Test
 void testHighTax() {
	 assertEquals(4000,h.calculateSalary(30000, 2000, 28000));
 }
 
 @Test
 void testNegateBasicSalary() {
	 assertThrows(IllegalArgumentException.class,()->{
		 h.calculateSalary(-10000, 1000, 200);
	 });
 }
 
 @Test
 void testTaxGreaterThanSalary() {
	 assertThrows(IllegalArgumentException.class,()->{
		 h.calculateSalary(20000, 0, 30000);
	 });
 }
 
 
 @Test
 void testBoundaryValue() {
	 assertEquals(1, h.calculateSalary(1, 0, 0));
 }

}
