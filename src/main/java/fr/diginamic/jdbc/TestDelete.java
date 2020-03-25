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
		// �tape 0 - lecture fichier "db.properties"
		ResourceBundle db = ResourceBundle.getBundle("db");

		// �tape 1 - enregistrer le pilote
		Class.forName(db.getString("db.driver"));

		// �tape 2 - cr�er la connexion
		Connection connection = DriverManager.getConnection(db.getString("db.url"), db.getString("db.user"),
				db.getString("db.pass"));

		// �tape 3 - cr�er un "statement" (outil pour faire des requ�tes)
		Statement statement = connection.createStatement();

		// �tape 4 - ex�cuter la requ�te
		statement.executeUpdate("DELETE FROM `fournisseur` WHERE `nom` = 'La Maison des Peintures'");

		// 4.2 - exemple select
		ResultSet resultSet = statement.executeQuery("select * from fournisseur");

		while (resultSet.next()) {
			System.out.println(resultSet.getInt("id") + " " + resultSet.getString("nom"));
		}

		// �tape 5 => lib�ration des ressources
		resultSet.close();
		statement.close();
		connection.close();

	}

}
