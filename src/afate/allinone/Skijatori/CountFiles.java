/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afate.allinone.Skijatori;

import java.io.File;
import java.io.FileFilter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Fatos
 */
public class CountFiles {

    private File folder = null;

    public CountFiles(String emri) throws IOException {
        folder = new File(emri);
        
        if (!folder.exists()) {
            throw new IOException("Emri nuk egziston !");
        }
        
        if (!folder.isDirectory()) {
            throw new IOException("Nuk eshte folder !");
        }
    }

    public void fileCount() throws IOException {
        File[] folders = folder.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().toUpperCase().endsWith("AT");
            }
        });

        File[] files = folder.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if (pathname.isFile()) {
                    String emriFilet = pathname.getName();
                    int index = emriFilet.lastIndexOf(".");
                    if (index == -1) {
                        return emriFilet.toUpperCase().endsWith("AT");
                    }
                    return emriFilet.substring(index + 1).toUpperCase().endsWith("AT");
                }
                return false;

            }
        });
        try(PrintWriter pw = new PrintWriter(new FileWriter("D:/Ubt.out"))){
            pw.println("Folderi "+folder.getName()+" ka:");
            pw.println("File "+files.length);
            pw.println("Folder "+folders.length);
        }
    }
    
    public static void main(String[] args) {
        try {
            CountFiles cf = new CountFiles("D:/test");
            cf.fileCount();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
