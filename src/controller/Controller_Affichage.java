package controller;

import metier.I_Catalogue;

public class Controller_Affichage {

	private I_Catalogue catalogue = ControllerInstance.catalogue;
	
	public String affichageCatalogue()
	{
		return catalogue.toString();
	}
}
