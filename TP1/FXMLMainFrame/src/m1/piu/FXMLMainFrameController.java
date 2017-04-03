/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m1.piu;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author amnesia
 */
public class FXMLMainFrameController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private AnchorPane addressPane;
    
    @FXML
    private AnchorPane listPane;
    
    @FXML
    private AnchorPane detailPane;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Node list = null;
        Node address  = null;
        Node detail = null;
        try{
             list = FXMLLoader.load(getClass().getResource("FXMLTable.fxml"));
             address = FXMLLoader.load(getClass().getResource("FXMLList.fxml"));
             detail = FXMLLoader.load(getClass().getResource("FXMLDetails.fxml"));
             
             addressPane.getChildren().add(address);
             listPane.getChildren().add(list);
             detailPane.getChildren().add(detail);
        }
        catch(IOException e){
            System.out.println("Error...");
        }
    }    
    
}
