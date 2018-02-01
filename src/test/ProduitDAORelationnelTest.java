package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import DAO.ProduitDAO;
import DAO.ProduitDAORelationnel;
import metier.I_Produit;
import metier.Produit;

public class ProduitDAORelationnelTest {

	ProduitDAO prod;

	@Before
	public void setUp() {
		prod = ProduitDAORelationnel.getInstance();
	}

	@Test
	public void test_create() {
		I_Produit produit1 = new Produit("Bernard", 12.5, 12);

		assertFalse(prod.create(produit1));
	}

	@Test
	public void test_delete() {

		assertFalse(prod.delete("Bernard"));
	}

}
