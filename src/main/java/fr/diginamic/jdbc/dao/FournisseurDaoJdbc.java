/**
 * 
 */
package fr.diginamic.jdbc.dao;

import java.sql.*;
import java.util.List;
import java.util.ResourceBundle;

import fr.diginamic.jdbc.entites.Fournisseur;

/**
 * @author boukh
 *
 */
public class FournisseurDaoJdbc implements FournisseurDao {

	public List<Fournisseur> extraire() {
		// TODO Auto-generated method stub
		return null;
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

	public int update(String ancienNom, String nouveauNom) {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean delete(Fournisseur fournisseur) {
		// TODO Auto-generated method stub
		return false;
	}

}
