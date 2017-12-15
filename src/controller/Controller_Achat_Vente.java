package controller;

public class Controller_Achat_Vente {

	public boolean acheterArticle(String nomProduit, int qteAchetee) {
		return ControllerInstance.catalogue.acheterStock(nomProduit, qteAchetee);
	}

	public boolean vendreArticle(String nomProduit, int qteVendue) {
		return ControllerInstance.catalogue.vendreStock(nomProduit, qteVendue);
	}
	
}
