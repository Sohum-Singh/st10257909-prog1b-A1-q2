package prog1b_assignment_q2;

public class Prog1b_assignment_q2 {

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.playGame();
        generateReport(game);
    }

    private static void generateReport(TicTacToe game) {
        System.out.println("\nGame Over!");
        System.out.println("Final Board:");
        game.displayBoard();
        System.out.println("Player " + game.getCurrentPlayer() + " wins!");
    }
}
