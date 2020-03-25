/**
 * 
 */
package fr.diginamic.jdbc.entites;

/**
 * @author boukh
 *
 */
public class Fournisseur {

	private int id;
	private String nom;
	
	public Fournisseur(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Fournisseur [id=" + id + ", nom=" + nom + "]";
	}
	
	
	
}
