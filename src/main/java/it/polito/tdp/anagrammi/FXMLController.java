package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.Model;
import it.polito.tdp.anagrammi.model.Parola;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	private Model model;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea txtCorretti;

    @FXML
    private TextArea txtErrati;

    @FXML
    private TextField txtWord;

    @FXML
    void handleCalcola(ActionEvent event) {
    	this.txtCorretti.clear();
    	this.txtErrati.clear();
    	String parola = this.txtWord.getText().toLowerCase();
    	
    	if(!parola.matches("[a-zA-Z]*")) {
    		this.txtErrati.appendText("ERRORE! Inserire solo lettere");
    		return;
    	}
    		
    	
    	List<String> anagrammi = model.anagrammi(parola);
    	model.getDizionario();
    	
    	for(String s : anagrammi) {
    		if(model.isCorrect(s))
    			this.txtCorretti.appendText(s+"\n");
    		else
    			this.txtErrati.appendText(s+"\n");
    	}
    	
    }

    @FXML
    void handleReset(ActionEvent event) {
    	this.txtCorretti.clear();
    	this.txtErrati.clear();
    	this.txtWord.clear();
    	
    }
    
    public void setModel(Model model) {
    	this.model= model;
    }

    @FXML
    void initialize() {
        assert txtCorretti != null : "fx:id=\"txtCorretti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtErrati != null : "fx:id=\"txtErrati\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Scene.fxml'.";

    }

}
