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
public class TestUpdate {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
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
		statement.executeUpdate(
				"UPDATE fournisseur SET `nom`='La Maison des Peintures' WHERE `nom` LIKE 'La Maison de la Peinture'");

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
