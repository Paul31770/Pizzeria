import java.util.List;

public class Pizza {
    private int id;
    private String nom;
    private taille_pizza taille;
    private double prix;
    private List<ingredient> ingredients;

    private IPizzaService service = new pizzaService();

    public Pizza(int id, String nom, taille_pizza taille, double prix) {
        this.id = id;
        this.nom = nom;
        this.taille = taille;
        this.prix = prix;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public taille_pizza getTaille() {
        return taille;
    }

    public double getPrix() {
        return prix;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setTaille(taille_pizza taille) {
        this.taille = taille;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String toString() {
        return "Pizza [id=" + id + ", nom=" + nom + ", taille=" + taille + ", prix=" + prix + "]";
    }

}