package Model;

public class Resource {
    private int Id;
    private String resourceName;
    private String resourceType;
    private String resourceLink;
    private String resourceGradeLevel;
    private int teacherID;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(int teacherID) {
        this.teacherID = teacherID;
    }

    public Resource() {
        this.resourceName = "";
        this.resourceType = "";
        this.resourceLink = "";
        this.resourceGradeLevel = "";
    }

    public Resource(String resourceName, String resourceType, String resourceLink, String resourceGradeLevel, int teacherID) {
        this.resourceName = resourceName;
        this.resourceType = resourceType;
        this.resourceLink = resourceLink;
        this.teacherID = teacherID;
        this.resourceGradeLevel = resourceGradeLevel;
    }

    public Resource(int Id,String resourceName, String resourceType, String resourceLink, String resourceGradeLevel) {
        this.Id = Id;
        this.resourceName = resourceName;
        this.resourceType = resourceType;
        this.resourceLink = resourceLink;
        this.resourceGradeLevel = resourceGradeLevel;
    }

    public String getResourceName() {
        return resourceName;
    }

    public String getResourceType() {
        return resourceType;
    }

    public String getResourceLink() {
        return resourceLink;
    }

    public String getResourceGradeLevel() {
        return resourceGradeLevel;
    }


    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public void setResourceLink(String resourceLink) {
        this.resourceLink = resourceLink;
    }

    public void setResourceGradeLevel(String resourceGradeLevel) {
        this.resourceGradeLevel = resourceGradeLevel;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "Id=" + Id +
                ", resourceName='" + resourceName + '\'' +
                ", resourceType='" + resourceType + '\'' +
                ", resourceLink='" + resourceLink + '\'' +
                ", resourceGradeLevel='" + resourceGradeLevel + '\'' +
                ", teacherID=" + teacherID +
                '}';
    }
}
