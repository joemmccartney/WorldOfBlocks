/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldofblocks;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;

/**
 *
 * @author Joe
 */
public class WorldOfBlocks {
    
    private static final Location L1 = new Location(50);
    private static final Location L2 = new Location(100);
    private static final Location L3 = new Location(150);
    private static final Location L4 = new Location(200);
    private static final Block BLOCK_A = new Block('a');
    private static final Block BLOCK_B = new Block('b');
    private static final Block BLOCK_C = new Block('c');
    private static final Block BLOCK_D = new Block('d');
    private static final Block BLOCK_E = new Block('e');
    private static final Block BLOCK_F = new Block('f');
    private static final Block BLOCK_G = new Block('g');
    private static final Block BLOCK_H = new Block('h');
    private static final Block BLOCK_I = new Block('i');
    private static final Block BLOCK_J = new Block('j');
    private static final Block BLOCK_K = new Block('k');
    private static final Block BLOCK_L = new Block('l');
    private static final Block BLOCK_M = new Block('m');
    private static final Block BLOCK_N = new Block('n');
    
    private static final Location[] L_ARRAY = new Location[4];
    private static final Block[] B_ARRAY = new Block[14];
    
    private static final int WINDOW_WIDTH = 320;
    private static final int WINDOW_HEIGHT = 480;
    private static final int BLOCK_DIM = 48;
    
    private static final JFrame WINDOW = new JFrame("Image Shell");
    private static final ImgPane IMG_PANE = new ImgPane(WINDOW_WIDTH, WINDOW_HEIGHT, BLOCK_DIM);
    

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, Exception {
        String[] endState = initialize();
        TimeUnit.SECONDS.sleep(4);
        IMG_PANE.setDelay(150);
        stateChange(endState);
        IMG_PANE.updateText("NOOP()");
        WINDOW.repaint();
    }
    
    public static String[] initialize() throws FileNotFoundException, InterruptedException {
        
        // Files for start and end states
        File startState = new File("startState.txt");
        File endState = new File("endState.txt");
        
        // Scanners for reading files
        Scanner scanStartState = new Scanner(startState);
        Scanner scanEndState = new Scanner(endState);
        
        // Array for handling Locations       
        L_ARRAY[0] = L1;
        L_ARRAY[1] = L2;
        L_ARRAY[2] = L3;
        L_ARRAY[3] = L4;
        
        // Array for handling Blocks        
        B_ARRAY[0] = BLOCK_A;
        B_ARRAY[1] = BLOCK_B;
        B_ARRAY[2] = BLOCK_C;
        B_ARRAY[3] = BLOCK_D;
        B_ARRAY[4] = BLOCK_E;
        B_ARRAY[5] = BLOCK_F;
        B_ARRAY[6] = BLOCK_G;
        B_ARRAY[7] = BLOCK_H;
        B_ARRAY[8] = BLOCK_I;
        B_ARRAY[9] = BLOCK_J;
        B_ARRAY[10] = BLOCK_K;
        B_ARRAY[11] = BLOCK_L;
        B_ARRAY[12] = BLOCK_M;
        B_ARRAY[13] = BLOCK_N;
        
        initGraphics();
        
        WINDOW.setVisible(true);
        
        // Read in start state to an array
        String[] start = new String[18];
        for (int i = 0; i < 18; i++) {
            start[i] = scanStartState.next();
        }
        
        String[] end = new String[18];
        for (int i = 0; i < 18; i++) {
            end[i] = scanEndState.next();
        }
        
        // Create start state
        int locationNum = 0;
        int blockHeight = BLOCK_DIM + (BLOCK_DIM / 2);
        for (int j = 0; j < 18; j++) {
            switch (start[j]) {
                case "L1":
                    locationNum = 0;
                    blockHeight = BLOCK_DIM + (BLOCK_DIM / 2);
                    break;
                case "L2":
                    locationNum = 1;
                    blockHeight = BLOCK_DIM + (BLOCK_DIM / 2);
                    break;
                case "L3":
                    locationNum = 2;
                    blockHeight = BLOCK_DIM + (BLOCK_DIM / 2);
                    break;
                case "L4":
                    locationNum = 3;
                    blockHeight = BLOCK_DIM + (BLOCK_DIM / 2);
                    break;
                default:
                    for (int i = 0; i < 14; i++) {
                        char temp = start[j].charAt(0);
                        if (temp == (B_ARRAY[i].getLetter())) {
                            L_ARRAY[locationNum].push(B_ARRAY[i]);
                            IMG_PANE.drawBlock(B_ARRAY[i].getLetter(), L_ARRAY[locationNum].getOffset(), (WINDOW_HEIGHT - blockHeight));
                            WINDOW.repaint();
                            blockHeight = blockHeight + (BLOCK_DIM / 2);
                            break;
                        }
                    }
                    break;
            }
        }
        return end;       
    }
    
    public static void initGraphics() {
        
        WINDOW.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        WINDOW.setResizable(false);
        WINDOW.setLocationRelativeTo(null);
        WINDOW.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        WINDOW.add(IMG_PANE);
        IMG_PANE.initPane();
    }
    
    public static void stateChange(String[] endState) throws Exception {
        //Find a block to place
        int endLocation = 0;
        int startLocation;
        int endIndex = 0;
        int startIndex;
        //int blockHeight = BLOCK_DIM + (BLOCK_DIM / 2);
        for (int j = 0; j < 18; j++) {
            switch (endState[j]) {
                case "L1":
                    endLocation = 0;
                    endIndex = -1;
                    //blockHeight = BLOCK_DIM + (BLOCK_DIM / 2);
                    break;
                case "L2":
                    endLocation = 1;
                    endIndex = -1;
                    //blockHeight = BLOCK_DIM + (BLOCK_DIM / 2);
                    break;
                case "L3":
                    endLocation = 2;
                    endIndex = -1;
                    //blockHeight = BLOCK_DIM + (BLOCK_DIM / 2);
                    break;
                case "L4":
                    endLocation = 3;
                    endIndex = -1;
                    //blockHeight = BLOCK_DIM + (BLOCK_DIM / 2);
                    break;
                default:
                    for (int i = 0; i < 14; i++) {
                        char temp = endState[j].charAt(0);
                        if (temp == (B_ARRAY[i].getLetter())) {
                            startLocation = findBlock(B_ARRAY[i]);
                            startIndex = L_ARRAY[startLocation].GetIndex(B_ARRAY[i]);
                            //Check if block is already where it is supposed to be
                            if ((startLocation == endLocation) && (endIndex == startIndex)) {
                                break;
                            }
                            //Is it clear?
                            if (L_ARRAY[startLocation].clear(B_ARRAY[i])){
                                // case for both start and end being available
                                if (L_ARRAY[endLocation].IndexIsFree(endIndex)) {
                                    moveBlock(startLocation, endLocation, B_ARRAY[i]);
                                }
                                // case for only start being available
                                else {
                                    int tempLocation = FreeLocation(startLocation, endLocation);
                                    while (!(L_ARRAY[endLocation].IndexIsFree(endIndex))) {
                                        if (L_ARRAY[endLocation].peak().equals(B_ARRAY[i])) {
                                            startLocation = AlternateLocation(startLocation, tempLocation);
                                            moveBlock(endLocation, startLocation, L_ARRAY[endLocation].peak());
                                        }
                                        moveBlock(endLocation, tempLocation, L_ARRAY[endLocation].peak());
                                    }
                                    moveBlock(startLocation, endLocation, B_ARRAY[i]);
                                       
                                        
                                    //}
                                }
                            }
                            else {
                                // case for only end being available
                                if (L_ARRAY[endLocation].IndexIsFree(endIndex)) {
                                    int tempLocation = FreeLocation(startLocation, endLocation);
                                    while (!(L_ARRAY[startLocation].clear(B_ARRAY[i]))) {
                                        moveBlock(startLocation, tempLocation, L_ARRAY[startLocation].peak());
                                    }
                                    moveBlock(startLocation, endLocation, B_ARRAY[i]);
                                }
                                // case for both start and end being unavailable
                                else {
                                    // case for both start and end are the same
                                    if(startLocation == endLocation) {
                                        int tempLocation = FreeLocation(startLocation, endLocation);
                                        while (!(L_ARRAY[endLocation].IndexIsFree(endIndex))) {
                                            moveBlock(endLocation, tempLocation, L_ARRAY[endLocation].peak());
                                        }
                                        startLocation = findBlock(B_ARRAY[i]);
                                        tempLocation = FreeLocation(startLocation, endLocation);
                                        while (!(L_ARRAY[startLocation].clear(B_ARRAY[i]))) {
                                            moveBlock(startLocation, tempLocation, L_ARRAY[startLocation].peak());
                                        }
                                        moveBlock(startLocation, endLocation, B_ARRAY[i]);
                                    }
                                    else {
                                    int tempLocation = FreeLocation(startLocation, endLocation);
                                    while (!(L_ARRAY[endLocation].IndexIsFree(endIndex))) {
                                        moveBlock(endLocation, tempLocation, L_ARRAY[endLocation].peak());
                                    }
                                    while (!(L_ARRAY[startLocation].clear(B_ARRAY[i]))) {
                                        moveBlock(startLocation, tempLocation, L_ARRAY[startLocation].peak());
                                    }
                                    moveBlock(startLocation, endLocation, B_ARRAY[i]);
                                    }
                                } 
                            }
                            
                            //IMG_PANE.drawBlock(B_ARRAY[i].getLetter(), L_ARRAY[locationNum].getOffset(), (WINDOW_HEIGHT - blockHeight));
                            //blockHeight = blockHeight + (BLOCK_DIM / 2);
                            break;
                        }
                        //System.out.println("Inner For Loop step " + i);
                    }
                    break;
            }            
            endIndex++;
        }        
    }
    
    public static int findBlock(Block block) {
        if (L_ARRAY[0].scanList(block))
            return 0;
        else if (L_ARRAY[1].scanList(block))
            return 1;
        else if (L_ARRAY[2].scanList(block))
            return 2;
        else if (L_ARRAY[3].scanList(block))
            return 3;
        else
            return -1;
    }
    
    public static void moveBlock(int startLocation, int endLocation, Block block) throws Exception {      
        int blockHeight = BLOCK_DIM + (BLOCK_DIM / 2);
        for (int i = 0; i <(L_ARRAY[startLocation].GetIndex(block)); i++) {
            blockHeight = blockHeight + (BLOCK_DIM / 2);
        }  
        Block tempBlock;
        if (L_ARRAY[startLocation].table(block)) {
            // pick up
            tempBlock = L_ARRAY[startLocation].pop();
            IMG_PANE.updateText("PICK-UP(" + tempBlock.getLetter() + ")");
            WINDOW.repaint();
            IMG_PANE.clearBlock(tempBlock.getLetter(), L_ARRAY[startLocation].getOffset(), (WINDOW_HEIGHT - blockHeight));
            WINDOW.repaint();
            IMG_PANE.updateText("MOVE(" + tempBlock.getLetter() + ", L" + (startLocation + 1) + ", L" + (endLocation + 1) + ")");
            IMG_PANE.updateMoveCount();
            WINDOW.repaint();
            IMG_PANE.moveBlock(tempBlock.getLetter(), L_ARRAY[endLocation].getOffset());
            WINDOW.repaint();
            if (L_ARRAY[endLocation].empty()) {
                IMG_PANE.updateText("PUT-DOWN(" + tempBlock.getLetter() + ", L" + (endLocation + 1) + ")");
                WINDOW.repaint();
            }
            else {
                IMG_PANE.updateText("STACK(" + tempBlock.getLetter() + ", L" + (endLocation + 1) + ")");
                WINDOW.repaint();
            }
            L_ARRAY[endLocation].push(tempBlock);
            blockHeight = BLOCK_DIM + ((BLOCK_DIM / 2) * (L_ARRAY[endLocation].GetIndex(block) + 1));
            IMG_PANE.drawBlock(tempBlock.getLetter(), L_ARRAY[endLocation].getOffset(), (WINDOW_HEIGHT - blockHeight));
        }
        else {
            tempBlock = L_ARRAY[startLocation].pop();
            IMG_PANE.updateText("UNSTACK(" + tempBlock.getLetter() + ")");
            WINDOW.repaint();
            IMG_PANE.clearBlock(tempBlock.getLetter(), L_ARRAY[startLocation].getOffset(), (WINDOW_HEIGHT - blockHeight));
            WINDOW.repaint();
            IMG_PANE.updateText("MOVE(" + tempBlock.getLetter() + ", L" + (startLocation + 1) + ", L" + (endLocation + 1) + ")");
            IMG_PANE.updateMoveCount();
            WINDOW.repaint();
            IMG_PANE.moveBlock(tempBlock.getLetter(), L_ARRAY[endLocation].getOffset());
            WINDOW.repaint();
            if (L_ARRAY[endLocation].empty()) {
                IMG_PANE.updateText("PUT-DOWN(" + tempBlock.getLetter() + ", L" + (endLocation + 1) + ")");
                WINDOW.repaint();
            }
            else {
                IMG_PANE.updateText("STACK(" + tempBlock.getLetter() + ", L" + (endLocation + 1) + ")");
                WINDOW.repaint();
            } 
            L_ARRAY[endLocation].push(tempBlock); 
            blockHeight = BLOCK_DIM + ((BLOCK_DIM / 2) * (L_ARRAY[endLocation].GetIndex(block) + 1));
            IMG_PANE.drawBlock(tempBlock.getLetter(), L_ARRAY[endLocation].getOffset(), (WINDOW_HEIGHT - blockHeight));
        }
        WINDOW.repaint();
    }
    
    public static int FreeLocation(int start, int end) {
        int returnVal = 0;
        int minLength = 15;
        if ((L_ARRAY[1].GetLength() < minLength) && (start != 0) && (end != 0)) {
            returnVal = 0;
            minLength = L_ARRAY[0].GetLength();
        }
        if ((L_ARRAY[1].GetLength() < minLength) && (start != 1) && (end != 1)) {
            returnVal = 1;
            minLength = L_ARRAY[1].GetLength();
        }
        if ((L_ARRAY[2].GetLength() < minLength) && (start != 2) && (end != 2)) {
            returnVal = 2;
            minLength = L_ARRAY[2].GetLength();
        }
        if ((L_ARRAY[1].GetLength() < minLength) && (start != 3) && (end != 3)) {
            returnVal = 3;
        }
        
        return returnVal;
    }
    
    public static int AlternateLocation(int start, int target) {
        switch (start) {
            case 0:
                switch(target) {
                    case 1:
                        return 2;
                    case 2:
                        return 1;
                    default:
                        return 1;
                }
            case 1:
                switch(target) {
                    case 0:
                        return 2;
                    case 2:
                        return 0;
                    default:
                        return 0;
                }
            default:
                switch(target) {
                    case 0:
                        return 1;
                    case 1:
                        return 0;
                    default:
                        return 0;
                }
        }
    }

    private static Exception Exception(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
