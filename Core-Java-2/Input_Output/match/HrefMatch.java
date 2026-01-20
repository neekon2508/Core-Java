package Input_Output.match;
import java.io.*;
import java.net.*;
import java.nio.charset.*;
import java.util.regex.*;

/*
 * This program displays all URLs in a web page by matching a regular expression that
 * describes the <a href = ...> HTML tag. Start the program as <br> 
 * java.match.HreMatch URL
 * @version 1.0 2024-09-02
 * @author Neekon
 */
public class HrefMatch {
    public static void main(String[] args) {
        try
        {
            //get URL string from command line or use default
            String urlString;
            if (args.length > 0) urlString = args[0];
            else urlString = "http://openjdk.java.net/";

            //read contents of URL
            InputStream in = new URL(urlString).openStream();
            var input = new String(in.readAllBytes(), StandardCharsets.UTF_8);

            //Search for all occurrences of pattern
            var patternString = "<a\\s+href\\s*=\\s*(\"[^\"]*\"|[^\\s>]*)\\s*>";
            Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);
            pattern.matcher(input).results().map(MatchResult::group).forEach(System.out::println);
        }
        catch(IOException | PatternSyntaxException e)
        {
            e.printStackTrace();
        }

    }
}
