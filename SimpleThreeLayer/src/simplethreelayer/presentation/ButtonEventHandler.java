/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplethreelayer.presentation;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import simplethreelayer.domain.StudentIndex;

/**
 *
 * @author Anders
 */
class ButtonEventHandler implements EventHandler<ActionEvent> {

    private final StudentIndex sdb;
    private final TextField txtAge;
    private final TextField txtName;


    ButtonEventHandler(StudentIndex sdb, TextField txtName, TextField txtAge) {
        this.sdb = sdb;
        this.txtName = txtName;
        this.txtAge = txtAge;
    }

    @Override
    public void handle(ActionEvent event) {
        String studentName = txtName.getText();
        int studentAge = Integer.parseInt(txtAge.getText());
        sdb.addStudent(studentName, studentAge);
    }

}
