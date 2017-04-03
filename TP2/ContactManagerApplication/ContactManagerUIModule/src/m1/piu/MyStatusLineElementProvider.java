/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m1.piu;
import java.awt.Button;
import javafx.fxml.FXML;
import java.awt.Component;
import java.awt.Label;
import java.io.IOException;
import java.net.URL;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import org.openide.awt.StatusLineElementProvider;
import org.openide.util.Exceptions;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author pierre
 */
@ServiceProvider(service = StatusLineElementProvider.class, position = 100)
public class MyStatusLineElementProvider implements StatusLineElementProvider{

    @Override
    public Component getStatusLineElement() {
        JFXPanel fxPanel = new JFXPanel();
        URL url = getClass().getResource("/m1/piu/FXMLMyStatusBar.fxml");
        FXMLLoader loader = new FXMLLoader(url);
        try
        {
            Parent root=(Parent)loader.load();
            Scene scene=new Scene(root);
            fxPanel.setScene(scene);
        }
        catch(IOException e)
        {
            Exceptions.printStackTrace(e);
        }
        return fxPanel;
    }
    
}
