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
public class Interpreter implements IInterpreter {
    
    
    public IExpression parse(String expression) 
    {
	if(isFirstLevel(expression))
	{
            return parse(expression.substring(1, expression.length() - 2));
	}
       
	int operatorIndex = nextOperatorIndex(expression);
        
	if(operatorIndex < 0)
	{
            try{
                return new Number(Double.parseDouble(expression));
            }
            catch(Exception e){
                return new Number(Double.NaN); 
            }
	}
	else
	{
            switch(expression.charAt(operatorIndex))
            {
                case '+' : return new Addition(parse(getLeftSubString(expression, operatorIndex)), parse(getRightSubString(expression, operatorIndex)));
                case '*' : return new Multiplication(parse(getLeftSubString(expression, operatorIndex)), parse(getRightSubString(expression, operatorIndex)));
                case '-' : return new Substraction(parse(getLeftSubString(expression, operatorIndex)), parse(getRightSubString(expression, operatorIndex)));
                case '%' : return new Modulo(parse(getLeftSubString(expression, operatorIndex)), parse(getRightSubString(expression, operatorIndex)));
                case '^' : return new Expon(parse(getLeftSubString(expression, operatorIndex)), parse(getRightSubString(expression, operatorIndex)));
                default  : return new  Division(parse(getLeftSubString(expression, operatorIndex)), parse(getRightSubString(expression, operatorIndex)));
            }
	}
    }
    
    String getLeftSubString(String str, int index){
       
        try{
            return str.split("\\" + str.substring(index, index+1))[0];
        }
        catch(Exception e){
            return "";
        }

    }
    
    String getRightSubString(String str, int index){
        
        try{
            return str.substring(index + 1);
        }
        catch(Exception e){
            return "";
        }
    }
    
    int nextOperatorIndex(String expr){
        
         for(int i = 0; i < expr.length(); i++){
            if(expr.charAt(i) == '+'){
                return i;
            }
        }
         
         for(int i = 0; i < expr.length(); i++){
            if(expr.charAt(i) == '-'){
                return i;
            }
        }
        
        for(int i = 0; i < expr.length(); i++){
            if(expr.charAt(i) == '*'){
                return i;
            }
        }
        
        for(int i = 0; i < expr.length(); i++){
            if(expr.charAt(i) == '/'){
                return i;
            }
        }
        
        for(int i = 0; i < expr.length(); i++){
            if(expr.charAt(i) == '%'){
                return i;
            }
        }
        
        for(int i = 0; i < expr.length(); i++){
            if(expr.charAt(i) == '^'){
                return i;
            }
        }
       
        return -1;
    }

    
    
    boolean isFirstLevel( String expr )
    {
        if( !expr.startsWith("(") || !expr.endsWith(")") )
        {
            return false;
        }
        
        int niveauParentheses = 0;
        for( int i = 0; i < expr.length(); ++i )
        {
            if( expr.charAt(i) == '(' )
            {
                niveauParentheses++;
            }
            else if( expr.charAt(i) == ')' )
            {
                niveauParentheses--;
                if( niveauParentheses == 0 )
                {
                    return i == expr.length() - 1;
                }
            }
        }
        
        return false;
    }

}
