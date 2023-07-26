import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient;
    private Database database;
    private List<Ingredient> ingredients;
    private Burger burger;
    @Before
    public void setUp() {
        database = new Database();
        ingredients = database.availableIngredients();
        burger = new Burger();
    }
    @Test
    public void addIngredientTest(){
        burger.addIngredient(ingredients.get(1));
        assertEquals(ingredients.get(1), burger.ingredients.get(0));
    }

    @Test
    public void removeIngredientTest(){
        burger.addIngredient(ingredients.get(0));
        burger.removeIngredient(0);
        assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest(){
        burger.addIngredient(ingredients.get(0));
        burger.addIngredient(ingredients.get(1));
        burger.moveIngredient(0, 1);
        assertEquals(ingredients.get(1), burger.ingredients.get(0));
    }
    @Test
    public void getBurgerPriceTest(){
        List<Bun> buns = database.availableBuns();
        burger.setBuns(buns.get(0));
        burger.addIngredient(ingredients.get(0));
        burger.getPrice();
        assertEquals(300, burger.getPrice(), 0);
    }
    @Test
    public void getBurgerReceiptTest(){
        Mockito.when(bun.getName()).thenReturn("red bun");
        Mockito.when(ingredient.getName()).thenReturn("chicken cutlet");
        Mockito.when(bun.getPrice()).thenReturn(1f);
        Mockito.when(ingredient.getPrice()).thenReturn(10f);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        final String expected = "(==== red bun ====)\r\n" +
                                "= filling chicken cutlet =\r\n" +
                                "(==== red bun ====)\r\n" +
                                "\r\n" +
                                "Price: 12,000000\r\n";
        assertEquals(expected, burger.getReceipt());
    }
}
