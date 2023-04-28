package pro.sky.calculator;

import org.springframework.stereotype.Service;

@Service //Моя модель-сервис
public class CalculatorServiseImpl implements CalculatorService {
    @Override
    public String calculator() {
        return "<b>Welcome to the calculator</b>";
    }
    @Override
    public String calculatorSum(int num1, int num2) {
        return num1 + " + " + num2 + " = " + (num1 + num2);
    }
    @Override
    public String calculatorDifference(int num1, int num2) {
        return num1 + " - " + num2 + " = " + (num1 - num2);
    }
    @Override
    public String calculatorMultiply(int num1, int num2) {
        return num1 + " * " + num2 + " = " + (num1 * num2);
    }
    @Override
    public String calculatorDivide(int num1, int num2) {
        return num1 + " / " + num2 + " = " + (num1 / num2);
    }
}
