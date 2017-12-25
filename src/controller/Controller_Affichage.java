package controller;

import metier.Catalogue;
import metier.I_Catalogue;

public class Controller_Affichage {

	private I_Catalogue catalogue;

	public Controller_Affichage() {
		catalogue = Catalogue.getInstance();
	}

	public String affichageCatalogue() {
		return catalogue.toString();
	}
}
