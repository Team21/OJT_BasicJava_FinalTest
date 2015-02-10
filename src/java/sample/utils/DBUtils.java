/* 
 * Le Hung Thien
 * ThienLH1
 * FSOFT OJT
 * 09.02.2015
 * Basic Java Final Test
 **/

package sample.utils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author thienle
 */
public class DBUtils implements Serializable {
    //  Return jdbc connection
    public static Connection makeConnection() {
        try {
            //  Load driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //  Connection String
            //  protocol:servername://ip:port;databaseName=DBName;instanceName=adfasdf
            String url = "jdbc:sqlserver://localhost:1433;databaseName=BasicJava_FinalTest";
            //  Establish
            Connection cn = DriverManager.getConnection(url, "sa", "*9394lht#");
            //  Return
            return cn;
        } catch (ClassNotFoundException ex) {
            System.out.println("Error finding JDBC driver class! " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error getting sql connection! " + ex.getMessage());
        }
        return null;
    }
}
