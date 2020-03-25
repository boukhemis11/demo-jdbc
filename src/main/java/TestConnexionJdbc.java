/**
 * 
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

/**
 * @author boukh
 *
 */
public class TestConnexionJdbc {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {

        ResourceBundle db = ResourceBundle.getBundle("db");

        String driverName = db.getString("db.driver");

        // cr�er la connexion
        Connection connection = DriverManager.getConnection(db.getString("db.url"), db.getString("db.user"), db.getString("db.pass"));
        
		try {
			Class.forName(driverName);
			System.out.println("connexion � la base de donn�es");
		} catch (ClassNotFoundException e) {
			System.out.println("La connexion � la base de donn�es n'a pas pu s'�tablir");
			throw new Exception("Le driver JDBC " + driverName + " n'a pas �t� trouv� ", e);
		}

        connection.close();

	}

}
