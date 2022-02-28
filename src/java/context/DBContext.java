
package context;


import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DBContext {
    
    /*USE BELOW METHOD FOR YOUR DATABASE CONNECTION FOR BOTH SINGLE AND MULTILPE SQL SERVER INSTANCE(s)*/
    /*DO NOT EDIT THE BELOW METHOD, YOU MUST USE ONLY THIS ONE FOR YOUR DATABASE CONNECTION*/
//     public Connection getConnection()throws Exception {
//        Connection conn = null;
//        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//        conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=PotatoesCute;user=sa;password=123");
//        return conn;
//    }   
     
     public Connection getConnection() throws Exception {
        String connectionUrl = "jdbc:sqlserver://localhost;databaseName=PotatoesCute;"
                            + "User=sa;Password=123";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(connectionUrl);
    }
    /*Insert your other code right after this comment*/
    /*Change/update information of your database connection, DO NOT change name of instance variables in this class*/
     
     public static void main(String[] args) {
         try {
             DBContext db = new DBContext();
             System.out.println( db.getConnection() );
         } catch (Exception ex) {
             Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
}
 