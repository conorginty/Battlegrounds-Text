package com.conorginty.battlegrounds.Combat;

import com.conorginty.battlegrounds.CardCollections.Board;
import com.conorginty.battlegrounds.CardCollections.Hand;
import com.conorginty.battlegrounds.CardCollections.Tavern;
import com.conorginty.battlegrounds.Cards.Minion;
import com.conorginty.battlegrounds.Cards.Tier1Minions.AlleyCat;
import com.conorginty.battlegrounds.Cards.Tier1Minions.FiendishServant;
import com.conorginty.battlegrounds.Cards.Tier1Minions.MurlocTidehunter;
import com.conorginty.battlegrounds.Player;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {

        Board board = new Board();
        Hand hand = new Hand(board);

        hand.printMinions();
        board.printMinions();

        MurlocTidehunter murlocTidehunter1 = new MurlocTidehunter(false, false, false, false, board);
        AlleyCat alleyCat = new AlleyCat(false, false, false, false, board);
        MurlocTidehunter murlocTidehunter2 = new MurlocTidehunter(false, false, false, false, board);
        FiendishServant fiendishServant = new FiendishServant(false, false, false, false, board);

        System.out.println("========");
        System.out.println(board.getMinions());
        System.out.println("========");
        // Filling the LinkedList
        ArrayList<Minion> minions = board.getMinions();

        CircularlyLinkedList cl = new CircularlyLinkedList();
        //Adds data to the list
        cl.add(minions.get(0));
        cl.add(minions.get(1));
        cl.add(minions.get(2));
        cl.add(minions.get(3));

        //Displays all the nodes present in the list
        cl.display();
        System.out.println("========");

        // Delete and display
        cl.deleteNode(murlocTidehunter2);
        cl.display();
        System.out.println("========");

        // Try and delete the same one again
        cl.deleteNode(murlocTidehunter2);
        cl.display();
        System.out.println("========");

        // Then delete the other murloc tidehunter object
        cl.deleteNode(murlocTidehunter1);
        cl.display();
        System.out.println("+++++++++++++++++++");

        // Using the Arg-Constructor
        CircularlyLinkedList anotherCircLL = new CircularlyLinkedList(board);
        anotherCircLL.display();
        System.out.println("+++++++++++++++++++");
        anotherCircLL.printDetails();
    }
}
