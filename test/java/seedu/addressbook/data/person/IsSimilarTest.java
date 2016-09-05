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
	
	@Test
	public void differentOtherName() throws IllegalValueException{
		Name name = new Name("JW");
		Name other = new Name("MA");
		assertEquals(name.isSimilar(other), false);
	}
	
	@Test
	public void sameOtherName() throws IllegalValueException{
		Name name = new Name("JW");
		Name other = new Name("JW");
		assertEquals(name.isSimilar(other), true);
	}
	
	@Test
	public void sameOtherNameDifferentCase() throws IllegalValueException{
		Name name = new Name("JW");
		Name other = new Name("Jw");
		assertEquals(name.isSimilar(other), true);
	}
}
