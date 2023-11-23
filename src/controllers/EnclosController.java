package controllers;

import models.ZooFantastique;
import models.enclos.Enclos;
import view.EnclosView;

/**
 * La classe {@code EnclosController} est responsable de contrôler les interactions
 * liées aux enclos dans l'application. Elle facilite la communication entre
 * le modèle ({@link Enclos}) et la vue ({@link view.EnclosView}).
 * <p>
 * La principale fonctionnalité fournie par ce contrôleur est d'examiner les enclos
 * en affichant des informations via la {@link view.EnclosView} associée.
 * </p>
 * <p>
 *
 * @author [Raphael]
 * @version 1.0
 * @see Enclos
 * @see view.EnclosView
 */
public class EnclosController {

    private ZooFantastique zoo;

    public EnclosController(ZooFantastique zoo) {
        this.zoo = zoo;
    }

    /**
     * Affiche des informations sur les enclos en utilisant la {@link view.EnclosView} associée.
     */
    public void examinerEnclos() {
        EnclosView enclosView = new EnclosView(null);
        enclosView.displayEnclos();
    }

}