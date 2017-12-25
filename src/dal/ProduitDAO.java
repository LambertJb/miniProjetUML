package dal;

import metier.I_Produit;
import metier.Produit;

public interface ProduitDAO {
	
	public boolean create(I_Produit p);
	public I_Produit read();
	public boolean update(I_Produit p);
	public boolean delete(String nom);

}
