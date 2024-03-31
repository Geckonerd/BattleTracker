import java.util.*;
public class Game {
    Player player;
    Enemy enemy;
    Integer damageDealt = 0;
    public Game() {
        player = new Player();
        enemy = new Enemy();
    }

    public Boolean gameRunning() { return player.isAlive(); }
    public void displayStats() {
        player.displayStats();
        enemy.displayType();
    }

    public void displayMoney() {
        System.out.println(player.money);
    }

    // takeTurn will handle the input from the user, running logic or
    // calling functions related to the user's choice
    public void takeTurn(String input) {
        Scanner in = new Scanner(System.in);
        switch (input) {
            case "1":
                damageDealt += (player.getOffense()-enemy.enemyDefense());
                break;
            case "2":
                System.out.println("1: Weapon, 2: Armor, 3: Potion, 4: Trinket");
                String type = in.nextLine();
                System.out.println("Enter name of item");
                String name = in.nextLine();
                player.addItem(type, name);
                break;
            case "3":
                player.heal();
                break;
            case "4":
                player.loot();
                break;
        }
    }

    // playerChanges handles what happens to the player, which includes inflicting
    // damage and placing a new status condition on them
    public void playerChanges() {
        player.health -= Math.max(0, (enemy.enemyAttack() - player.getDefense()));
        player.inflictStatus();
        if (player.conditions.contains(status.poisoned)) {
            player.health -= 5;
        }

        enemy.changeType();
    }

}
