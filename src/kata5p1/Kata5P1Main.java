package kata5p1;

import java.sql.*;

public class Kata5P1Main {
    public static void main(String[] args) {
        Connection con = connect();
        createEmail(con);
        selectAll(con);
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createEmail(Connection con) {
        String sql = "CREATE TABLE MAIL (\n" +
                " Id integer PRIMARY KEY AUTOINCREMENT, \n" +
                " Mail text NOT NULL);";
        try{
            Statement stm = con.createStatement();
            stm.execute(sql);
            System.out.println("Tabla creada");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void selectAll(Connection con) {
        String sql = "SELECT * FROM PEOPLE";
        try{
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
}
