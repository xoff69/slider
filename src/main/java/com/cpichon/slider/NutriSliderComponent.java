package com.cpichon.slider;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Christophe PICHON
 * 
 * 
 * le composant "Slider" type nutriscore
 */
public class NutriSliderComponent extends JPanel {

    /**
     * le JTextField de controle
     *
     */
    private JTextField jtfControl;

    /**
     * le tableau des composants
     */
    private final LetterComponent aLcScore[];
    // dans cette version, 5 notes donc  couleurs
    private final Color COLORS[] = {Color.GREEN, new Color(176, 242, 182), Color.YELLOW, Color.ORANGE, Color.RED};

    /**
     * constructeur
     */
    public NutriSliderComponent() {
        super();
        aLcScore = new LetterComponent[5];
        buildUI();
    }

    /*
    * mise a jour du score
     */
    public void updateLetter(int value) {
        jtfControl.setText(String.valueOf(value));
        for (int i=0;i<Constantes.NBNOTES;i++){
            aLcScore[i].updateLetter((char) ('A'+value));
        }
    }

    /**
     * fabrication de l'ihm
     */
    private void buildUI() {
        setPreferredSize(new Dimension(500, 200));
        setLayout(new BorderLayout());
        add(makeTitle(), BorderLayout.PAGE_START);
        add(makeSliderMain(), BorderLayout.CENTER);
        add(makeControl(), BorderLayout.PAGE_END);

    }

    /**
     * le titre
     *
     * @return
     */
    private JPanel makeTitle() {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel jl = new JLabel("Score");
        panel.add(jl, BorderLayout.CENTER);
        return panel;
    }

    /**
     * le composant slider
     *
     * @return
     */
    private JPanel makeSliderMain() {
        
        JPanel panel = new JPanel(new GridLayout(1, Constantes.NBNOTES));
        // ajout des composants lettres
        for (int i = 0; i < Constantes.NBNOTES; i++) {
            LetterComponent c = new LetterComponent((char) ('A' + i), COLORS[i]);
            aLcScore[i] = c;
            panel.add(c);
        }

        return panel;
    }

    /**
     * le panel de controle
     *
     * @return
     */
    private JPanel makeControl() {
        JLabel jl = new JLabel("Control - score recu:");
        jtfControl = new JTextField(5);
        jtfControl.setEditable(false);

        JPanel panel = new JPanel(new GridLayout(1, 2));
        panel.add(jl);
        panel.add(jtfControl);
        return panel;
    }
}
