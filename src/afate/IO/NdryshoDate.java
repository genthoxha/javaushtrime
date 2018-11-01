package afate.IO;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class NdryshoDate {

    private File file;
    int counter = 0;

    public NdryshoDate(String emriFolderit) throws IOException {
        if (emriFolderit.trim().isEmpty()) {
            throw new IOException("Emri folderit nuk duhet te jete i zbrazet!");
        }
        file = new File(emriFolderit);
    }

    public void ndryshoDaten(String prefiks) throws IOException {
        File[] files = file.listFiles();
        Date date = new Date();
        for (File f : files) {
            if (f.isDirectory() && file.exists()) {
                if (f.getName().startsWith(prefiks)) {
                    f.setLastModified(date.getTime());
                    counter++;
                    ndryshoDaten(f.getAbsolutePath());
                }
            }
        }
        shkruaj("Ne total iu ndryshua data " + counter + " qe filluan me " + prefiks);
    }

    private void shkruaj(String text) throws IOException {
        FileWriter fileWriter = new FileWriter("C:\\Users\\Admin\\Desktop\\shkruaj.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(text);
        bufferedWriter.close();
    }

    public static void main(String[] args) {
        try {
            NdryshoDate ndryshoDate = new NdryshoDate("C:\\Users\\Admin\\Desktop\\deletefilesfolder");
            ndryshoDate.ndryshoDaten("mix");
        } catch (IOException io) {
            io.getMessage();
        }
    }

}
