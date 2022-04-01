import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.MonthDay;

public class Board {
    public int[][] board = new int[8][8];
    public int x;
    public int y;
   /* public Board(int[][] board, int x, int y)
    {
        this.board= board;
        this.x=x;
        this.y=y;
    }*/
    public int Location() {

        int location = board[x][y];

        return location;
    }

    public static void main(String[] args) throws IOException, SQLException {
        Main main = new Main();
        main.createNewDB("test.db");
        testdB.createTable();
        Player player= new Player("D", new Board(),new PieceColor());
        King king = new King(1,1,player,new PieceColor());
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Coordinate for King Piece is (1,1)" +
                    "Write new coordinate x and y to move the piece!");

        System.out.println("Write x!");
        int x = Integer.parseInt(reader.readLine());
        System.out.println("Write y!");
        int y = Integer.parseInt(reader.readLine());
        if(king.isvalid(x,y))
        {
            System.out.println("New coordinate for King piece is "+ "(" +x+","+y+")");
            //KingDB kingdb= new KingDB();
            //System.out.println(king.Move(x,y));
            InserApp app= new InserApp();
                app.insert(x,y);

                //king.Move(x,y);
                //System.out.println(app.insert(x,y));
                SelectKing ap= new SelectKing();
                ap.selectAll();
        }
        else
        {
            System.out.println("Wrong!! Enter new coordinate!");
        }

        //


    }

}
