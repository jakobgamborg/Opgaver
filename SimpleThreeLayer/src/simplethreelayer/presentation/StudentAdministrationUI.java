/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplethreelayer.presentation;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import simplethreelayer.domain.StudentIndex;

/**
 *
 * @author Anders
 */
public class StudentAdministrationUI extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        StudentIndex sdb = new StudentIndex();
        
        ListView lvStudents = new ListView();
        lvStudents.setItems(sdb.getStudents());
        Label stdName = new Label("Name:");
        TextField txtName = new TextField();
        Label stdAge = new Label("Age:");
        TextField txtAge = new TextField();
        Button btnAdd = new Button("Add Student");
        btnAdd.setOnAction(new ButtonEventHandler(sdb,txtName,txtAge));
        VBox studentForm = new VBox(stdName,txtName,stdAge,txtAge,btnAdd);
        
        FlowPane root = new FlowPane(studentForm,lvStudents);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Student Administration");
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
