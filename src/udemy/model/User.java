package udemy.model;

public class User {

    private Long id;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private int gender; // 0:male, 1:female
    private int type;// 0:student, 1:teacher

    public User(Long id, String userName, String password, String firstName, String lastName, int gender, int type) {
        super();
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "id: " + id + "\n"
                + "userName: " + userName + "\n"
                + "fullName: " + firstName + " " + lastName + "\n"
                + "gender: " + ((gender == 0) ? "male" : "female") + "\n"
                + "type: " + ((type == 0) ? "student" : "teacher") + "\n";
    }

}
