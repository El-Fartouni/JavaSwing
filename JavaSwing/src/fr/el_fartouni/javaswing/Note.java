/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.el_fartouni.javaswing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.Buffer;
import java.util.Date;

/**
 *
 * @author Administrateur
 */
public class Note {

    private String title;
    private String text;
    private String fileName;
    private String forlderName = "notes";
    private String fileExtension = ".txt";

    public Note() {
    }

    public Note(String fileName) {
        this.fileName = fileName;
    }

    public Note(String title, String text, String fileName) {
        this.title = title;
        this.text = text;
        this.fileName = fileName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getForlderName() {
        return forlderName;
    }

    public void setForlderName(String forlderName) {
        this.forlderName = forlderName;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    /*
    *Sauvegarde une note sur le disque dur
     */
    public void saveNote() throws IOException {

        //le contenu du fichier note
        StringBuilder sb = new StringBuilder();
        sb.append(this.title);
        sb.append("\n");
        sb.append(this.text);

        String fileContent = sb.toString();

        //Instanciation du fichier
        File noteFile = new File(this.forlderName, this.fileName + this.fileExtension);
        //Si le fichier n'existe pas on le crée
        if (!noteFile.exists()) {
            noteFile.createNewFile();
        }

        //Ecriture dans le fichier
        PrintWriter pw = new PrintWriter(noteFile);
        pw.write(fileContent);
        pw.flush();

        pw.close();

    }

    public void newNote() throws IOException {
        // this.fileName = String.valueOf((new Date()).getTime());

        //Le titre est utilisé comme nom de fichier
        String baseFileName = this.title.replaceAll(" ", "-");
        int suffix = 0;
        //Instanciation du fichier avec le nom de base pour tester son existence
        File f = new File(this.forlderName, baseFileName + this.fileExtension);
        //Boucle jusqu'à trouver un nom de fichier qui n'existe pas
        while (f.exists()) {
            suffix++;
            f = new File(forlderName, fileName + this.fileExtension);
        }
        
        //Attribution du nom trouvé à la propriété fileName de l'objet
        this.fileName = fileName;
        this.saveNote();

    }

    /**
     * Chargement d'une note
     */
    public void loadNote() throws IOException {
        //Instanciation du fichier
        File noteFile = new File(this.forlderName, this.fileName + this.fileExtension);

        //Instanciation de FileReader et BufferedReader (pour lire le fichier ligne à ligne)
        FileReader fr = new FileReader(noteFile);
        BufferedReader br = new BufferedReader(fr);

        //Récuperation du tire
        this.title = br.readLine();

        //Récuperation du texte 
        String line;
        StringBuilder sb = new StringBuilder();
        //Boucle ligne à ligne jusqu'à la fin du fichier
        while ((line = br.readLine()) != null) {
            sb.append(line);
            sb.append("\n");
        }

        this.text = sb.toString();

        br.close();
        fr.close();
    }

    public void deleteNote() {
        //Instanciation du fichier
        File noteFile = new File(this.forlderName, this.fileName + this.fileExtension);
        noteFile.delete();
    }
}
