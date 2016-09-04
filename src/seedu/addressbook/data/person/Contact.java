package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

public class Contact {
	
	private boolean isPrivate;
	public String value;
	
	public Contact(String contact, boolean isPrivate) throws IllegalValueException {
        this.isPrivate = isPrivate;
        contact = contact.trim();
        this.value = contact;
    }
	
	/**
     * Checks if a given string is a valid person contact.
     */
    public boolean isValidContact(String test, String validationRegex) {
        return test.matches(validationRegex);
    }
		
    @Override
    public String toString() {
        return value;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }


    public boolean isPrivate() {
        return isPrivate;
    }
}
