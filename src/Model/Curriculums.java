package Model;

import java.util.Arrays;
import java.util.List;

public class Curriculums {
    private int ID;
    private int teacherId;
    private String curriculumSubject;
    private String curriculumGrade;
    private String[] resourcesId;


    //From Tariq - Starts ///////////////////////////////////////////////////////////////////////
    private int curriculumID;
    private List<Resource> curriculumResources;
    private String teacher;
    private String subject;
    private String curriculumName;


    public void setCurriculumID (int curriculumID){
    this.curriculumID = curriculumID;
    }

        public void setCurriculumName (String curriculumName){
        this.curriculumName = curriculumName;
    }

        public void setTeacher (String teacher){
        this.teacher = teacher;
    }

        public void setCurriculumResources (List < Resource > curriculumResources) {
        this.curriculumResources = curriculumResources;
    }

        public void setSubject (String subject){
        this.subject = subject;
    }

        public int getCurriculumID () {
        return curriculumID;
    }

        public String getCurriculumName () {
        return curriculumName;
    }

        public String getTeacher () {
        return teacher;
    }

        public List<Resource> getCurriculumResources () {
        return curriculumResources;
    }

        public String getSubject () {
        return subject;
    }
    //From Tariq - Ends ///////////////////////////////////////////////////////////////////////

    public Curriculums(int ID, int teacherId, String curriculumSubject, String curriculumGrade, String[] resourcesId) {
        this.ID = ID;
        this.teacherId = teacherId;
        this.curriculumSubject = curriculumSubject;
        this.curriculumGrade = curriculumGrade;
        this.resourcesId = resourcesId;
    }
    public Curriculums(int teacherId, String curriculumSubject, String curriculumGrade, String[] resourcesId) {
        this.teacherId = teacherId;
        this.curriculumSubject = curriculumSubject;
        this.curriculumGrade = curriculumGrade;
        this.resourcesId = resourcesId;
    }

    public Curriculums() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getCurriculumSubject() {
        return curriculumSubject;
    }

    public void setCurriculumSubject(String curriculumSubject) {
        this.curriculumSubject = curriculumSubject;
    }

    public String getCurriculumGrade() {
        return curriculumGrade;
    }

    public void setCurriculumGrade(String curriculumGrade) {
        this.curriculumGrade = curriculumGrade;
    }

    public String[] getResourcesId() {
        return resourcesId;
    }

    public void setResourcesId(String[] resourcesId) {
        this.resourcesId = resourcesId;
    }

    @Override
    public String toString() {
        return "Curriculums{" +
                "ID=" + ID +
                ", teacherId=" + teacherId +
                ", curriculumSubject='" + curriculumSubject + '\'' +
                ", curriculumGrade='" + curriculumGrade + '\'' +
                ", resourcesId=" + Arrays.toString(resourcesId) +
                '}';
    }

    public String toString2() {
        return "Curriculums{" +
                "curriculumID=" + curriculumID +
                ", curriculumResources=" + curriculumResources +
                ", teacher='" + teacher + '\'' +
                ", subject='" + subject + '\'' +
                ", curriculumName='" + curriculumName + '\'' +
                '}';
    }
}
