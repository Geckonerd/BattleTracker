import java.util.*;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // The game object handles all the logic
        Game game = new Game();

        while (game.gameRunning()) {
            // At the start of each turn, the current stats will be displayed
            // including money, items, health, conditions, and enemy status
            Scanner in = new Scanner(System.in);
            game.displayStats();

            // User chooses one of 4 options and the game goes from there.
            System.out.println();
            System.out.println("What would you like to do?");
            System.out.println("1. Attack, 2. Add item, 3. Use Potion, 4. Grab loot");
            String input = in.nextLine();
            game.takeTurn(input);

            // After the player does their part, the game handles the enemy's turn
            game.playerChanges();
        }
        // At the end of the game, it will display the final stats to the user.
        System.out.println("Your character has fallen! Better luck next time!");
        System.out.println("You dealt " + game.damageDealt + " damage this battle.");
        game.displayMoney();
    }
}