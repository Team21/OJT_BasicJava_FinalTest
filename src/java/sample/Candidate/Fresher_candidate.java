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
 * @author Tuan
 */
public class Fresher_candidate extends Candidate {

    private String Graduation_date;
    private String Graduation_rank;
    private String Education;

    public Fresher_candidate() {
    }

    public Fresher_candidate(String FirstName, String LastName, int BirthDate, String Address, String Phone, String Email, int Candidate_type, String Graduation_date, String Graduation_rank, String Education) {
        super(FirstName, LastName, BirthDate, Address, Phone, Email, Candidate_type);
        this.Graduation_date = Graduation_date;
        this.Graduation_rank = Graduation_rank;
        this.Education = Education;
    }

    /**
     * @return the Graduation_date
     */
    public String getGraduation_date() {
        return Graduation_date;
    }

    /**
     * @param Graduation_date the Graduation_date to set
     */
    public void setGraduation_date(String Graduation_date) {
        this.Graduation_date = Graduation_date;
    }

    /**
     * @return the Graduation_rank
     */
    public String getGraduation_rank() {
        return Graduation_rank;
    }

    /**
     * @param Graduation_rank the Graduation_rank to set
     */
    public void setGraduation_rank(String Graduation_rank) {
        this.Graduation_rank = Graduation_rank;
    }

    /**
     * @return the Education
     */
    public String getEducation() {
        return Education;
    }

    /**
     * @param Education the Education to set
     */
    public void setEducation(String Education) {
        this.Education = Education;
    }

    @Override
    public boolean isValid() {
        boolean isValid = super.isValid(); //To change body of generated methods, choose Tools | Templates.
        //  Check ExpInYear
        if (!this.getGraduation_rank().equals("Excellence") && !this.getGraduation_rank().equals("Good")
                && !this.getGraduation_rank().equals("Fair") && !this.getGraduation_rank().equals("Poor")) {
            isValid = false;
        }
        return isValid;
    }
}
