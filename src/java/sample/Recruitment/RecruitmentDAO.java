/* 
 * Le Hung Thien
 * ThienLH1
 * FSOFT OJT
 * 09.02.2015
 * Basic Java Final Test
 **/
package sample.Recruitment;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
    //  Get a list of all candidate from database
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
                int id = rs.getInt("ID");
                String firstName = rs.getString("FirstName");
                String lastName = rs.getString("LastName");
                int candidateType = rs.getInt("Candidate_Type");
                //  Add to list
                Candidate candidate = new Candidate(id, firstName, lastName, candidateType);

                candidates.add(candidate);
            }
            return candidates;
        } catch (SQLException ex) {
            Logger.getLogger(RecruitmentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    //  Get a list of all recruiment available in database
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

                recruitments.add(recruitment);
            }
            return recruitments;
        } catch (SQLException ex) {
            Logger.getLogger(RecruitmentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    /*   Validation by compare type of candidate and package   */
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
    //  participant++ when a new candidate is recruited
    public void increaseParticipant(String recruitmentCode, int recruitmentParticipant) {
        Connection cn = null;
        PreparedStatement stm = null;
        
        try {
            cn = DBUtils.makeConnection();
            String sql = "UPDATE Recruitment SET Participant = ? WHERE Recruitment_code = ?";
            stm = cn.prepareStatement(sql);
            stm.setInt(1, recruitmentParticipant + 1);
            stm.setString(2, recruitmentCode);
            System.out.println("Fuck you! " + recruitmentCode + recruitmentParticipant);
            stm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stm != null) {
                    stm.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    //  Get recruitment object from database base on recruitment code
    public Recruitment getRecruitment(String recruitmentCode) {
        try {
            cn = DBUtils.makeConnection();
            PreparedStatement stm;
            ResultSet rs;

            String query = "SELECT * FROM Recruitment WHERE Recruitment_code = ?";
            stm = cn.prepareStatement(query);
            stm.setString(1, recruitmentCode);
            rs = stm.executeQuery();

            while (rs.next()) {
                //  Get values
                String code = rs.getString("Recruitment_code");
                String position = rs.getString("Position");
                String recruitmentPackage = rs.getString("Recruitment_package");
                int participant = rs.getInt("Participant");
                //  Add to list
                return new Recruitment(recruitmentCode, position, recruitmentPackage, participant);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RecruitmentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
