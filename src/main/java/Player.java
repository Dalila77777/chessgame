public class Player {
    public String name = "name";
    public Board board= new Board();
    public PieceColor color= new PieceColor();

    public Player(String name, Board board, PieceColor color)
    {
        this.name= name;
        this.board=board;
        this.color=color;
    }
}
