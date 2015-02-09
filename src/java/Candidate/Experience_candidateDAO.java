/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Candidate;

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

    public void add(String FirstName, String LastName, int BirthDate, String Address, int Phone, String Email, int Candidate_type, int ExpInYear, String ProSkill) {
        Connection cn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            cn = DBUtils.makeConnection();
            String sql = "INSERT INTO Candidate(FirstName,LastName,BirthDate,Addr,Phone,Email,Candidate_type, ExpInYear,ProSkill) VALUES (?,?,?,?,?,?,?,?,?) ";
            stm = cn.prepareStatement(sql);
            stm.setString(1, FirstName);
            stm.setString(2, LastName);
            stm.setInt(3, BirthDate);
            stm.setString(4, Address);
            stm.setInt(5, Phone);
            stm.setString(6, Email);
            stm.setInt(7, Candidate_type);
            stm.setInt(8, ExpInYear);
            stm.setString(9, ProSkill);
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
