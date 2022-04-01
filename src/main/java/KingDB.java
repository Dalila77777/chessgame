import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

import static java.lang.System.*;

public class KingDB {
    private static final String CREATE_TABLE_King = "CREATE TABLE King(ID BIGINT PRIMARY KEY, X INT DEFAULT 0, " +
            "Y INT DEFAULT 0, COLOR VARCHAR(255))";
    //private static final String CREATE_TABLE_Piece = "CREATE TABLE Piece(ID BIGINT PRIMARY KEY, X INT DEFAULT 0, Y INT DEFAULT 0, COLOR VARCHAR(255))";

    private static final String CONNECTION_STRING_IM = "jdbc:h2:mem:";
    private static final String CONNECTION_STRING_FILE = "jdbc:h2:./account_db";

    public static boolean createTable() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(CONNECTION_STRING_FILE);
            var stmt = con.createStatement();
            stmt.execute("DROP TABLE IF EXISTS ACCOUNT");
            return stmt.execute(CREATE_TABLE_King);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (Exception ignore) {
                err.println(ignore);
            }
        }
        return false;
    }

    public King create(int x, int y) {
        King king= null;
        String uniqueID= UUID.randomUUID().toString();

        Connection con = null;
        try {
            con = DriverManager.getConnection(CONNECTION_STRING_FILE);
            //Om vi lägger till Statement.RETURN_GENERATED_KEYS så kommer vi att kunna hämta de värden som autogenererats efter att vi kört frågan.
            var stmt = con.prepareStatement("INSERT INTO King(ID,X, Y, COLOR) VALUES(?)", Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, Integer.parseInt(uniqueID));

            stmt.setInt(x, king.getX());//Ersätt frågetecken 1 med Holder i Account!
            stmt.setInt(y, king.getY());//Ersätt frågetecken 1 med Holder i Account!

            stmt.execute();//Kör frågan.
            var rs = stmt.getGeneratedKeys();//Hämta det ID som genererats i databasen.
            if (rs.next()) {//Om vi har en rad i resultatet, så gå till den raden.
                int KingId = rs.getInt(1);//Hämta värdet i den första kolumnen i den första raden.
                king.setId(KingId);//Lägg indexet i våran account
                int a= rs.getInt(x);
                int b=rs.getInt(y);
                king.Move(a,b);
                var sql = con.prepareStatement("SELECT ID, X, Y, COLOR FROM King WHERE ID=?");
                var RS = sql.executeQuery();
                if (RS.next()) {
                    System.out.println(king);
                }
            }
        } catch (SQLException e) {//Oj det gick fel
            e.printStackTrace();
        } finally {//Oavsett om det gick rätt eller fel, hamnar vi här.
            try {
                con.close();
            } catch (Exception ignore) {
            }
        }
        return king;
    }
}

    /*public King findById(int id) {
        int x = 0;
        int y=0;
        //King king = new King(x, y,new Player("name",new Board(),new PieceColor()), new PieceColor());
        Connection connection = null;
        King king=null;
        //King king = new King(x,y,new Player("name",new Board(),new PieceColor()),new PieceColor());
        //String uniqueID= UUID.randomUUID().toString();

        try{
            connection = DriverManager.getConnection(CONNECTION_STRING_FILE);
            var stmt = connection.prepareStatement("SELECT ID, X, Y, COLOR FROM King WHERE ID=?");

            stmt.setInt(1, id);
            var rs= stmt.executeQuery();
            if(rs.next()){

                int a= rs.getInt(x);
                int b=rs.getInt(y);
                king.setX(a);
                king.setY(b);

               //out.println(king.Move(a,b));
                var stm = connection.prepareStatement("SELECT  x, y FROM King WHERE uniqueID = ?");






            }

            /*if (RS.next())
            {
                out.println(king.Move(x,y));

                return king.Move(x,y);
            }
        }catch(Exception e){

        }finally{
            try {
                connection.close();
            }catch(Exception ignore){}
        }
        return king;
    }

    public King findPieceMovement(int x, int y) {
        Connection connection = null;
        King king = null;
        try{
            connection = DriverManager.getConnection(CONNECTION_STRING_FILE);
            var stmt = connection.prepareStatement("SELECT ID, X, Y FROM King WHERE ID = ?");
            stmt.setInt(1, id);
            var rs = stmt.executeQuery();
            if(rs.next()){
                String holder = rs.getString(2);
                int balance = rs.getInt(3);

                account = new Account(holder);
                account.setId(id);
                account.setBalance(balance);
            }
        }catch(Exception e){

        }finally{
            try {
                connection.close();
            }catch(Exception ignore){}
        }
        return account;
    }
}*/
