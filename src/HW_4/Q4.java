/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HW_4;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author AboodHassKov
 */
public class Q4 extends Application {
    
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException, IOException{
        
//        /////////Screen=1/////////        //
        
////////Labels
        
        Label wel = new Label("Welcome");
        wel.setId("wel");
        Label L_Name = new Label("User Name");
        Text F = new Text();
        F.setStyle( "-fx-font-style: italic;\n" +
                    "    -fx-font-size: 10;\n" +
                    "    -fx-color:red;\n" +
                    "    -fx-float: left;");
        Label L_Pass = new Label("User Password");
        
////////Text Inputs
        
        TextField Name = new TextField();
        PasswordField Password = new PasswordField();
        
////////Buttons
        
        Button Login = new Button("Login");
        Button Exit = new Button("Exit");
       
////////Adding Children
        
        HBox HBtn = new HBox(8,Login,Exit);
        
        GridPane GP1 = new GridPane();
        
//               0                  1                           2
/*0*/   GP1.add(wel,0,0);
/*1*/   GP1.add(L_Name,0,1);    GP1.add(Name,1,1);      
/*2*/   GP1.add(L_Pass,0,2);    GP1.add(Password,1,2);  
/*3*/   GP1.add(F,0,3);         GP1.add(HBtn,1,3);
        
        GP1.setAlignment(Pos.CENTER);
        StackPane root1 = new StackPane();
        
        root1.getChildren().add(GP1);
        
        Scene scene1 = new Scene(root1,300, 250);
        
//        /////////End Screen=1/////////        //
        
//        /////////Screen=2/////////        //

////////Buttons
        
        Button View = new Button("View All Students");
        
        Button Add = new Button("Add Student");
        
////////Adding Children
        
        HBox H3 = new HBox(10,View,Add);
        
        StackPane root2 = new StackPane();
        
        root2.getChildren().add(H3);
        
        H3.setAlignment(Pos.CENTER);
        
        Scene scene2 = new Scene(root2,300, 250);
        
//        /////////End Screen=2/////////        //


//        /////////Screen=3/////////        //

        
        ////////List View
        
        ObservableList<Student> group$90_80 =FXCollections.observableArrayList();
        
        ListView LV$90_80 = new ListView();
        
        List Excelling = new ArrayList<>(group$90_80);
        
        
        ObservableList<Student> group =FXCollections.observableArrayList();
        
        
        ListView LV = new ListView();
        
        Student[] STDs = {
            new Student(80, 123, "A", "CS")
            ,new Student(80, 123, "F", "CS")
            ,new Student(85, 342, "B", "EE")
            ,new Student(90, 534, "C", "EE")
            ,new Student(100, 133, "D", "CS")
            ,new Student(70, 568, "F", "CS")
            ,new Student(65, 715, "E", "Bilogy")
            ,new Student(55, 665, "G", "EE")
            ,new Student(65, 698, "M", "EE")
            ,new Student(0, 0, "", "")
            ,new Student(0, 0, "", "")
            ,new Student(0, 0, "", "")
            ,new Student(0, 0, "", "")} ;
        
        ////////Label
        
        Label L1 = new Label("Student Data");
        L1.setId("wel");
        
        Label id_L = new Label("ID");
        Label name_L = new Label("Name");
        Label major_L = new Label("Major");
        Label Grade_L = new Label("Grade");


        ////////Text Inputs
        
        TextField ID2 = new TextField("");
        TextField Name2 = new TextField("");
        TextField Major = new TextField("");
        TextField Grade = new TextField("");
        
        ////////Buttons
        
        Button Add2 = new Button("Add");
        
        Button rest = new Button("Rest");
        
        Button exit = new Button("Exit");
        
        ////////GP3
        HBox btn = new HBox(Add2,rest,exit);
        btn.setSpacing(10);
        GridPane GP3 = new GridPane();
        
        
//               0                             1                           
/*0*/           GP3.add(L1, 0, 0);
/*1*/           GP3.add(id_L, 0, 1);        GP3.add(ID2, 1, 1);            
/*2*/           GP3.add(name_L, 0, 2);      GP3.add(Name2, 1, 2);
/*3*/           GP3.add(major_L, 0, 3);     GP3.add(Major, 1, 3);
/*4*/           GP3.add(Grade_L, 0, 4);     GP3.add(Grade, 1, 4);
/*5*/                                       GP3.add(btn, 1, 5);
        
        HBox Coll = new HBox(GP3,LV,LV$90_80);
        StackPane Screen3 = new  StackPane(Coll);
        Screen3.setAlignment(Pos.CENTER);
        Scene scene3 = new  Scene(Screen3);
        
//        /////////End Screen=3/////////        //

        Login.setOnAction((ActionEvent event) -> {
            primaryStage.setScene(scene2);
        });
        
        
        Exit.setOnAction((ActionEvent event) -> {
            Platform.exit();
            System.exit(0);
        });
        
        
        Add.setOnAction((ActionEvent event) -> {
            primaryStage.setScene(scene1);
        });
        
        
        View.setOnAction((ActionEvent event) -> {
            primaryStage.setScene(scene3);
        });
        
        
        Add2.setOnAction((ActionEvent event) -> {
            try {
                int N = STDs.length-4;
            int i = Integer.parseInt(ID2.getText());
            double g = Double.parseDouble(Grade.getText());
            
            Student STD = new Student(g, i, Name2.getText(), Major.getText());
            Comparator<Student> compareByName  = (Student o1, Student o2)-> o1.Name.compareTo(o2.Name);
            Comparator<Student> compareByGrade  = (Student o1, Student o2)-> -Double.compare(o1.Grade, o2.Grade);
            
            Comparator<Student> Compare  = compareByGrade.thenComparing(compareByName);
            
                if(N != STDs.length && STD != null){
                    STDs[N] = STD;
                }
            
            ++N;
            List<Student> S = null;
               
            List<Student> E = null;
            
            
            
            S = Arrays.stream(STDs)
                    .sorted(Compare)
                    .filter(n->n.Name!="")
                    .collect(Collectors.toList());
            
            E = Arrays.stream(STDs)
                        .filter(c -> c.Grade > 80 && c.Grade < 90 && c.Name!="")
                        .collect(Collectors.toList());
            
            
            
            LV.getItems().setAll(S);
            
            LV$90_80.getItems().setAll(E);
            
            
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        });
        
        
        rest.setOnAction((ActionEvent event) -> {
            ID2.setText(null);
            Name2.setText(null);
            Grade.setText(null);
            Major.setText(null);
        });
        
        
        exit.setOnAction((ActionEvent event) -> {
            primaryStage.setScene(scene1);
        });
        
        
        primaryStage.setTitle("");
        primaryStage.setScene(scene2);
        scene1.getStylesheets().add("Style.css");
        scene2.getStylesheets().add("Style.css");
        scene3.getStylesheets().add("Style.css");
        primaryStage.show();
        
        
    }

public class Student implements Comparable<Student>{
    int ID;
    double Grade;
    String Name;
    String Major;

    public Student(double Grade, int ID, String Name, String Major) {
        this.ID = ID;
        this.Grade = Grade;
        this.Name = Name;
        this.Major = Major;
    }

    public int getID() {
        return ID;
    }

    public double getGrade() {
        return Grade;
    }

    public String getName() {
        return Name;
    }

    public String getMajor() {
        return Major;
    }

    @Override
    public String toString() {
        return ID + "              " + Name + "              " + Major + "              " + Grade + ' ';
    }
    
    @Override
  public int compareTo(Student o) {
    if (o == null) {
      return -1;
    }
    int c = Double.valueOf(Grade).compareTo(o.Grade);
    if (c != 0) {
      return c;
    }
    return Name.compareTo(o.Name);
  }
}

    public static void main(String[] args) {
        launch(args);
    }
    
}
