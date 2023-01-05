package junit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FirstJUnitTest {
    @BeforeEach
    void beforeEach(){
        System.out.println("Это метод @BeforeEach");
    }
    @AfterEach
    void afterEach(){
        System.out.println("Это метод @AfterEach");
    }
    @Test
    void firstTest(){
        System.out.println("Это тест");
        Assertions.assertTrue(3>2);
    }
}
