package com.cpichon.slider;

import java.util.TimerTask;

/**
 *
 * @author Christophe PICHON
 *
 * tache lancee par le scheduler la tache recupere le nombre aleatoire et met a
 * jour le slider
 */
public class UpdateSliderRepeatTask extends TimerTask {

    /**
     * le composant a mettre a jour
     */
    private final NutriSliderComponent slider;
    /**
     * le generateur de nombre
     */
    private final Generator generator;

    /**
     * le constructeur
     *
     * @param slider
     */
    public UpdateSliderRepeatTask(NutriSliderComponent slider) {
        this.slider = slider;
        generator = new Generator();
    }

    /**
     * // met a jour le composant slider
     */
    @Override
    public void run() {
        
        int gen = generator.getValue();
        slider.updateLetter(gen);
    }
}
