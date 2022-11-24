import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class pizzaDAO {
    private String url = "jdbc:sqlserver://localhost:1433;databaseName=PizzaDB";
    private String user = "sa";
    private String password = "Basket17";

    private Statement statement;

    public pizzaDAO() {
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

    public void enregistrementPizza(Pizza p) throws SQLException {
        String request = "INSERT INTO Pizzas (nom, taille, prix) VALUES ('" + p.getNom() + "', '"
                + p.getTaille().toString()
                + "', '" + p.getPrix() + "')";
        statement.executeUpdate(request);

    }

    public void deletePizza(int ID) {
        String request = "DELETE FROM Pizzas WHERE id = " + ID;
        try {
            statement.executeUpdate(request);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePizzaNom(int id, String nom) {
        String request = "UPDATE Pizzas SET nom = '" + nom + "' WHERE id = " + id;
        try {
            statement.executeUpdate(request);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePizzaTaille(int id, taille_pizza taille) {
        String request = "UPDATE Pizzas SET taille = '" + taille + "' WHERE id = " + id;
        try {
            statement.executeUpdate(request);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePizzaPrix(int id, double prix) {
        String request = "UPDATE Pizzas SET prix = '" + prix + "' WHERE id = " + id;
        try {
            statement.executeUpdate(request);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
