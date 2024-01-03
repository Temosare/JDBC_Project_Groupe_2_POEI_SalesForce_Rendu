/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package doa;

import java.sql.*;

public class CreationCheckBdd {

    public static void CreationAndCheck() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
        String url = "jdbc:mysql://localhost:3306/";
        try {
            conn = DriverManager.getConnection(url, "root", "");
        } catch (SQLException e) {
            System.out.println(e);
        }
        try {
            Statement stmt = conn.createStatement();

            ResultSet res = stmt.executeQuery("SELECT schema_name FROM information_schema.schemata WHERE schema_name = 'jdbcGroupe2';");
            if (res.next()) {
                System.out.println("BDD dejà crée");
            } else {
                System.out.println("Création de la Bdd...");
                stmt.executeUpdate("CREATE database jdbcGroupe2;");
                System.out.println("Bdd créée");
            }
            stmt.executeUpdate("use jdbcGroupe2;");

            res = stmt.executeQuery("SELECT TABLE_NAME FROM information_schema.tables WHERE TABLE_SCHEMA='jdbcGroupe2' AND TABLE_NAME='utilisateur';");
            if (res.next()) {
                System.out.println("Table utilisateur dejà créée");
            } else {
                System.out.println("Création de la table utilisateur...");
                stmt.executeUpdate("""
            CREATE TABLE IF NOT EXISTS utilisateur
            (
                utilisateur_id serial PRIMARY KEY,
                numero_emp     int         not null,
                nom            varchar(50) not null,
                prenom         varchar(50) not null,
                email          varchar(50) not null,
                login          varchar(50) not null,
                password       varchar(50) not null,
                CONSTRAINT UK_numero_emp_utilisateur UNIQUE(numero_emp)                   
            );""");
                System.out.println("Table utilisateur créée");
            }
            try{
                stmt.executeUpdate("INSERT INTO utilisateur (numero_emp, nom, prenom, email, login, password)VALUES (1, 'chirac','bob','chiracbob@exemple.com','bob','boby55');");
                stmt.executeUpdate("INSERT INTO utilisateur (numero_emp, nom, prenom, email, login, password)VALUES (2, 'chirac','marie','chiracmarie@exemple.com','marie','marie55');");
                stmt.executeUpdate("INSERT INTO utilisateur (numero_emp, nom, prenom, email, login, password)VALUES (3, 'chirac','jacque','chiracjacque@exemple.com','jacque','jacque55');");
                System.out.println("Insertion de base utilisateur effectuee");
            }
            catch(SQLException e){
                System.out.println("Insertion utilisateur deja realise");
            }
             
            res = stmt.executeQuery("SELECT TABLE_NAME FROM information_schema.tables WHERE TABLE_SCHEMA='jdbc' AND TABLE_NAME='client';");
            if (res.next()) {
                System.out.println("Table client dejà créée");
            } else {
                System.out.println("Création de la table client...");
                stmt.executeUpdate("""
            create table IF NOT EXISTS client
            (
                client_id serial PRIMARY KEY,
                numero    int         not null,
                nom       varchar(50) not null,
                prenom    varchar(50) not null,
                email     varchar(50) not null,
                adresse   varchar(50) not null,
                CONSTRAINT UK_numero_client UNIQUE(numero)
            );""");
                System.out.println("Table client créée");
            }
            try{
                stmt.executeUpdate("INSERT INTO client (numero, nom, prenom, email, adresse)VALUES (1, 'durant','lorie','durantlorie@exemple.com','30 rue de la dome');");
                stmt.executeUpdate("INSERT INTO client (numero, nom, prenom, email, adresse)VALUES (2, 'durant','jean','durantjean@exemple.com','32 rue de la frage');");
                stmt.executeUpdate("INSERT INTO client (numero, nom, prenom, email, adresse)VALUES (3, 'durant','elias','durantelias@exemple.com','au domaine lorain');");
                System.out.println("Insertion client de base effectuee");
            }
            catch(SQLException e){
                System.out.println("Insertion client deja realise");
            }

            res = stmt.executeQuery("SELECT TABLE_NAME FROM information_schema.tables WHERE TABLE_SCHEMA='jdbc' AND TABLE_NAME='fournisseur';");
            if (res.next()) {
                System.out.println("Table fournisseur dejà créée");
            } else {
                System.out.println("Création de la table fournisseur...");
                stmt.executeUpdate("""
            create table IF NOT EXISTS fournisseur
            (
                fournisseur_id serial PRIMARY KEY,
                numero         int         not null,
                nom            varchar(50) not null,
                email          varchar(50) not null,
                adresse        varchar(50) not null,
                CONSTRAINT UK_numero_fournisseur UNIQUE(numero)
            );""");
                System.out.println("Table fournisseur créée");
            }
            try{
                stmt.executeUpdate("INSERT INTO fournisseur (numero, nom, email, adresse)VALUES (1, 'windows', 'windows@exemple.com','domaine windows 32');");
                stmt.executeUpdate("INSERT INTO fournisseur (numero, nom, email, adresse)VALUES (2, 'ubuntu', 'ubuntu@exemple.com','domaine ubuntu 64');");
                stmt.executeUpdate("INSERT INTO fournisseur (numero, nom, email, adresse)VALUES (3, 'mac', 'mac@exemple.com','domaine mac 128');");
                System.out.println("Insertion fournisseur de base effectuee");
            }
            catch(SQLException e){
                System.out.println("Insertion fournisseur deja realise");
            }

            res = stmt.executeQuery("SELECT TABLE_NAME FROM information_schema.tables WHERE TABLE_SCHEMA='jdbc' AND TABLE_NAME='article';");
            if (res.next()) {
                System.out.println("Table article dejà créée");
            } else {
                System.out.println("Création de la table article...");
                stmt.executeUpdate("""
            create table IF NOT EXISTS article
            (
                article_id  serial PRIMARY KEY,
                numero      int          not null,
                buy_or_sell boolean      not null,
                nom         varchar(50)  not null,
                description varchar(150) not null,
                CONSTRAINT UK_numero_article UNIQUE(numero)
            );""");
                System.out.println("Table article créée");
            }
            try{
                stmt.executeUpdate("INSERT INTO article (numero, buy_or_sell, nom, description)VALUES (1, true, 'roue','roue de mobilette');");
                stmt.executeUpdate("INSERT INTO article (numero, buy_or_sell, nom, description)VALUES (2, false, 'vitre retro','vitre vintage annee 50');");
                stmt.executeUpdate("INSERT INTO article (numero, buy_or_sell, nom, description)VALUES (3, true, 'poubelle n2','grosse poubelle de recyclage');");
                System.out.println("Insertion article de base effectuee");
            }
            catch(SQLException e){
                System.out.println("Insertion article deja realise");
            }

            } catch (SQLException ex) {
            throw new RuntimeException(ex);   
        }
    }

}

