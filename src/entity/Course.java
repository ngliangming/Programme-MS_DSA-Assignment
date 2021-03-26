/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

//    public Course(String CourseName, String CourseCode, int CreditHours) {
//        this.courseName = CourseName;
//        this.courseCode = CourseCode;
//        this.creditHours = CreditHours;
//    }

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
                + "\nProgramme = " + programme.getProgrammeCode() + "\n";
    }

    @Override
    public int compareTo(Course o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
