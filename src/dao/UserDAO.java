package dao;

import java.io.IOException;
import java.util.List;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.User;

public class UserDAO {
    
    public static void main(String[] args) {
        User p = new UserDAO().getUser("tom", "123");
        if (p == null) System.out.println(false);
        else System.out.println(true);
    }
    
    public User getUser(String name, String password) {
        User r = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/chatroom?characterEncoding=UTF-8",
                    "root", "password");
            String sql = "select * from user where name = ? and password = ?";
            PreparedStatement ps = c.prepareStatement(sql);           
            ps.setString(1, name);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                r = new User();
                r.setName(name); 
                r.setPassword(password);
                r.setId(rs.getInt(1));
            }

            ps.close();
            c.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return r;
    }
}
