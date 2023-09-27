package prog1b_assignment_q2;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class TicTacToeTest {

    private TicTacToe instance;

    @Before
    public void setUp() {
        instance = new TicTacToe();
    }

    @Test
    public void testDisplayBoard() {
        // This method just displays the board, so we can't perform automated tests on it.
        // You can visually verify the output in the console.
    }

    @Test
    public void testPlayGame_PlayerXWins() {
        // Simulate a game where Player X wins.
        instance.getBoard()[0][0] = 'X';
        instance.getBoard()[1][1] = 'X';
        instance.getBoard()[2][2] = 'X';
        instance.setCurrentPlayer('X'); // Set current player to X to simulate X's turn.
        instance.switchPlayer(); // Switch to O's turn to end the game.

        // Create a new TicTacToe instance and simulate the game
        TicTacToeResult result = simulateGame(instance);

        // Verify that Player X wins the game.
        assertEquals(TicTacToeResult.WIN_X, result);
    }

    @Test
    public void testPlayGame_GameDraw() {
        // Simulate a game that ends in a draw.
        instance.getBoard()[0][0] = 'X';
        instance.getBoard()[0][1] = 'O';
        instance.getBoard()[0][2] = 'X';
        instance.getBoard()[1][0] = 'X';
        instance.getBoard()[1][1] = 'O';
        instance.getBoard()[1][2] = 'O';
        instance.getBoard()[2][0] = 'O';
        instance.getBoard()[2][1] = 'X';
        instance.getBoard()[2][2] = 'X';

        // Create a new TicTacToe instance and simulate the game
        TicTacToeResult result = simulateGame(instance);

        // Verify that the game ends in a draw.
        assertEquals(TicTacToeResult.DRAW, result);
    }

    @Test
    public void testGetBoard() {
        char[][] expResult = new char[3][3]; // A new empty board
        char[][] result = instance.getBoard();
        assertArrayEquals(expResult, result);
    }

    @Test
    public void testGetCurrentPlayer() {
        char expResult = 'X';
        char result = instance.getCurrentPlayer();
        assertEquals(expResult, result);
    }

    // Helper method to simulate a game and return the result.
    private TicTacToeResult simulateGame(TicTacToe game) {
        while (true) {
            if (game.checkWin()) {
                if (game.getCurrentPlayer() == 'X') {
                    return (TicTacToeResult) TicTacToeResult.WIN_X;
                } else {
                    return TicTacToeResult.WIN_O;
                }
            } else if (game.isBoardFull()) {
                return TicTacToeResult.DRAW;
            }
            game.switchPlayer();
        }
    }
}
