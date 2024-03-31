import java.util.*;
enum  status {
    poisoned, cursed, empowered
}


public class Player {
    ArrayList<Item> inventory;
    HashSet<status> conditions;
    Map<String, Integer> money;
    Integer health;

    public Player() {
        inventory = new ArrayList<>();
        conditions = new HashSet<>();
        money = new HashMap<>();
        health = 100;
        basicInventory();
    }

    public void basicInventory() {
        inventory.addLast(new Weapon("Sword", 5));
        inventory.addLast(new Armor("Shield", 2));
        inventory.addLast(new Potion("Healing Potion", 10));
        inventory.addLast(new Trinket("Magic Amulet", 1, 1));
        money.put("Bronze", 10);
        money.put("Silver", 10);
        money.put("Gold", 10);
        money.put("Platinum", 10);
    }

    public Boolean isAlive() {
        return health > 0;
    }

    public void inflictStatus() {
        conditions.add(status.values()[new Random().nextInt(status.values().length)]);
    }

    // If the user chose to add an item, they will input what type of item
    // they want, and addItem will handle the rest.
    public void addItem(String type, String name) {
        if (Objects.equals(type, "1")) {
            inventory.addLast(new Weapon(name, new Random().nextInt(3, 6)));
        } else if (Objects.equals(type, "2")) {
            inventory.addLast(new Armor(name, new Random().nextInt(1, 4)));
        } else if (Objects.equals(type, "3")) {
            inventory.addLast(new Potion(name, new Random().nextInt(5, 11)));
        } else if (Objects.equals(type, "4")) {
            inventory.addLast(new Trinket(name,
                    new Random().nextInt(1, 5), new Random().nextInt(1, 6)));
        }
    }

    public void displayStats() {
        for (Item x : inventory) {
            if (x instanceof Weapon) {
                System.out.println(x.name + " " + ((Weapon) x).offense);
            }
            else if (x instanceof Armor) {
                System.out.println(x.name + " " + ((Armor) x).defense);
            }
            else if (x instanceof Potion) {
                System.out.println(x.name + " " + ((Potion) x).heal);
            }
            else if (x instanceof Trinket) {
                System.out.println(x.name + " " + ((Trinket) x).offense + " " + ((Trinket) x).defense);
            }
        }
        System.out.println(money);
        System.out.println(conditions);
        System.out.println("Remaining Health: " + health);
    }

    // getOffense calculates all changes to the player's offensive power
    // and returns the total to the call statement
    public Integer getOffense() {
        var offense = 0;
        if (conditions.contains(status.empowered)) {
            offense += 5;
        }

        if (inventory.isEmpty()) {
            return offense;
        }

        else {
            for (Item x : inventory) {
                if (x instanceof Weapon) {
                    offense = ((Weapon) x).offense + 5;
                }

                if (x instanceof Trinket) {
                    offense = ((Trinket) x).offense + 5;
                }
            }
        }
        return offense;
    }

    // getDefense calculates all changes to the player's defensive power
    // and returns the total to the call statement
    public Integer getDefense() {
        var defense = 0;
        if (conditions.contains(status.cursed)) {
            defense -= 5;
        }

        if (inventory.isEmpty()) {
            return defense;
        }
        else {
            for (Item x : inventory) {
                if (x instanceof Armor) {
                    defense = ((Armor) x).defense + 5;
                }
                if (x instanceof Trinket) {
                    defense = ((Trinket) x).defense + 5;
                }
            }
        }
        return defense;
    }

    // heal will use a potion from the inventory, and then it will be
    // removed from the list once used.
    public void heal() {
        for (Item x : inventory) {
            if (x instanceof Potion) {
                health += ((Potion) x).heal;
                ((Potion) x).used = true;
            }
        }
        inventory.removeIf(x -> (x instanceof Potion && ((Potion) x).used));
    }

    // loot will grab a random amount of each currency type and add it to the
    // players current amount of each one.
    public void loot() {
        money.put("Bronze", money.get("Bronze") + new Random().nextInt(1, 10));
        money.put("Silver", money.get("Silver") + new Random().nextInt(1, 10));
        money.put("Gold", money.get("Gold") + new Random().nextInt(1, 10));
        money.put("Platinum", money.get("Platinum") + new Random().nextInt(1, 10));
    }
}