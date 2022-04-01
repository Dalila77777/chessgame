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

    public int selectX()
    {
        String sql="SELECT x FROM updatekungsmovement";
        int x =1;
        try

                (Connection conn= this.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs= stmt.executeQuery(sql))
        {
            while (rs.next())
            {
                 x = rs.getInt("x");
            }
        } catch (SQLException e) {
            //e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return x;
    }

    public int selectY()
    {
        String sql="SELECT y FROM updatekungsmovement";
        int y =1;
        try

                (Connection conn= this.connect();
                 Statement stmt = conn.createStatement();
                 ResultSet rs= stmt.executeQuery(sql))
        {
            while (rs.next())
            {
                y = rs.getInt("y");
            }
        } catch (SQLException e) {
            //e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return y;
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
