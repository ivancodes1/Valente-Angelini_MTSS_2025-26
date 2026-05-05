////////////////////////////////////////////////////////////////////
// IVAN VALENTE 2147985
// MATTEO ANGELINI 2101737
////////////////////////////////////////////////////////////////////

package it.unipd.mtss;

import static org.junit.Assert.*;

import org.junit.Test;

public class IntegerToRomanTest {
	@Test
	public void TestOneThroughThree() {
		String Expected = "";
		for (int num = 1; num <= 3; ++num) {
			Expected += "I";
			String RomanNum = IntegerToRoman.convert(num);
			assertEquals(Expected, RomanNum);
		}
	}

	@Test (expected = IllegalArgumentException.class)
	public void TestLessThanOne() {
		IntegerToRoman.convert(0);
	}

	@Test (expected = IllegalArgumentException.class)
	public void TestMoreThanThree() {
		IntegerToRoman.convert(4);
	}

}
//