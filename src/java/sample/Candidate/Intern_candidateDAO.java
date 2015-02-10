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
 * @author thienlh
 */
public class Intern_candidateDAO implements Serializable {
    private final int Candidate_type = 2;   //  Type of candidate
    //  Add new intern candidate to database
    public void add(Intern_candidate ic) {
        Connection cn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            cn = DBUtils.makeConnection();
            String sql = "INSERT INTO Candidate(FirstName,LastName,BirthDate,Addr,Phone,Email,Candidate_Type,Majors,Semester,University_name) VALUES(?,?,?,?,?,?,?,?,?,?)";
            stm = cn.prepareStatement(sql);
            stm.setString(1, ic.getFirstName());
            stm.setString(2, ic.getLastName());
            stm.setInt(3, ic.getBirthDate());
            stm.setString(4, ic.getAddress());
            stm.setString(5, ic.getPhone());
            stm.setString(6, ic.getEmail());
            stm.setInt(7, Candidate_type);
            stm.setString(8, ic.getMajors());
            stm.setString(9, ic.getSemester());
            stm.setString(10, ic.getUniversity_name());
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
