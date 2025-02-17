package com.example.productcatalogservice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    public void AdditionOn2Integers_RunSuccessfully() {
        //Arrange
        Calculator calc = new Calculator();

        //Act
        int res = calc.add(1,2);

        //Assert
        assert(res == 3 );
    }


    @Test
    public void DivideByZero_ThrowsException() {
        //arrage
        Calculator calc = new Calculator();

        //Act and assert
       assertThrows(ArithmeticException.class, () -> calc.divide(1,0));
    }


}