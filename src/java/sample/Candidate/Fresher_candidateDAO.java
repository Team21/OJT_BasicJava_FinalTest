/* 
 * Le Hung Thien
 * ThienLH1
 * FSOFT OJT
 * 09.02.2015
 * Basic Java Final Test
 **/

package sample.Candidate;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import sample.utils.DBUtils;

/**
 *
 * @author Ginta
 */
public class Fresher_candidateDAO implements Serializable {
    private final int candidateType = 1;
    public void add(Fresher_candidate fc) {
        Connection cn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            cn = DBUtils.makeConnection();
            String sql = "INSERT INTO Candidate(FirstName,LastName,BirthDate,Addr,Phone,Email,Candidate_Type,Graduation_Date, Graduation_Rank, Education) VALUES(?,?,?,?,?,?,?,?,?, ?)";
            stm = cn.prepareStatement(sql);
            stm.setString(1, fc.getFirstName());
            stm.setString(2, fc.getLastName());
            stm.setInt(3, fc.getBirthDate());
            stm.setString(4, fc.getAddress());
            stm.setString(5, fc.getPhone());
            stm.setString(6, fc.getEmail());
            stm.setInt(7, candidateType);
            stm.setString(8, fc.getGraduation_date());
            stm.setString(9, fc.getGraduation_rank());
            stm.setString(10, fc.getEducation());
            
            stm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
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
}
