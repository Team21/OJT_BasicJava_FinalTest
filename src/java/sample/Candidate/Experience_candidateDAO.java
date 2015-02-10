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
public class Experience_candidateDAO implements Serializable {
    private final int candidateType = 0;
    
    public void add(Experience_candidate ec) {
        Connection cn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            cn = DBUtils.makeConnection();
            String sql = "INSERT INTO Candidate(FirstName,LastName,BirthDate,Addr,Phone,Email,Candidate_Type,ExpInYear,ProSkill) VALUES(?,?,?,?,?,?,?,?,?)";
            stm = cn.prepareStatement(sql);
            stm.setString(1, ec.getFirstName());
            stm.setString(2, ec.getLastName());
            stm.setInt(3, ec.getBirthDate());
            stm.setString(4, ec.getAddress());
            stm.setString(5, ec.getPhone());
            stm.setString(6, ec.getEmail());
            stm.setInt(7, candidateType);
            stm.setInt(8, ec.getExpInYear());
            stm.setString(9, ec.getProSkill());
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
