package com.example.calculadora.model.entidade;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Calculator {
    private String oper;
    private float first_n;
    private float second_n; 

}
