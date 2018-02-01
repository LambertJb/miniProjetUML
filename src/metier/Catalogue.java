package metier;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import DAO.FactoryDAO;
import DAO.ProduitDAO;

public class Catalogue implements I_Catalogue {

	private List<I_Produit> lesProduits;
	private ProduitDAO produitBDD;
	
	public Catalogue() {
		produitBDD = FactoryDAO.createInstance();
		lesProduits = new ArrayList<I_Produit>();
		lesProduits = produitBDD.read();
	}

	@Override
	public boolean addProduit(I_Produit produit) {
		if (produit != null) {
			if (!lesProduits.contains(produit) && produit.getPrixUnitaireHT() > 0 && produit.getQuantite() >= 0
					&& getProduit(produit.getNom()) == null) {
				lesProduits.add(produit);
				return true;
			}
			return false;
		}
		return false;

	}

	@Override
	public boolean addProduit(String nom, double prix, int qte) {
		I_Produit produit = new Produit(nom, prix, qte);
		return addProduit(produit);

	}

	@Override
	public int addProduits(List<I_Produit> list) {
		int compteur = 0;
		if (list != null) {
			for (I_Produit produit : list) {
				if (testProduit(produit)) {
					compteur++;
				}
			}
		}
		return compteur;
	}

	private boolean testProduit(I_Produit produit) {
		if (!lesProduits.contains(produit) && produit.getPrixUnitaireHT() > 0 && produit.getQuantite() >= 0
				&& getProduit(produit.getNom()) == null) {
			lesProduits.add(produit);
			return true;
		}
		return false;
	}

	@Override
	public boolean removeProduit(String nom) {
		I_Produit produit = getProduit(nom);
		if (produit != null) {
			lesProduits.remove(produit);
			return true;
		}
		return false;
	}

	@Override
	public boolean acheterStock(String nomProduit, int qteAchetee) {
		I_Produit produit = getProduit(nomProduit);
		if (qteAchetee >= 0) {
			if (produit != null) {
				if (produit.getQuantite() != 0 && qteAchetee > 0) {
					produit.ajouter(qteAchetee);
					return true;
				}
			}
			return false;
		}
		return false;
	}

	@Override
	public boolean vendreStock(String nomProduit, int qteVendue) {
		I_Produit produit = getProduit(nomProduit);
		if (produit != null) {
			if (produit.getQuantite() != 0 && qteVendue <= produit.getQuantite() && qteVendue > 0) {
				produit.enlever(qteVendue);
				return true;
			}
		}
		return false;
	}

	@Override
	public String[] getNomProduits() {
		String[] tousLesNoms = new String[lesProduits.size()];
		int index = 0;
		for (I_Produit produit : lesProduits) {
			tousLesNoms[index] = produit.getNom();
			index++;
		}
		Arrays.sort(tousLesNoms);
		return tousLesNoms;
	}

	@Override
	public double getMontantTotalTTC() {
		double prix = 0;
		for (I_Produit produit : lesProduits) {
			prix += produit.getPrixStockTTC();
		}
		return (double) Math.round(prix * 100) / 100;
	}

	@Override
	public void clear() {
		lesProduits.clear();
	}

	private I_Produit getProduit(String nom) {
		if (nom != null) {
			for (Iterator iterator = lesProduits.iterator(); iterator.hasNext();) {
				I_Produit produit = (I_Produit) iterator.next();
				if (produit.getNom().trim().equals(nom.trim())) {
					return produit;
				}
			}
		}
		return null;
	}

	@Override
	public String toString() {
		String toString = "";
		NumberFormat prix = new DecimalFormat("##.00");
		if (!lesProduits.isEmpty()) {
			for (I_Produit produit : lesProduits) {
				toString += produit.getNom() + " - prix HT : "
						+ prix.format(produit.getPrixUnitaireHT()).replace(".", ",") + " � - prix TTC : "
						+ prix.format(produit.getPrixUnitaireTTC()) + " � - quantit� en stock : "
						+ produit.getQuantite() + "\n";
			}
			toString += "\n";
			return toString += "Montant total TTC du stock : " + prix.format(getMontantTotalTTC()).replace(".", ",")
					+ " �";
		}

		toString += "\n";
		return toString += "Montant total TTC du stock : 0,00 �";

	}

	@Override
	public void mettreAJour() {
		this.lesProduits = this.produitBDD.read();
		
	}
}
