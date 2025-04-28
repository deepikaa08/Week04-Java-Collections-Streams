import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Calculator {
    public int add(int a, int b){
        return a+b;
    }

    public int subtract(int a, int b){
        return a-b;
    }

    public int multiply(int a, int b){
        return a*b;
    }

    public int divide(int a, int b){
        if(b == 0){
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a/b;
    }

    @Test
    public void testAddition(){
        assertEquals(8, add(5, 3));
    }

    @Test
    public void testSubtraction(){
        assertEquals(2, subtract(5, 3));
    }

    @Test
    public void testMultiplication(){
        assertEquals(15, multiply(5, 3));
    }

    @Test
    public void testDivision(){
        assertEquals(2, divide(6, 3));
    }

    @Test
    public void testDivisionbyzero(){
        assertThrows(ArithmeticException.class, () -> divide(10, 0));
    }
}
