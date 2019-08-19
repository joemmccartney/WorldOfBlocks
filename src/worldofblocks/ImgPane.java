/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldofblocks;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.concurrent.TimeUnit;

import javax.swing.JPanel;

/**
 *
 * @author Joe
 */
public class ImgPane extends JPanel implements ActionListener {
    
    private BufferedImage image;
    private Graphics2D graphic;
    
    private final int WIDTH;
    private final int HEIGHT;
    private final int BLOCK_DIM;
    private int delay = 100;
    private int moveCount = 0;
    
    public ImgPane(int width, int height, int blockDim) {
        this.WIDTH = width;
        this.HEIGHT = height;
        this.BLOCK_DIM = blockDim;
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        graphic = (Graphics2D) image.getGraphics();
    }
    
    public void initPane() {
        int tableHeight = HEIGHT - 50;
        graphic.setColor(Color.white);
        graphic.drawLine(0, tableHeight, WIDTH, tableHeight);
        graphic.drawString("L1", 53, HEIGHT - 35);
        graphic.drawString("L2", 103, HEIGHT - 35);
        graphic.drawString("L3", 153, HEIGHT - 35);
        graphic.drawString("L4", 203, HEIGHT - 35);
        graphic.drawString("Loading Start State...", 0, 20);
    }
    
    public void drawBlock(char block, int xOffset, int yOffset) throws InterruptedException {
        String letter = String.valueOf(block);
        int letterX = xOffset + (BLOCK_DIM / 7);
        int letterY = yOffset + (BLOCK_DIM / 3);
        graphic.setColor(Color.white);
        graphic.clearRect(0, 50, WIDTH, 21);
        graphic.drawRect(xOffset, yOffset, 20, 20);
        graphic.drawString(letter, letterX, letterY);
        TimeUnit.MILLISECONDS.sleep(delay);
    }
    
    public void clearBlock(char block, int xOffset, int yOffset) throws InterruptedException {
        String letter = String.valueOf(block);
        int letterX = xOffset + (BLOCK_DIM / 7);
        int letterY = 50 + (BLOCK_DIM / 3);
        graphic.setColor(Color.white);
        graphic.clearRect(xOffset, yOffset, 21, 21);
        graphic.drawRect(xOffset, 50, 20, 20);
        graphic.drawString(letter, letterX, letterY);
        TimeUnit.MILLISECONDS.sleep(delay);
    }
    
    public void moveBlock(char block, int xOffset) throws InterruptedException {
        String letter = String.valueOf(block);
        int letterX = xOffset + (BLOCK_DIM / 7);
        int letterY = 50 + (BLOCK_DIM / 3);
        graphic.setColor(Color.white);
        graphic.clearRect(0, 50, WIDTH, 21);
        graphic.drawRect(xOffset, 50, 20, 20);
        graphic.drawString(letter, letterX, letterY);
        TimeUnit.MILLISECONDS.sleep(delay);
    }
    
    public void updateText(String text) throws InterruptedException {
        graphic.clearRect(0, 0, (WIDTH / 2), 30);
        graphic.drawString(text, 0, 20);
        TimeUnit.MILLISECONDS.sleep(delay);
    }
    
    public void updateMoveCount() {
        moveCount++;
        graphic.clearRect((WIDTH / 2), 0, (WIDTH / 2), 30);
        graphic.drawString(("Moves: " + moveCount), (WIDTH / 2), 20);
    }
    
    public void setDelay(int val) {
        this.delay = val;
    }
    
    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
