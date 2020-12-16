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
public interface IHistory {
    void add(String exp, double result);
    ArrayList getList();
    String[] getArray();
    void save();
}    