/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.Recruitment;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sample.Candidate.Candidate;
import sample.utils.DBUtils;

/**
 *
 * @author thienlh
 */
public class RecruitmentDAO {

    private Connection cn = null;

    public List<Candidate> getCandidateList() {
        try {
            List<Candidate> candidates = new ArrayList<>();
            cn = DBUtils.makeConnection();
            Statement stm = null;
            ResultSet rs = null;
            
            String query = "SELECT * FROM Candidate";
            stm = cn.createStatement();
            rs = stm.executeQuery(query);
            
            while (rs.next()) {
                //  Get values
                String id = rs.getString("ID");
                String firstName = rs.getString("FirstName");
                String lastName = rs.getString("LastName");
                int candidateType = rs.getInt("Candidate_Type");
                //  Add to list
                Candidate candidate = new Candidate(candidateType, firstName, lastName, candidateType);
                
                candidates.add(candidate);
            }
            return candidates;
        } catch (SQLException ex) {
            Logger.getLogger(RecruitmentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<Recruitment> getRecruitmentList() {
        try {
            List<Recruitment> recruitments = new ArrayList<>();
            cn = DBUtils.makeConnection();
            Statement stm = null;
            ResultSet rs = null;
            
            String query = "SELECT * FROM Recruitment";
            stm = cn.createStatement();
            rs = stm.executeQuery(query);
            
            while (rs.next()) {
                //  Get values
                String code = rs.getString("Recruitment_code");
                String position = rs.getString("Position");
                String recruitmentPackage = rs.getString("Recruitment_package");
                int participant = rs.getInt("Participant");
                //  Add to list
                Recruitment recruitment = new Recruitment(code, position, recruitmentPackage, participant);
                System.out.println(recruitment.toString());
                
                recruitments.add(recruitment);
            }
            return recruitments;
        } catch (SQLException ex) {
            Logger.getLogger(RecruitmentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public boolean isValid(String recruitmentPackage, String candidateType) {
        boolean isValid = false;
        if (recruitmentPackage.equals("A") && candidateType.equals("0")) {
            isValid = true;
        }
        if (recruitmentPackage.equals("B") && candidateType.equals("1")) {
            isValid = true;
        }
        if (recruitmentPackage.equals("C") && candidateType.equals("2")) {
            isValid = true;
        }
        return isValid;
    }
}
