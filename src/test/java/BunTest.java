import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import static org.junit.Assert.assertEquals;

//параметризация не обязательно)

@RunWith(Parameterized.class)
public class BunTest {
    private final String name;
    private final float price;
    private Bun bun;

    public BunTest(String name, float price){
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "bunName - {0}. bunPrice - {1}")
    public static Object[][] Data(){
        return new Object[][] {
                {"BUN1", 1.01f},
                {"BUN2", 25f}
        };
    }
    @Before
    public void setUp() {
        bun = new Bun(name, price);
    }
    @Test
    public void bunPriceTest(){

        float actualPrice = bun.getPrice();
        float expectedPrice = price;
        assertEquals(expectedPrice, actualPrice, 0);
    }
    @Test
    public void bunNameTest(){
        String actualName = bun.getName();
        String expectedName = name;
        assertEquals(expectedName, actualName);
    }
}
