/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modele;

/**
 *
 * @author Temosare
 * La table Article correspond aux articles achet� au fournisseurs et vendu aux clients.
 * Ils ont un id, un numero unique, un champs indiquant si c'est un article acheter ou vendu, un nom, une description.
 */
public final class ArticleBean {
    private int id;
    private int numero;
    private boolean buyOrSell;
    private String nom;
    private String description;
	
    public ArticleBean() {
        super();
    }

    public ArticleBean(int id,int numero,boolean buyOrSell,String nom,String description) {
        this.setId(id);
        this.setNumero(numero);
        this.setBuyOrSell(buyOrSell);
        this.setNom(nom);
        this.setDescription(description);
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
     * @return the buyOrSell
     */
    public boolean isBuyOrSell() {
        return buyOrSell;
    }

    /**
     * @param buyOrSell the buyOrSell to set
     */
    public void setBuyOrSell(boolean buyOrSell) {
        this.buyOrSell = buyOrSell;
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
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
    @Override
    public String toString() {
        return "ArticleBean [id=" + this.getId() + ", numero=" + this.getNumero() + ", buyOrSell=" + this.isBuyOrSell()+ 
                ", nom=" + this.getNom()+ ", description=" + this.getDescription()+ "]";
    }
    
}
