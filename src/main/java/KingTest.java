import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class KingTest {

    @Test
    public void Isvalidated()
    {
        //int a;
        //int b;
        PieceColor color= new PieceColor();
        Player player= new Player("player 1", new Board(), color);
        King king= new King(1, 1,player, color);
        king.Captrure();
        assertTrue(king.isvalid(2,1));
        assertTrue(king.isvalid(2,2));
        assertTrue(king.isvalid(2,0));
        assertTrue(king.isvalid(2,1));
        assertTrue(king.isvalid(0,0));
        assertTrue(king.isvalid(0,1));
        assertTrue(king.isvalid(0,2));
        assertTrue(king.isvalid(1,0));
        assertTrue(king.isvalid(1,2));
        //assertTrue(king.isvalid(8,0));

        // testa när det är fel
        //assertTrue(king.isvalid(0,9));
    }

    /*
    @Test
    public void shouldbeAbleToCapture() throws Exception
    {
        Player player= new Player("player2");
        King king = new King(0, 0, player);
        king.Captrure();
    }

    @Test
    public void shouldbeAbleToBeCaptured() throws Exception
    {
        Player player= new Player("player2");
        King king = new King(0, 0, player);
        king.BeCaptured();
    }

    @Test
    public void shouldbeAbleToMove() throws Exception
    {
        Player player= new Player("player2");
        King king = new King(0, 0, player);
        king.Move(1,1);
    }

     */
}
