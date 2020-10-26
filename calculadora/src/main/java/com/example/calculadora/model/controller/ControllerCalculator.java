package com.example.calculadora.model.controller;

import java.util.Objects;

import com.example.calculadora.model.entidade.Calculator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@ResponseBody
public class ControllerCalculator {

        float value;

        
        @GetMapping("/calculator")
        @RequestMapping(path = "/calculator/{oper}/{first_n}/{second_n}", method = RequestMethod.GET)
	public String getCalculatorString (@PathVariable String oper,@PathVariable float first_n,@PathVariable float second_n) {
        
                int check =checkOper(oper);
                if(check == 1)
                        value = first_n + second_n;
                else if(check == 2)
                        value = first_n - second_n;
                else if(check == 3)
                        value = first_n * second_n;
                else if(check == 4)
                        value = first_n / second_n;
                else
                        return "Operacao Invalida";
                
                
                String s = String.valueOf(value);

                return "Resulta foi " + s;

        }
        
        public int checkOper(String oper){
                if(!(Objects.equals(oper, null))){
                        if(Objects.equals(oper, "+") || Objects.equals(oper, "soma") || Objects.equals(oper, "sum") || Objects.equals(oper, "som") || Objects.equals(oper, "s"))
                                return 1;
                        else if(Objects.equals(oper, "-") || Objects.equals(oper, "subtracao") || Objects.equals(oper, "subtraction") || Objects.equals(oper, "sub") || Objects.equals(oper, "su"))
                                return 2;
                        else if(Objects.equals(oper, "*") || Objects.equals(oper, "multiplicacao") || Objects.equals(oper, "multiplication") || Objects.equals(oper, "mul") || Objects.equals(oper, "m") || Objects.equals(oper, "x"))
                                return 3;
                        else if(Objects.equals(oper, "divisao") || Objects.equals(oper, "divide") || Objects.equals(oper, "div") || Objects.equals(oper, "d"))
                                return 4;
                        else
                                return 5;
                }
                return 0;
        }
}
