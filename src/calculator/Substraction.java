/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

/**
 *
 * @author Etudiant
 */
public class Substraction extends Operator {

    public Substraction(IExpression num1, IExpression num2) {
        left_ = num1;
        right_ = num2;
    }

    @Override
    public double eval() {

        return left_.eval() - right_.eval();
    }
    
}
