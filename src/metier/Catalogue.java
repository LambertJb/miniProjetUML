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
		if (!lesProduits.contains(produit)) {
			lesProduits.add(produit);
			return true;
		}
		return false;

	}

	@Override
	public boolean addProduit(String nom, double prix, int qte) {
		I_Produit produit = new Produit(nom,prix,qte);
		return addProduit(produit);

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
		I_Produit produit = getProduit(nom);
		if(produit != null){
			lesProduits.remove(produit);
			return true;
		}
		return false;
	}

	@Override
	public boolean acheterStock(String nomProduit, int qteAchetee) {
		I_Produit produit = getProduit(nomProduit);
		if (produit != null) {
			produit.ajouter(qteAchetee);
			return true;
		}
		return false;
	}

	@Override
	public boolean vendreStock(String nomProduit, int qteVendue) {
		I_Produit produit = getProduit(nomProduit);
		if (produit != null){
			produit.enlever(qteVendue);
			return true;
		}
		return false;
	}

	@Override
	public String[] getNomProduits() {
		String[] tousLesNoms = new String[lesProduits.size()];
		int index = 0;
		for (Iterator iterator = lesProduits.iterator(); iterator.hasNext();index++) {
			I_Produit produit = (I_Produit) iterator.next();
			tousLesNoms[index] = produit.getNom();
		}
		return tousLesNoms;
	}

	@Override
	public double getMontantTotalTTC() {
		double prix = 0;
		for (I_Produit produit : lesProduits) {
			prix += produit.getPrixStockTTC();
		}
		return prix;
	}

	@Override
	public void clear() {
		lesProduits.clear();
	}
	
	private I_Produit getProduit(String nom) {
		for (Iterator iterator = lesProduits.iterator(); iterator.hasNext();) {
			I_Produit produit = (I_Produit) iterator.next();
			if (produit.getNom() == nom){
				return produit;
			}
		}
		return null;
	}

}
