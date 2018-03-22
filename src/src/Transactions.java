import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Transactions {
    private Connection con = null;
    private Statement statement = null;
    private PreparedStatement ps = null;

    public Transactions() {
        String url="jdbc:mysql://"+DB.host+":"+DB.port+"/"+DB.db_name+"?useUnicode=true&characterEncoding=utf8";
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch(Exception ex) {
            System.out.println("Driver can't be found....");
        }
        try {
            con = DriverManager.getConnection(url,DB.username,DB.password);
            System.out.println("Connection is succeed....");
        }catch(Exception ex) {
            System.out.println("Connection is failed....");
        }
    }

    public void Register(String fullName,String userName,String password,String email,String telephone) throws SQLException {
        String query = "Insert into customers(fullName,userName,password,email,telephone) values (?,?,?,?,?)";
        ps = con.prepareStatement(query);
        ps.setString(1, fullName);
        ps.setString(2, userName);
        ps.setString(3, password);
        ps.setString(4, email);
        ps.setString(5, telephone);
        ps.executeUpdate();
    }

    public void ForgotPassword(String email,String newPassword) throws SQLException{
        String query = "Delete Password from customers where Email = ?";
        ps = con.prepareStatement(query);
        System.out.println("Password Silindi");
        String password = "Insert into customers(password) values(?,?,?,?,?,?)";
        ps = con.prepareStatement(password);
        ps.setString(1,newPassword);
        ps.executeUpdate();


    }

    public boolean Login(String userName, String password) throws SQLException {
        String query = "Select * from customers where userName=? and password=?";
        ps = con.prepareStatement(query);
        ps.setString(1, userName);
        ps.setString(2, password);
        ResultSet rs = ps.executeQuery();
        return rs.next();
    }

    //public void AdminEntrance(){

    //}
    public void Remove(){} //admin booking silecek
    public void TicketBooking(){} // customer
    public void Payment(){} // customer
    public void TicketChecking(){} // admin

}
