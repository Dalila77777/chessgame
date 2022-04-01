public class King extends Piece {
    public King(int x, int y, Player player, PieceColor color)
    {
        super(x, y, player,color);
    }

    public boolean isvalid(int a, int b) {
        if(a<=8 && b<=8) {
            if ((a == x + 1 && b == y + 1) || (a == x - 1 && b == y - 1) || (a == x && b == y - 1) || (a == x && b == y + 1) || (a == x + 1 && b == y) || (a == x - 1 && b == y)) {
                return true;
            } else if ((a == x + 1 && b == y - 1) || (a == x - 1 && b == y + 1))
                return true;
        }

        return false;

    }

    public King Move(int finalx, int finaly)
    {
        Board board= new Board();
        //
        return null;
    }

    /*public boolean isvalid(int a, int b)
    {
        if((a==x+1 &&b==y+1) ||(a==x-1 && b==y-1) || (a==x && b==y-1) || (a==x && b==y+1) || (a==x+1 && b==y) || (a==x-1 && b==y))
        {
            return true;
        }
        else if ((a==x+1 &&b==y-1) ||(a==x-1 && b==y+1))
            return true;

        return false;
    }*/
}
