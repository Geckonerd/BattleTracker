
// Item stores data relative to the general sense,
// as well as for each specific item type
public class Item {
        String name;
}

// Weapons contribute to the player's offensive power,
// allowing them to do more damage
class Weapon extends Item {
    Integer offense;
    public Weapon(String name, Integer offense) {
        this.name = name;
        this.offense = offense;
    }
}
// Armor increases the player's defensive power,
// reducing the amount of damage they take
class Armor extends Item {
    Integer defense;
    public Armor(String name, Integer defense) {
        this.name = name;
        this.defense = defense;
    }
}

// Potion can heal the player, marking it as used when done
class Potion extends Item {
    Integer heal;
    Boolean used = false;
    public Potion(String name, Integer heal) {
        this.name = name;
        this.heal = heal;
    }
}

// Trinket is a magical type of item that increases both
// a player's offense and defense at the same time
class Trinket extends Item {
    Integer offense;
    Integer defense;
    public Trinket(String name, Integer offense, Integer defense) {
        this.name = name;
        this.offense = offense;
        this.defense = defense;
    }
}