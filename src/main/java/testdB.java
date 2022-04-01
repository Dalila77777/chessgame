import java.sql.*;

public class testdB {
    public static void createTable()
    {
        String url= "jdbc:sqlite:C://sqlite/db/test.db";

        String sql = "CREATE TABLE IF NOT EXISTS updatekungsmovement (\n" +
                " id integer PRIMARY KEY,\n" +
                " x integer ,\n" +
                " y integer )";

        try(Connection con = DriverManager.getConnection(url);
            Statement stmt= con.createStatement())
        {
            stmt.execute(sql);
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }


    }

}

