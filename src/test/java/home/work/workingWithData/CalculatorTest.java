package home.work.workingWithData;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class CalculatorTest {
    Participant participant;

    @BeforeEach
    void createParticipant() {
        participant = new Participant("Inna Ivanova", 100);
    }

    @Test
    void calculateThePercentage() {
        Calculator calculator = new Calculator();
        String result = calculator.calculateThePercentage(participant,10);
        Assertions.assertEquals("Текущий вес 90.0 процент скинутых килограмм 10.0",result);
    }
}