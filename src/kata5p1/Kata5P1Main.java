package kata5p1;

import java.sql.*;

public class Kata5P1Main {
    public static void main(String[] args) {
        SelectAll();
    }

    private static void SelectAll() {
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
}
