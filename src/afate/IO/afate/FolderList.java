package afate.IO.afate;

import java.io.*;

public class FolderList {

    private File root;
    private BufferedWriter bufferedWriter;
    private BufferedReader bufferedReader;


    public FolderList(String emriFolderit) throws IOException {
        if (emriFolderit == null || emriFolderit.trim().isEmpty()) {
            throw new IOException("Emri i folderit eshte null!");
        }
        this.root = new File(emriFolderit);

    }

    public void shfleto(String teksti) throws IOException {

        File[] files = root.listFiles();
        int count = 0;
        for (File file : files) {
            if (file.isDirectory()) {
                root = new File(file.getAbsolutePath());
                return;
            } else {
                if (file.getName().contains(teksti)) {
                    count++;
                    System.out.println(file);
                    bufferedWriter = new BufferedWriter(new FileWriter("SHK2.out"));
                    bufferedWriter.write("Ne folder-in " + file.getName() + " gjenden: " + count + " file-a qe permbajne tekstin e dhene " + teksti);

                }
            }

        }

    }
}
