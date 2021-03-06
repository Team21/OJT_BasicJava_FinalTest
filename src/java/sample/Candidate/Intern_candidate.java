/* 
 * Le Hung Thien
 * ThienLH1
 * FSOFT OJT
 * 09.02.2015
 * Basic Java Final Test
 **/


package sample.Candidate;

/**
 *
 * @author thienlh
 */
public class Intern_candidate extends Candidate{
private String Majors;
private String Semester;
private String University_name;

    public Intern_candidate() {
    }

    public Intern_candidate(String FirstName, String LastName, int BirthDate, String Address, String Phone, String Email, int Candidate_type,String Majors, String Semester, String University_name) {
        super(FirstName, LastName, BirthDate, Address, Phone, Email, Candidate_type);
        this.Majors = Majors;
        this.Semester = Semester;
        this.University_name = University_name;
    }

    /**
     * @return the Majors
     */
    public String getMajors() {
        return Majors;
    }

    /**
     * @param Majors the Majors to set
     */
    public void setMajors(String Majors) {
        this.Majors = Majors;
    }

    /**
     * @return the Semester
     */
    public String getSemester() {
        return Semester;
    }

    /**
     * @param Semester the Semester to set
     */
    public void setSemester(String Semester) {
        this.Semester = Semester;
    }

    /**
     * @return the University_name
     */
    public String getUniversity_name() {
        return University_name;
    }

    /**
     * @param University_name the University_name to set
     */
    public void setUniversity_name(String University_name) {
        this.University_name = University_name;
    }

}
