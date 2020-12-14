/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import gui.*;
import java.io.IOException;
import javax.swing.*;

/**
 *
 * @author Etudiant
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        IInterpreter interpreter = new Interpreter();
        IStorage storage = new FileStorage("history.txt");
        IHistory history = new History(storage);
        
        JFrame mainFrame = new MainFrame(interpreter, history);
        mainFrame.setVisible(true);
    }
    
}
