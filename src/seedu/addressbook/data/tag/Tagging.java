package seedu.addressbook.data.tag;

import seedu.addressbook.data.person.*;

public class Tagging {

	private boolean isAdded = false;
	private Name name;
	private Tag tag;
	private String list = "";
	
	public Tagging(Person person, Tag tag, boolean isAdded) {
		name = person.getName();
		this.tag = tag;
		this.isAdded = isAdded;
		this.makeString();
	}
	
	/**
	 * Makes a string in the following format
	 * + Jake Woo [friend]
	 */
	public void makeString() {
		if (isAdded) {
			list = list + "+ " + name.toString() + " [" + tag.toString() + "]\n";
		}
		else {
			list = list + "- " + name.toString() + " [" + tag.toString() + "]\n";
		}	
	}
	
	/**
	 * Obtain string upon exit
	 * @return
	 */
	public String getString(){
		return list;
	}
}
