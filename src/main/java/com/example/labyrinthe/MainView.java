package com.example.labyrinthe;

import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.VBox;

public class MainView extends VBox
{
    public MainView (double espace)
    {
        super(espace);


        Label titre = new Label("Labyrinthe - v1");

        Button recupererConfigExistante = new Button("Récuperer \n Config Deja Existante");
        recupererConfigExistante.setMaxWidth(200);


        Separator espacementEntreButton = new Separator(Orientation.VERTICAL);



        Button creerNouvelleConfig = new Button("Créer \n Nouvelle Config");
        creerNouvelleConfig.setMinWidth(200);


        this.getChildren().addAll(titre,recupererConfigExistante,espacementEntreButton,creerNouvelleConfig);
    }
}
