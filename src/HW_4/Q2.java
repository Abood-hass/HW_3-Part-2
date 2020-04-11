/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HW_4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;
import java.util.stream.Stream;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author AboodHassKov
 */
public class Q2 extends Application {
    String Text1 = "";
    String Text2 = "";
    Label Result = new Label();
    
    List<String> lst = new ArrayList<>();
    
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        
        HashMap<String,Integer> map = new HashMap<>();
        
        Button btn = new Button("the number of occurrences");
	try {
            
            lst = Files
                  .lines(Paths.get("A://For Test.txt"))
                  .map(line->line.replace(" ", ""))
                  .collect(Collectors.toList());
                  
            for (int i = 0; i < lst.size(); i++) {
                String line = lst.get(i);
                for (int j = 0; j <line.length(); j++){
                    int count = 0;
                    String C = line.charAt(j)+"";
                    for (int k = 65; k < 122; k++) {
                        if(C.codePointAt(0) == k && !(k > 90 && k < 97)){
                            ++count;
                            if(map.containsKey(C)){
                                map.put(C, 1+map.get(C));
                            }else{
                                map.put(C, count);
                            }

                        } else{
                        }
                    }
                }
            }
            } catch (IOException e) {
                    e.getMessage();
            }
        
        btn.setOnAction((ActionEvent event) -> {
            System.out.println(map);
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
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
