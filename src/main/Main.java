/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import doa.ArticleDao;
import doa.ClientDao;
import doa.CreationCheckBdd;
import doa.FournisseurDao;
import doa.UtilisateurDao;
import java.sql.SQLException;
import java.util.Scanner;
import modele.ArticleBean;
import modele.ClientBean;
import outilMenu.DataMenu;
import modele.FournisseurBean;
import modele.UtilisateurBean;
import outilMenu.TypeTable;

/**
 * 
 * 
 * @author Temosare, mathys, steve, thibaut
 */
public class Main {
    public static void main(String[] args) {
        try{
            CreationCheckBdd.CreationAndCheck();
        }
        catch(Exception e){
            System.out.println("---------------------------------------------------------------------------------");
            System.out.println("Connection a la BDD impossible, lancer le serveur MySQL et relancer l'application");
            System.out.println("Erreur : " +e);        
            System.out.println("---------------------------------------------------------------------------------");
            System.exit(0);
        }
        Scanner sc = new Scanner(System.in);
        boolean startProg = true;
        DataMenu dataMenu;
        while(startProg) {
            boolean tableChoice = true;
            System.out.println("*********************************************");
            System.out.println("Bienvenue sur la gestion de la base de donnee");
            System.out.println("*********************************************"); 
            System.out.println("""
                               1. Gestion des tables 
                               2. Quitter l'application 
                               """);
            System.out.println("Veuillez choisir une option");
            int choice;
            try{
                choice=sc.nextInt();
            }
            catch(Exception e){
                System.out.println("Option incorecte");
                System.out.println("---------------------------");
                choice=0;
                sc.next();
            }
            while(tableChoice){
                switch(choice) {
                    case 1 -> {
                        System.out.println("CHOIX DE LA TABLE");
                        System.out.println("--------------------------");
                        System.out.println("""
                                            1. Table UTILISATEUR
                                            2. Table CLIENT
                                            3. Table FOURNISSEUR
                                            4. Table ARTICLE
                                            5. Quitter l'application
                                            """);
                        System.out.println("Veuillez choisir une option");
                        int choiceTable;
                        try{
                            choiceTable=sc.nextInt();
                        }
                        catch(Exception e){
                            System.out.println("Option incorecte");
                            System.out.println("---------------------------");
                            choiceTable=0;
                            sc.next();
                        }
                        switch(choiceTable){
                            case 1 -> {
                                dataMenu = new DataMenu(TypeTable.UTILISATEUR);
                                UtilisateurDao user= new UtilisateurDao();
                                while(dataMenu.isChoiceContinueSwitch()){
                                    System.out.println("GESTION UTILISATEUR");
                                    System.out.println("-------------------------------");
                                    System.out.println(""" 
                                                       1. Voir tous les utilisateurs 
                                                       2. Voir un utilisateur particulier 
                                                       3. Ajouter un utilisateur 
                                                       4. Modifier un utilisateur 
                                                       5. Supprimer un utilisateur 
                                                       6. Quitter la gestion utilisateur 
                                                       """);
                                    System.out.println("Veuillez choisir une option");
                                    try{
                                        dataMenu.setChoiceSubSwitch(sc.nextInt());
                                    }
                                    catch(Exception e){
                                        System.out.println("Option incorecte");
                                        System.out.println("---------------------------");
                                        sc.next();
                                    }
                                    switch(dataMenu.getChoiceSubSwitch()){
                                        case 1 -> {
                                            try {
                                                System.out.println("-------ALL UTILISATEUR DETAILS------");
                                                user.viewAllUtilisateur();	
                                            } catch (SQLException e) {
                                                System.out.println(e);
                                            }
                                        }
                                        case 2 -> {
                                            System.out.println("--------UTILISATEUR DETAILS---------");
                                            System.out.println("Entrer un id utilisateur ");
                                            dataMenu.setId(0);
                                            try{
                                                dataMenu.setId(sc.nextInt());
                                            }
                                            catch(Exception e){
                                                System.out.println("Option incorecte");
                                                System.out.println("---------------------------");
                                                sc.next();
                                            }                				
                                            try {
                                                UtilisateurBean mes =  user.viewUtilisateur(dataMenu.getId());
                                                if(mes!=null) {
                                                    System.out.println("******************************");
                                                    System.out.println("Utilisateur Id: " + mes.getId());
                                                    System.out.println("Numero: " + mes.getNumeroEmp());
                                                    System.out.println("Nom: " + mes.getNom());
                                                    System.out.println("Prenom: " + mes.getPrenom());
                                                    System.out.println("Email: " + mes.getEmail());
                                                    System.out.println("Login: " + mes.getLogin());
                                                    System.out.println("Password: " + mes.getPassword());
                                                    System.out.println("******************************");	
                                                }else {
                                                    System.out.println("L'utilisateur n'existe pas");
                                                    System.out.println("---------------------------");
                                                }
                                                
                                            } catch (SQLException e) {
                                                System.out.println(e);
                                            }
                                        }
                                        case 3 -> {
                                            System.out.println("---------AJOUTER UN UTILISATEUR----------");
                                            System.out.println("Entrer numero employe: ");
                                            dataMenu.setNotValid(true);
                                            dataMenu.setNumero(0);
                                            while(dataMenu.isNotValid()){
                                                try{
                                                    dataMenu.setNumero(sc.nextInt());
                                                    dataMenu.setNotValid(false);
                                                }catch (Exception e) {
                                                    System.out.println("Saisi incorecte, chosir un nombre");
                                                    System.out.println("----------------------------------");
                                                    sc.next();
                                                }                           
                                            }
                                            System.out.println("Entrer nom: ");
                                            dataMenu.setNom(sc.next());  
                                            System.out.println("Entrer prenom:");
                                            dataMenu.setPrenom(sc.next()); 
                                            System.out.println("Entrer email: ");
                                            dataMenu.setEmail(sc.next()); 
                                            System.out.println("Entrer login: ");
                                            dataMenu.setLogin(sc.next()); 
                                            System.out.println("Entrer password: ");
                                            dataMenu.setPassword(sc.next()); 
                                            try {
                                                user.addUtilisateur(dataMenu.getNumero(), dataMenu.getNom(),
                                                        dataMenu.getPrenom(), dataMenu.getEmail(), dataMenu.getLogin(), dataMenu.getPassword());
                                            } catch (SQLException e) {
                                                System.out.println(e);
                                            }
                                        }
                                        case 4 -> {
                                            System.out.println("-------MODIFIER UN UTILISATEUR-------");
                                            System.out.println("Entrer un id utilisateur ");
                                            dataMenu.setId(0);
                                            try{
                                                dataMenu.setId(sc.nextInt());
                                            }
                                            catch(Exception e){
                                                System.out.println("Option incorecte");
                                                System.out.println("---------------------------");
                                                sc.next();
                                            }                
                                            try {
                                                UtilisateurBean findUser = user.viewUtilisateur(dataMenu.getId());
                                                if(findUser!=null) {
                                                    System.out.println("Entrer numero employe: ");
                                                    dataMenu.setNotValid(true);
                                                    dataMenu.setNumero(0);
                                                    while(dataMenu.isNotValid()){
                                                        try{
                                                            dataMenu.setNumero(sc.nextInt());
                                                            dataMenu.setNotValid(false);
                                                        }catch (Exception e) {
                                                            System.out.println("Saisi incorecte, chosir un nombre");
                                                            System.out.println("----------------------------------");
                                                            sc.next();
                                                        }                           
                                                    }
                                                    System.out.println("Entrer nom: ");
                                                    dataMenu.setNom(sc.next());
                                                    System.out.println("Entrer prenom:");
                                                    dataMenu.setPrenom(sc.next());
                                                    System.out.println("Entrer email: ");
                                                    dataMenu.setEmail(sc.next());
                                                    System.out.println("Entrer login: ");
                                                    dataMenu.setLogin(sc.next());
                                                    System.out.println("Entrer password: ");
                                                    dataMenu.setPassword(sc.next());
                                                    try {
                                                        user.updateUtilisateur(dataMenu.getId(),dataMenu.getNumero(), dataMenu.getNom(),
                                                                dataMenu.getPrenom(), dataMenu.getEmail(), dataMenu.getLogin(), dataMenu.getPassword());
                                                    } catch (SQLException e) {
                                                        System.out.println(e);
                                                    }
                                                }else {
                                                    System.out.println("L'utilisateur n'existe pas");
                                                    System.out.println("---------------------------");
                                                }
                                            } catch (SQLException e) {
                                                System.out.println(e);
                                            }
                                        }
                                        case 5 -> {
                                            System.out.println("-------SUPPRIMER UN UTILISATEUR-------");
                                            System.out.println("Entrer un id utilisateur ");
                                            dataMenu.setId(0);
                                            try{
                                                dataMenu.setId(sc.nextInt());
                                            }
                                            catch(Exception e){
                                                System.out.println("Option incorecte");
                                                System.out.println("---------------------------");
                                                sc.next();
                                            }                
                                            try {
                                                user.deleteUtilisateur(dataMenu.getId());   
                                            } catch (SQLException e) {
                                                System.out.println(e);
                                            }
                                        }
                                        case 6 -> dataMenu.setChoiceContinueSwitch(false);
                                        default -> {
                                            System.out.println("Option incorecte");
                                            System.out.println("---------------------------");
                                            sc.next();
                                        }
                                    }   
                                }
                            }
                            case 2 -> {
                                dataMenu = new DataMenu(TypeTable.CLIENT);
                                ClientDao client= new ClientDao();
                                while(dataMenu.isChoiceContinueSwitch()){
                                    System.out.println("GESTION CLIENT");
                                    System.out.println("-------------------------------");
                                    System.out.println("""
                                                        1. Voir tous les client
                                                        2. Voir un client particulier
                                                        3. Ajouter un client
                                                        4. Modifier un client
                                                        5. Supprimer un client
                                                        6. Quitter la gestion utilisateur
                                                        """);
                                    System.out.println("Veuillez choisir une option");
                                    try{                                        
                                        dataMenu.setChoiceSubSwitch(sc.nextInt());
                                    }
                                    catch(Exception e){
                                        System.out.println("Option incorecte");
                                        System.out.println("---------------------------");
                                        sc.next();
                                    }
                                    switch(dataMenu.getChoiceSubSwitch()){
                                        case 1 -> {
                                            try {
                                                System.out.println("-------ALL CLIENT DETAILS------");
                                                client.viewAllClient();
                                            } catch (SQLException e) {
                                                System.out.println(e);
                                            }
                                        }
                                        case 2 -> {
                                            System.out.println("--------CLIENT DETAILS---------");
                                            System.out.println("Entrer un id client ");
                                            dataMenu.setId(0);
                                            try{
                                                dataMenu.setId(sc.nextInt());
                                            }
                                            catch(Exception e){
                                                System.out.println("Option incorecte");
                                                System.out.println("---------------------------");
                                                sc.next();
                                            }                				
                                            try {
                                                ClientBean mes =  client.viewClient(dataMenu.getId());
                                                if(mes!=null) {
                                                    System.out.println("******************************");
                                                    System.out.println("Client Id: " + mes.getId());
                                                    System.out.println("Numero: " + mes.getNumero());
                                                    System.out.println("Nom: " + mes.getNom());
                                                    System.out.println("Prenom: " + mes.getPrenom());
                                                    System.out.println("Email: " + mes.getEmail());
                                                    System.out.println("Adresse: " + mes.getAdresse());
                                                    System.out.println("******************************");	
                                                }else {
                                                    System.out.println("Le client n'existe pas");
                                                    System.out.println("---------------------------");
                                                }
                                            } catch (SQLException e) {
                                                System.out.println(e);
                                            }
                                        }
                                        case 3 -> {
                                            System.out.println("---------AJOUTER UN CLIENT----------");
                                            System.out.println("Entrer numero client: ");
                                            dataMenu.setNotValid(true);
                                            dataMenu.setNumero(0);
                                            while(dataMenu.isNotValid()){
                                                try{
                                                    dataMenu.setNumero(sc.nextInt());
                                                    dataMenu.setNotValid(false);
                                                }catch (Exception e) {
                                                    System.out.println("Saisi incorecte, chosir un nombre");
                                                    System.out.println("----------------------------------");
                                                    sc.next();
                                                }                           
                                            }
                                            System.out.println("Entrer nom: ");
                                            dataMenu.setNom(sc.next()); 
                                            System.out.println("Entrer prenom:");
                                            dataMenu.setPrenom(sc.next());
                                            System.out.println("Entrer email: ");
                                            dataMenu.setEmail(sc.next());
                                            System.out.println("Entrer adresse: ");
                                            dataMenu.setAdresse(sc.next());
                                            try {
                                                client.addClient(dataMenu.getNumero(), dataMenu.getNom(), dataMenu.getPrenom(), dataMenu.getEmail(), dataMenu.getAdresse());
                                            } catch (SQLException e) {
                                                System.out.println(e);
                                            }
                                        }
                                        case 4 -> {
                                            System.out.println("-------MODIFIER UN CLIENT-------");
                                            System.out.println("Entrer un id client ");
                                            dataMenu.setId(0);
                                            try{
                                                dataMenu.setId(sc.nextInt());
                                            }
                                            catch(Exception e){
                                                System.out.println("Option incorecte");
                                                System.out.println("---------------------------");
                                                sc.next();
                                            }                
                                            try {
                                                ClientBean findClient = client.viewClient(dataMenu.getId());
                                                if(findClient!=null) {
                                                    System.out.println("Entrer numero client: ");
                                                    dataMenu.setNotValid(true);
                                                    dataMenu.setNumero(0);
                                                    while(dataMenu.isNotValid()){
                                                        try{
                                                            dataMenu.setNumero(sc.nextInt());
                                                            dataMenu.setNotValid(false);
                                                        }catch (Exception e) {
                                                            System.out.println("Saisi incorecte, chosir un nombre");
                                                            System.out.println("----------------------------------");
                                                            sc.next();
                                                        }                           
                                                    }
                                                    System.out.println("Entrer nom: ");
                                                    dataMenu.setNom(sc.next()); 
                                                    System.out.println("Entrer prenom:");
                                                    dataMenu.setPrenom(sc.next());
                                                    System.out.println("Entrer email: ");
                                                    dataMenu.setEmail(sc.next());
                                                    System.out.println("Entrer adresse: ");
                                                    dataMenu.setAdresse(sc.next());
                                                    try {
                                                        client.updateClient(dataMenu.getId(),dataMenu.getNumero(),
                                                                dataMenu.getNom(), dataMenu.getPrenom(), dataMenu.getEmail(), dataMenu.getAdresse());
                                                    } catch (SQLException e) {
                                                        System.out.println(e);
                                                    }
                                                }else {
                                                    System.out.println("Le client n'existe pas");
                                                    System.out.println("---------------------------");
                                                }
                                            } catch (SQLException e) {
                                                System.out.println(e);
                                            }
                                        }
                                        case 5 -> {
                                            System.out.println("-------SUPPRIMER UN CLIENT-------");
                                            System.out.println("Entrer un id client ");
                                            dataMenu.setId(0);
                                            try{
                                                dataMenu.setId(sc.nextInt());
                                            }
                                            catch(Exception e){
                                                System.out.println("Option incorecte");
                                                System.out.println("---------------------------");
                                                sc.next();
                                            }                
                                            try {
                                                client.deleteClient(dataMenu.getId());   
                                            } catch (SQLException e) {
                                                System.out.println(e);
                                            }
                                        }
                                        case 6 -> dataMenu.setChoiceContinueSwitch(false);
                                        default -> {
                                            System.out.println("Option incorecte");
                                            System.out.println("---------------------------");
                                            sc.next();
                                        }
                                    }   
                                }
                            }
                            case 3 -> {
                                dataMenu = new DataMenu(TypeTable.FOURNISSEUR); 
                                FournisseurDao fournisseur= new FournisseurDao();   
                                while(dataMenu.isChoiceContinueSwitch()){
                                    System.out.println("GESTION FOURNISSEUR");
                                    System.out.println("-------------------------------");
                                    System.out.println("""
                                                        1. Voir tous les fournisseur
                                                        2. Voir un fournisseur particulier
                                                        3. Ajouter un fournisseur
                                                        4. Modifier un fournisseur
                                                        5. Supprimer un fournisseur
                                                        6. Quitter la gestion fournisseur
                                                        """);
                                    System.out.println("Veuillez choisir une option");
                                    try{
                                        dataMenu.setChoiceSubSwitch(sc.nextInt());
                                    }
                                    catch(Exception e){
                                        System.out.println("Option incorecte");
                                        System.out.println("---------------------------");
                                        sc.next();
                                    }
                                    switch(dataMenu.getChoiceSubSwitch()){
                                        case 1 -> {
                                            try {
                                                System.out.println("-------ALL FOURNISSEUR DETAILS------");
                                                fournisseur.viewAllFournisseur();
                                            } catch (SQLException e) {
                                                System.out.println(e);
                                            }
                                        }
                                        case 2 -> {
                                            System.out.println("--------FOURNISSEUR DETAILS---------");
                                            System.out.println("Entrer un id fournisseur ");
                                            dataMenu.setId(0);
                                            try{
                                                dataMenu.setId(sc.nextInt());
                                            }
                                            catch(Exception e){
                                                System.out.println("Option incorecte");
                                                System.out.println("---------------------------");
                                                sc.next();
                                            }
                                            try {
                                                FournisseurBean mes =  fournisseur.viewFournisseur(dataMenu.getId());
                                                if(mes!=null) {
                                                    System.out.println("******************************");
                                                    System.out.println("Fournisseur Id: " + mes.getId());
                                                    System.out.println("Numero: " + mes.getNumero());
                                                    System.out.println("Nom: " + mes.getNom());
                                                    System.out.println("Email: " + mes.getEmail());
                                                    System.out.println("Adresse: " + mes.getAdresse());
                                                    System.out.println("******************************");
                                                }else {
                                                    System.out.println("Le fournisseur n'existe pas");
                                                    System.out.println("---------------------------");
                                                }
                                            } catch (SQLException e) {
                                                System.out.println(e);
                                            }
                                        }
                                        case 3 -> {
                                            System.out.println("---------AJOUTER UN FOURNISSEUR----------");
                                            System.out.println("Entrer numero fournisseur: ");
                                            dataMenu.setNotValid(true);
                                            dataMenu.setNumero(0);
                                            while(dataMenu.isNotValid()){
                                                try{
                                                    dataMenu.setNumero(sc.nextInt());
                                                    dataMenu.setNotValid(false);
                                                }catch (Exception e) {
                                                    System.out.println("Saisi incorecte, chosir un nombre");
                                                    System.out.println("----------------------------------");                                              
                                                    sc.next();
                                                }
                                            }
                                            System.out.println("Entrer nom: ");
                                            dataMenu.setNom(sc.next());
                                            System.out.println("Entrer email: ");
                                            dataMenu.setEmail(sc.next());
                                            System.out.println("Entrer adresse: ");
                                            dataMenu.setAdresse(sc.next());
                                            try {
                                                fournisseur.addFournisseur(dataMenu.getNumero(), dataMenu.getNom(), dataMenu.getEmail(), dataMenu.getAdresse());
                                            } catch (SQLException e) {
                                                System.out.println(e);
                                            }
                                        }
                                        case 4 -> {
                                            System.out.println("-------MODIFIER UN FOURNISSEUR-------");
                                            System.out.println("Entrer un id fournisseur ");
                                            dataMenu.setId(0);
                                            try{
                                                dataMenu.setId(sc.nextInt());
                                            }
                                            catch(Exception e){
                                                System.out.println("Option incorecte");
                                                System.out.println("---------------------------");
                                                sc.next();
                                            }
                                            try {
                                                FournisseurBean findFournisseur = fournisseur.viewFournisseur(dataMenu.getId());
                                                if(findFournisseur!=null) {
                                                    System.out.println("Entrer numero fournisseur: ");
                                                    dataMenu.setNotValid(true);
                                                    dataMenu.setNumero(0);
                                                    while(dataMenu.isNotValid()){
                                                        try{
                                                            dataMenu.setNumero(sc.nextInt());
                                                            dataMenu.setNotValid(false);
                                                        }catch (Exception e) {
                                                            System.out.println("Saisi incorecte, chosir un nombre");
                                                            System.out.println("-----------------------------------");
                                                            sc.next();                           
                                                        }
                                                    }
                                                    System.out.println("Entrer nom: ");
                                                    dataMenu.setNom(sc.next());
                                                    System.out.println("Entrer email: ");
                                                    dataMenu.setEmail(sc.next());
                                                    System.out.println("Entrer adresse: ");
                                                    dataMenu.setAdresse(sc.next());
                                                    try {
                                                        fournisseur.updateFournisseur(dataMenu.getId(),dataMenu.getNumero(),
                                                                dataMenu.getNom(), dataMenu.getEmail(), dataMenu.getAdresse());
                                                    } catch (SQLException e) {
                                                        System.out.println(e);
                                                    }
                                                }else {
                                                    System.out.println("Le fournisseur n'existe pas");
                                                    System.out.println("---------------------------");
                                                }
                                            } catch (SQLException e) {
                                                System.out.println(e);
                                            }
                                        }
                                        case 5 -> {
                                            System.out.println("-------SUPPRIMER UN FOURNISSEUR-------");
                                            System.out.println("Entrer un id fournisseur ");
                                            dataMenu.setId(0);
                                            try{
                                                dataMenu.setId(sc.nextInt());
                                            }
                                            catch(Exception e){
                                                System.out.println("Option incorecte");
                                                System.out.println("---------------------------");
                                                sc.next();
                                            }
                                            try {   
                                                fournisseur.deleteFournisseur(dataMenu.getId());
                                            } catch (SQLException e) {
                                                System.out.println(e);
                                            }
                                        }
                                        case 6 -> dataMenu.setChoiceContinueSwitch(false);
                                        default -> {
                                            System.out.println("Option incorecte");
                                            System.out.println("---------------------------");
                                            sc.next();
                                        }
                                    }
                                }
                            }
                            case 4 -> {
                                dataMenu = new DataMenu(TypeTable.ARTICLE);
                                ArticleDao article= new ArticleDao();
                                while(dataMenu.isChoiceContinueSwitch()){
                                    System.out.println("GESTION ARTICLE");
                                    System.out.println("-------------------------------");
                                    System.out.println("""
                                                        1. Voir tous les article
                                                        2. Voir un article particulier
                                                        3. Ajouter un article
                                                        4. Modifier un article
                                                        5. Supprimer un article
                                                        6. Quitter la gestion article
                                                        """);
                                    System.out.println("Veuillez choisir une option");
                                    try{
                                        dataMenu.setChoiceSubSwitch(sc.nextInt());
                                    }
                                    catch(Exception e){
                                        System.out.println("Option incorecte");
                                        System.out.println("---------------------------");
                                        sc.next();
                                    }
                                    switch(dataMenu.getChoiceSubSwitch()){
                                        case 1 -> {
                                            try {
                                                System.out.println("-------ALL ARTICLE DETAILS------");
                                                article.viewAllArticle();
                                            } catch (SQLException e) {
                                                System.out.println(e);
                                            }
                                        }
                                        case 2 -> {
                                            System.out.println("--------ARTICLE DETAILS---------");
                                            System.out.println("Entrer un id article ");
                                            dataMenu.setId(0);
                                            try{
                                                dataMenu.setId(sc.nextInt());
                                            }
                                            catch(Exception e){
                                                System.out.println("Option incorecte");
                                                System.out.println("---------------------------");
                                                sc.next();
                                            }                				
                                            try {
                                                ArticleBean mes =  article.viewArticle(dataMenu.getId());
                                                if(mes!=null) {
                                                    System.out.println("******************************");
                                                    System.out.println("Fournisseur Id: " + mes.getId());
                                                    System.out.println("Numero: " + mes.getNumero());
                                                    System.out.println("Acheter ou vendu: " + mes.isBuyOrSell());
                                                    System.out.println("Nom: " + mes.getNom());
                                                    System.out.println("Description: " + mes.getDescription());
                                                    System.out.println("******************************");	
                                                }else {
                                                    System.out.println("L'article n'existe pas");
                                                    System.out.println("---------------------------");
                                                }
                                            } catch (SQLException e) {
                                                System.out.println(e);
                                            }
                                        }
                                        case 3 -> {
                                            System.out.println("---------AJOUTER UN ARTICLE----------");
                                            System.out.println("Entrer numero article: ");
                                            dataMenu.setNotValid(true);
                                            dataMenu.setNumero(0);
                                            while(dataMenu.isNotValid()){
                                                try{
                                                    dataMenu.setNumero(sc.nextInt());
                                                    dataMenu.setNotValid(false);
                                                }catch (Exception e) {
                                                    System.out.println("Saisi incorecte, chosir un nombre");
                                                    System.out.println("-----------------------------------");
                                                    sc.next();
                                                }                           
                                            }
                                            System.out.println("Entrer '1' pour acheter ou '2' pour vendu: ");
                                            dataMenu.setNotValid(true);
                                            while(dataMenu.isNotValid()){
                                                try{
                                                    dataMenu.setChoiceBuyOrSell(sc.nextInt());
                                                    switch (dataMenu.getChoiceBuyOrSell()) {
                                                        case 1 -> {
                                                            dataMenu.setNotValid(false);
                                                            dataMenu.setBuyOrSell(true);
                                                        }
                                                        case 2 -> {
                                                            dataMenu.setNotValid(false);
                                                            dataMenu.setBuyOrSell(false);
                                                        }
                                                        default -> {
                                                            System.out.println("Saisi incorecte, chosir un nombre");
                                                            System.out.println("Entrer '1' pour acheter ou '2' pour vendu: ");
                                                            System.out.println("-----------------------------------");
                                                        }
                                                    }
                                                }catch (Exception e) {
                                                    System.out.println("Saisi incorecte, chosir un nombre");
                                                    System.out.println("Entrer '1' pour acheter ou '2' pour vendu: ");
                                                    System.out.println("-----------------------------------");
                                                    sc.next();
                                                }                           
                                            }
                                            System.out.println("Entrer nom: ");
                                            dataMenu.setNom(sc.next());
                                            System.out.println("Entrer description: ");
                                            dataMenu.setDescription(sc.next());
                                            try {
                                                article.addArticle(dataMenu.getNumero(), dataMenu.isBuyOrSell(), dataMenu.getNom(), dataMenu.getDescription());
                                            } catch (SQLException e) {
                                                System.out.println(e);
                                            }
                                        }
                                        case 4 -> {
                                            System.out.println("-------MODIFIER UN ARTICLE-------");
                                            System.out.println("Entrer un id article ");
                                            dataMenu.setId(0);
                                            try{
                                                dataMenu.setId(sc.nextInt());
                                            }
                                            catch(Exception e){
                                                System.out.println("Option incorecte");
                                                System.out.println("---------------------------");
                                                sc.next();
                                            }                
                                            try {
                                                ArticleBean findArticle = article.viewArticle(dataMenu.getId());
                                                if(findArticle!=null) {
                                                    System.out.println("Entrer numero article: ");
                                                    dataMenu.setNotValid(true);
                                                    dataMenu.setNumero(0);
                                                    while(dataMenu.isNotValid()){
                                                        try{
                                                            dataMenu.setNumero(sc.nextInt());
                                                            dataMenu.setNotValid(false);
                                                        }catch (Exception e) {
                                                            System.out.println("Saisi incorecte, chosir un nombre");
                                                            System.out.println("----------------------------------");
                                                            sc.next();
                                                        }                           
                                                    }
                                                    System.out.println("Entrer '1' pour acheter ou '2' pour vendu: ");
                                                    dataMenu.setNotValid(true);
                                                    while(dataMenu.isNotValid()){
                                                        try{
                                                            dataMenu.setChoiceBuyOrSell(sc.nextInt());
                                                            switch (dataMenu.getChoiceBuyOrSell()) {
                                                                case 1 -> {
                                                                    dataMenu.setNotValid(false);
                                                                    dataMenu.setBuyOrSell(true);
                                                                }
                                                                case 2 -> {
                                                                    dataMenu.setNotValid(false);
                                                                    dataMenu.setBuyOrSell(false);
                                                                }
                                                                default -> {
                                                                    System.out.println("Saisi incorecte, chosir un nombre");
                                                                    System.out.println("Entrer '1' pour acheter ou '2' pour vendu: ");
                                                                    System.out.println("-----------------------------------");
                                                                }
                                                            }
                                                        }catch (Exception e) {
                                                            System.out.println("Saisi incorecte, chosir un nombre");
                                                            System.out.println("Entrer '1' pour acheter ou '2' pour vendu: ");
                                                            System.out.println("-----------------------------------");
                                                            sc.next();
                                                        }
                                                    } 
                                                    System.out.println("Entrer nom: ");
                                                    dataMenu.setNom(sc.next());
                                                    System.out.println("Entrer description: ");
                                                    dataMenu.setDescription(sc.next());
                                                    try {
                                                        article.updateArticle(dataMenu.getId(),dataMenu.getNumero(), dataMenu.isBuyOrSell(), dataMenu.getNom(), dataMenu.getDescription());
                                                    } catch (SQLException e) {
                                                        System.out.println(e);
                                                    }
                                                }else {
                                                    System.out.println("L'article n'existe pas");
                                                    System.out.println("---------------------------");
                                                }
                                            } catch (SQLException e) {
                                                System.out.println(e);
                                            }
                                        }
                                        case 5 -> {
                                            System.out.println("-------SUPPRIMER UN ARTICLE-------");
                                            System.out.println("Entrer un id article ");
                                            dataMenu.setId(0);
                                            try{
                                                dataMenu.setId(sc.nextInt());
                                            }
                                            catch(Exception e){
                                                System.out.println("Option incorecte");
                                                System.out.println("---------------------------");
                                                sc.next();
                                            }                
                                            try {
                                                article.deleteArticle(dataMenu.getId());   
                                            } catch (SQLException e) {
                                                System.out.println(e);
                                            }
                                        }
                                        case 6 -> dataMenu.setChoiceContinueSwitch(false);
                                        default -> {
                                            System.out.println("Option incorecte");
                                            System.out.println("---------------------------");
                                            sc.next();
                                        }
                                    }   
                                }
                            }
                            case 5 -> {
                                tableChoice = false;
                                startProg = false;
                            }
                            default -> {
                                System.out.println("Saisi incorecte");
                                System.out.println("---------------------------");
                                sc.next();
                            }
                        }
                    }
                    case 2 -> startProg = false;
                    default -> {
                        System.out.println("Saisi incorecte");
                        System.out.println("---------------------------");
                        tableChoice = false;
                    }
                }
            }
        }
    }
}
                            
                            
                            
                                
                                

                                
                            
                            
                            
                            
                            
                           
                                
                                
                                
                                
                                
                                
                                
                                
                                
                      
