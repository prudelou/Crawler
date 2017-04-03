/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m1.piu;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javax.swing.*;
import org.openide.awt.*;
import org.openide.util.Exceptions;
import org.openide.util.NbBundle.Messages;
import org.openide.util.actions.Presenter;

@ActionID(
        category = "Edit",
        id = "m1.piu.ToolbarAction"
)
@ActionRegistration(
        iconBase = "m1/piu/Open-icon.png",
        displayName = "#CTL_ToolbarAction"
)
@ActionReference(path = "Toolbars/File", position = 3333)
@Messages("CTL_ToolbarAction=Toolbar")
public final class ToolbarAction extends AbstractAction implements Presenter.Toolbar, ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO implement action body
        
    }

    @Override
    public Component getToolbarPresenter() {
        JFXPanel fxPanel = new JFXPanel();
        URL url = getClass().getResource("/m1/piu/FXMLToolbar.fxml");
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