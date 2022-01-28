// File reading code from https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {
    public static ArrayList<String> getLinks(String[] markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        int currentIndex = 0;
        for(int i = 0; i<markdown.length; i++){
            //if the current line contains a set of brackets and parentheses, then search for the link
            if(markdown[i].contains("[") && markdown[i].contains("]") && markdown[i].contains("(") && markdown[i].contains(")")){
                // find the next [, then find the ], then find the (, then take up to
                // the next )
                int nextOpenBracket = markdown[i].indexOf("[", currentIndex);
                int nextCloseBracket = markdown[i].indexOf("]", nextOpenBracket);
                int openParen = markdown[i].indexOf("(", nextCloseBracket);
                int closeParen = markdown[i].indexOf(")", openParen);
                toReturn.add(markdown[i].substring(openParen + 1, closeParen));
                currentIndex = closeParen + 1;
            }
        }
        return toReturn;
    }
    public static void main(String[] args) throws IOException {
		Path fileName = Path.of(args[0]);
	    String contents = Files.readString(fileName);
        String[] inp = contents.split(System.lineSeparator());
        ArrayList<String> links = getLinks(inp);
        System.out.println(links);
    }
}