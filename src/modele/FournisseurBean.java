/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modele;

/**
 *
 * @author thibaut
 * * La table Fournisseurs correspond aux fournisseurs de l'entreprise.
 * Ils ont un id, un num�ro unique, un nom, un email et une adresse.
 */
public final class FournisseurBean {
    private int id;
    private int numero;
    private String nom;
    private String email;
    private String adresse;
	
    public FournisseurBean() {
        super();
    }

    public FournisseurBean(int id,int numero,String nom,String email,String adresse) {
        this.setId(id);
        this.setNumero(numero);
        this.setNom(nom);
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
        return "FournisseurBean [id=" + this.getId() + ", numero=" + this.getNumero() +
                ", nom=" + this.getNom() + ", email=" + this.getEmail() + ", adresse=" + this.getAdresse() + "]";
    }
    
}
