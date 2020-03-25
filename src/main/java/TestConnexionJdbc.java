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

        // créer la connexion
        Connection connection = DriverManager.getConnection(db.getString("db.url"), db.getString("db.user"), db.getString("db.pass"));
        
		try {
			Class.forName(driverName);
			System.out.println("connexion à la base de données");
		} catch (ClassNotFoundException e) {
			System.out.println("La connexion à la base de données n'a pas pu s'établir");
			throw new Exception("Le driver JDBC " + driverName + " n'a pas été trouvé ", e);
		}

        connection.close();

	}

}
