package com.example.labyrinthe;

import Labyrinthe.Labyrinthe;
import Labyrinthe.Case;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.List;

public class ShortestPathView extends Pane
{
    private final int WIDTH = 600;
    private final int HEIGHT = 600;

    private List<Case> chemin;
    private double delay;
    private Timeline timeline;

    private Rectangle[][] rectangles;
    int i;

    public ShortestPathView(Damier damier,double delay)
    {
        Labyrinthe lab = damier.getLabyrinthe();
        copyDamier(damier);

        this.chemin = lab.getPlusPetitChemin();
        System.out.println(chemin.size());
        this.delay = delay;
        i = 0;




        this.timeline = new Timeline(new KeyFrame(Duration.seconds(this.delay), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent)
            {
                if (i < chemin.size()-2)
                {
                    Case c = chemin.get(++i);
                    int x = c.getX();
                    int y = c.getY();

                    rectangles[y][x].setFill(Color.DARKVIOLET);
                }
            }
        }));
        this.timeline.setCycleCount(chemin.size() - 1);
        this.timeline.play();
    }







    private void copyDamier(Damier da)
    {
        Rectangle[][] rectangleOrigine = da.getDamier();
        rectangles = new Rectangle[rectangleOrigine.length][rectangleOrigine[0].length];


        for (int i = 0; i < rectangleOrigine.length; i++) {
            for (int j = 0; j < rectangleOrigine[0].length; j++) {
                rectangles[i][j] = new Rectangle(j * rectangleOrigine[i][j].getWidth(), i * rectangleOrigine[i][j].getHeight(),  rectangleOrigine[i][j].getWidth(),  rectangleOrigine[i][j].getHeight());
                rectangles[i][j].setFill(rectangleOrigine[i][j].getFill());
                rectangles[i][j].setStroke(Color.BLACK);
                this.getChildren().add(rectangles[i][j]);
            }
        }
    }




}
