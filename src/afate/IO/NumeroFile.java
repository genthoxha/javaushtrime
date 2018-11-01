package afate.IO;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class NumeroFile {

    int countFiles = 0;
    int countExtensionExt = 0;
    private File root;


    public NumeroFile(String emriFolderit) throws IOException {
        if (emriFolderit.trim().isEmpty()) {
            throw new IOException("Emri i folderit nuk duhet te jete empty");
        }
        root = new File(emriFolderit);
    }

    public static void main(String[] args) {
        try {
            NumeroFile numeroFile = new NumeroFile("C:\\Users\\Admin\\Desktop\\deletefilesfolder");
            numeroFile.numero(".html");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int numero(String ext) throws IOException {
        File[] files = root.listFiles();
        for (File f : files) {
            if (f.isDirectory()) {
                root = new File(f.getAbsolutePath());
                numero(ext);
            } else if (f.isFile()) {
                countFiles++;
                if (f.getName().contains(ext)) {
                    countExtensionExt++;
                }
            }
        }
        shkruaj("Total files jane: " + countFiles + "\nMe ext: " + ext + " jane: " + countExtensionExt);
        return countExtensionExt;
    }

    public void shkruaj(String ext) throws IOException {
        FileWriter fileWriter = new FileWriter("C:\\Users\\Admin\\Desktop\\shkruaj.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(ext);
        bufferedWriter.close();
    }

}
