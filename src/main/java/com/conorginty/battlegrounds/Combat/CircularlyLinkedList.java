package com.conorginty.battlegrounds.Combat;

import com.conorginty.battlegrounds.CardCollections.CardCollection;
import com.conorginty.battlegrounds.Cards.Minion;

public class CircularlyLinkedList {
    // Represents the node of list.
    // Node stores a reference to a given Minion (in data attribute)
    public class Node {
        Minion data;
        Node next;

        public Node(Minion data) {
            this.data = data;
        }
    }

    //Declaring head and tail pointer as null.
    public Node head = null;
    public Node tail = null;

    // CardCollection of Interest (Usually the board)
    private CardCollection cardCollection;

    // No-Arg Constructor
    public CircularlyLinkedList() {
    }

    // With the card collection as a constructor
    public CircularlyLinkedList(CardCollection cardCollection) {
        for (int i=0; i < cardCollection.getSize(); i++) {
            Minion current = cardCollection.getMinions().get(i);
            add(current);
        }
    }

    //This function will add the new node at the end of the list.
    public void add(Minion data){
        //Create new node
        Node newNode = new Node(data);
        //Checks if the list is empty.
        if(head == null) {
            //If list is empty, both head and tail would point to new node.
            head = newNode;
            tail = newNode;
            newNode.next = head;
        }
        else {
            //tail will point to new node.
            tail.next = newNode;
            //New node will become new tail.
            tail = newNode;
            //Since, it is circular linked list tail will point to head.
            tail.next = head;
        }
    }

    public boolean containsNode(Minion searchValue) {
        Node currentNode = head;

        if (head == null) {
            // Empty Circularly Linked List
            return false;
        } else {
            do {
                if (currentNode.data == searchValue) {
                    return true;
                }
                currentNode = currentNode.next;
            } while (currentNode != head);
            return false;
        }
    }

    public void deleteNode(Minion valueToDelete) {
        Node currentNode = head;
        if (head == null) { // the list is empty
            return;
        }
        do {
            Node nextNode = currentNode.next;
            if (nextNode.data == valueToDelete) {
                if (tail == head) { // the list has only one single element
                    head = null;
                    tail = null;
                } else {
                    currentNode.next = nextNode.next;
                    if (head == nextNode) { //we're deleting the head
                        head = head.next;
                    }
                    if (tail == nextNode) { //we're deleting the tail
                        tail = currentNode;
                    }
                }
                break;
            }
            currentNode = nextNode;
        } while (currentNode != head);
    }

    //Displays all the nodes in the list
    public void display() {
        Node current = head;
        if(head == null) {
            System.out.println("List is empty");
        }
        else {
            System.out.println("Nodes of the circular linked list: ");
            do{
                //Prints each node by incrementing pointer.
                System.out.print(" "+ current.data);
                current = current.next;
            }while(current != head);
            System.out.println();
        }
    }

    public void printDetails() {
        System.out.println("Data contained in what Head is pointed to: " + head.data);
        System.out.println("Data contained in the node after Head (i.e. head.next): " + head.next.data);
        System.out.println("Data contained in what Tail is pointed to: " + tail.data);
        System.out.println("Data contained in the node after Tail (i.e. tail.next) pointed to: " + tail.next.data);
    }
}