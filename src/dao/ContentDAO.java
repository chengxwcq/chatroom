package dao;
import java.util.List;
import java.util.LinkedList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Content;

public class ContentDAO {

    public static void main(String[] args) {
        Content p = new Content();
        p.setUsername("jane");
        p.setStime("03/23/2016");
        p.setContent("this is added by eclipse");
        new ContentDAO().addContent(p);
    }
    
    public void addContent(Content p) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/chatroom?characterEncoding=UTF-8",
                    "root", "password");
            String sql = "INSERT INTO record values(null, ?, ?, ?);";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, p.getUsername());
            ps.setString(2, p.getStime());
            ps.setString(3, p.getContent());
            ps.executeUpdate();

            ps.close();
            c.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Content> ListContent() {
        List<Content> list = new LinkedList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/chatroom?characterEncoding=UTF-8",
                    "root", "password");
            String sql = "select * from record";
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Content content = new Content();
                content.setId(rs.getInt(1));
                content.setUsername(rs.getString(2));
                content.setContent(rs.getString(4));
                content.setStime(rs.getString(3));

                list.add(content);
            }

            ps.close();
            c.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
