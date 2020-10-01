package com.cpichon.slider;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * @author Christophe PICHON
 
 * Panel pour une lettre ie un score
 *
 */
public class LetterComponent extends JPanel {

    /**
     * les polices, mise en valeur ou pas
     *
     */
    private static final Font FONT_HL = new Font("Serif", Font.PLAIN, 48);
    private static final Font FONT_NOT_HL = new Font("Serif", Font.ITALIC, 40);
    /**
     * la lettre a afficher
     */
    private final char letter;
    /**
     * la couleur de fond
     */
    private final Color color;
    /**
     * mise en valeur ou pas
     */
    private boolean isHighligh = false;

    /**
     * constructeur
     *
     * @param letter
     * @param color
     */
    public LetterComponent(char letter, Color color) {
        super();
        this.letter = letter;
        this.color = color;

    }
    /**
     * met a jour la presentation pour cette lettre de score
     * @param newLetter 
     */
    public void updateLetter(char newLetter) {
        isHighligh = (newLetter == letter);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(color);

        if (isHighligh) {

            g.setFont(FONT_HL);
            g.drawString(String.valueOf(letter), getWidth() / 3, getHeight() / 2);
            g.setColor(Color.white);
            g.draw3DRect(10, 10, getWidth() - 20, getHeight() - 20, true);
            g.draw3DRect(12, 12, getWidth() - 24, getHeight() - 24, true);
        } else {

            g.setFont(FONT_NOT_HL);
            g.drawString(String.valueOf(letter), getWidth() / 3, getHeight() / 2);
        }
    }

}
