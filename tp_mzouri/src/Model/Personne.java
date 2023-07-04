package Model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Personne {

	 private String nom;
	    private String annee;
	    private String categorie;

	    // Propriété statique pour stocker la liste des personnes
	    private static ObservableList<Personne> listePersonnes = FXCollections.observableArrayList();

	    public Personne(String nom, String annee, String categorie) {
	        this.nom = nom.toUpperCase();
	        this.annee = annee;
	        this.categorie = categorie;
	    }

	    public static ObservableList<Personne> getListePersonnes() {
	        return listePersonnes;
	    }

	    public static void setListePersonnes(ObservableList<Personne> listePersonnes) {
	        Personne.listePersonnes = listePersonnes;
	    }

	    @Override
	    public String toString() {
	        // Format d'affichage : NOM (Année) - Catégorie
	        return nom + " (" + annee + ") - " + categorie;
	    }
}
