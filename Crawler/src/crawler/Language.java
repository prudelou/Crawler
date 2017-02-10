/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crawler;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;

/**
 *
 * @author amnesia
 */
public class Language {
    private final ChoiceBox langue1;
    private final ChoiceBox langue2;
    private ResourceBundle resources;
    private final String[] fr = new String[]{"Français", "Anglais", "Russe"};
    private final String[] en = new String[]{"French", "English", "Russian"};
    private final String[] ru = new String[]{"французский", "английский", "русский"};
    private final String[][] langue = new String[][]{fr, en, ru};
    private final String[] lang = new String[]{"fr","en","ru"};
    private boolean inChange = false;
    public Language(ChoiceBox langue1, ChoiceBox langue2, ResourceBundle resources) {
        int ind = 2;
        if("fr".equals(Crawler.lang)) ind = 0;
        else if("en".equals(Crawler.lang)) ind = 1;
        
        this.langue1 = langue1;
        this.langue2 = langue2;
        this.resources = resources;
        this.langue1.getItems().addAll((Object[]) langue[ind]);
        this.langue1.getSelectionModel().select(ind);
        this.langue1.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue ov, Number value, Number new_value) {
                try {
                    changeLangue(new_value.intValue());
                } catch (IOException ex) {
                    Logger.getLogger(Language.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
        this.langue2.getItems().addAll((Object[]) langue[ind]);
        this.langue2.getSelectionModel().select(ind);
        this.langue2.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue ov, Number value, Number new_value) {
                try {
                    changeLangue(new_value.intValue());
                } catch (IOException ex) {
                    Logger.getLogger(Language.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    private void changeLangue(int indice) throws IOException{
        if(inChange) return;
        inChange = true;
        
        this.resources = ResourceBundle.getBundle("resources/UIResources", new Locale(lang[indice]));
        Crawler.lang = this.lang[indice];
        FXMLLoader loader = new FXMLLoader(getClass().getResource("maquette.fxml"), this.resources);
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Crawler.stage.setScene(scene);
        
        inChange = false;
    }

}
