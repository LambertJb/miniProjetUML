package dal;

import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

import metier.I_Produit;
import metier.Produit;

public class ProduitDAORelationnel implements ProduitDAO {
	private PreparedStatement pst;
	private Connection cn;
	private ResultSet res;

	public ProduitDAORelationnel() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			cn = DriverManager.getConnection("jdbc:oracle:thin:@162.38.222.149:1521:iut","lambertj","Jibet199");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean create(I_Produit p) {
		if (p != null) {
			try {
				String sql = "INSERT INTO Produits (quantiteStock,nom,prixUnitaireHT) Values (:qteStock, :nom, :prixUnitaireHT";
				pst = cn.prepareStatement(sql);
				pst.setInt(1, p.getQuantite());
				pst.setString(2, p.getNom());
				pst.setDouble(3, p.getPrixUnitaireHT());
				return pst.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public I_Produit read() {
		return null;
	}

	public boolean update(I_Produit p) {
		if (p != null) {
			String sql = "Update Produits SET quantiteStock = :qteStock, prixUnitaireHT = :prixUnitaireHT WHERE nom = :nom";
			try {
				pst = cn.prepareStatement(sql);
				pst.setInt(1, p.getQuantite());
				pst.setDouble(2, p.getPrixUnitaireHT());
				pst.setString(3, p.getNom());
				return pst.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public boolean delete(String nom) {
		if (nom != null){
			String sql = "Delete From Produit WHERE nom = :nom";
			try {
				pst = cn.prepareStatement(sql);
				pst.setString(1, nom);
				return pst.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return false;
	}
}
