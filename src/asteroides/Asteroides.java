/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Asteroides;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

/**
 *
 * @author DaSTer
 */
public class Asteroides extends Application {
    //Nave
    Polygon nave = new Polygon ();
    double angulo;
    double direccion;
    double direccionRAD;
    double dirX;
    double dirY;
    
    double velNave=3;
    
    int velGiro=7;
    //Variables de la posicion nave
    double posx;
    double posy;
    
        
    //Variables ventana
    final int ventanax =800;
    final int ventanay =400;
    Scene ventana;
    
    
    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        ventana = new Scene(root, ventanax, ventanay, Color.BLACK);
        primaryStage.setScene(ventana);
        primaryStage.show();
        
        
        nave.setFill(Color.BLUE);
        nave.getPoints().addAll(new Double[]{
            0.0, -30.0,
            10.0, 0.0,
            0.0, -5.0,
            -10.0, 0.0});
        root.getChildren().add(nave);
       
        nave.setLayoutX(100);
        nave.setLayoutY(100);
        
        
            
        
        ventana.setOnKeyPressed((KeyEvent event) -> {
            switch(event.getCode()){
                case RIGHT:
                    angulo+= velGiro;
                    break;
                case LEFT:
                    angulo-= velGiro;
                    break;
                case UP:
                    dirX += velNave;
                    dirY += velNave;
            }
        });
        animationNave.start(); //Llamada a la animación
    }//Cierre Método Start
    
    AnimationTimer animationNave = new AnimationTimer() {
            @Override
            public void handle(long now) {
                
                direccion = angulo % 360;
                direccionRAD = Math.toRadians(direccion);
                dirX = Math.sin(direccionRAD);
                dirY = Math.cos(direccionRAD);
                
                nave.setRotate(direccion);
                nave.;
                
            }
        };
}//Cierre de la Clase JuegoNave