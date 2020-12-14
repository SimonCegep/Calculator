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
public class Number implements IExpression {

    double number_;
    
    Number(double parseDouble) {
        number_ = parseDouble;
    }

    @Override
    public double eval() {
        return number_;
    }
    
}
