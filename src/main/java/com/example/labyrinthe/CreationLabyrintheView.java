package com.example.labyrinthe;

import Labyrinthe.Labyrinthe;
import Labyrinthe.CreationLabyrinthe;

import Labyrinthe.ResolutionLabyrtinthe.BFS;
import Labyrinthe.ResolutionLabyrtinthe.DFS;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;

public class CreationLabyrintheView extends GridPane
{
    private Button creeLabyrintheAleatoirement;
    private Button enregistrement;
    private Button recupererAncienLabyrinthe;
    private Button cheminPlusPetitAvecDFS;
    private Button cheminAvecBFS;
    private Button recouvrementDFS;
    private Button recouvrementBFS;
    private Button nettoie;
    private Label consigneX, consigneY;
    private TextField x, y;
    private HBox h1, h2;
    private VBox v1;
    private Pane  leftPane, rightPane;

    private Damier damier;
    private FileChooser fileChooser;

    public CreationLabyrintheView()
    {
        super();

        initPane();
        initControle();
        addButton();
        initFileChooser();



    }


    private void initFileChooser()
    {
        this.fileChooser = new FileChooser();
        this.fileChooser.setTitle("Choisir un labyrinthe");


    }

    private void initPane()
    {
        this.leftPane = new Pane();
        this.rightPane = new Pane();

        this.leftPane.setMinSize(430,600);
        this.rightPane.setMinSize(430,600);

        this.add(leftPane, 0, 0);
        this.add(rightPane, 1, 0);


    }

    private void initControle()
    {
        this.creeLabyrintheAleatoirement = new Button("Crée Labyrinthe Aleatoirement");
        this.enregistrement = new Button("Sauvegarder Labyrinthe");
        this.recupererAncienLabyrinthe = new Button("Recuperez Un Labyririnthe déja existant");
        this.cheminPlusPetitAvecDFS = new Button("Affichez le chemin le plus court DFS");
        this.recouvrementDFS = new Button("Explorer tout le labyrinthe DFS");
        this.cheminAvecBFS = new Button("Affiche un chemin avec BFS");
        this.recouvrementBFS = new Button("Explore tout le labyrinthe BFS");
        this.nettoie = new Button("Nettoyer");



        this.creeLabyrintheAleatoirement.setMinWidth(250);
        this.enregistrement.setMinWidth(250);
        this.recupererAncienLabyrinthe.setMinWidth(250);
        this.cheminPlusPetitAvecDFS.setMinWidth(250);
        this.recouvrementDFS.setMinWidth(250);
        this.cheminAvecBFS.setMinWidth(250);
        this.recouvrementBFS.setMinWidth(250);
        this.nettoie.setMinWidth(250);




        this.consigneX = new Label("Entrez Largeur");
        this.consigneY = new Label("Entrez Hauteur");
        this.x = new TextField();
        this.y = new TextField();

        this.h1 = new HBox(consigneX, x);
        this.h2 = new HBox(consigneY, y);
        this.v1 = new VBox(h1, h2);
        this.v1.setLayoutX(75);
        this.v1.setLayoutY(150);






        x.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*"))
                x.setText(newValue.replaceAll("\\D", ""));
        });


        y.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*"))
                y.setText(newValue.replaceAll("\\D", ""));

        });

    }

    private void addButton()
    {
        this.creeLabyrintheAleatoirement.setLayoutX(50);
        this.creeLabyrintheAleatoirement.setLayoutY(100);

        this.enregistrement.setLayoutX(50);
        this.enregistrement.setLayoutY(500);

        this.recupererAncienLabyrinthe.setLayoutX(50);
        this.recupererAncienLabyrinthe.setLayoutY(50);

        this.cheminPlusPetitAvecDFS.setLayoutX(50);
        this.cheminPlusPetitAvecDFS.setLayoutY(250);

        this.recouvrementDFS.setLayoutX(50);
        this.recouvrementDFS.setLayoutY(310);

        this.cheminAvecBFS.setLayoutX(50);
        this.cheminAvecBFS.setLayoutY(390);

        this.recouvrementBFS.setLayoutX(50);
        this.recouvrementBFS.setLayoutY(420);

        this.nettoie.setLayoutX(50);
        this.nettoie.setLayoutY(450);


        this.nettoie.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                damier.nettoie();
            }
        });


        this.cheminPlusPetitAvecDFS.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (damier != null)
                {
                    damier.nettoie();
                    damier.afficherPlusPetitChemin(new DFS(damier.getLabyrinthe()));
                }
            }
        });

        this.recouvrementDFS.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent)
            {
                if (damier != null)
                {
                    damier.nettoie();
                    damier.afficherEtapeDeParcours(new DFS(damier.getLabyrinthe()));
                }
            }
        });


        this.cheminAvecBFS.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent)
            {
                if (damier != null)
                {
                    damier.afficherPlusPetitChemin(new BFS(damier.getLabyrinthe()));
                }
            }
        });

        this.recouvrementBFS.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent)
            {
                if (damier != null)
                {
                    damier.afficherEtapeDeParcours(new BFS(damier.getLabyrinthe()));
                }
            }
        });



        this.recupererAncienLabyrinthe.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                File selectedFile = fileChooser.showOpenDialog(new Stage());

                if (selectedFile != null)
                {
                    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(selectedFile)))
                    {
                        Object obj = ois.readObject();

                        if (obj instanceof Labyrinthe lab)
                        {
                            rightPane.getChildren().clear();
                            rightPane.getChildren().add(new Damier(lab));
                        } else {
                            System.out.println("Le fichier ne contient pas une instance de la classe attendue.");
                        }

                    }
                    catch (IOException | ClassNotFoundException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        });

        this.creeLabyrintheAleatoirement.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent)
            {
                if (!leftPane.getChildren().contains(v1))
                {
                    leftPane.getChildren().add(v1);
                }
                else
                {
                    int l,h;

                    l = Integer.parseInt(x.getText());
                    h = Integer.parseInt(y.getText());



                    Labyrinthe lab = CreationLabyrinthe.creationLabyrhinteAleatoire(l,h);
                    rightPane.getChildren().add(damier = new Damier(lab));



                    damier = new Damier(lab);

                    if (!rightPane.getChildren().contains(damier))
                        rightPane.getChildren().add(damier);

                }
            }

        });

        this.enregistrement.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent actionEvent)
            {
                if (damier != null)
                {

                    Labyrinthe labyrinthe = damier.getLabyrinthe();
                    String nomFichier = "lab"+"_"+labyrinthe.hashCode();

                    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomFichier)))
                    {
                        oos.writeObject(labyrinthe);
                        System.out.println("Objet sauvegardé avec succès dans " +nomFichier);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
        });






        this.leftPane.getChildren().addAll(creeLabyrintheAleatoirement, recupererAncienLabyrinthe, enregistrement, cheminPlusPetitAvecDFS,cheminAvecBFS,nettoie);
    }

}



