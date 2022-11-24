import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ingredientDAO {
    private String url = "jdbc:sqlserver://localhost:1433;databaseName=PizzaDB";
    private String user = "sa";
    private String password = "Basket17";

    private Statement statement;

    public ingredientDAO() {
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            this.statement = con.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Statement getStatement() {
        return statement;
    }

    public void enregistrementIngredient(ingredient i) {
        String request = "INSERT INTO Ingredients (nom, unite, quantite, prix) VALUES ('" + i.getNom() + "', '"
                + i.getUnite() + "', '" + i.getQuantite() + "', '" + i.getPrix() + "')";
        try {
            statement.executeUpdate(request);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteIngredient(int ID) {
        String request = "DELETE FROM Ingredients WHERE id = " + ID;
        try {
            statement.executeUpdate(request);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateIngredientNom(int id, String nom) {
        String request = "UPDATE Ingredients SET nom = '" + nom + "' WHERE id = " + id;
        try {
            statement.executeUpdate(request);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}