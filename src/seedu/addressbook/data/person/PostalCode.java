package seedu.addressbook.data.person;

/**
 * Represents the postal code component of an address
 * 
 * @author JiaWern
 *
 */
public class PostalCode {
	private final String postalCode;
	
	public PostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	public String getPostalCode() {
		return postalCode;
	}
}
