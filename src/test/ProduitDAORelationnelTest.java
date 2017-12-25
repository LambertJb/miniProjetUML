package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import dal.ProduitDAO;
import dal.ProduitDAORelationnel;
import metier.I_Produit;
import metier.Produit;

public class ProduitDAORelationnelTest {

	ProduitDAO prod;

	@Before
	public void setUp() {
		prod = new ProduitDAORelationnel();
	}
	
	
	@Test
	public void test_create(){
		I_Produit produit1 = new Produit("Bernard", 12.5,12);
		
		assertTrue(prod.create(produit1));
	}

}
