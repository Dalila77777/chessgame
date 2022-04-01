import java.sql.*;

public class SelectKing {

    private Connection connect()
    {
        String url="jdbc:sqlite:C://sqlite/db/test.db";
        Connection conn=null;
        try
        {
            conn= DriverManager.getConnection(url);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void selectAll()
    {
        String sql="SELECT id, x,y FROM updatekungsmovement";
        try

                (Connection conn= this.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs= stmt.executeQuery(sql))
        {
            while (rs.next())
            {
                System.out.println(rs.getInt("id")+ "\t"+
                        rs.getInt("x")+ "\t"+
                        rs.getInt("y"));
            }
        } catch (SQLException e) {
            //e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
