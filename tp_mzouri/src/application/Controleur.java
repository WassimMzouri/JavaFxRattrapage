package application;
import Model.Personne;
import Model.Categorie;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class Controleur {
	

    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfAnnee;
    @FXML
    private TextField tfCategorie;
    @FXML
    private ListView<Personne> lvPersonne;

    private ObservableList<Personne> listePersonnes;

    public void initialize() {
        // Initialisation de la liste des personnes
        listePersonnes = Personne.getListePersonnes();
        lvPersonne.setItems(listePersonnes);
    }

    @FXML
    public void actionEnregistrer(ActionEvent evt) {
        String nom = tfNom.getText();
        String annee = tfAnnee.getText();
        String categorie = tfCategorie.getText();

        // Création d'une nouvelle personne
        Personne personne = new Personne(nom, annee, categorie);

        // Ajout de la personne à la liste
        listePersonnes.add(personne);

        // Effacement des champs de texte
        tfNom.clear();
        tfAnnee.clear();
        tfCategorie.clear();
    }
	
}
