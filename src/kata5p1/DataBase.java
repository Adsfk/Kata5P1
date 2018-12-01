package kata5p1;

import java.sql.*;
import java.util.List;

public class DataBase {
    public DataBase() {
        Connection con = connect();
        createEmail();
        //selectAll();
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createEmail() {
        String sql = "CREATE TABLE IF NOT EXISTS MAIL (\n" +
                " Id integer PRIMARY KEY AUTOINCREMENT, \n" +
                " Mail text NOT NULL);";
        try (Connection con = connect()){
            Statement stm = con.createStatement();
            stm.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void selectAll() {
        String sql = "SELECT * FROM PEOPLE";
        try(Connection con = connect()){
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                System.out.println(rs.getInt("id") + "\t" +
                        rs.getString("Name") + " \t" +
                        rs.getString("Apellidos") + "\t" +
                        rs.getString("Departamento") + "\t");
            }
            stm.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Connection connect() {
        Connection con = null;
        String url = "jdbc:sqlite:KATA5.db";
        try {
            con = DriverManager.getConnection(url);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    public void insert(List<String> mails){
        String sql = "INSERT INTO MAIL(Mail) VALUES(?)";
        try (Connection con = connect();
            PreparedStatement pstmt = con.prepareStatement(sql)) {
            for (String mail : mails) {
                pstmt.setString(1, mail);
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
