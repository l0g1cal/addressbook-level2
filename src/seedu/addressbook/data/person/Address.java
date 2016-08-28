package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "a/123, Clementi Ave 3, #12-34, 231534";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses must be in the format "
    														+ "\"a/BLOCK, STREET, UNIT, POSTAL CODE\"";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";

    public final String value;
    private final Block block;
    private final Street street;
    private final Unit unit;
    private final PostalCode postalCode;
    private boolean isPrivate;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        this.isPrivate = isPrivate;
        if (!isValidAddress(address)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        String[] addressDetails = splitAddress(address);
        this.block = new Block(addressDetails[0]);
        this.street = new Street(addressDetails[1]);
        this.unit = new Unit(addressDetails[2]);
        this.postalCode = new PostalCode(addressDetails[3]);
        this.value = address;
    }
    
    private static String[] splitAddress(String address) {
    	String[] addressDetails = address.split(",");
    	return addressDetails;
    }
    
    /**
     * Returns true if a given string is a valid person email.
     */
    public static boolean isValidAddress(String test) {
    	String[] addressDetails = splitAddress(test);
    	if (addressDetails.length == 4) {
    		return addressDetails[0] == null 
    				&& addressDetails[1] == null
    				&& addressDetails[2] == null
    				&& addressDetails[3] == null;
    	}
    	return false;
    }

    @Override
    public String toString() {
        return "a/" + block.getBlock() + ", " 
        			+ street.getStreet() + ", "
        			+ unit.getUnit() + ", "
        			+ postalCode.getPostalCode();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.value.equals(((Address) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}