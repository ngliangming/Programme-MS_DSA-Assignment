package entity;

/**
 *
 * @author wong-
 */
public class Course implements Comparable<Course> {

    public static int sessionIndex = 1001;

    private String sessionId;
    private String courseName;
    private String courseCode;
    private int creditHours;

    private Lecturer lecturer;
    private Programme programme;

    public Course() {

    }

    public Course(int creditHours) {
        this.creditHours = creditHours;
    }

    public Course(String sessionId, String courseName, String courseCode, int creditHours, Lecturer lecturer, Programme programme) {
        this.sessionId = sessionId;
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.creditHours = creditHours;
        this.lecturer = lecturer;
        this.programme = programme;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    public void setProgramme(Programme programme) {
        this.programme = programme;
    }

    public String getSessionId() {
        return sessionId;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public Programme getProgramme() {
        return programme;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String CourseName) {
        this.courseName = CourseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String CourseCode) {
        this.courseCode = CourseCode;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public void setCreditHours(int CreditHours) {
        this.creditHours = CreditHours;
    }

    @Override
    public String toString() {
        return "Session ID = " + sessionId
                + "\nCourse Name  = " + courseName
                + "\nCourse Code  = " + courseCode
                + "\nCredit Hours = " + creditHours
                + "\nLecturer = " + lecturer.getName()
                + "\nProgramme = " + programme.getPCode() + "\n";
    }

    public boolean equals(Course c) {
        if (!c.getCourseCode().equals(this.courseCode)) {
            return false;
        }

        if (!c.getCourseName().equals(this.courseName)) {
            return false;
        }

        if (this.creditHours != c.getCreditHours()) {
            return false;
        }
        
        return true;
    }

    @Override
    public int compareTo(Course c) {
        if(this.creditHours<c.creditHours)
            return -1;
        else if(this.creditHours>c.creditHours)
            return 1;
        else
            return 0;
    }

}
