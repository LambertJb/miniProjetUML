package DAO;

import java.util.List;

import metier.I_Produit;

public interface ProduitDAO {
	
	public boolean create(I_Produit p);
	public List<I_Produit> read();
	public boolean update(I_Produit p);
	public boolean delete(String nom);

}
