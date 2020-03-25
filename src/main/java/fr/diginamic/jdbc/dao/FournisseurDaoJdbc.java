/**
 * 
 */
package fr.diginamic.jdbc.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import fr.diginamic.jdbc.entites.Fournisseur;

/**
 * @author boukh
 *
 */
public class FournisseurDaoJdbc implements FournisseurDao {

	public List<Fournisseur> extraire() throws SQLException, ClassNotFoundException {

		// Cr�ation d'un tableau
		ArrayList<Fournisseur> listeFournisseurs = new ArrayList<Fournisseur>();

		// �tape 0 - lecture fichier "db.properties"
		ResourceBundle db = ResourceBundle.getBundle("db");

		// �tape 1 - enregistrer le pilote
		Class.forName(db.getString("db.driver"));

		// �tape 2 - cr�er la connexion
		Connection connection = DriverManager.getConnection(db.getString("db.url"), db.getString("db.user"),
				db.getString("db.pass"));

		// �tape 3 - cr�er un "preparedStatement"
		// Statement statement = connection.createStatement();
		PreparedStatement preparedStatement = connection.prepareStatement("select * from fournisseur");

		// Execution du statement
		ResultSet resultats = preparedStatement.executeQuery();
		while (resultats.next()) {
			listeFournisseurs.add(new Fournisseur(resultats.getInt("id"), resultats.getString("nom")));
		}

		// �tape 5 => lib�ration des ressources
		resultats.close();
		preparedStatement.close();
		connection.close();
		return listeFournisseurs;
	}

	public void insert(Fournisseur fournisseur) throws SQLException, ClassNotFoundException {

		// �tape 0 - lecture fichier "db.properties"
		ResourceBundle db = ResourceBundle.getBundle("db");

		int idFournisseur = fournisseur.getId();
		String nomFournisseur = fournisseur.getNom();

		// �tape 1 - enregistrer le pilote
		Class.forName(db.getString("db.driver"));

		// �tape 2 - cr�er la connexion
		Connection connection = DriverManager.getConnection(db.getString("db.url"), db.getString("db.user"),
				db.getString("db.pass"));

		// �tape 3 - cr�er un "preparedStatement"
		PreparedStatement preparedStatement = connection.prepareStatement(
				"insert into fournisseur(id,nom) values(" + idFournisseur + ", '" + nomFournisseur + "')");

		// Execution du statement
		preparedStatement.executeUpdate();

		// �tape 5 => lib�ration des ressources
		preparedStatement.close();
		connection.close();

	}

	public int update(String ancienNom, String nouveauNom) throws SQLException, ClassNotFoundException {

		// �tape 0 - lecture fichier "db.properties"
		ResourceBundle db = ResourceBundle.getBundle("db");

		// �tape 1 - enregistrer le pilote
		Class.forName(db.getString("db.driver"));

		// �tape 2 - cr�er la connexion
		Connection connection = DriverManager.getConnection(db.getString("db.url"), db.getString("db.user"),
				db.getString("db.pass"));

		// �tape 3 - cr�er un "preparedStatement"
		// Statement statement = connection.createStatement();
		PreparedStatement preparedStatement = connection
				.prepareStatement("UPDATE fournisseur SET `nom`='" + nouveauNom + "' WHERE `nom` LIKE ?");

		// D�finir "parametres?"
		preparedStatement.setString(1, ancienNom);

		// Execution du statement
		preparedStatement.executeUpdate();

		// �tape 5 => lib�ration des ressources
		preparedStatement.close();
		connection.close();
		return 0;
	}
;
	public boolean delete(Fournisseur fournisseur) throws SQLException, ClassNotFoundException {

		// �tape 0 - lecture fichier "db.properties"
		ResourceBundle db = ResourceBundle.getBundle("db");

		int idFournisseur = fournisseur.getId();

		// �tape 1 - enregistrer le pilote
		Class.forName(db.getString("db.driver"));

		// �tape 2 - cr�er la connexion
		Connection connection = DriverManager.getConnection(db.getString("db.url"), db.getString("db.user"),
				db.getString("db.pass"));

		// �tape 3 - cr�er un "preparedStatement"
		// Statement statement = connection.createStatement();
		PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM `fournisseur` WHERE `id` = ? ");

		// D�finir "parametres?"
		preparedStatement.setInt(1, idFournisseur);

		// Execution du statement
		preparedStatement.executeUpdate();

		// �tape 5 => lib�ration des ressources
		preparedStatement.close();
		connection.close();
		return true;
	}
}
