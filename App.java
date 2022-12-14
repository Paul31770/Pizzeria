import java.sql.Statement;
import java.util.Scanner;
import java.sql.ResultSet;
import java.sql.SQLException;

public class App {
    public static void showPizza(Statement sts) {
        try {
            ResultSet rs = sts.executeQuery("SELECT * FROM Pizzas");
            while (rs.next()) {
                System.out
                        .println(rs.getInt("id") + " | " + rs.getString("nom") + " | " + rs.getString("taille") + " | "
                                + rs.getDouble("prix"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addPizza(Statement sts) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrer le nom de la pizza");
        String nom = sc.nextLine();
        System.out.println("Entrez la taille de la pizza");
        System.out.println("1: Petite");
        System.out.println("2: Moyenne");
        System.out.println("3: Grande");
        int choix = sc.nextInt();
        taille_pizza piz = null;
        switch (choix) {
            case 1:
                piz = taille_pizza.PETITE;
                break;
            case 2:
                piz = taille_pizza.MOYENNE;
                break;
            case 3:
                piz = taille_pizza.GRANDE;
                break;

        }
        System.err.println("Prix de la pizza");
        double prix = sc.nextDouble();

        Pizza pizza = new Pizza(0, nom, piz, prix);
        pizzaDAO dao = new pizzaDAO();
        try {
            dao.enregistrementPizza(pizza);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void showIngredient(Statement sts) {
        try {
            ResultSet rs = sts.executeQuery("SELECT * FROM Ingredients");
            while (rs.next()) {
                System.out
                        .println(rs.getInt("id") + " | " + rs.getString("nom") + " | " + rs.getString("unite") + " | "
                                + rs.getDouble("quantite") + " | " + rs.getDouble("prix"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addIngredient(Statement sts) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrer le nom de l'ingredient");
        String nom = sc.nextLine();
        System.out.println("Entrez l'unit?? de l'ingredient");
        System.out.println("1: Petite");
        System.out.println("2: Moyenne");
        System.out.println("3: Grande");
        int choix = sc.nextInt();
        unite_ingr??dient u = null;
        switch (choix) {
            case 1:
                u = unite_ingr??dient.MILILITRE;
                break;
            case 2:
                u = unite_ingr??dient.GRAMMES;
                break;
            case 3:
                u = unite_ingr??dient.UNITAIRES;
                break;
        }
        System.out.println("Entrez la quantit?? de l'ingredient");
        Float quantite = sc.nextFloat();
        System.out.println("Entrez le prix de l'ingredient");
        Float prix = sc.nextFloat();
        ingredient ingredient = new ingredient(0, nom, u, quantite, prix);
        ingredientDAO dao = new ingredientDAO();
        dao.enregistrementIngredient(ingredient);

    }

    public static void majPizza(Statement sts) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrer l'id de la pizza");
        int id = sc.nextInt();
        System.out.println();
        System.out.println("Que voulez-vous modifier ?");
        System.out.println("1: Le nom");
        System.out.println("2: La taille");
        System.out.println("3: Le prix");
        int choix = sc.nextInt();

        if (choix == 1) {

            System.out.println("Entrer le nouveau nom de la pizza");
            String nom = sc.next();
            pizzaDAO dao = new pizzaDAO();
            dao.updatePizzaNom(id, nom);
        } else if (choix == 2) {

            System.out.println("Entrez la nouvelle taille de la pizza");
            System.out.println("1: Petite");
            System.out.println("2: Moyenne");
            System.out.println("3: Grande");
            int choix2 = sc.nextInt();
            taille_pizza taille = null;
            switch (choix2) {
                case 1:
                    taille = taille_pizza.PETITE;
                    break;
                case 2:
                    taille = taille_pizza.MOYENNE;
                    break;
                case 3:
                    taille = taille_pizza.GRANDE;
                    break;
            }
            pizzaDAO dao = new pizzaDAO();
            dao.updatePizzaTaille(id, taille);

        } else {
            System.err.println("Prix de la pizza");
            double prix = sc.nextDouble();
            pizzaDAO dao = new pizzaDAO();
            dao.updatePizzaPrix(id, prix);

        }

    }

    public static void majIngredient(Statement sts) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrer l'id de l'ingr??dient ?? modifier");
        int id = sc.nextInt();
        System.out.println("Que voulez-vous modifier ?");
        System.out.println("1: Le nom");
        System.out.println("2: L'unit??");
        System.out.println("3: La quantit??");
        System.out.println("3: Le prix");
        int choix = sc.nextInt();
        if (choix == 1) {
            System.out.println(("Entrez le nouveau nom de l'ingr??dients"));
            String nom = sc.next();
            ingredientDAO dao = new ingredientDAO();
            dao.updateIngredientNom(id, nom);

        }

    }

    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);

        pizzaDAO dao = new pizzaDAO();
        Statement sts = dao.getStatement();

        // Pizza p1 = new Pizza(1, "Reine", taille_pizza.MOYENNE, 12.5);
        while (true) {
            System.out.println("-----------------------------");
            System.out.println("Faites votre choix");
            System.out.println("1: Afficher la liste de pizza");
            System.out.println("2: Ajouter une pizza");
            System.out.println("3: Supprimer un pizza ");
            System.out.println("4: Voir les ingr??dients");
            System.out.println("5: Ajouter un ingr??dient");
            System.out.println("6: Supprimer un ingr??dient");
            System.out.println("7: Modifier une pizza");
            System.out.println(("8: Modifier un ingr??dient"));
            System.out.println("-----------------------------");
            int choix = sc.nextInt();
            switch (choix) {
                case 1:
                    showPizza(sts);
                    break;
                case 2:
                    addPizza(sts);
                    break;
                case 3:
                    System.out.println("Entrer l'ID de la pizza ?? supprimer");
                    int id = sc.nextInt();
                    dao.deletePizza(id);
                    break;
                case 4:
                    showIngredient(sts);
                    break;
                case 5:
                    addIngredient(sts);
                    break;
                case 6:
                    System.out.println("Entrer l'ID de l'ingredient ?? supprimer");
                    int id2 = sc.nextInt();
                    ingredientDAO dao2 = new ingredientDAO();
                    dao2.deleteIngredient(id2);
                    break;
                case 7:
                    majPizza(sts);
                    break;
                case 8:
                    majIngredient(sts);
                    break;
            }
        }

    }

}
// while (true) {
// System.out.println("-----------------");
// System.out.println("|1: Pizza |");
// System.out.println("|2: Ingr??dients |");
// System.out.println("-----------------");
// int choix = sc.nextInt();
// switch (choix) {
// case 1:
// System.out.println("---------------------------------");
// System.out.println("| 1: Afficher la liste de pizza |");
// System.out.println("| 2: Ajouter une pizza |");
// System.out.println("| 3: Supprimer un pizza | ");
// System.out.println("| 4: Modifier une pizza |");
// System.out.println("---------------------------------");
// int p = sc.nextInt();
// switch (p) {
// case 1:
// showPizza(sts);
// break;
// case 2:
// addPizza(sts);
// break;
// case 3:
// System.out.println("Entrer l'ID de la pizza ?? supprimer");
// int id = sc.nextInt();
// dao.deletePizza(id);
// break;
// case 4:
// majPizza(sts);
// break;
// }
// break;
// case 2:
// System.out.println("------------------------------");
// System.out.println("| 1: Voir les ingr??dients |");
// System.out.println("| 2: Ajouter un ingr??dient |");
// System.out.println("| 3: Supprimer un ingr??dient |");
// System.out.println("| 4: Modifier un ingr??dient |");
// System.out.println("------------------------------");
// int i = sc.nextInt();
// switch (i) {
// case 1:
// showIngredient(sts);
// break;
// case 2:
// addIngredient(sts);
// break;
// case 3:
// System.out.println("Entrer l'ID de l'ingredient ?? supprimer");
// int id2 = sc.nextInt();
// ingredientDAO dao2 = new ingredientDAO();
// dao2.deleteIngredient(id2);
// break;
// case 4:
// majIngredient(sts);
// break;
// }
// break;

// }

// }
