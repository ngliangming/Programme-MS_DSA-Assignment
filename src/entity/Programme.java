/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Brandon Choong
 */
public class Programme {

    private String PCode;
    private String PName;
    private Faculty faculty;

    public Programme() {
    }

    @Override
    public String toString() {
        return "Programme Code = " + PCode
                + "\nProgramme Name  = " + PName
                + "\nFaculty = " + faculty.getFCode() + "\n";
    }

    public Programme(String PCode) {

        this.PCode = PCode;
    }

    public Programme(String PCode, String PName, Faculty faculty) {
        this.PCode = PCode;
        this.PName = PName;
        this.faculty = faculty;
    }

    public String getPCode() {
        return PCode;
    }

    public void setPCode(String PCode) {
        this.PCode = PCode;
    }

    public String getPName() {
        return PName;
    }

    public void setPName(String PName) {
        this.PName = PName;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public int compareTo(Programme p) {
        return PCode.compareTo(p.PCode);

    }

    public int hashCode() {
        return PCode.hashCode();
    }

}
