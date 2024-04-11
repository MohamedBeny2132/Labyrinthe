package com.example.labyrinthe;

import javafx.application.Application;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class ApplicationLabyrinthe extends Application
{
    private final int LARGEUR = 1045;
    private final int HAUTEUR = 635;

    @Override
    public void start(Stage stage) throws Exception
    {
        stage.setWidth(LARGEUR);
        stage.setHeight(HAUTEUR);


        Scene sc = new Scene(new CreationLabyrintheView());
        stage.setScene(sc);

        stage.show();
    }
}
