/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplethreelayer.dataaccess;

import simplethreelayer.simplethreelayer.interfaces.IDataAccess;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Anders
 */
public class DataAccess implements IDataAccess {

    private final String path;
    public DataAccess(String path)
    {
        this.path = path;
    }
    
    public List<String> load()
    {
        List<String> result = new ArrayList<>();
        try{
            File f = new File(path);
            Scanner s = new Scanner(f);
            while(s.hasNextLine())
            {
                result.add(s.nextLine());
            }
            s.close();
        }
        catch(FileNotFoundException ex)
        {
            System.out.println("Nothing found. Returning empty result.");
        }
        return result;
    }
    
    public void save(List<String> data)
    {
        try {
            File f = new File(path);
            PrintWriter pw = new PrintWriter(f);
            for(String d : data)
            {
                pw.println(d);
            }
            pw.close();
        } catch (FileNotFoundException ex) {
            System.out.println("No file. Saving nothing.");
        }
    }
}
