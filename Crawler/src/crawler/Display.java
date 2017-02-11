/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crawler;

import java.io.File;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.*;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

/**
 *
 * @author amnesia
 */
public class Display {
    private final TreeView treeView;
    private final TextField textFieldRepertoire;
    private String repertoireSelected;
    private String chemin;
    private TreeItem selected;
    private final WebView webView;
    private final WebEngine webEngine;
    private final Image dossier = new Image(getClass().getResourceAsStream("/images/dossier.png")
    );
    private final Image fichier = new Image(getClass().getResourceAsStream("/images/fichier.png")
    );
    private boolean inChange = false;
    
    public Display(TreeView treeView, TextField textFieldRepertoire, WebView webView) {
        this.treeView = treeView;
        this.textFieldRepertoire = textFieldRepertoire;
        this.webView = webView;
        this.webEngine = this.webView.getEngine();
        this.buildTreeView();

    }
    private void buildTreeView() {
        Display self = this;
        this.treeView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if(self.inChange) return;
            self.selected = (TreeItem) newValue;
            TreeItem select = (TreeItem) newValue;
            
            self.chemin = (String) select.getValue();
            while (select.getParent() != null && select.getParent().getParent() != null) {
                select = select.getParent();
                self.chemin = select.getValue() + "/" + self.chemin;
            }
        });
        this.textFieldRepertoire.textProperty().addListener((observable, oldValue, newValue) -> {
            this.inChange = true;
            this.repertoireSelected = newValue;
            this.updateTreeView(newValue);
            this.inChange = false;
        });
        
    }
    private void buildWebView() {
        
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
                if (verifExtension(item)){
                    root.getChildren().add(new TreeItem(item, new ImageView(fichier)));
                }
            }
        }
        return root;
    }
    public void launch(){
        if(verifExtension(this.chemin)) {
            String file = "file://"+this.repertoireSelected+"/"+this.chemin;
            this.webEngine.load(file);
            System.out.println(file);
        }
        
    }
    public void remove(){
        if(verifExtension(this.chemin)) {
            File file = new File(this.repertoireSelected+"/"+this.chemin);
            file.delete();
            this.inChange = true;
            this.updateTreeView(this.repertoireSelected);
            this.inChange = false;
        }
    }
    private boolean verifExtension(String item){
        if (item.lastIndexOf(".") > 0) {
            String extension = item.substring(item.lastIndexOf("."));
            if (extension.equals(".html")) {
                return true;
            }
        }
        return false;
    }
    
}
