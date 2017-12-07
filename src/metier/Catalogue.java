package metier;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Catalogue implements I_Catalogue {

	private ArrayList<I_Produit> lesProduits;

	public Catalogue() {
		lesProduits = new ArrayList<I_Produit>();
	}

	@Override
	public boolean addProduit(I_Produit produit) {
		if (lesProduits.contains(produit)) {
			lesProduits.add(produit);
			return true;
		}
		return false;

	}

	@Override
	public boolean addProduit(String nom, double prix, int qte) {
		I_Produit produit = new Produit(nom,prix,qte);
		if (!lesProduits.contains(produit)) {
			lesProduits.add(produit);
			return true;
		}
		return false;

	}

	@Override
	public int addProduits(List<I_Produit> l) {
		int compteur = 0;
		for (I_Produit produit : l) {
			if(!lesProduits.contains(produit)){
				lesProduits.add(produit);
				compteur++;
			}
		}
		return compteur;
	}

	@Override
	public boolean removeProduit(String nom) {
		for (Iterator iterator = lesProduits.iterator(); iterator.hasNext();) {
			I_Produit produit = (I_Produit) iterator.next();
			if (produit.getNom() == nom){
				lesProduits.remove(produit);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean acheterStock(String nomProduit, int qteAchetee) {
		
		return false;
	}

	@Override
	public boolean vendreStock(String nomProduit, int qteVendue) {
		return false;
	}

	@Override
	public String[] getNomProduits() {
		return null;
	}

	@Override
	public double getMontantTotalTTC() {
		return 0;
	}

	@Override
	public void clear() {

	}

}
