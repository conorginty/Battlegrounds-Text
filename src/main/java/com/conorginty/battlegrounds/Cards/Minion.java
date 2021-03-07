package com.conorginty.battlegrounds.Cards;

import com.conorginty.battlegrounds.CardCollections.Board;
import com.conorginty.battlegrounds.CardCollections.CardCollection;
import com.conorginty.battlegrounds.Cards.AbilityInterfaces.Deathrattle;

import java.util.ArrayList;

public class Minion {
    // === Instance Variables/ Fields ===
    private String name;
    private int tavernTier;
    private int attack;
    private int health;
    private String type; // Neutral, Murloc, Beast, Mech, Demons, Dragon, Pirate and Elemental
    private boolean hasBattlecry;
    private boolean hasDeathrattle;
    private boolean hasTaunt;
    private boolean hasDivineShield;
    // I don't think the following Fields should be included in the JSON
    private boolean isTavernMinion;
    private boolean isOwnedMinion;
    private boolean isHandMinion;
    private boolean isPlayedMinion;
    // Reference to the Card Collection (as the Minion needs to know where it is)
    public CardCollection cardCollection;
    // The minion will be created somewhere
    // Wherever it's created, it should know about it
    // When the board is creating the minion, it's passing itself
    private static int cost = 3;

    // === Constructors ===
    public Minion(String name, int tavernTier, int attack, int health, String type, boolean hasBattlecry, boolean hasDeathrattle, boolean hasTaunt, boolean hasDivineShield, boolean isTavernMinion, boolean isOwnedMinion, boolean isHandMinion, boolean isPlayedMinion, CardCollection cardCollection) {
        this.name = name;
        this.tavernTier = tavernTier;
        this.attack = attack;
        this.health = health;
        this.type = type;
        this.hasBattlecry = hasBattlecry;
        this.hasDeathrattle = hasDeathrattle;
        this.hasTaunt = hasTaunt;
        this.hasDivineShield = hasDivineShield;
        this.isTavernMinion = isTavernMinion;
        this.isOwnedMinion = isOwnedMinion;
        this.isHandMinion = isHandMinion;
        this.isPlayedMinion = isPlayedMinion;
        this.cardCollection = cardCollection;
        // When we create the minion for that collection, add it to that collection
        cardCollection.addNewMinion(this);
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

    public boolean isHasDivineShield() {
        return hasDivineShield;
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

    public CardCollection getCardCollection() {
        return cardCollection;
    }

    public static int getCost() {
        return cost;
    }

    // === Setters ===

    public void setCardCollection(CardCollection cardCollection) {
        this.cardCollection = cardCollection;
    }

    // === Extras ===
    private void attackEnemyMinion() {

    }

    public void gainAttack(int amount) {
        attack += amount;
    }

    public void gainHealth(int amount) {
        health += amount;
    }

    public void loseHealth(int amount) {
        health -= amount;
    }

    public boolean die() {
        if (health <= 0) {
            System.out.println("Minion has died...");
            return true;
        }
        return false;
    }

    // Summon the Minion from hand to the Board
    public boolean play() {
        System.out.println("Minion has been played...");
        return true;
    }

    public void attackMinion(Minion target) {
        // targeted Minion loses health equal to the attacking minion's attack
        target.loseHealth(this.attack);
        // The attacking Minion also loses health equal to the defending minion's attack
        loseHealth(target.attack);
    }

    // ===== Factory Constructor??? =====
    // Public static method to create a new Minion
    // static is important, as it means we don't have to create a new object instance for this Minion class
    public static Minion createMinion(String name, int tavernTier, int attack, int health, String type, boolean hasBattlecry, boolean hasDeathrattle, boolean hasTaunt, boolean hasDivineShield, boolean isTavernMinion, boolean isOwnedMinion, boolean isHandMinion, boolean isPlayedMinion, CardCollection cardCollection) {
        return new Minion(name, tavernTier, attack, health, type, hasBattlecry, hasDeathrattle, hasTaunt, hasDivineShield, isTavernMinion, isOwnedMinion, isHandMinion, isPlayedMinion, cardCollection);
    }

}