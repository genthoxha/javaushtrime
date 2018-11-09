package afate.IO.ushtrime;

import java.io.*;

public class TextRead {

    private File file;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;

    public TextRead(String s) throws IOException {
        if (s == null || s.trim().isEmpty()) {
            throw new IOException("File nuk duhet te jete i zbrazet");
        }
        this.file = new File(s);
        bufferedReader = new BufferedReader(new FileReader(file));

    }

    public static void main(String[] args) {
        try {
            TextRead textRead = new TextRead("C:\\Users\\Admin\\Desktop\\TextToRead.txt");
            textRead.countLines("C:\\Users\\Admin\\Desktop\\TextToWrite.txt");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int countLines(String file) {
        int count = 0;
        try {
            while ((bufferedReader.readLine()) != null) {
                count++;
            }
            bufferedWriter = new BufferedWriter(new FileWriter(file));
            bufferedWriter.write("Teksti ka gjithsej: numri i rreshtave " + count);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return count;
    }


}
