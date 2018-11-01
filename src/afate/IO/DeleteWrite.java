package afate.IO;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DeleteWrite {

    public File root;
    int count = 0;

    public DeleteWrite(String emriFld)throws IOException {
        root = new File(emriFld);
    }

    public void deleteFiles(String kushti) throws IOException {
        File[] listRoot = root.listFiles();
        for (int i = 0; i < listRoot.length; i++) {
            System.out.println(listRoot[i]);
            if (listRoot[i].isDirectory()) {
                root = new File(listRoot[i].getAbsolutePath());
                deleteFiles(kushti);
            } else if (listRoot[i].isFile()) {
                if (listRoot[i].getName().startsWith(kushti)) {
                    listRoot[i].delete();
                    count++;
                }
            }
        }
        shkruaj("Ne total u fshin total " + count + " fajlla qe fillonin me kushtin: " + kushti);
    }
    public void shkruaj(String text)throws IOException {
        FileWriter fw = new FileWriter("C:\\Users\\Admin\\Desktop\\shkruaj.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fw);
        fw.write(text);
        bufferedWriter.close();
    }

    public static void main(String[] args) {
        try {
            DeleteWrite deleteWrite = new DeleteWrite("C:\\Users\\Admin\\Desktop\\deletefilesfolder");
            deleteWrite.deleteFiles("dhurki");

        } catch (IOException e) {
            e.printStackTrace();

        }
    }

}
