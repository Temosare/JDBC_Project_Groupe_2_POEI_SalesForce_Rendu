/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package outilMenu;

/**
 *
 * @author Temosare
 */
public final class DataMenu {
    private boolean choiceContinueSwitch = true;
    private int choiceSubSwitch = 0;
    private int id;
    private int numero;
    private boolean notValid = true;
    private String nom;
    private String prenom;
    private String email;
    private String login;
    private String password;
    private String adresse;
    private String description;
    private boolean buyOrSell = true;
    private int choiceBuyOrSell;
    
    public DataMenu(){
        super();
    }
    
    /*Pour changer au besoin les valeurs de base de chaque menu*/
    public DataMenu(TypeTable typeTable){        
        switch(typeTable){
            case TypeTable.CLIENT -> {
                this.setChoiceContinueSwitch(choiceContinueSwitch);
                this.setChoiceSubSwitch(choiceSubSwitch);
                this.setId(id);
                this.setNumero(numero);
                this.setNotValid(notValid);
                this.setNom(nom);
                this.setPrenom(prenom);
                this.setEmail(email);
                this.setLogin(login);
                this.setPassword(password);
            }
            case TypeTable.UTILISATEUR -> {
                this.setChoiceContinueSwitch(choiceContinueSwitch);
                this.setChoiceSubSwitch(choiceSubSwitch);
                this.setId(id);
                this.setNumero(numero);
                this.setNotValid(notValid);
                this.setNom(nom);
                this.setPrenom(prenom);
                this.setEmail(email);
                this.setAdresse(adresse);
            }
            case TypeTable.FOURNISSEUR -> {
                this.setChoiceContinueSwitch(choiceContinueSwitch);
                this.setChoiceSubSwitch(choiceSubSwitch);
                this.setId(id);
                this.setNumero(numero);
                this.setNotValid(notValid);
                this.setNom(nom);
                this.setEmail(email);
                this.setAdresse(adresse);
            }
            case TypeTable.ARTICLE -> {
                this.setChoiceContinueSwitch(choiceContinueSwitch);
                this.setChoiceSubSwitch(choiceSubSwitch);
                this.setId(id);
                this.setNumero(numero);
                this.setNotValid(notValid);
                this.setNom(nom);
                this.setDescription(description);
                this.setBuyOrSell(buyOrSell);
                this.setChoiceBuyOrSell(choiceBuyOrSell);
            }
            default -> System.out.println("Type non reconu");        
        }
    }
    
    /**
     * @return the choiceGeneralSwitch
     */
    public boolean isChoiceContinueSwitch() {
        return choiceContinueSwitch;
    }

    /**
     * @param choiceContinueSwitch the choiceGeneralSwitch to set
     */
    public void setChoiceContinueSwitch(boolean choiceContinueSwitch) {
        this.choiceContinueSwitch = choiceContinueSwitch;
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
     * @return the notValidNumero
     */
    public boolean isNotValid() {
        return notValid;
    }

    /**
     * @param notValid the notValidNumero to set
     */
    public void setNotValid(boolean notValid) {
        this.notValid = notValid;
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
     * @return the choiceBuyOrSell
     */
    public int getChoiceBuyOrSell() {
        return choiceBuyOrSell;
    }

    /**
     * @param choiceBuyOrSell the choiceBuyOrSell to set
     */
    public void setChoiceBuyOrSell(int choiceBuyOrSell) {
        this.choiceBuyOrSell = choiceBuyOrSell;
    }

    /**
     * @return the choiceSubSwitch
     */
    public int getChoiceSubSwitch() {
        return choiceSubSwitch;
    }

    /**
     * @param choiceSubSwitch the choiceSubSwitch to set
     */
    public void setChoiceSubSwitch(int choiceSubSwitch) {
        this.choiceSubSwitch = choiceSubSwitch;
    }
    
}
