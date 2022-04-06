import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class Board {
    public int[][] board = new int[8][8];
    public int x;
    public int y;
//    public Board(int x, int y)
//    {
//        this.board= board;
//        this.x=x;
//        this.y=y;
//    }
    public int Squares() {

        int square = board[x][y];

        return square;
    }

    public static void main(String[] args) throws IOException, SQLException {
        ChessDB chessDB = new ChessDB();
        chessDB.createNewDB("test.db");
        Kingtable.createTable();
        Player player= new Player("D", new Board(),new PieceColor());
        int a,b;
        //SelectKing selectKing= new SelectKing();
        InserApp inserApp = new InserApp();
        a = inserApp.selectX();
        b = inserApp.selectY();
        King king = new King(a,b,player,new PieceColor());
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Coordinate for King Piece is (" + a +","+b+")"+
                    " Write new coordinate x and y to move the piece!");

        System.out.println("Write x!");
        int x = Integer.parseInt(reader.readLine());
        System.out.println("Write y!");
        int y = Integer.parseInt(reader.readLine());
        if(king.isvalid(x,y))
        {
            System.out.println("New coordinate for King piece is "+ "(" +x+","+y+")");
            InserApp app= new InserApp();
                app.insert(x,y);
                SelectKing ap= new SelectKing();
                ap.selectAll();
        }
        else
        {
            System.out.println("Wrong!! Enter new coordinate!");
        }

    }

}
