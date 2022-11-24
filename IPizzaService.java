import java.util.List;

public interface IPizzaService {
    List<ingredient> getIngredient(int ID);

    int ajouterIngredientPizza(int ID_ingredient, int ID_Pizza);
}
