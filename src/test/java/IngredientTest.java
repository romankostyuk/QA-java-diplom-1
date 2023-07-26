import org.junit.Before;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;
import static org.junit.Assert.assertEquals;

public class IngredientTest {
    private Ingredient ingredient;
    @Before
    public void setUp() {
        ingredient = new Ingredient(IngredientType.SAUCE, "mazik sauce",1.01f);
    }
    @Test
    public void checkIngredientNameTest(){
        String expectedName = "mazik sauce";
        String actualName = ingredient.getName();
        assertEquals(expectedName, actualName);
    }

    @Test
    public void checkIngredientPriceTest(){
        float expectedPrice = 1.01f;
        float actualPrice = ingredient.getPrice();
        assertEquals(expectedPrice, actualPrice, 0);
    }

    @Test
    public void checkIngredientTypeTest(){
        IngredientType expectedType = IngredientType.SAUCE;
        IngredientType actualType = ingredient.getType();
        assertEquals(expectedType, actualType);
    }
}