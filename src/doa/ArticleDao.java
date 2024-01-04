/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package doa;
import java.sql.*;
import modele.ArticleBean;

/**
 *
 * @author Temosare
 */
public class ArticleDao {

    /**
     *
     * @param numero
     * @param buyOrSell info sur acheter ou vendu true acheter | false vendu
     * @param nom
     * @param description
     * @return
     * @throws SQLException
     */
    public String addArticle(int numero,boolean buyOrSell, String nom, String description) throws SQLException {
        String message=null;	
        try(Connection conn= ConnectionBdd.connection()) {
            PreparedStatement ps=conn.prepareStatement("insert into article(numero,buy_or_sell,nom,description) values(?,?,?,?)");
            ps.setInt(1,numero);
            ps.setBoolean(2,buyOrSell);
            ps.setString(3,nom);
            ps.setString(4,description);
            //either (1) the row count for SQL Data Manipulation Language (DML) statements or (2) 0 for SQL statements that return nothing
            int x=ps.executeUpdate();
            if(x > 0) {
                System.out.println("L'article a bien ete ajouter");
                System.out.println("-------------------------------");
            }else
                System.out.println("L'insertion n'est pas bonne");
                System.out.println("-------------------------------");
        }catch(SQLException e) {
            //1062 = code erreur pour une violation de contrainte d'unicite
            if (e.getErrorCode() == 1062) {
                System.out.println("Impossible d'ajouter l'article avec le numero : '" + numero + "' => Voilation de contrainte d'unicite");
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
     * @param articleId
     * @return
     * @throws SQLException
     */
    public String deleteArticle(int articleId) throws SQLException {
        String message=null;
        try(Connection conn= ConnectionBdd.connection()) {
            PreparedStatement ps=conn.prepareStatement("delete from article where article_id=?;");
            ps.setInt(1, articleId);
            //either (1) the row count for SQL Data Manipulation Language (DML) statements or (2) 0 for SQL statements that return nothing
            int x=ps.executeUpdate();
            if(x > 0) {
                System.out.println("L'article a bien ete supprimer");
                System.out.println("------------------------------------");
            }else {
                System.out.println("Article non trouver, suppression impossible");
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
     * @param articleId
     * @param numero
     * @param buyOrSell info sur acheter ou vendu true acheter | false vendu
     * @param nom
     * @param description
     * @return
     * @throws SQLException
     */
    public String updateArticle(int articleId,int numero,boolean buyOrSell, String nom, String description) throws SQLException {
        String message=null;
        try(Connection conn= ConnectionBdd.connection()) {
            PreparedStatement ps=conn.prepareStatement("UPDATE article SET numero=?, buy_or_sell=?, nom=?, description=? WHERE article_id=?;");
            ps.setInt(1,numero);
            ps.setBoolean(2,buyOrSell);
            ps.setString(3,nom);
            ps.setString(4,description);
            ps.setInt(5,articleId);
            //either (1) the row count for SQL Data Manipulation Language (DML) statements or (2) 0 for SQL statements that return nothing
            int x=ps.executeUpdate();
            if(x > 0) {
                System.out.println("L'article a bien ete modifier");
                System.out.println("-----------------------------------");
            }else {
                System.out.println("Modification impossible, article non trouver");
                System.out.println("------------------------------------------------");
            }
        }catch(SQLException e) {
            //1062 = code erreur pour une violation de contrainte d'unicite
            if (e.getErrorCode() == 1062) {
                System.out.println("Impossible de modifier l'article en utilisant le numero : '" + numero + "' => Voilation de contrainte d'unicite");
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
     * @param articleId
     * @return
     * @throws SQLException
     */
    public ArticleBean viewArticle(int articleId) throws SQLException {
        ArticleBean ab = null;
        try(Connection conn= ConnectionBdd.connection()) {
            PreparedStatement ps=conn.prepareStatement("SELECT * FROM article WHERE article_id=?;");
            ps.setInt(1,articleId);
            //a ResultSet object that contains the data produced by the query; never null
            ResultSet rs= ps.executeQuery();
            if(rs.next()) {
                int id=rs.getInt("article_id");
                int numero=rs.getInt("numero");
                boolean buyOrSell= rs.getBoolean("buy_or_sell");
                String nom= rs.getString("nom");
                String description= rs.getString("description");
                ab=new ArticleBean(id,numero,buyOrSell,nom,description);
            }else
                System.out.println("Affichage impossible, article non trouver");
                System.out.println("--------------------------------------------");                           
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println(e.getMessage());
        }
        return ab;
    }	
//	################################################################################

    /**
     *
     * @throws SQLException
     */
    public void viewAllArticle() throws SQLException {
        try(Connection conn = ConnectionBdd.connection()) {
            PreparedStatement ps= conn.prepareStatement("select * from article");
            //a ResultSet object that contains the data produced by the query; never null
            ResultSet rs= ps.executeQuery();
            while(rs.next()) {
                int id=rs.getInt("article_id");
                int numero=rs.getInt("numero");
                boolean buyOrSell= rs.getBoolean("buy_or_sell");
                String nom= rs.getString("nom");
                String description= rs.getString("description");
                System.out.println("******************************");
                System.out.println("Fournisseur Id: " + id);
                System.out.println("Numero: " + numero);
                System.out.println("Acheter ou vendu: " + buyOrSell);
                System.out.println("Nom: " + nom);
                System.out.println("Description: " + description);
                System.out.println("******************************");
            }
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println(e.getMessage());
        }
    }
}
