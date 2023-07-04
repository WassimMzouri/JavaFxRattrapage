package Model;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Categorie {
    private int ageMini;
    private int ageMaxi;
    public  String libelle;

    public static List<Categorie> listeCategories = new ArrayList<>();

    public Categorie(int ageMini, int ageMaxi, String libelle) {
        this.ageMini = ageMini;
        this.ageMaxi = ageMaxi;
        this.libelle = libelle;
    }

    public boolean correspond(int age) {
        return age >= ageMini && age <= ageMaxi;
    }

    public static String getCategorie(int anneeNaissance) {
        int age = LocalDateTime.now().getYear() - anneeNaissance;
        for (Categorie categorie : listeCategories) {
            if (categorie.correspond(age)) {
                return categorie.libelle;
            }
        }
        throw new IllegalArgumentException("Aucune catégorie correspondante trouvée.");
    }
 
    public static void chargerFichierTexte(String nomFichier) {
//        String cheminFichier = "Téléchargements/" + nomFichier;
        String cheminFichier =  nomFichier;
        try (BufferedReader br = new BufferedReader(new FileReader(cheminFichier))) {
            String ligne;
            while ((ligne = br.readLine()) != null) {
                String[] elements = ligne.split(",");
                int ageMini = Integer.parseInt(elements[0]);
                int ageMaxi = Integer.parseInt(elements[1]);
                String libelle = elements[2];
                Categorie categorie = new Categorie(ageMini, ageMaxi, libelle);
                listeCategories.add(categorie);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   
}
