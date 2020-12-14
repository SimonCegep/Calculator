/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author simon
 */
public class FileStorage implements IStorage{

    File file_;
    FileWriter writer_ = null;
    String fileName_;
    
    FileStorage(String fileName) throws IOException{
        fileName_ = fileName;
    }
    
    @Override
    public void export(ArrayList list) {
        try {
            file_ = new File(fileName_);
            writer_ = new FileWriter(file_);
            
            for(int i = 0; i < list.size(); i++){
                writer_.append((CharSequence) list.get(i) + "\n");
            }
        } catch (IOException ex) {
            Logger.getLogger(FileStorage.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                writer_.close();
            } catch (IOException ex) {
                Logger.getLogger(FileStorage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public ArrayList importContent() {
        BufferedReader reader = null;
        ArrayList<String> list = new ArrayList<>();
        
        try {
            reader = new BufferedReader(new FileReader(fileName_));
            
            String ln = reader.readLine();
            while(ln != null){
                list.add(ln);
                ln = reader.readLine();
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileStorage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileStorage.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                reader.close();
            } catch (IOException ex) {
                Logger.getLogger(FileStorage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
           return list;
    }
    
}
