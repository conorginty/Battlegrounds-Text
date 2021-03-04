import java.util.ArrayList;

public class CardCollection {
    // === Instance Variables ===
    private ArrayList<Minion> minions;
    private int maxCapacity;
    private int size;

    // === Constructors ===
    public CardCollection(int maxCapacity) {
        // Default as you start of with nothing;
        this.minions = new ArrayList<Minion>(); // Empty ArrayList;
        this.maxCapacity = this.maxCapacity; // max capacity for a Board is 7 and 10 for a Hand
        this.size = 0; // Both boards and hands should start off empty
    }

    // === Getters ===
    public ArrayList<Minion> getBoardMinions() {
        return minions;
    }

    public int getSize() {
        return size;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    // === Setters ===

    // === Extras ===
    public boolean isEmpty() {
        return size == 0;
    }
}
