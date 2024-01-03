/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package doa;
import java.sql.*;
import modele.ClientBean;

/**
 *
 * @author mathys
 */
public class ClientDao {
    
    /**
     *
     * @param numero
     * @param nom
     * @param prenom
     * @param email
     * @param adresse
     * @return
     * @throws SQLException
     */
    public String addClient(int numero, String nom, String prenom, String email,String adresse) throws SQLException {
        String message=null;	
        try(Connection conn= ConnectionBdd.connection()) {
            PreparedStatement ps=conn.prepareStatement("insert into client(numero,nom,prenom,email,adresse) values(?,?,?,?,?)");
            ps.setInt(1,numero);
            ps.setString(2,nom);
            ps.setString(3,prenom);
            ps.setString(4,email);
            ps.setString(5,adresse);
            //either (1) the row count for SQL Data Manipulation Language (DML) statements or (2) 0 for SQL statements that return nothing
            int x=ps.executeUpdate();
            if(x > 0) {
                System.out.println("Le client a bien ete ajouter");
                System.out.println("-------------------------------");
            }else
                System.out.println("L'insertion n'est pas bonne");
                System.out.println("-------------------------------");
        }catch(SQLException e) {
            //1062 = code erreur pour une violation de contrainte d'unicite
            if (e.getErrorCode() == 1062) {
                System.out.println("Impossible d'ajouter le client avec le numero : '" + numero + "' => Voilation de contrainte d'unicite");
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
     * @param clientId
     * @return
     * @throws SQLException
     */
    public String deleteClient(int clientId) throws SQLException {
        String message=null;
        try(Connection conn= ConnectionBdd.connection()) {
            PreparedStatement ps=conn.prepareStatement("delete from client where client_id=?;");
            ps.setInt(1, clientId);
            //either (1) the row count for SQL Data Manipulation Language (DML) statements or (2) 0 for SQL statements that return nothing
            int x=ps.executeUpdate();
            if(x > 0) {
                System.out.println("Le client a bien ete supprimer");
                System.out.println("-------------------------------");
            }else {
                System.out.println("Client non trouver, suppression impossible");
                System.out.println("---------------------------------------------");
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
     * @param clientId
     * @param numero
     * @param nom
     * @param prenom
     * @param email
     * @param adresse
     * @return
     * @throws SQLException
     */
    public String updateClient(int clientId,int numero, String nom, String prenom, String email,String adresse) throws SQLException {
        String message=null;
        try(Connection conn= ConnectionBdd.connection()) {
            PreparedStatement ps=conn.prepareStatement("UPDATE client SET numero=?, nom=?, prenom=?, email=?, adresse=? WHERE client_id=?;");
            ps.setInt(1,numero);
            ps.setString(2,nom);
            ps.setString(3,prenom);
            ps.setString(4,email);
            ps.setString(5,adresse);
            ps.setInt(6,clientId);
            //either (1) the row count for SQL Data Manipulation Language (DML) statements or (2) 0 for SQL statements that return nothing
            int x=ps.executeUpdate();
            if(x > 0) {
                System.out.println("Le client a bien ete modifier");
                System.out.println("-------------------------------");
            }else {
                System.out.println("Modification impossible, client non trouver");
                System.out.println("--------------------------------------------");
            }
        }catch(SQLException e) {
            //1062 = code erreur pour une violation de contrainte d'unicite
            if (e.getErrorCode() == 1062) {
                System.out.println("Impossible de modifier le client en utilisant le numero : '" + numero + "' => Voilation de contrainte d'unicite");
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
     * @param clientId
     * @return
     * @throws SQLException
     */
    public ClientBean viewClient(int clientId) throws SQLException {
        ClientBean cb = null;
        try(Connection conn= ConnectionBdd.connection()) {
            PreparedStatement ps=conn.prepareStatement("SELECT * FROM client WHERE client_id=?;");
            ps.setInt(1,clientId);
            //a ResultSet object that contains the data produced by the query; never null
            ResultSet rs= ps.executeQuery();
            if(rs.next()) {
                int id=rs.getInt("client_id");
                int numero=rs.getInt("numero");
                String nom= rs.getString("nom");
                String prenom= rs.getString("prenom");
                String email= rs.getString("email");
                String adresse= rs.getString("adresse");
                cb=new ClientBean(id,numero,nom,prenom,email,adresse);
            }else
                System.out.println("Affichage impossible, client non trouver");
                System.out.println("--------------------------------------------");                           
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println(e.getMessage());
        }
        return cb;
    }	
//	################################################################################

    /**
     *
     * @throws SQLException
     */
    public void viewAllClient() throws SQLException {
        try(Connection conn = ConnectionBdd.connection()) {
            PreparedStatement ps= conn.prepareStatement("select * from client");
            //a ResultSet object that contains the data produced by the query; never null
            ResultSet rs= ps.executeQuery();
            while(rs.next()) {
                int id=rs.getInt("client_id");
                int numero=rs.getInt("numero");
                String nom= rs.getString("nom");
                String prenom= rs.getString("prenom");
                String email= rs.getString("email");
                String adresse= rs.getString("adresse");
                System.out.println("******************************");
                System.out.println("Client Id: " + id);
                System.out.println("Numero: " + numero);
                System.out.println("Nom: " + nom);
                System.out.println("Prenom: " + prenom);
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
