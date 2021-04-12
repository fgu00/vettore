/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vector2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author russo.salvatore
 */
public class Vector2 extends Application {
  int posREd=0;
    @Override
    public void start(Stage primaryStage) {
        Integer[]vettore={1,2,3,4,5,6};
        Rectangle[]r=new Rectangle[vettore.length];
        Button bSx=new Button("<<");
        Button bDs=new Button(">>");
        bSx.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               if(posREd!=0){
                   r[posREd].setFill(Color.WHITE);
                   r[posREd-1].setFill(Color.RED);
                   posREd--;
               }else{
                 r[posREd].setFill(Color.WHITE); 
                  r[r.length-1].setFill(Color.RED);
                  posREd=r.length-1;  
               }
            }
        });
        bDs.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               if(posREd<r.length-1){
                   r[posREd].setFill(Color.WHITE);
                   r[posREd+1].setFill(Color.RED);
                   posREd++;
               }else{
                  r[posREd].setFill(Color.WHITE); 
                  r[0].setFill(Color.RED);
                  posREd=0;
               }
            }
        });
         TilePane tp=new TilePane();
         tp.getChildren().add(bSx);
         for (int i = 0; i < vettore.length; i++) {
            StackPane sp=new StackPane();
            r[i]=new Rectangle(60,60);
            r[i].setStroke(Color.RED);
            if(i==0)
                r[i].setFill(Color.RED);
            else
                r[i].setFill(Color.WHITE);
            Label l=new Label();
            l.setText(vettore[i].toString());
             l.setFont(new Font("Verdana",30));
             sp.getChildren().addAll(r[i],l);
             tp.getChildren().add(sp);
        }
         tp.getChildren().add(bDs);
         tp.setAlignment(Pos.CENTER);
         
        StackPane root = new StackPane();
        Scene scene = new Scene(tp, 500, 500);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
