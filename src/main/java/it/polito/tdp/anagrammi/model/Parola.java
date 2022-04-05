package it.polito.tdp.anagrammi.model;

public class Parola {

	private int id;
	private String nome;
	
	public Parola(int id, String parola) {
		
		this.id = id;
		this.nome = parola;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String parola) {
		this.nome = parola;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Parola other = (Parola) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Parola [id=" + id + ", nome=" + nome + "]";
	}
	
	
	
}
