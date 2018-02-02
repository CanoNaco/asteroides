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
    //variable angulo
    double angulo;
    //variable direccion (aplicado de 0 a 359 grados)
    double direccion;
    //variable direccion convertida en radianes
    double direccionRAD;
    //variable direccion X aplicando seno del angulo
    double dirX;
    //variable direccion Y aplicando coseno del angulo
    double dirY;
    //variable de velocidad de la nave
    double velNave;
    //variable de velocidad de giro
    int velGiro;
    //Variables de la posicion nave
    double posX = 400;
    double posY = 200;
    
          
    //Variables ventana
    final int ventanax =800;
    final int ventanay =400;
    Scene ventana;
    
    
    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        ventana = new Scene(root, ventanax, ventanay, Color.WHITE);
        primaryStage.setScene(ventana);
        primaryStage.show();
        
        
        nave.setFill(Color.RED);
        nave.getPoints().addAll(new Double[]{
            0.0, -30.0,
            10.0, 0.0,
            0.0, -5.0,
            -10.0, 0.0});
        root.getChildren().add(nave);
       
        ventana.setOnKeyPressed((KeyEvent event) -> {
            
            switch(event.getCode()){
                case RIGHT:
                    velGiro = 2;
                    break;
                case LEFT:
                    velGiro = -2;
                    break;
                case UP:
                    dirX = Math.sin(direccionRAD);
                    dirY = Math.cos(direccionRAD);
                    velNave += 0.1;
                    if (velNave >= 2) {
                        velNave = 2;
                    };
                    break;
            }
        });
        
        ventana.setOnKeyReleased((KeyEvent event) -> {
            velGiro = 0;
        });

        //Llamada a la animación
        animationNave.start();
    }//Cierre Método Start
    
    AnimationTimer animationNave = new AnimationTimer() {
            @Override
            public void handle(long now) {
                
                direccion = angulo % 360;
                direccionRAD = Math.toRadians(direccion);
                
                
                
                angulo += velGiro;
                nave.setRotate(direccion);
                
                posX += (dirX * velNave);
                posY += (-dirY * velNave);
                
                nave.setLayoutX(posX);
                nave.setLayoutY(posY);
                
            }
        };
}//Cierre de la Clase JuegoNave