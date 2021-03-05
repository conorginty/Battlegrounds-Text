package com.conorginty.battlegrounds;

import com.conorginty.battlegrounds.CardCollections.Board;
import com.conorginty.battlegrounds.CardCollections.Hand;
import com.conorginty.battlegrounds.CardCollections.Tavern;
import com.conorginty.battlegrounds.Cards.Minion;
import com.conorginty.battlegrounds.Cards.Tier1Minions.MurlocTidehunter;

public class MainGame {
    public static void main(String[] args) {
        // ===== Playing a basic Game =====
        Board board = new Board();
        Hand hand = new Hand(board);
        Tavern tavern = new Tavern(hand);

        Player conor = new Player("Conor", board, hand, tavern);

        hand.printMinions();
        board.printMinions();

        System.out.println(hand.getMaxCapacity());
        System.out.println(hand.getSize());
        System.out.println(board.getMaxCapacity());
        System.out.println(board.getSize());

        MurlocTidehunter murlocTidehunter = new MurlocTidehunter(false, false, false, false, hand);
        System.out.println(murlocTidehunter.getName());
        System.out.println(murlocTidehunter.getCardCollection().getName());
        hand.printMinions();

        hand.playMinion(0);
        System.out.println("==================");
        hand.printMinions();
        board.printMinions();
    }
}
