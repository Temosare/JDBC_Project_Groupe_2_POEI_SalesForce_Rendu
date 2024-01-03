/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package doa;
import java.sql.*;
import modele.FournisseurBean;

/**
 *
 * @author thibaut
 */
public class FournisseurDao {

    /**
     *
     * @param numero
     * @param nom
     * @param email
     * @param adresse
     * @return
     * @throws SQLException
     */
    public String addFournisseur(int numero, String nom, String email,String adresse) throws SQLException {
        String message=null;	
        try(Connection conn= ConnectionBdd.connection()) {
            PreparedStatement ps=conn.prepareStatement("insert into fournisseur(numero,nom,email,adresse) values(?,?,?,?)");
            ps.setInt(1,numero);
            ps.setString(2,nom);
            ps.setString(3,email);
            ps.setString(4,adresse);
            //either (1) the row count for SQL Data Manipulation Language (DML) statements or (2) 0 for SQL statements that return nothing
            int x=ps.executeUpdate();
            if(x > 0) {
                System.out.println("Le fournisseur a bien ete ajouter");
                System.out.println("-------------------------------");
            }else
                System.out.println("L'insertion n'est pas bonne");
                System.out.println("-------------------------------");
        }catch(SQLException e) {
            //1062 = code erreur pour une violation de contrainte d'unicite
            if (e.getErrorCode() == 1062) {
                System.out.println("Impossible d'ajouter le fournisseur avec le numero : '" + numero + "' => Voilation de contrainte d'unicite");
                System.out.println("--------------------------------------------------------------------------------------------------------------");
            }else{
                System.out.println(e);
            }
            message=e.getMessage();
        }
        return message;
    }
//######################################################################################

    /**
     *
     * @param fournisseurId
     * @return
     * @throws SQLException
     */
    public String deleteFournisseur(int fournisseurId) throws SQLException {
        String message=null;
        try(Connection conn= ConnectionBdd.connection()) {
            PreparedStatement ps=conn.prepareStatement("delete from fournisseur where fournisseur_id=?;");
            ps.setInt(1, fournisseurId);
            //either (1) the row count for SQL Data Manipulation Language (DML) statements or (2) 0 for SQL statements that return nothing
            int x=ps.executeUpdate();
            if(x > 0) {
                System.out.println("Le fournisseur a bien ete supprimer");
                System.out.println("------------------------------------");
            }else {
                System.out.println("Fournisseur non trouver, suppression impossible");
                System.out.println("-----------------------------------------------");
            }	
        }catch(SQLException e) {
            System.out.println(e);
            message=e.getMessage();
        }
        return message;
    }	
//######################################################################################	

    /**
     *
     * @param fournisseurId
     * @param numero
     * @param nom
     * @param email
     * @param adresse
     * @return
     * @throws SQLException
     */
    public String updateFournisseur(int fournisseurId,int numero, String nom, String email,String adresse) throws SQLException {
        String message=null;
        try(Connection conn= ConnectionBdd.connection()) {
            PreparedStatement ps=conn.prepareStatement("UPDATE fournisseur SET numero=?, nom=?, email=?, adresse=? WHERE fournisseur_id=?;");
            ps.setInt(1,numero);
            ps.setString(2,nom);
            ps.setString(3,email);
            ps.setString(4,adresse);
            ps.setInt(5,fournisseurId);
            //either (1) the row count for SQL Data Manipulation Language (DML) statements or (2) 0 for SQL statements that return nothing
            int x=ps.executeUpdate();
            if(x > 0) {
                System.out.println("Le fournisseur a bien ete modifier");
                System.out.println("-----------------------------------");
            }else {
                System.out.println("Modification impossible, fournisseur non trouver");
                System.out.println("------------------------------------------------");
            }
        }catch(SQLException e) {
            //1062 = code erreur pour une violation de contrainte d'unicite
            if (e.getErrorCode() == 1062) {
                System.out.println("Impossible de modifier le fournisseur en utilisant le numero : '" + numero + "' => Voilation de contrainte d'unicite");
                System.out.println("-----------------------------------------------------------------------------------------------------------------------");
            }else{
                System.out.println(e);
            }
            message=e.getMessage();
        }
        return message;
    }
//######################################################################################		

    /**
     *
     * @param fournisseurId
     * @return
     * @throws SQLException
     */
    public FournisseurBean viewFournisseur(int fournisseurId) throws SQLException {
        FournisseurBean fb = null;
        try(Connection conn= ConnectionBdd.connection()) {
            PreparedStatement ps=conn.prepareStatement("SELECT * FROM fournisseur WHERE fournisseur_id=?;");
            ps.setInt(1,fournisseurId);
            //a ResultSet object that contains the data produced by the query; never null
            ResultSet rs= ps.executeQuery();
            if(rs.next()) {
                int id=rs.getInt("fournisseur_id");
                int numero=rs.getInt("numero");
                String nom= rs.getString("nom");
                String email= rs.getString("email");
                String adresse= rs.getString("adresse");
                fb=new FournisseurBean(id,numero,nom,email,adresse);
            }else
                System.out.println("Affichage impossible, fournisseur non trouver");
                System.out.println("--------------------------------------------");                           
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println(e.getMessage());
        }
        return fb;
    }	
//	################################################################################

    /**
     *
     * @throws SQLException
     */
    public void viewAllFournisseur() throws SQLException {
        try(Connection conn = ConnectionBdd.connection()) {
            PreparedStatement ps= conn.prepareStatement("select * from fournisseur");
            //a ResultSet object that contains the data produced by the query; never null
            ResultSet rs= ps.executeQuery();
            while(rs.next()) {
                int id=rs.getInt("fournisseur_id");
                int numero=rs.getInt("numero");
                String nom= rs.getString("nom");
                String email= rs.getString("email");
                String adresse= rs.getString("adresse");
                System.out.println("******************************");
                System.out.println("Fournisseur Id: " + id);
                System.out.println("Numero: " + numero);
                System.out.println("Nom: " + nom);
                System.out.println("Email: " + email);
                System.out.println("Adresse: " + adresse);
                System.out.println("******************************");
            }
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println(e.getMessage());
        }
    }    
}
