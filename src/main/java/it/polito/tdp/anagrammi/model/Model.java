package it.polito.tdp.anagrammi.model;

import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.anagrammi.DAO.ParolaDAO;

public class Model {

	private ParolaDAO parolaDao;
	private List<String> anagrammi;
	private List<String> dizionario;
	
	public Model() {
		this.parolaDao = new ParolaDAO();
	}

	public List<Parola> getDizionario(){
		List<Parola> l = this.parolaDao.getDizionario();
		dizionario = new LinkedList<String>();
		for(Parola p : l)
			dizionario.add(p.getNome());
		
		return l;
	}
	
	public List<String> anagrammi(String s){
		
		anagrammi = new LinkedList<String>();
		anagrammi_ricorsiva("",0,s);
		
		return anagrammi;
	}

	private void anagrammi_ricorsiva(String parziale, int L, String rimanenti) {
		if(rimanenti.length()==0){
			this.anagrammi.add(parziale);
		}
		else {
			for(int pos=0; pos<rimanenti.length(); pos++) {
				anagrammi_ricorsiva(parziale+rimanenti.charAt(pos), 
						L+1,
						rimanenti.substring(0, pos)+rimanenti.substring(pos+1) );
			}
		}
		
	}
	
	public boolean isCorrect(String s) {
		
		if(dizionario.contains(s))
			return true;
		
		return false;
	}
	
}
