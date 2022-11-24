public class ingredient {

    private int id;
    private String nom;
    private unite_ingrédient unite;
    private Float quantite;
    private double prix;

    public ingredient(int id, String nom, unite_ingrédient unite, Float quantite, double prix) {
        this.id = id;
        this.nom = nom;
        this.unite = unite;
        this.quantite = quantite;
        this.prix = prix;
    }

    public String toString() {
        return "Ingredient [id=" + id + ", nom=" + nom + ", unite=" + unite + ", quantite=" + quantite + ", prix="
                + prix + "]";
    }

    /**
     * @return int return the id
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
     * @return String return the nom
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
     * @return unite return the unite
     */
    public unite_ingrédient getUnite() {
        return unite;
    }

    /**
     * @param unite the unite to set
     */
    public void setUnite(unite_ingrédient unite) {
        this.unite = unite;
    }

    /**
     * @return Float return the quantite
     */
    public Float getQuantite() {
        return quantite;
    }

    /**
     * @param quantite the quantite to set
     */
    public void setQuantite(Float quantite) {
        this.quantite = quantite;
    }

    /**
     * @return double return the prix
     */
    public double getPrix() {
        return prix;
    }

    /**
     * @param prix the prix to set
     */
    public void setPrix(double prix) {
        this.prix = prix;
    }

}
