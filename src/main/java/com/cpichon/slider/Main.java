package com.cpichon.slider;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Timer;
import javax.swing.JFrame;

/**
 *
 * @author Christophe PICHON 
 * 
 * classe principale
 */
public class Main {

    /**
     * intervalle entre 2 rafraichissements du slider
     */
    private static final int PERIODICITY = 10000;

    /**
     * le composant graphique gere par la frame
     */
    private static NutriSliderComponent slider;

    /**
     * initialise le scheduler
     */
    private static void initScheduler() {
        new Timer().schedule(new UpdateSliderRepeatTask(slider), 0, PERIODICITY);
    }

    /**
     * initialise la fenetre principale
     */
    private static void initUI() {

        // création de l'application
        JFrame f = new JFrame();
        // affectation du titre et de l'icône
        f.setTitle("Slider Nutriscore");
        // affectation de l'opération à effectuer lors de la fermeture de la fenêtre
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // taille et position
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        f.setSize(screenSize);

        f.setLocation(0, 0);

        f.setLocationRelativeTo(null);
        
        slider = new NutriSliderComponent();
        f.setLayout(new BorderLayout());
        f.add(slider, BorderLayout.CENTER);
        // rendre la fenêtre visible, pack fait en sorte que tous les composants de l'application soient à
        // leur preferredSize, ou au dessus
        f.pack();

        
        f.setVisible(true);
    }

    /**
     * lance le slider
     *
     * @param args
     */
    public static void main(String[] args) {
        initUI();
        initScheduler();
    }
}
