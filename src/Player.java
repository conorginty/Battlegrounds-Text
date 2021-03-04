public class Player {
    // === Instance Variables ===
    private String username;
    private Board board;
    private Hand hand;

    // === Constructors ===
    public Player(String username, Board board, Hand hand) {
        this.username = username;
        // Player starts off with an empty board and hand (looked after in those classes)
        this.board = board;
        this.hand = hand;
    }

    // === Getters ===
    public String getUsername() {
        return username;
    }

    public Board getBoard() {
        return board;
    }

    public Hand getHand() {
        return hand;
    }

    // === Setters ===

    // === Extras ===
}
