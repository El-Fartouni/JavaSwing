/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.el_fartouni.exos.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Administrateur
 */
public class ExosFile {

    public static void main(String[] args) {
        try {
            //listFiles("c:/sql");
            //listFiles("c:/windows");
 
            writeTextFile("liste.txt", "Un frigidaire\n");
            writeTextFile("liste.text","un évier en fer\n");
            
            writeTextFile("data/liste.txt", "pommes");
        } catch (IOException ex) {
            Logger.getLogger(ExosFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Ecrire in contenu dans un fichier texte
     * @param path
     * @param Content 
     */
   public static void writeTextFile(String path, String content) throws IOException{
       FileWriter fw = new FileWriter(path, true);
       BufferedWriter bw = new BufferedWriter(fw);
       bw.write(content);
       bw.close();
       fw.close();
   }
    
    
    public static void listFiles(String path) {
        //Lister les fichiers
        File f = new File(path);

        /*
        String[] contentList = f.list();

        for (String fileName : contentList) {
            System.out.println(fileName);
        }*/
        File[] contentList = f.listFiles();
        for (File file : contentList) {
            String fileInfo;
            if (file.isDirectory()) {
                fileInfo = "d ";
            } else {
                fileInfo = "f ";
            }

            fileInfo += file.getName();
            fileInfo += " (" + file.length() + " octet)";

            System.out.println(fileInfo);
        }
    }
}
