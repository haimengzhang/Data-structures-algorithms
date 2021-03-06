import java.util.*;
import java.util.HashMap;

public class PhoneBook {
    HashMap<Person, PhoneNumber> phoneBook = new HashMap<Person, PhoneNumber> ();
    /*
     * Adds a person with this name to the phone book and associates
     * with the given PhoneNumber.
     */
    public void addEntry(Person personToAdd, PhoneNumber numberToAdd){
            phoneBook.put(personToAdd, numberToAdd);
    }
    /*
     * Access an entry in the phone book.
     */
    public PhoneNumber getNumber(Person personToLookup){
    	return phoneBook.get(personToLookup);
    }

}
