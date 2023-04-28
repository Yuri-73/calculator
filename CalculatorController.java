package pro.sky.calculator;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class CalculatorController {
    private final CalculatorService calculatorServise;
    public CalculatorController(CalculatorService calculatorServise) {
        this.calculatorServise = calculatorServise;
    }

    @RequestMapping("/calculator") //Выведен общий адрес за скобки

    @GetMapping
    public String calculator() { //Приветствие, если в адресе один calculator (но он за скобками!)
        return calculatorServise.calculator();
    }
    @GetMapping(path = "/plus")
    public String calculatorSum(Integer num1, Integer num2) { //В адресе сумма 2-х параметров: http://localhost:8080/plus?num1=5&num2=2
        if (num1 == null || num2 == null) { //Проверка на корректность ввода, чтобы приложение не упало
            return "Один (несколько параметров) не записаны в адресную строку, не инициализирован или введён неправильный параметр!";
        }
        return calculatorServise.calculatorSum(num1, num2);
    }
    @GetMapping(path = "/minus")
    public String calculatorDifference(@RequestParam(required = false) Integer num1, @RequestParam(required = false) Integer num2) { //В адресе вычитание 2-х параметров с бесплатным подвеском false: http://localhost:8080/minus?num1=5&num2=2
        if (num1 == null || num2 == null) {
            return "Один (несколько параметров) не записаны в адресную строку, не инициализирован или введён неправильный параметр!";
        }
        return calculatorServise.calculatorDifference(num1, num2);
    }
    @GetMapping(path = "/multiply") //То же, но для умножения
    public String calculatorMultiply(@RequestParam(required = false) Integer num1, @RequestParam(required = false) Integer num2) {
         if (num1 == null || num2 == null) {
            return "Один (несколько параметров) не записаны в адресную строку, не инициализирован или введён неправильный параметр!";
         }
         return calculatorServise.calculatorMultiply(num1, num2);
    }
    @GetMapping(path = "/divide") //То же, но для деления 2-х параметров. Добавил к некорректности ввода параметров ещё некорректность деления на 0
    public String calculatorDivide(@RequestParam(required = false) Integer num1, @RequestParam(required = false) Integer num2) {
        if (num1 == null || num2 == null) {
            return "Один (несколько параметров) не записаны в адресную строку, не инициализирован или введён неправильный параметр!";
        }
        if(num2 != 0) {
            return calculatorServise.calculatorDivide(num1, num2);
        }
        else { return "Деление на 0 запрещено!"; }
    }

}
