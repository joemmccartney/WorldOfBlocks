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
public class Block {
    
    private final char letter;
    
    public Block(char letter) {
        this.letter = letter;
    }
    
    public char getLetter() {
        return this.letter;
    }
    
    @Override
    public String toString() {
        String outputString;
        outputString = "" + this.letter;
        return outputString;
    }
}
