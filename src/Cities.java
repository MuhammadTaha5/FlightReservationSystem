public enum Cities {
    LAHORE("PAKISTAN"), KARACHI("PAKISTAN"), CHENNAI("INDIA"), MUMBAI("INDIA"), DUBAI("UAE"), ABUDHABI("UAE");
    private String country;
    Cities(String country)
    {
        setCountry(country);
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
