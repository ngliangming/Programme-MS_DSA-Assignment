package entity;

/**
 *
 * @author Ng Liang Ming
 */
public class Lecturer implements Comparable<Lecturer> {

    private int staffId;
    private String name;
    private String phoneNumber;
    private String email;

    public Lecturer(int staffId, String name, String phoneNumber, String email) {
        this.staffId = staffId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public int getStaffId() {
        return staffId;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("Staff ID: %d\n"
                + "Name: %s\n"
                + "Phone number: %s"
                + "Email: %s",
                staffId, name, phoneNumber, email);
    }

    @Override
    public int compareTo(Lecturer l) {
        return name.compareTo(l.name);
    }
}
