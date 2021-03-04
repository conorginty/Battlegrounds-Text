public class Minion {
    // === Instance Variables ===
    private String name;
    private int tavernTier;
    private int attack;
    private int health;
    private boolean hasBattlecry;
    private boolean hasDeathrattle;
    private boolean hasTaunt;
    private boolean hasDivineSheild;
    private String type; // Neutral, Murloc, Beast, Mech, Demons, Dragon, Pirate and Elemental
    private boolean isTavernMinion;
    private boolean isOwnedMinion;
    private boolean isHandMinion;
    private boolean isPlayedMinion;

    // === Constructors ===
    public Minion(String name, int tavernTier, int attack, int health, boolean hasBattlecry, boolean hasDeathrattle, boolean hasTaunt, boolean hasDivineSheild, String type, boolean isTavernMinion, boolean isOwnedMinion, boolean isHandMinion, boolean isPlayedMinion) {
        this.name = name;
        this.tavernTier = tavernTier;
        this.attack = attack;
        this.health = health;
        this.hasBattlecry = hasBattlecry;
        this.hasDeathrattle = hasDeathrattle;
        this.hasTaunt = hasTaunt;
        this.hasDivineSheild = hasDivineSheild;
        this.type = type;
        this.isTavernMinion = isTavernMinion;
        this.isOwnedMinion = isOwnedMinion;
        this.isHandMinion = isHandMinion;
        this.isPlayedMinion = isPlayedMinion;
    }

    // === Getters ===
    public String getName() {
        return name;
    }

    public int getTavernTier() {
        return tavernTier;
    }

    public int getAttack() {
        return attack;
    }

    public int getHealth() {
        return health;
    }

    public boolean isHasBattlecry() {
        return hasBattlecry;
    }

    public boolean isHasDeathrattle() {
        return hasDeathrattle;
    }

    public boolean isHasTaunt() {
        return hasTaunt;
    }

    public boolean isHasDivineSheild() {
        return hasDivineSheild;
    }

    public String getType() {
        return type;
    }

    public boolean isTavernMinion() {
        return isTavernMinion;
    }

    public boolean isOwnedMinion() {
        return isOwnedMinion;
    }

    public boolean isHandMinion() {
        return isHandMinion;
    }

    public boolean isPlayedMinion() {
        return isPlayedMinion;
    }

    // === Setters ===

    // === Extras ===
}