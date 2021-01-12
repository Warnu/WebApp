package Model;

public class Teacher {
    private static Teacher currentLoggedInTeacher;

    private int Id;
    private String firstName;
    private String lastName;
    private String userName;
    private String emailAddress;
    private String passwordSalt;
    private String passwordHash;
    private String Subject;
    private String fullName;

    public static Teacher getCurrentLoggedInTeacher(){
        return currentLoggedInTeacher;
    }

    public static void setCurrentLoggedInTeacher(Teacher currentLoggedInTeacher) {
        Teacher.currentLoggedInTeacher = currentLoggedInTeacher;
    }

    public Teacher(){}

    public Teacher(String firstName, String lastName, String userName, String emailAddress, String passwordHash, String subject) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = firstName + " "+lastName;
        this.userName = userName;
        this.emailAddress = emailAddress;
        this.passwordHash = passwordHash;
        this.Subject = subject;
    }

    public Teacher(int id, String firstName, String lastName, String userName, String emailAddress, String passwordSalt, String passwordHash, String subject) {
        Id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = firstName + " "+lastName;
        this.userName = userName;
        this.emailAddress = emailAddress;
        this.passwordSalt = passwordSalt;
        this.passwordHash = passwordHash;
        this.Subject = subject;
    }

    public void setFullName(){
        fullName = firstName + " " + lastName;
    }
    public String getFullName(){
        return fullName;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPasswordSalt() {
        return passwordSalt;
    }

    public void setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "Id=" + Id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", passwordSalt='" + passwordSalt + '\'' +
                ", passwordHash='" + passwordHash + '\'' +
                ", Subject='" + Subject + '\'' +
                '}';
    }
}
