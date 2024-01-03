/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package doa;
import java.sql.*;
import modele.UtilisateurBean;

/**
 *
 * @author steve
 */
public class UtilisateurDao { 
    /**
     *
     * @param numeroEmp
     * @param nom
     * @param prenom
     * @param email
     * @param login
     * @param password
     * @return
     * @throws SQLException
     */
    public String addUtilisateur(int numeroEmp, String nom, String prenom, String email,String login,String password) throws SQLException {
        String message=null;	
        try(Connection conn= ConnectionBdd.connection()) {
            PreparedStatement ps=conn.prepareStatement("insert into utilisateur(numero_emp,nom,prenom,email,login,password) values(?,?,?,?,?,?)");
            ps.setInt(1,numeroEmp);
            ps.setString(2,nom);
            ps.setString(3,prenom);
            ps.setString(4,email);
            ps.setString(5,login);
            ps.setString(6,password);
            //either (1) the row count for SQL Data Manipulation Language (DML) statements or (2) 0 for SQL statements that return nothing
            int x=ps.executeUpdate();
            if(x > 0) {
                System.out.println("L'utilisateur a bien ete ajouter");
                System.out.println("-------------------------------");
                ps.close();
            }else
                System.out.println("L'insertion n'est pas bonne");
                System.out.println("-------------------------------");
        }catch(SQLException e) {
            //1062 = code erreur pour une violation de contrainte d'unicite
            if (e.getErrorCode() == 1062) {
                System.out.println("Impossible d'ajouter l'utilisateur avec le numero employe : '" + numeroEmp + "' => Voilation de contrainte d'unicite");
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
     * @param utilisateurId
     * @return
     * @throws SQLException
     */
    public String deleteUtilisateur(int utilisateurId) throws SQLException {
        String message=null;
        try(Connection conn= ConnectionBdd.connection()) {
            PreparedStatement ps=conn.prepareStatement("delete from utilisateur where utilisateur_id=?;");
            ps.setInt(1, utilisateurId);
            //either (1) the row count for SQL Data Manipulation Language (DML) statements or (2) 0 for SQL statements that return nothing
            int x=ps.executeUpdate();
            if(x > 0) {
                System.out.println("L'utilisateur a bien ete supprimer");
                System.out.println("-------------------------------");
            }else {
                System.out.println("Utilisateur non trouver, suppression impossible");
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
     * @param utilisateurId
     * @param numeroEmp
     * @param nom
     * @param prenom
     * @param email
     * @param login
     * @param password
     * @return
     * @throws SQLException
     */
    public String updateUtilisateur(int utilisateurId,int numeroEmp, String nom, String prenom, String email,String login,String password) throws SQLException {
        String message=null;
        try(Connection conn= ConnectionBdd.connection()) {
            PreparedStatement ps=conn.prepareStatement("UPDATE utilisateur SET numero_emp=?, nom=?, prenom=?, email=?, login=?, password=? WHERE utilisateur_id=?;");
            ps.setInt(1,numeroEmp);
            ps.setString(2,nom);
            ps.setString(3,prenom);
            ps.setString(4,email);
            ps.setString(5,login);
            ps.setString(6,password);
            ps.setInt(7,utilisateurId);
            //either (1) the row count for SQL Data Manipulation Language (DML) statements or (2) 0 for SQL statements that return nothing
            Integer x=ps.executeUpdate();
            if(x > 0) {
                System.out.println("L'utilisateur a bien ete modifier");
                System.out.println("-------------------------------");
            }else {
                System.out.println("Modification impossible, utilisateur non trouver");
                System.out.println("--------------------------------------------");
            }
        }catch(SQLException e) {
            //1062 = code erreur pour une violation de contrainte d'unicite
            if (e.getErrorCode() == 1062) {
                System.out.println("Impossible de modifier l'utilisateur en utilisant le numero employe : '" + numeroEmp + "' => Voilation de contrainte d'unicite");
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
     * @param utilisateurId
     * @return
     * @throws SQLException
     */
    public UtilisateurBean viewUtilisateur(int utilisateurId) throws SQLException {
        UtilisateurBean ub = null;
        try(Connection conn= ConnectionBdd.connection()) {
            PreparedStatement ps=conn.prepareStatement("SELECT * FROM utilisateur WHERE utilisateur_id=?;");
            ps.setInt(1,utilisateurId);
            //a ResultSet object that contains the data produced by the query; never null
            ResultSet rs= ps.executeQuery();
            if(rs.next()) {
                int id=rs.getInt("utilisateur_id");
                int numeroEmp=rs.getInt("numero_emp");
                String nom= rs.getString("nom");
                String prenom= rs.getString("prenom");
                String email= rs.getString("email");
                String login= rs.getString("login");
                String password= rs.getString("password");
                ub=new UtilisateurBean(id,numeroEmp,nom,prenom,email,login,password);
            }else
                System.out.println("Affichage impossible, utilisateur non trouver");
                System.out.println("--------------------------------------------"); 
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println(e.getMessage());
        }
        return ub;
    }	
//	################################################################################

    /**
     *
     * @throws SQLException
     */
    public void viewAllUtilisateur() throws SQLException {
        try(Connection conn = ConnectionBdd.connection()) {
            PreparedStatement ps= conn.prepareStatement("select * from utilisateur");
            //a ResultSet object that contains the data produced by the query; never null
            ResultSet rs= ps.executeQuery();
            while(rs.next()) {
                int id=rs.getInt("utilisateur_id");
                int numeroEmp=rs.getInt("numero_emp");
                String nom= rs.getString("nom");
                String prenom= rs.getString("prenom");
                String email= rs.getString("email");
                String login= rs.getString("login");
                String password= rs.getString("password");
                System.out.println("******************************");
                System.out.println("Utilisateur Id: " + id);
                System.out.println("Numero: " + numeroEmp);
                System.out.println("Nom: " + nom);
                System.out.println("Prenom: " + prenom);
                System.out.println("Email: " + email);
                System.out.println("Login: " + login);
                System.out.println("Password: " + password);
                System.out.println("******************************");
            }
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println(e.getMessage());
        }
    }
}
