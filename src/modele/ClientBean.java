/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modele;

/**
 *
 * @author mathys
 * La table Clients cotiendra les client de l'entreprise. Ils ont un id, un num�ro unique,
 * un nom, un pr�nom, un email et une adresse.
 */
public final class ClientBean {
    private int id;
    private int numero;
    private String nom;
    private String prenom;
    private String email;
    private String adresse;
	
    public ClientBean() {
        super();
    }

    public ClientBean(int id,int numero,String nom,String prenom,String email,String adresse) {
        this.setId(id);
        this.setNumero(numero);
        this.setNom(nom);
        this.setPrenom(prenom);
        this.setEmail(email);
        this.setAdresse(adresse);
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @param prenom the prenom to set
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the adresse
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * @param adresse the adresse to set
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    
    @Override
    public String toString() {
        return "ClientBean [id=" + this.getId() + ", numero=" + this.getNumero() + ", nom=" + this.getNom() + 
                ", prenom=" + this.getPrenom() + ", email=" + this.getEmail() + ", adresse=" + this.getAdresse() + "]";
    }
    
}
