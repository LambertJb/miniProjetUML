package controller;

import metier.Catalogue;
import metier.I_Catalogue;

public class Controller_Achat_Vente {

	private I_Catalogue catalogue;

	public Controller_Achat_Vente() {
		catalogue = Catalogue.getInstance();
	}

	public boolean acheterArticle(String nomProduit, String qteAchetee) {

		boolean resultat = false;
		try {
			resultat = catalogue.acheterStock(nomProduit, Integer.parseInt(qteAchetee));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return resultat;
	}

	public boolean vendreArticle(String nomProduit, String qteVendue) {
		boolean resultat = false;
		try {
			resultat = catalogue.vendreStock(nomProduit, Integer.parseInt(qteVendue));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return resultat;
	}

	public String[] demandeAchats() {
		return catalogue.getNomProduits();
	}
}
