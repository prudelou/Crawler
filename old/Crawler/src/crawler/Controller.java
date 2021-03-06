package crawler;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;


import javafx.scene.control.Button;

import javafx.scene.control.ProgressIndicator;

import javafx.scene.control.TextField;

import javafx.scene.control.Label;

import javafx.scene.control.ProgressBar;


import javafx.scene.control.Tab;

import javafx.scene.input.MouseEvent;

import javafx.scene.control.CheckBox;

import javafx.scene.control.ChoiceBox;


import javafx.scene.control.TreeView;

import javafx.scene.input.ContextMenuEvent;
import javafx.scene.web.WebView;

public class Controller implements Initializable {
        @FXML
        private ResourceBundle resources;
	@FXML
	private Tab tabCrawl;
	@FXML
	private Label labelURL;
	@FXML
	private Label labelLien;
	@FXML
	private TextField textFielURL;
	@FXML
	private CheckBox checkBoxLien;
	@FXML
	private CheckBox checkBoxIV;
	@FXML
	private Label labelProfondeur;
	@FXML
	private TextField textFieldProfondeur;
	@FXML
	private Button buttonDownload;
	@FXML
	private Label labelLangue1;
	@FXML
	private ChoiceBox choiceBoxLangue1;
	@FXML
	private Label labelRepertoire;
	@FXML
	private TextField textFieldRepertoire;
        @FXML
	private TextField textFieldRepertoire2;
	@FXML
	private Button buttonParcourir;
        @FXML
	private Button buttonParcourir2;
	@FXML
	private Label labelDownload1;
	@FXML
	private ProgressBar progressBarDownload1;
	@FXML
	private ProgressIndicator progressIndicatorDownload;
	@FXML
	private Tab tabVisualisation;
	@FXML
	private Label labelLangue2;
	@FXML
	private ChoiceBox choiceBoxLangue2;
	@FXML
	private Label labelDownload2;
	@FXML
	private ProgressBar progressBarDownload2;
	@FXML
	private ProgressIndicator progressIndicator2;
	@FXML
	private TreeView treeView;
	@FXML
	private Button buttonOuvrir;
	@FXML
	private Button buttonSupprimer;
	@FXML
	private WebView webView;

	// Classes of features
		// Use for Crawl feature
		private ProcessCrawler processCrawler;
		// Use for update download state
		private ProgressDownload progressDownload;
		// Use for adapt language
		private Language language;
		// Use for visualisation feature
		private Display display;

	// Root for Romain...
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.resources = resources;
		//Instantiate Classes
		this.progressDownload = new ProgressDownload();
		this.processCrawler = new ProcessCrawler();
		this.language = new Language(choiceBoxLangue1, choiceBoxLangue2, this.resources);
		this.display = new Display(treeView, textFieldRepertoire2, webView);

                // Bind ProgressBarDownload & ProgressBarIndicator with DoubleProperty
		this.progressBarDownload1.progressProperty().bind(progressDownload.getDownloadProgress());
		this.progressIndicatorDownload.progressProperty().bind(progressDownload.getDownloadProgress());
		this.progressBarDownload2.progressProperty().bind(progressDownload.getDownloadProgress());
		this.progressIndicator2.progressProperty().bind(progressDownload.getDownloadProgress());

		// Initialize current directory to user directory
		this.textFieldRepertoire.setText(System.getProperty("user.home"));
		
		checkBoxLien.setDisable(true); // Becaise not implemented
	}


	// Event Listener on CheckBox[#checkBoxLien].onMouseClicked
	@FXML
	public void listenerCheckBox(MouseEvent event) {
		// Disable or Enable TextField Profondeur
		if (this.textFieldProfondeur.isDisable()) textFieldProfondeur.setDisable(false);
		else textFieldProfondeur.setDisable(true);
	}
	// Event Listener on Button[#buttonDownload].onMouseClicked
	@FXML
	public void listenerDownload(MouseEvent event) {
		// Lauch process Download
		this.progressDownload.getDownloadProgress().set(0);
		processCrawler.download(	this.textFielURL.getText(),
									this.textFieldRepertoire.getText(),
									this.checkBoxLien.isSelected(),
									this.textFieldProfondeur.getText(),
									this.checkBoxIV.isSelected(),
									this.progressDownload);

	}
	// Event Listener on ChoiceBox[#choiceBoxLangue1].onContextMenuRequested
	@FXML
	public void listenerLangueContext1(ContextMenuEvent event) {
		// TODO Autogenerated
	}
	// Event Listener on ChoiceBox[#choiceBoxLangue1].onMouseClicked
	@FXML
	public void listenerLangueClicked(MouseEvent event) {
		// TODO Autogenerated
	}
	// Event Listener on Button[#buttonParcourir].onMouseClicked
	@FXML
	public void listenerParcourir(MouseEvent event) {
		// Open a DirectoryChooser and set the text of Repertoire TextField
		textFieldRepertoire.setText(processCrawler.getDirectory());
	}
        	@FXML
	public void listenerParcourir2(MouseEvent event) {
		// Open a DirectoryChooser and set the text of Repertoire TextField
		textFieldRepertoire2.setText(processCrawler.getDirectory());
	}
	// Event Listener on ChoiceBox[#choiceBoxLangue2].onContextMenuRequested
	@FXML
	public void listenerLangueContext2(ContextMenuEvent event) {
		// TODO Autogenerated
	}
	// Event Listener on ChoiceBox[#choiceBoxLangue2].onMouseClicked
	@FXML
	public void listenerLangueClicked2(MouseEvent event) {
		// TODO Autogenerated
	}
	// Event Listener on Button[#buttonOuvrir].onMouseClicked
	@FXML
	public void listenerOuvrir(MouseEvent event) {
		// TODO Autogenerated
                this.display.launch();
	}
	// Event Listener on Button[#buttonSupprimer].onMouseClicked
	@FXML
	public void listenerSupprimer(MouseEvent event) {
		// TODO Autogenerated
                this.display.remove();
	}

}
