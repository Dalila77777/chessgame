public class PieceBuilder {
    private int x;
    private int y;
    private Player player;

    public PieceBuilder setX(int x) {
        this.x = x;
        return this;
    }

    public PieceBuilder setY(int y) {
        this.y = y;
        return this;
    }

    public PieceBuilder setPlayer(Player player) {
        this.player = player;
        return this;
    }

    /*public Piece createPiece() {
        return new Piece(x, y, player, createPiece().getColor());
    }*/
}