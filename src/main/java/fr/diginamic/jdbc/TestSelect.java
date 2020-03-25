/**
 * 
 */
package fr.diginamic.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

import fr.diginamic.jdbc.entites.Fournisseur;

/**
 * @author boukh
 *
 */
public class TestSelect {

	/**
	 * @param args
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// Cr�ation d'un tableau
		ArrayList<Fournisseur> listeFournisseurs = new ArrayList<Fournisseur>();
		// �tape 0 - lecture fichier "db.properties"
		ResourceBundle db = ResourceBundle.getBundle("db");

		// �tape 1 - enregistrer le pilote
		// option 1
		// DriverManager.registerDriver(new Driver());
		// option 2
		Class.forName(db.getString("db.driver"));

		// �tape 2 - cr�er la connexion
		Connection connection = DriverManager.getConnection(db.getString("db.url"), db.getString("db.user"),
				db.getString("db.pass"));

		// �tape 3 - cr�er un "statement" (outil pour faire des requ�tes)
		Statement statement = connection.createStatement();

		// �tape 4 - ex�cuter la requ�te
		ResultSet resultSet = statement.executeQuery("select * from fournisseur");

		while (resultSet.next()) {
			listeFournisseurs.add(new Fournisseur(resultSet.getInt("id"), resultSet.getString("nom")));
		}

		// Liste des fournisseurs
		for (Fournisseur valeur : listeFournisseurs) {
			System.out.println(valeur.toString());
		}

		// �tape 5 => lib�ration des ressources
		resultSet.close();
		statement.close();
		connection.close();

	}

}
