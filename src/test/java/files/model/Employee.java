package files.model;

public class Employee {
    public String name;
    public Address address;

    public static class Address {
        public String street;
        public String city;
        public String country;
    }
    public String[] role;
}
