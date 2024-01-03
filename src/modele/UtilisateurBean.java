/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modele;

/**
 *
 * @author steve
 * * La table Utilisateurs correpond aux utilisateurs du programme dans une entreprise.
 * Les Utilisateurs ont un id, un numero d'employ� unique, un nom, un prenom, un email
 * un login et un mot de passe.
 */
public final class UtilisateurBean {
    private int id;
    private int numeroEmp;
    private String nom;
    private String prenom;
    private String email;
    private String login;
    private String password;
	
    public UtilisateurBean() {
        super();
    }

    public UtilisateurBean(int id,int numeroEmp,String nom,String prenom,String email,String login,String password) {
        this.setId(id);
        this.setNumeroEmp(numeroEmp);
        this.setNom(nom);
        this.setPrenom(prenom);
        this.setEmail(email);
        this.setLogin(login);
        this.setPassword(password);
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
     * @return the numeroEmp
     */
    public int getNumeroEmp() {
        return numeroEmp;
    }

    /**
     * @param numeroEmp the numeroEmp to set
     */
    public void setNumeroEmp(int numeroEmp) {
        this.numeroEmp = numeroEmp;
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
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    @Override
    public String toString() {
        return "UtilisateurBean [id=" + this.getId() + ", numeroEmp=" + this.getNumeroEmp()+ ", nom=" + this.getNom() + 
                ", prenom=" + this.getPrenom() + ", email=" + this.getEmail() +
                ", login=" + this.getLogin()+ ", password=" + this.getPassword()+ "]";
    }
}
