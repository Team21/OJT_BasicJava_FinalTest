/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Candidate;

/**
 *
 * @author Tuan
 */
public class Experience_candidate extends Candidate {
    private int ExpInYear;
    private String ProSkill;

    public Experience_candidate() {
    }

    public Experience_candidate(int Id, String FirstName, String LastName, int BirthDate, String Address, int Phone, String Email, int Candidate_type,int ExpInYear, String ProSkill) {
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
    
}
