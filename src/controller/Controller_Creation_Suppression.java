package controller;

import metier.I_Catalogue;
import metier.Produit;

public class Controller_Creation_Suppression {
	
	private I_Catalogue catalogue = ControllerInstance.catalogue;
	
	public String[] demandeSuppression() {
		
		return catalogue.getNomProduits();
	}
	
	public boolean supprimerProduit(String nomProd) {
		
		return catalogue.removeProduit(nomProd);
	}
	
	public boolean ajouterProduit(String nomProd, double prixUnitaireHT, int qte) {
		
		return catalogue.addProduit(nomProd, prixUnitaireHT, qte);
	}
}
