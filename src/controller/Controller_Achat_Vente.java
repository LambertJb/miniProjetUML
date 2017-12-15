package controller;

public class Controller_Achat_Vente {

	public boolean acheterArticle(String nomProduit, String qteAchetee) {

		boolean resultat = false;
		try {
			resultat = ControllerInstance.catalogue.acheterStock(nomProduit, Integer.parseInt(qteAchetee));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return resultat;
	}

	public boolean vendreArticle(String nomProduit, int qteVendue) {
		return ControllerInstance.catalogue.vendreStock(nomProduit, qteVendue);
	}

}
