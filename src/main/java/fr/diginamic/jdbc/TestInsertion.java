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
public class TestInsertion {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException, ClassNotFoundException {

	        // étape 0 - lecture fichier "db.properties"
	        ResourceBundle db = ResourceBundle.getBundle("db");

	        // étape 1 - enregistrer le pilote
	        Class.forName(db.getString("db.driver"));

	        // étape 2 - créer la connexion
	        Connection connection = DriverManager.getConnection(db.getString("db.url"), db.getString("db.user"), db.getString("db.pass"));


	        // étape 3 - créer un "statement" 
	        Statement statement = connection.createStatement();

	        // étape 4 - exécuter la requête
	        int nbLignesImpactées = statement.executeUpdate("insert into fournisseur(id,nom) values(1, 'La Maison de la Peinture')");
	        
			// 4.2 - exemple select
			ResultSet resultSet = statement.executeQuery("select * from fournisseur");
	        
			while (resultSet.next()) {
				System.out.println(resultSet.getInt("id") + " " + resultSet.getString("nom"));
			}

	        // étape 5 => libération des ressources

	        statement.close();
	        connection.close();

	}

}
