package Model;

public class Student {

    private int id;
    private String firstName;
    private String lastName;
    private String userName;
    private String fullName;
    private String emailAddress;
    private String passwordSalt;
    private String passwordHash;
    private String gradeLevel;
    private int curriculumID;

    public Student(){}

    public Student(int id, String firstName, String lastName, String userName, String emailAddress, String passwordHash, String gradeLevel, int curriculumID) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.emailAddress = emailAddress;
        this.fullName = firstName+" "+lastName;
        this.passwordHash = passwordHash;
        this.gradeLevel = gradeLevel;
        this.curriculumID = curriculumID;
    }
    public Student(String firstName, String lastName, String userName, String emailAddress, String passwordHash, String gradeLevel, int curriculumID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.emailAddress = emailAddress;
        this.fullName = firstName+" "+lastName;
        this.passwordHash = passwordHash;
        this.gradeLevel = gradeLevel;
        this.curriculumID = curriculumID;
    }
    public Student(int id, String firstName, String lastName, String userName, String emailAddress, String passwordHash, String gradeLevel) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.emailAddress = emailAddress;
        this.fullName = firstName+" "+lastName;
        this.passwordHash = passwordHash;
        this.gradeLevel = gradeLevel;
    }
    public Student(String firstName, String lastName, String userName, String emailAddress, String passwordHash, String gradeLevel) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.emailAddress = emailAddress;
        this.fullName = firstName+" "+lastName;
        this.passwordHash = passwordHash;
        this.gradeLevel = gradeLevel;
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName() {
        this.fullName = firstName+" "+lastName;
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

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.fullName = name;
    }

    public void setGradeLevel(String gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    public void setCurriculumID(int curriculumID) {
        this.curriculumID = curriculumID;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return fullName;
    }

    public String getGradeLevel() {
        return gradeLevel;
    }

    public int getCurriculumID() {
        return curriculumID;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", fullName='" + fullName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", passwordSalt='" + passwordSalt + '\'' +
                ", passwordHash='" + passwordHash + '\'' +
                ", gradeLevel='" + gradeLevel + '\'' +
                ", curriculumID=" + curriculumID +
                '}';
    }
}
