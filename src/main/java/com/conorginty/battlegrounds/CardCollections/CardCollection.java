package com.conorginty.battlegrounds.CardCollections;

import com.conorginty.battlegrounds.Cards.Minion;

import java.util.ArrayList;
// Random number generator
import java.util.Random;

public class CardCollection {
    // === Instance Variables ===
    private String name;
    private ArrayList<Minion> minions;
    private int maxCapacity;
    private int size;

    // === Constructors ===
    public CardCollection(String name, int maxCapacity) {
        this.name = name;
        // Default as you start of with nothing;
        this.minions = new ArrayList<Minion>(); // Empty ArrayList;
        this.maxCapacity = maxCapacity; // max capacity for a Board is 7 and 10 for a Hand
        this.size = minions.size(); // Both boards and hands should start off empty (and are dependent on the size of the list)
    }

    // === Getters ===
    public String getName() {
        return name;
    }

    public ArrayList<Minion> getMinions() {
        return minions;
    }

//    public int getSize() {
//        return size;
//    }
    public int getSize() {
        return minions.size();
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    // === Setters ===

    // === Extras ===
    public boolean isEmpty() {
        return minions.size() == 0;
    }

    public boolean isFull() {
        return size == maxCapacity;
    }

    public void printTooFullMessage() {
        System.out.println("Your " + name + " is too full. Minion not added.");
    }

    public void printMinionAddedSuccessfullyMessage(Minion minion) {

        System.out.println("Minion: " + minion.getName() + " was added successfully to your " + name);
    }

    public void printMinionDoesntExistMessage(Minion minion) {
        System.out.println("Minion: " + minion.getName() + " does not exist. Minion not added to your " + name);
    }

    public boolean validIndex(int index) {
        return (index >= 0 && index <= minions.size());
        // OPPOSITE LOGIC: index < 0 || index >= size
    }
    private int findMinion(String queryMinionName) {
        for (int i=0; i < minions.size(); i++) {
            Minion current = minions.get(i);
            if (current.getName().equals(queryMinionName)) {
                // Then the Minion exists within this collection
                return i;
            }
        }
        // Minion doesn't exist in this collection
        return -1;
    }

    // ==== Locate a Minion in a given Card Collection ====
    public int findMinion(Minion minion) {
        // return index of customer (-1 if it doesn't exist)
        return minions.indexOf(minion);
    }

    /*
    - Adding a Minion from X (CardCollection) to your Y (CardCollection);
    - e.g. Adding a Minion from Tavern to your Hand;
    - e.g. Adding a Minion from Hand to your Board;
     */
    public boolean addNewMinion(Minion minion, CardCollection other) {
        if (isFull()) {
            printTooFullMessage();
        } else {
            // Try locating the minion in the X (e.g. Tavern, Hand etc)
            int foundIndex = other.findMinion(minion);
            if (foundIndex >= 0) {
                // Then the minion exists, so we add it to the non-full Y (e.g. Hand, Board etc)
                printMinionAddedSuccessfullyMessage(minion);
                minions.add(minion);
                return true;
            }
            // otherwise, minion doesn't exist (I DON'T THINK THIS SHOULD EVER HAPPEN, THOUGH - WE'LL ADD CONSTRAINTS SO THEY ADD BASED ON POSITION IN THE TAVERN)
            printMinionDoesntExistMessage(minion);
        }
        return false;
    }

    public boolean addNewMinion(int index, CardCollection other) {
        if (isFull()) {
            printTooFullMessage();
        } else if (index < 0 || index >= other.size) {
            System.out.println("You have chosen an invalid index of " + index + ". No minion was added");
        } else {
            // Get Minion from the correct index
            Minion minion = minions.get(index);
            // Add it to the non-full Y (e.g. Hand, Board etc)
            printMinionAddedSuccessfullyMessage(minion);
            minions.add(minion);
            // Make it aware of what Card Collection it's apart of
            minion.setCardCollection(this);
            return true;
        }
        return false;
    }

    // Effectively the same as Summon
    public boolean addNewMinion(Minion minion) {
        if (isFull()) {
            printTooFullMessage();
        } else {
            printMinionAddedSuccessfullyMessage(minion);
            minions.add(minion);
            // Make it aware of what Card Collection it's apart of
            minion.setCardCollection(this);
        }
        return false;
    }

    public Minion popMinion(int index) {
        if (validIndex(index)) {
            System.out.println("Removing Minion at index " + index + " from the " + name);
            return minions.remove(index);
        }
        return null;
    }

    public Minion getRandomMinion() {
        Random randomGenerator = new Random();
        int index = randomGenerator.nextInt(minions.size());
        Minion minion = minions.get(index);
        return minion;
    }

    public void printMinions() {
        System.out.println("****** Current " + name + " ******");
//        System.out.println("Current Minion Count = " + size); // I DON'T UNDERSTAND WHY THIS DOESN'T WORK??
        System.out.println("Current Minion Count = " + minions.size());
        if (minions.isEmpty()) {
            System.out.println(name + " is currently empty");
            System.out.println();
            return;
        }
        for (int i=0; i < minions.size(); i++) {
            Minion current = minions.get(i);
//            System.out.println(i+1 + ". " + current.getName() + " -> " + current.getAttack() + "/" + current.getHealth());
            System.out.println(i+1 + ". " + current);
        }
    }
}
