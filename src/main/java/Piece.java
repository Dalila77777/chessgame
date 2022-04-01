public class Piece {
    public int id;
    public int x;
    public int y;
    public Player player;
    private PieceColor color;

    public Piece (int x, int y, Player player, PieceColor color)
    {
        this.x=x;
        this.y=y;
        this.player= player;
        this.color= color;
    }

    public void Captrure()
    {

    }

    public void BeCaptured()
    {

    }

    public King Move(int finalx, int finaly)
    {
        return Move(x,y);
    }

    public boolean isvalid(int x, int y)
    {
        return false;
    }

    public PieceColor getColor() {
        return color;
    }

    public void setColor(PieceColor color) {
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getX()
    {
        return x;
    }

    public void setX(int x)
    {
        this.x=x;
    }

    public int getY()
    {
        return y;
    }

    public void setY(int y)
    {
        this.y=y;
    }





}
