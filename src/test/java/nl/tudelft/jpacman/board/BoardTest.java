package nl.tudelft.jpacman.board;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class BoardTest {

    @Test
    void testValidBoardInvariantAndSquareAt() {
        Square square = new BasicSquare();
        Square[][] grid = new Square[][] { { square } };
        Board board = new Board(grid);
        assertTrue(board.invariant(), "Board should be valid when all squares are non-null.");

        assertEquals(square, board.squareAt(0, 0), "squareAt(0,0) should return the correct square.");
    }

    @Test
    void testInvalidBoardInvariantAndSquareAt() {
        Square[][] grid = new Square[][] { { null } };
        AssertionError thrown = assertThrows(AssertionError.class, () -> new Board(grid),
            "Expected an AssertionError due to null square in board.");
        assertTrue(thrown.getMessage().contains("Initial grid cannot contain null squares"));
    }

}
