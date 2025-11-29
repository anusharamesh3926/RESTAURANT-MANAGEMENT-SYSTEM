public final class Address {
    private final String street;
    private final String city;
    private final String state;
    private final String zipCode;

    public Address(String street, String city, String state, String zipCode) {
        this.street = street != null ? street : "";
        this.city = city != null ? city : "";
        this.state = state != null ? state : "";
        this.zipCode = zipCode != null ? zipCode : "";
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public Address withStreet(String newStreet) {
        return new Address(newStreet, this.city, this.state, this.zipCode);
    }

    public Address withCity(String newCity) {
        return new Address(this.street, newCity, this.state, this.zipCode);
    }

    public String getFullAddress() {
        return String.format("%s, %s, %s %s", street, city, state, zipCode);
    }

    @Override
    public String toString() {
        return getFullAddress();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Address))
            return false;
        Address other = (Address) obj;
        return street.equals(other.street) &&
                city.equals(other.city) &&
                state.equals(other.state) &&
                zipCode.equals(other.zipCode);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + street.hashCode();
        result = 31 * result + city.hashCode();
        result = 31 * result + state.hashCode();
        result = 31 * result + zipCode.hashCode();
        return result;
    }
}