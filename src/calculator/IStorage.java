/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.util.ArrayList;

/**
 *
 * @author simon
 */
public interface IStorage {
    void export(ArrayList list);
    ArrayList importContent();
}
