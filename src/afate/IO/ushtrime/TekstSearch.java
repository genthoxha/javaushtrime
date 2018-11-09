package afate.IO.ushtrime;


import java.io.*;

public class TekstSearch {

    private BufferedWriter bufferedWriter;
    private BufferedReader bufferedReader;

    public TekstSearch(String pathToRead, String pathToWrite) throws IOException {
        if (pathToRead == null || pathToRead.trim().isEmpty()) {
            throw new IOException("Path per te lexuar eshte null !");
        }
        bufferedReader = new BufferedReader(new FileReader(pathToRead));
        bufferedWriter = new BufferedWriter(new FileWriter(pathToWrite));
    }

    public void search(String string) {
        int countString = 0;
        int countLine = 0;
        try {
            String rreshti = null;
            while ((rreshti = bufferedReader.readLine()) != null) {
                countLine++;
                if (rreshti.contains(string)) {
                    countString++;
                }
            }
            bufferedWriter.write("Gjithsej rreshta jane : " + countLine + " permbajne " + string + " : " + countString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            TekstSearch tekstSearch = new TekstSearch("C:\\Users\\Admin\\Desktop\\TextToRead.txt", "C:\\Users\\Admin\\Desktop\\TextToWrite.txt");
            tekstSearch.search("ubt");
            tekstSearch.closeResources();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeResources() {
        try {
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
