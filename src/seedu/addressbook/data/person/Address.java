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
    
    private static final int ADDRESS_DETAIL_COUNT = 4;
    private static final int ADDRESS_DETAIL_BLOCK = 0;
    private static final int ADDRESS_DETAIL_STREET = 1;
    private static final int ADDRESS_DETAIL_UNIT = 2;
    private static final int ADDRESS_DETAIL_POSTAL_CODE = 3;
    
    private final Block block;
    private final Street street;
    private final Unit unit;
    private final PostalCode postalCode;
    public final String value;
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
        this.block = new Block(addressDetails[ADDRESS_DETAIL_BLOCK].trim());
        this.street = new Street(addressDetails[ADDRESS_DETAIL_STREET].trim());
        this.unit = new Unit(addressDetails[ADDRESS_DETAIL_UNIT].trim());
        this.postalCode = new PostalCode(addressDetails[ADDRESS_DETAIL_POSTAL_CODE].trim());
        this.value = toString();
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
    	if (addressDetails.length == ADDRESS_DETAIL_COUNT) {
    		return addressDetails[ADDRESS_DETAIL_BLOCK] != null 
    				&& addressDetails[ADDRESS_DETAIL_STREET] != null
    				&& addressDetails[ADDRESS_DETAIL_UNIT] != null
    				&& addressDetails[ADDRESS_DETAIL_POSTAL_CODE] != null;
    	}
    	return false;
    }

    @Override
    public String toString() {
        return block.getBlock() + ", " 
        			+ street.getStreet() + ", "
        			+ unit.getUnit() + ", "
        			+ postalCode.getPostalCode();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.block.getBlock().equals(((Address) other).block.getBlock())
                && this.street.getStreet().equals(((Address) other).street.getStreet())
                && this.unit.getUnit().equals(((Address) other).unit.getUnit())
                && this.postalCode.getPostalCode().equals(((Address) other).postalCode.getPostalCode())); // state check
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}