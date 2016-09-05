package seedu.addressbook.common;

import static org.junit.Assert.*;

import java.util.ArrayList;

import seedu.addressbook.common.Utils;

import org.junit.Test;

public class UtilsTest {
	private Utils utils = new Utils();
	
	@Test
	public void input_nullObjects_returnsTrue() {
		final String[] emptyInput = {null, "a"};
		assertEquals(utils.isAnyNull(emptyInput), true);
	}
	
	@Test
	public void input_noNullObjects_returnsFalse() {
		final String[] noEmptyInput = {"b", "a"};
		assertEquals(utils.isAnyNull(noEmptyInput), false);
	}
	
	@Test
	public void input_repeatedObjects_returnsFalse() {
		ArrayList<Integer> repeatedInput = new ArrayList<Integer>();
		repeatedInput.add(1);
		repeatedInput.add(2);
		repeatedInput.add(2);
		assertEquals(utils.elementsAreUnique(repeatedInput), false);
	}
	
	@Test
	public void input_noRepeatedObjects_returnsTrue() {
		ArrayList<Integer> repeatedInput = new ArrayList<Integer>();
		repeatedInput.add(1);
		repeatedInput.add(2);
		repeatedInput.add(3);
		assertEquals(utils.elementsAreUnique(repeatedInput), true);
	}

}
