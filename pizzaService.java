import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class pizzaService implements IPizzaService {
    private pizzaDAO dao = new pizzaDAO();

    public List<ingredient> getIngredient(int ID) {
        List<ingredient> list = new ArrayList<ingredient>();
        String SQL = "SELECT nom, unite, prix, ingredients.quantite, Contenir.quantite FROM Contenir, ingredients WHERE ingredients.ID = Contenir.ID_ingredient and ID_Pizza = 3";
        ResultSet rs;
        try {
            rs = dao.getStatement().executeQuery(SQL);
            while (rs.next()) {
                String nom = rs.getString("nom");
                unite_ingrédient unite = unite_ingrédient.valueOf(rs.getString("unite"));
                float quantite = rs.getFloat("quantite");
                double prix = rs.getDouble("prix");
                ingredient i = new ingredient(ID, nom, unite, quantite, prix);

                list.add(i);
            }
            return list;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public int ajouterIngredientPizza(int ID_ingredient, int ID_Pizza) {

        String sql = "INSERT INTO Contenir (ID_Ingredient, ID_Pizza, quantity) VALUES (" + ID_ingredient + ", "
                + ID_Pizza
                + ", 1)";

        try {
            dao.getStatement().executeUpdate(sql);
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }

    }

}