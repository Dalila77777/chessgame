import java.sql.*;

public class InserApp
{
    public Connection connect()
    {
        String url = "jdbc:sqlite:C://sqlite/db/test.db";
        Connection con=null;
        try {
            con = DriverManager.getConnection(url);
        }

        catch (SQLException e)
        {
            System.out.println((e.getMessage()));
        }
        return con;
    }

    public void insert(int x, int y) throws SQLException {
        String sql="INSERT INTO updatekungsmovement(x,y) VALUES(?,?)";
        King king=null;

        try(            Connection con=this.connect();
                        PreparedStatement pstmt= con.prepareStatement(sql);)
        {

            pstmt.setInt(1,x);
            pstmt.setInt(2,y);
            pstmt.executeUpdate();
            //king.Move(x,y);
            /*final var move = (pstmt) king.Move(x, y);
            return move;*/

        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        //return (PreparedStatement) king.Move(x,y);
        //return ;
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

}
