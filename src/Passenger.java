public class Passenger
{
    private String name;
    private String phoneNumber;
    private String email;

    public Passenger(String name, String phoneNumber, String email)
    {
        setName(name);
        setPhoneNumber(phoneNumber);
        setEmail(email);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void getDetails()
    {

    }

    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}