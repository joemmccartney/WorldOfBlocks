/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldofblocks;

/**
 *
 * @author Joe
 */
public class Location {
    private class Node<Block> {

        public Block payload;
        public Node next;

        public Node(Block payload) {
            this.payload = payload;
        }
    }
    
    private final int X_OFFSET;
    
    public Location(int xOffset) {
        X_OFFSET = xOffset;
    }
    
    public int getOffset() {
        return this.X_OFFSET;
    }

    private Node first = new Node(null);

    /**
     * checks to see if the list is empty.
     * @return if the list is empty in a boolean statement.
     */
    public boolean empty() {
        return first.next == null;
    }

     /**
     * This method adds a new item at the end of the list
     * @param payload the object stored by the item.
     */
    public void push(Block payload) {
        Node current = first;
        Node newNode = new Node(payload);
        if (first.next == null) {
            first.next = newNode;
            return;
        }
        if (current.next == null) {
            current.next = newNode;
            return;
        }
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }


    /**
     * This method removes the item at the end of the list.
     * @return 
     * @throws java.lang.Exception
     */
    public Block pop() throws Exception {

        // Case for if the list is empty
        if (first.next == null) {
            throw new Exception("Cannot pop - list is empty");
        }
        Node current = first;
        Node<Block> returnNode = first.next;
        while (returnNode.next != null) {
            current = current.next;
            returnNode = returnNode.next;
        }
        current.next = null;
        return returnNode.payload;
    }
    
    public Block peak() throws Exception {
        // Case for if the list is empty
        if (first.next == null) {
            throw new Exception("Cannot peak - list is empty");
        }
        Node current = first;
        Node<Block> returnNode = first.next;
        while (returnNode.next != null) {
            current = current.next;
            returnNode = returnNode.next;
        }
        return returnNode.payload;
    }
    
    public boolean scanList(Block block) {
        Node current = first.next;
        while (current != null) {
            if (block.equals(current.payload)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    public boolean clear(Block block) throws Exception {
        Node current = first.next;
        while (current != null) {
            if (block.equals(current.payload)) {
                return current.next == null;
            }
            current = current.next;
        }
        throw new Exception("Block not found in list");
    }
    
    public boolean table(Block block) {
        if (first.next != null) {
            return block.equals(first.next.payload);
        }
        return false;
    }
    
    public boolean on(Block blockTop, Block blockBot) throws Exception {
        Node current = first.next;
        Node previous = first;
        while (current != null) {
            if (blockTop.equals(current.payload)) {
                return blockBot.equals(previous.payload);
            }
            current = current.next;
            previous = previous.next;
        }
        throw new Exception("Block not found in list");
    }
    
    public int GetIndex(Block block) {
        int index = 0;
        Node current = first.next;
        while (current != null) {
            if (block.equals(current.payload)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }
    
    public int GetLength () {
        int length = 0;
        Node current = first.next;
        while (current != null) {
            current = current.next;
            length++;
        }
        return length;
    }
    
    public boolean above(Block blockTop, Block blockBot) {
        Node current = first.next;
        Node previous = first;
        boolean foundBot = false;
        while (current != null) {
            if (blockBot.equals(previous.payload)) {
                foundBot = true;
            }
            if (blockTop.equals(current.payload)) {
                if (foundBot) {
                    return true;
                }
            }          
            current = current.next;
            previous = previous.next;
        }
        
        return false;
    }
    
    public boolean IndexIsFree(int index) {
        int counter = 0;
        Node current = first.next;
        while (current != null) {
            counter++;
            current = current.next;
        }
        return index == counter;
    }
    
    public void print() {
        Node current = first.next;
        if (first.next == null) {
            return;
        }
        while (current.next != null) {
            System.out.println(current.payload.toString());
            current = current.next;
        }
        System.out.println(current.payload.toString());
    }
}
