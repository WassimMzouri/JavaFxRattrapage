package application;
 
import Model.Categorie;
import Model.Personne;
 
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.image.Image;
import javafx.scene.layout.ColumnConstraints;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		/*
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("IHM.fxml"));
			Scene scene = new Scene(root,800,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}*/		
	   try {   
		// Création GridPane
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setStyle("-fx-background-color: LIGHTGRAY;");

        // Ajout du titre
        Label titreLabel = new Label("Catégories");
        titreLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
        GridPane.setConstraints(titreLabel, 0, 0, 3, 1);
        gridPane.getChildren().add(titreLabel);

        // Ajout des label dans la 1er colonne
        Label nomLabel = new Label("Nom:");
        Label anneeLabel = new Label("Année:");
        Label categorieLabel = new Label("Catégorie:");
        nomLabel.setAlignment(javafx.geometry.Pos.CENTER_RIGHT);
        anneeLabel.setAlignment(javafx.geometry.Pos.CENTER_RIGHT);
        categorieLabel.setAlignment(javafx.geometry.Pos.CENTER_RIGHT);
        GridPane.setConstraints(nomLabel, 0, 1);
        GridPane.setConstraints(anneeLabel, 0, 2);
        GridPane.setConstraints(categorieLabel, 0, 3);
        gridPane.getChildren().addAll(nomLabel, anneeLabel, categorieLabel);

        // Ajout des textfield dans la 2e colonne
        TextField nomTextField = new TextField();
        TextField anneeTextField = new TextField();
        TextField categorieTextField = new TextField();
        GridPane.setConstraints(nomTextField, 1, 1);
        GridPane.setConstraints(anneeTextField, 1, 2);
        GridPane.setConstraints(categorieTextField, 1, 3);
        gridPane.getChildren().addAll(nomTextField, anneeTextField, categorieTextField);

        // Ajout du bouton Enregistrer dans la 3e colonne
        Button enregistrerButton = new Button("Enregistrer");
        GridPane.setConstraints(enregistrerButton, 1, 4);
        gridPane.getChildren().add(enregistrerButton);

        // Ajout de la ListView dans la 4e colonne
        ListView<String> listView = new ListView<>();
        GridPane.setConstraints(listView, 2, 1, 1, 4);
        gridPane.getChildren().add(listView);

        // Ajustement de la taille des colonnes
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(30);
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPercentWidth(30);
        ColumnConstraints column3 = new ColumnConstraints();
        column3.setPercentWidth(40);
        gridPane.getColumnConstraints().addAll(column1, column2, column3);

        // Création de la scène
        Scene scene = new Scene(gridPane, 400, 200);
        scene.setFill(javafx.scene.paint.Color.LIGHTGREY);

        // Chargement de l'icone 3il 
        Image icon = new Image("file:logo.png");
        primaryStage.getIcons().add(icon);
        //primaryStage.getIcons().add(new Image(this.getClass().getResourceAsStream("icon.png")));

        //Configuration de la fenetre principale
        primaryStage.setScene(scene);
        primaryStage.setTitle("Catégories");
        primaryStage.setResizable(false);
        primaryStage.show();
	   } 
	   catch(Exception e) {
			e.printStackTrace();
		}
    }
		
	
	
	public static void main(String[] args) {
		launch(args);
		
	    Categorie.chargerFichierTexte("/categorie");
        System.out.println("Liste des catégories :");
        for (Categorie categorie : Categorie.listeCategories) {
            System.out.println(categorie);
        }
        System.out.println("Taille de la liste : " + Categorie.listeCategories.size());
    
		
	      
	}
}



