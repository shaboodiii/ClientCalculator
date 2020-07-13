package com.calculatorClient.CalculatorClient.controller;

import com.calculatorClient.CalculatorClient.model.Calculator;
import com.calculatorClient.CalculatorClient.model.Result;
import com.calculatorClient.CalculatorClient.service.CalculatorService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CalculatorController {

    private CalculatorService calculatorService;

    @Autowired
    public CalculatorController(CalculatorService calculatorService){
        this.calculatorService = calculatorService;
    }

    @RequestMapping({"", "/", "index"})
    public String index(Model model){
        model.addAttribute("calculator", new Calculator());
        return "index";
    }

    @PostMapping(value = "/calculator", consumes= MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String addCalculator(@RequestParam(name="xValue") String xValue,
                                @RequestParam(name="yValue") String yValue,
                                @RequestParam(name="operator") String operator,
                                Model model) throws JsonProcessingException {

        Calculator calculator = new Calculator(Double.parseDouble(xValue),Double.parseDouble(yValue),operator);
        Result result = calculatorService.calculate(calculator);

        return "redirect:/results/" + result.getResult();
    }

    @GetMapping("/results/{result}")
    public String result(@PathVariable String result, Model model) {
        model.addAttribute("result", result);
        return "results";
    }

}
