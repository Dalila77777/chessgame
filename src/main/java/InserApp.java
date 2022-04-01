import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InserApp
{
    public Connection connect()
    {
        String url = "jdbc:sqlite:C://sqlite/db/test.db";
        Connection con=null;
        try {
            con = DriverManager.getConnection(url);
        }
            /*if(con != null)
            {
                con.close();
            }

            }*/
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

}
