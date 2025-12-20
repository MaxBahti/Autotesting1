package pages;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TrialTest {
    @AfterMethod
    public void boo() {
        System.out.println("v");
    }

    @Test
    public void boo1() {
        System.out.println("x");
    }

    @Test
    public void boo2() {
        System.out.println("c");
    }

    @BeforeMethod
    public void boo3() {
        System.out.println("z");
    }
}