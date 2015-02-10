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
public class Experience_candidate extends Candidate {

    private int ExpInYear;
    private String ProSkill;

    public Experience_candidate() {
    }

    public Experience_candidate(String FirstName, String LastName, int BirthDate, String Address, String Phone, String Email, int Candidate_type, int ExpInYear, String ProSkill) {
        super(FirstName, LastName, BirthDate, Address, Phone, Email, Candidate_type);
        this.ExpInYear = ExpInYear;
        this.ProSkill = ProSkill;
    }

    /**
     * @return the ExpInYear
     */
    public int getExpInYear() {
        return ExpInYear;
    }

    /**
     * @param ExpInYear the ExpInYear to set
     */
    public void setExpInYear(int ExpInYear) {
        this.ExpInYear = ExpInYear;
    }

    /**
     * @return the ProSkill
     */
    public String getProSkill() {
        return ProSkill;
    }

    /**
     * @param ProSkill the ProSkill to set
     */
    public void setProSkill(String ProSkill) {
        this.ProSkill = ProSkill;
    }

    @Override
    public boolean isValid() {
        boolean isValid = super.isValid(); //To change body of generated methods, choose Tools | Templates.
        //  Check ExpInYear
        if (this.getExpInYear() < 0 || this.getExpInYear() > 100) {
            isValid = false;
        }
        return isValid;
    }

}
