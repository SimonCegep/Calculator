/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Etudiant
 */
public class History implements IHistory{

    ArrayList<String> history_;
    IStorage storage_;
    
    History(IStorage storage){
        
         history_ = new ArrayList<>();
         storage_ = storage;
         loadHistory();
    }
    
    @Override
    public void add(String exp, double result) {
        history_.add(exp + " = " + result);
    }

    @Override
    public ArrayList getList() {
        return history_;
    }
    
    public String[] getArray(){
        return Arrays.copyOf(history_.toArray(), history_.toArray().length, String[].class);
    }
    
    void loadHistory(){
        history_ = storage_.importContent();
    }

    @Override
    public void save() {
        storage_.export(history_);
    }
    
    
    
}
