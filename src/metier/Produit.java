package metier;

public class Produit implements I_Produit{
	
	private int quantiteStock;
	
	private String nom;
	
	private double prixUnitaireHT;
	
	private double tauxTVA = 0.2f;
	
	public Produit(String nom, double prixUnitaireHT, int qte)
	{
		this.nom = nom;
		this.prixUnitaireHT = prixUnitaireHT;
		this.quantiteStock = qte;
	}

	@Override
	public boolean ajouter(int qteAchetee) {
		this.quantiteStock += qteAchetee;
		return true;
	}

	@Override
	public boolean enlever(int qteVendue) {
		this.quantiteStock = this.quantiteStock - qteVendue;
		return true;
	}

	@Override
	public String getNom() {
		return this.nom;
	}

	@Override
	public int getQuantite() {
		return this.quantiteStock;
	}

	@Override
	public double getPrixUnitaireHT() {
		return this.prixUnitaireHT;
	}

	@Override
	public double getPrixUnitaireTTC() {
		return this.prixUnitaireHT*(1+this.tauxTVA);
	}

	@Override
	public double getPrixStockTTC() {
		double prixUnitaireTTC = this.getPrixUnitaireTTC();
		return this.quantiteStock*prixUnitaireTTC;
	}

}
