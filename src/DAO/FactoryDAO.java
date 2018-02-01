package DAO;

public class FactoryDAO {
	
	private static ProduitDAO instance;
	
	public static ProduitDAO createInstance() {
		if (instance == null)
			instance = ProduitDAORelationnel.getInstance();
		return instance;
	}
}
