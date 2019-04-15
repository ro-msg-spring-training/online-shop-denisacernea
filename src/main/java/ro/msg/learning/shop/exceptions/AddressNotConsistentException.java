package ro.msg.learning.shop.exceptions;

public class AddressNotConsistentException extends RuntimeException {

    public AddressNotConsistentException() {
        super("Address is not consistent. Check that all properties are introduced. (Country, County, City, Street)");
    }
}
