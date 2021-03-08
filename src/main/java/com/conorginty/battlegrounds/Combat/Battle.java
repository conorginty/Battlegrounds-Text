package com.conorginty.battlegrounds.Combat;

import com.conorginty.battlegrounds.CardCollections.Board;
import com.conorginty.battlegrounds.Cards.Minion;
import com.conorginty.battlegrounds.Player;

import java.util.Random;

// Visualisation of how a battle would look
//                =======
//    enemyBoard:  1 2 3
//                =======
//                1 2 3 4
//    yourBoard:  =======
// Both sets of Minions attack one another until one side of minions is full dead

public class Battle {
    private Player you;
    private Player enemy;
    private Board yourBoard;
    private Board enemyBoard;

//    public Battle(Board yourBoard, Board enemyBoard) {
//        this.yourBoard = yourBoard;
//        this.enemyBoard = enemyBoard;
//    }

    public Battle(Player you, Player enemy) {
        this.you = you;
        this.enemy = enemy;
        yourBoard = you.getBoard();
        enemyBoard = enemy.getBoard();
    }

    public boolean determineWhoStarts() {
        // Whoever's board has more minions starts
        // true if you start, false if enemy starts
        if (yourBoard.getSize() > enemyBoard.getSize()) {
            System.out.println("You start the battle");
            return true;
        } else if (yourBoard.getSize() < enemyBoard.getSize()) {
            System.out.println("Enemy starts the battle");
            return false;
        }
        // Else, both boards are equal in size so need to determine at random
        System.out.println("Determining who starts at random...");
        double random = Math.round(Math.random()); // Generate int: 0 or 1 at random
        if (random == 1) {
            System.out.println("You start the battle");
            return true;
        } else {
            System.out.println("Enemy starts the battle");
            return false;
        }
    }

    // Engage a battle between Minions
    public void engageMinionBattle(Minion attackingMinion, Minion defendingMinion) {
        attackingMinion.attackMinion(defendingMinion);
    }

    // Remove a Minion from that player's board (i.e. because it has died)
    public void removeMinionFromBattle(Minion minionToRemove, Board board) {
        board.getMinions().remove(minionToRemove);
    }

    // Minions attack from left to right
    // When all minions have fought, it starts again until all minions have died
    public void engageBattle() {
        int yourPointer = 0;
        int enemyPointer = 0;
        int indexOfTarget;

        boolean continueBattling = !(yourBoard.isEmpty() && enemyBoard.isEmpty());

        // if true, then you start
        if (determineWhoStarts()) {
            // Determine index of enemy minion to attack at random
            indexOfTarget = determineIndexOfMinionToAttack(enemyBoard);
        } // else the enemy starts
        else {
            // Determine index of your minion to attack at random
            indexOfTarget = determineIndexOfMinionToAttack(yourBoard);
        }
    }

//    // Determine if the battle was won by either player, or if there was a draw
//    public int determineEndResult() {
//        if (yourBoard.isEmpty() && enemyBoard.isEmpty()) {
//            System.out.println("It was a Draw. Neither player took any damage");
//            return 0;
//        } else if (yourBoard.isEmpty()) {
//            System.out.println("Enemy Wins");
//            System.out.println("You took " + determineDamageTaken(thePlayer, enemyBoard));
//            return -1;
//        } else if (enemyBoard.isEmpty()) {
//            System.out.println("You Win");
//            System.out.println("Your enemy took " + determineDamageTaken(enemyPlayer, enemyBoard));
//            return 1;
//        }
//        // Unsure what logic to include here (if any)
//        return 100;
//    }



    // Determines the Minion that should be attacked at random by generating a random index based on the size of the board
    public int determineIndexOfMinionToAttack(Board board) {
        Random rand = new Random();
        int index = rand.nextInt((board.getSize()));
        return index;
    }
}
