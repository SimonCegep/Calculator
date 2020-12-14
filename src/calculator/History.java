/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.util.ArrayList;

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

    @Override
    public String getLast() {
       return history_.get(history_.size()-1);
    }
    
    void loadHistory(){
        history_ = storage_.importContent();
    }

    @Override
    public void save() {
        storage_.export(history_);
    }
    
    
    
}
