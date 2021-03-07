package com.conorginty.battlegrounds;

import com.conorginty.battlegrounds.CardCollections.Board;
import com.conorginty.battlegrounds.CardCollections.Hand;
import com.conorginty.battlegrounds.CardCollections.Tavern;
import com.conorginty.battlegrounds.Cards.Minion;
import com.conorginty.battlegrounds.Cards.Tier1Minions.MurlocTidehunter;

import java.util.Random;
import java.util.Scanner;

import java.util.Arrays;

public class MainGame {

    // Scanner for reading User Input
    private static Scanner scanner = new Scanner(System.in);
    // Game Components
    private static Board board = new Board();
    private static Hand hand = new Hand(board);
    private static Tavern tavern = new Tavern(hand);
    private static Player player = new Player("Conor", board, hand, tavern);

    public static void main(String[] args) {
//        // ===== Playing a basic Game =====
//        Board board = new Board();
//        Hand hand = new Hand(board);
//        Tavern tavern = new Tavern(hand);
//
//        Player conor = new Player("Conor", board, hand, tavern);
//
//        hand.printMinions();
//        board.printMinions();
//
//        System.out.println(hand.getMaxCapacity());
//        System.out.println(hand.getSize());
//        System.out.println(board.getMaxCapacity());
//        System.out.println(board.getSize());
//
//        MurlocTidehunter murlocTidehunter = new MurlocTidehunter(false, false, false, false, hand);
//        System.out.println(murlocTidehunter.getName());
//        System.out.println(murlocTidehunter.getCardCollection().getName());
//        hand.printMinions();
//
//        hand.playMinion(0);
//        System.out.println("==================");
//        hand.printMinions();
//        board.printMinions();

        // ===== Playing a Game =====

        printWelcomeMessage();

        boolean quit = false;
        printActions();
        while (!quit) {
            System.out.println("Enter your choice: (10 - To print a list of available actions)");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clears the input buffer

            switch(choice) {
                case 0:
                    quit = true;
                    System.out.println("Thank you for playing. Come back again!");
                    break;
                case 1:
                    player.displayFullView();
                    break;
                case 2:
                    hand.printMinions();
                    break;
                case 3:
                    board.printMinions();
                    break;
                case 4:
                    tavern.printMinions();
                    break;
                case 5:
                    buyMinion();
                    break;
                case 6:
                    playMinion();
                    break;
//                case 10:
//                    battle();
//                    break;
                case 11:
                    printActions();
                    break;
            }
        }
    }

    // ===== Static Methods for Playing the Game =====
//    private static void printWelcomeMessage() {
//        System.out.println("****************************");
//        System.out.println("Welcome " + player.getUsername() + " to a Text Based Version of Hearthstone's Auto-Chess Battler - Battlegrounds");
//        System.out.println("****************************");
//    }

    private static void printWelcomeMessage() {
        System.out.print("Please Enter your Name: ");
        String name = scanner.nextLine();
        String message = "Welcome " + name + " to a Text Based Version of Hearthstone's Auto-Chess Battler - Battlegrounds";
        int n = message.length();
        char[] chars = new char[n];
        Arrays.fill(chars, '*');
        String decorator = new String(chars);
        System.out.println(decorator);
        System.out.println(message);
        System.out.println(decorator);
    }

    private static void printActions() {
        System.out.println("Press: ");
        System.out.println("\t 0 - To stop playing.");
        System.out.println("\t 1 - To display full view.");
        System.out.println("\t 2 - To display Hand.");
        System.out.println("\t 3 - To display Board.");
        System.out.println("\t 4 - To display Tavern.");
        System.out.println("\t 5 - To buy a Minion from the Tavern.");
        System.out.println("\t 6 - To play a Minion from your Hand.");
//        System.out.println("\t 7 - To sell a Minion from your Hand.");
//        System.out.println("\t 8 - To re-roll the Tavern.");
//        System.out.println("\t 9 - To upgrade the Tavern.");
        System.out.println("\t 10 - To end turn, and BATTLE!!!");
        System.out.println("\t 11 - To print a list of available actions.");
    }

    private static void buyMinion() {
        if (hand.isFull()) {
            System.out.println("Your hand is too full");
            return;
        }
        tavern.printMinions();
        if (tavern.isEmpty()) {
            System.out.println("Sorry, nothing to be bought.");
            return;
        }
        System.out.println("Enter the position of the Tavern Minion you wish to purchase: ");
        if (scanner.hasNextInt()) {
            // Index is one less than the option that they have selected
            int index = scanner.nextInt()-1;
            if (tavern.validIndex(index)) {
                Minion minionToBuy = tavern.getMinions().get(index);
                System.out.println("Successfully bought: " + minionToBuy.getName());
                player.buyMinion(minionToBuy);
            } else {
                System.out.println("Problem with the number: " + index);
            }
        } else {
            System.out.println("Invalid option Entered. No Minion was purchased");
        }
    }

    private static void playMinion() {
        hand.printMinions();
        if (hand.isEmpty()) {
            System.out.println("Your hand is empty. No minions to play");
            return;
        }
        if (board.isFull()) {
            System.out.println("Board is too full");
            return;
        }
        System.out.println("Enter the position of the Hand Minion you wish to play: ");
        if (scanner.hasNextInt()) {
            // Index is one less than the option that they have selected
            int index = scanner.nextInt()-1;
            if (hand.validIndex(index)) {
                Minion minionToPlay = hand.getMinions().get(index);
                System.out.println("Successfully played: " + minionToPlay.getName());
                player.playMinion(index);
            } else {
                System.out.println("Problem with the number: " + index);
            }
        } else {
            System.out.println("Invalid option Entered. No Minion was played");
        }
    }

//    private int battle(Player yourPlayer, Player enemyPlayer) {
//        // int represents outcome of battle: (1) if you won, (-1) if you lost and (0) if you drew
//        Board yourBoard = yourPlayer.getBoard();
//        Board enemyBoard = enemyPlayer.getBoard();
//        Battle battle = new Battle(yourBoard, enemyBoard);
//
//        boolean continueBattling = !(yourBoard.isEmpty() && enemyBoard.isEmpty());
//        while (continueBattling) {
//            if (yourBoard.isEmpty() && enemyBoard.isEmpty()) {
//                System.out.println("It was a Draw. Neither player took any damage");
//                return 0;
//            } else if (yourBoard.isEmpty()) {
//                System.out.println("Enemy Wins");
//                System.out.println("You took " + battle.determineDamageTaken(thePlayer, enemyBoard));
//                return -1;
//            } else if (enemyBoard.isEmpty()) {
//                System.out.println("You Win");
//                System.out.println("Your enemy took " + battle.determineDamageTaken(enemyPlayer, enemyBoard));
//                return 1;
//
//                // Rest of the battle logic
//                return 0;
//        }


//        Minion yourCurrentPointer = yourBoard.getMinions().get(0);
//        Minion enemyCurrentPointer = enemyBoard.getMinions().get(0);
        // returns true
//    }
}
