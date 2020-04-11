/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HW_4;

import java.util.Arrays;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author AboodHassKov
 */

public class Q_1 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button A = new Button("Q.1 || A");
        
        A.setOnAction((ActionEvent event) -> {
           IntConsumer C = value  -> System.out.println("%d"+value);
            C.Value(20);
            System.out.println("");
        });
        
        Button B = new Button("Q.1 || B");
        
        B.setOnAction((ActionEvent event) -> {
            String[] Names = {"Ali", "Abood", "Ahmed"};
            Arrays.stream(Names).map(String:: toUpperCase).forEach(c -> System.out.println(c+","));
            System.out.println("");
        });
        
        Button C = new Button("Q.1 || C");
        
        C.setOnAction((ActionEvent event) -> {
            Empty C1 = ()  -> System.out.println("Welcome to lambdas!");
            C1.E();
            System.out.println("");
        });
        
        
        Button D = new Button("Q.1 || D");
        
        D.setOnAction((ActionEvent event) -> {
            Cube D1 = (int x)  ->  Math.pow(x, x);
            D1.Cube(20);
            System.out.println("");
        });
        
        HBox H = new HBox(A,B,C,D);
        StackPane root = new StackPane();
        root.getChildren().add(H);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

public interface IntConsumer {
    void Value(int value);
}
public interface Empty {
    void E(); 
}
public interface Cube {
    void Cube(int x); 
}


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
