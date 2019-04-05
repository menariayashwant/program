
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PdfRead {
    private static final String FILE_NAME = "/tmp/itext.pdf";
    public static void main(String[] args) {
    		PdfReader reader;
        try {
            reader = new PdfReader("/tmp/one.pdf");
            String textFromPage = PdfTextExtractor.getTextFromPage(reader, 4);
            System.out.println(textFromPage);
            
            System.out.println("-------------------------");
            
            System.out.println(textFromPage.contains("3251200"));  
            
            System.out.println("-------------------------");
            
            String text = textFromPage;
            String wordToFind = "EQUITY AND LIABILITIES";
            Pattern word = Pattern.compile(wordToFind);
            Matcher match = word.matcher(text);

            while (match.find()) {
                 System.out.println("Found line at index "+ match.start() +" - "+ (match.end()-1));
                 
                 System.out.println(text.substring(match.end()).split("\n")[2].split(" ")[0]);
            }
            
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
