/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crawler;

import java.io.File;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.*;

/**
 *
 * @author amnesia
 */
public class Display {
    private TreeView treeView;
    private TextField textFieldRepertoire;
    private final Image dossier = new Image(getClass().getResourceAsStream("/images/dossier.png")
    );
    private final Image fichier = new Image(getClass().getResourceAsStream("/images/fichier.png")
    );
    
    public Display(TreeView treeView, TextField textFieldRepertoire) {
        this.treeView = treeView;
        this.textFieldRepertoire = textFieldRepertoire;
        this.textFieldRepertoire.textProperty().addListener((observable, oldValue, newValue) -> {
            this.updateTreeView(newValue);
        });

    }
    private void updateTreeView(String repertoire){
        String[] r = repertoire.split("/");
        TreeItem root = new TreeItem(r[r.length-1], new ImageView(dossier));
        root.setExpanded(true);

        File dir = new File(repertoire);
        String[] s = dir.list();

        for (String item : s) {
            File dirTemp = new File(repertoire + "/" + item);
            if (dirTemp.isDirectory()) {
                TreeItem tmp = parcourRepertoire(repertoire + "/" + item, item);
                root.getChildren().add(tmp);
            }else {
                if (item.lastIndexOf(".") > 0 ){
                    String extension = item.substring(item.lastIndexOf("."));
                    if(extension.equals(".html")){
                        root.getChildren().add(new TreeItem(item, new ImageView(fichier)));
                    }
                }
            }
        }
        this.treeView.setRoot(root);
    }
    
    private TreeItem parcourRepertoire(String repertoire, String newRepertoire){
        File dir = new File(repertoire);
        TreeItem root = new TreeItem(newRepertoire, new ImageView(dossier));
        root.setExpanded(true);
        System.out.println(repertoire);
        String[] s = dir.list();
        for (String item : s) {
            File dirTemp = new File(repertoire + "/" + item);
            if (dirTemp.isDirectory()) {
                TreeItem tmp = parcourRepertoire(repertoire + "/" + item, item);
                root.getChildren().add(tmp);
            }else {
                if (item.lastIndexOf(".") > 0 ){
                    String extension = item.substring(item.lastIndexOf("."));
                    if(extension.equals(".html")){
                        root.getChildren().add(new TreeItem(item, new ImageView(fichier)));
                    }
                }
            }
        }
        return root;
    }
    
}
