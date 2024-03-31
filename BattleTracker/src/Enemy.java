import java.util.*;
enum Type {
    defensive, offensive
}
public class Enemy {
    Type type;
    public Enemy() {
        type = Type.offensive;
    }

    public void displayType() {
        if (type == Type.defensive) {
            System.out.println("Enemy is on the defensive!");
        } else {
            System.out.println("Enemy is on the offensive!");
        }

    }

    // Each turn the enemy will switch between going on the offensive
    // or going on the defensive. This will affect their durability
    // and their damage for that turn.
    public void changeType() {
        int rand = new Random().nextInt(1,3);
        if (rand == 1) {
            type = Type.defensive;
        }
        else {
            type = Type.offensive;
        }
    }

    // If the enemy is on the offensive, they will do more damage
    public Integer enemyAttack() {
        if (type == Type.offensive) {
            return 10;
        }
        else {
            return 5;
        }
    }

    // If the enemy is on the defensive, they will take less damage
    public Integer enemyDefense() {
        if (type == Type.defensive) {
            return 5;
        }
        else {
            return 3;
        }
    }
}
