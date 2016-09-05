package seedu.addressbook.data.person;

import static org.junit.Assert.*;
import seedu.addressbook.data.person.Name;

import seedu.addressbook.data.exception.IllegalValueException;

import org.junit.Test;

public class IsSimilarTest {
	
	@Test
	public void otherNameNull() throws IllegalValueException{
		Name name = new Name("JW");
		assertEquals(name.isSimilar(null), false);
	} 

}
