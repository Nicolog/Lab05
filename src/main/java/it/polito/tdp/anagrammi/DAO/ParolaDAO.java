package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.anagrammi.model.Parola;


public class ParolaDAO {

	public List<Parola> getDizionario() {

		final String sql = "SELECT * FROM parola";

		List<Parola> dizionario = new LinkedList<Parola>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				Parola p = new Parola(rs.getInt("id"),rs.getString("nome"));
				dizionario.add(p);
				
			}
		
			conn.close();
			return dizionario;
			

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
	}
	
}
