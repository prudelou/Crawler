package crawler;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.ProgressIndicator;

import javafx.scene.control.TextField;

import javafx.scene.control.Label;

import javafx.scene.control.ProgressBar;

import javafx.scene.control.ScrollPane;

import javafx.scene.control.Tab;

import javafx.scene.input.MouseEvent;

import javafx.scene.control.CheckBox;

import javafx.scene.control.ChoiceBox;

import javafx.scene.control.TreeView;

import javafx.scene.input.ContextMenuEvent;

public class Controller {
	@FXML
	private Tab tabCrawl;
	public Tab getTabCrawl() {
		return tabCrawl;
	}
	public void setTabCrawl(Tab tabCrawl) {
		this.tabCrawl = tabCrawl;
	}
	public Label getLabelURL() {
		return labelURL;
	}
	public void setLabelURL(Label labelURL) {
		this.labelURL = labelURL;
	}
	public Label getLabelLien() {
		return labelLien;
	}
	public void setLabelLien(Label labelLien) {
		this.labelLien = labelLien;
	}
	public TextField getTextFielURL() {
		return textFielURL;
	}
	public void setTextFielURL(TextField textFielURL) {
		this.textFielURL = textFielURL;
	}
	public CheckBox getCheckBoxLien() {
		return checkBoxLien;
	}
	public void setCheckBoxLien(CheckBox checkBoxLien) {
		this.checkBoxLien = checkBoxLien;
	}
	public CheckBox getCheckBoxIV() {
		return checkBoxIV;
	}
	public void setCheckBoxIV(CheckBox checkBoxIV) {
		this.checkBoxIV = checkBoxIV;
	}
	public Label getLabelProfondeur() {
		return labelProfondeur;
	}
	public void setLabelProfondeur(Label labelProfondeur) {
		this.labelProfondeur = labelProfondeur;
	}
	public TextField getTextFieldProfondeur() {
		return textFieldProfondeur;
	}
	public void setTextFieldProfondeur(TextField textFieldProfondeur) {
		this.textFieldProfondeur = textFieldProfondeur;
	}
	public Button getButtonDownload() {
		return buttonDownload;
	}
	public void setButtonDownload(Button buttonDownload) {
		this.buttonDownload = buttonDownload;
	}
	public Label getLabelLangue1() {
		return labelLangue1;
	}
	public void setLabelLangue1(Label labelLangue1) {
		this.labelLangue1 = labelLangue1;
	}
	public ChoiceBox getChoiceBoxLangue1() {
		return choiceBoxLangue1;
	}
	public void setChoiceBoxLangue1(ChoiceBox choiceBoxLangue1) {
		this.choiceBoxLangue1 = choiceBoxLangue1;
	}
	public Label getLabelRepertoire() {
		return labelRepertoire;
	}
	public void setLabelRepertoire(Label labelRepertoire) {
		this.labelRepertoire = labelRepertoire;
	}
	public TextField getTextFieldRepertoire() {
		return textFieldRepertoire;
	}
	public void setTextFieldRepertoire(TextField textFieldRepertoire) {
		this.textFieldRepertoire = textFieldRepertoire;
	}
	public Button getButtonParcourir() {
		return buttonParcourir;
	}
	public void setButtonParcourir(Button buttonParcourir) {
		this.buttonParcourir = buttonParcourir;
	}
	public Label getLabelDownload1() {
		return labelDownload1;
	}
	public void setLabelDownload1(Label labelDownload1) {
		this.labelDownload1 = labelDownload1;
	}
	public ProgressBar getProgressBarDownload1() {
		return progressBarDownload1;
	}
	public void setProgressBarDownload1(ProgressBar progressBarDownload1) {
		this.progressBarDownload1 = progressBarDownload1;
	}
	public ProgressIndicator getProgressIndicatorDownload() {
		return progressIndicatorDownload;
	}
	public void setProgressIndicatorDownload(ProgressIndicator progressIndicatorDownload) {
		this.progressIndicatorDownload = progressIndicatorDownload;
	}
	public Tab getTabVisualisation() {
		return tabVisualisation;
	}
	public void setTabVisualisation(Tab tabVisualisation) {
		this.tabVisualisation = tabVisualisation;
	}
	public Label getLabelLangue2() {
		return labelLangue2;
	}
	public void setLabelLangue2(Label labelLangue2) {
		this.labelLangue2 = labelLangue2;
	}
	public ChoiceBox getChoiceBoxLangue2() {
		return choiceBoxLangue2;
	}
	public void setChoiceBoxLangue2(ChoiceBox choiceBoxLangue2) {
		this.choiceBoxLangue2 = choiceBoxLangue2;
	}
	public Label getLabelDownload2() {
		return labelDownload2;
	}
	public void setLabelDownload2(Label labelDownload2) {
		this.labelDownload2 = labelDownload2;
	}
	public ProgressBar getProgressBarDownload2() {
		return progressBarDownload2;
	}
	public void setProgressBarDownload2(ProgressBar progressBarDownload2) {
		this.progressBarDownload2 = progressBarDownload2;
	}
	public ProgressIndicator getProgressIndicator2() {
		return progressIndicator2;
	}
	public void setProgressIndicator2(ProgressIndicator progressIndicator2) {
		this.progressIndicator2 = progressIndicator2;
	}
	public TreeView getTreeView() {
		return treeView;
	}
	public void setTreeView(TreeView treeView) {
		this.treeView = treeView;
	}
	public Button getButtonOuvrir() {
		return buttonOuvrir;
	}
	public void setButtonOuvrir(Button buttonOuvrir) {
		this.buttonOuvrir = buttonOuvrir;
	}
	public Button getButtonSupprimer() {
		return buttonSupprimer;
	}
	public void setButtonSupprimer(Button buttonSupprimer) {
		this.buttonSupprimer = buttonSupprimer;
	}
	public ScrollPane getScrollPane() {
		return scrollPane;
	}
	public void setScrollPane(ScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}
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
	private Button buttonParcourir;
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
	private ScrollPane scrollPane;

	// Event Listener on CheckBox[#checkBoxLien].onMouseClicked 
	@FXML
	public void listenerCheckBox(MouseEvent event) {
		// TODO Autogenerated
	}
	// Event Listener on Button[#buttonDownload].onMouseClicked
	@FXML
	public void listenerDownload(MouseEvent event) {
		// TODO Autogenerated
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
		// TODO Autogenerated
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
	}
	// Event Listener on Button[#buttonSupprimer].onMouseClicked
	@FXML
	public void listenerSupprimer(MouseEvent event) {
		// TODO Autogenerated
	}
}
