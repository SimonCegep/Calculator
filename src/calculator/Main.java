/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import gui.*;
import javax.swing.*;

/**
 *
 * @author Etudiant
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame mainFrame = new MainFrame(new Interpreter(), new History());
        mainFrame.setVisible(true);
    }
    
}