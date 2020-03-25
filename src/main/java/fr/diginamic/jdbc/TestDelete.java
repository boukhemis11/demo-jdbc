/**
 * 
 */
package fr.diginamic.jdbc;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * @author boukh
 *
 */
public class TestDelete {

	/**
	 * @param args
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// étape 0 - lecture fichier "db.properties"
		ResourceBundle db = ResourceBundle.getBundle("db");

		// étape 1 - enregistrer le pilote
		Class.forName(db.getString("db.driver"));

		// étape 2 - créer la connexion
		Connection connection = DriverManager.getConnection(db.getString("db.url"), db.getString("db.user"),
				db.getString("db.pass"));

		// étape 3 - créer un "statement" (outil pour faire des requêtes)
		Statement statement = connection.createStatement();

		// étape 4 - exécuter la requête
		statement.executeUpdate("DELETE FROM `fournisseur` WHERE `nom` = 'La Maison des Peintures'");

		// 4.2 - exemple select
		ResultSet resultSet = statement.executeQuery("select * from fournisseur");

		while (resultSet.next()) {
			System.out.println(resultSet.getInt("id") + " " + resultSet.getString("nom"));
		}

		// étape 5 => libération des ressources
		resultSet.close();
		statement.close();
		connection.close();

	}

}
