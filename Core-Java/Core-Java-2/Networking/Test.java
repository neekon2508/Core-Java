package Networking;
import java.io.*;
import java.net.*;
import java.nio.charset.*;
import java.util.*;
public class Test {
    public static void main(String[] args) throws IOException {
        // getAllHostName("google.com");
        getURLContent("https://www.google.com/");
    }
    public static void getAllHostName(String host) throws UnknownHostException
    {
        InetAddress[] addresses = InetAddress.getAllByName(host);
        for(var address : addresses)
        {
            byte[] addressBytes = address.getAddress();
            for(byte b : addressBytes)
             System.out.print(b+'.');
            System.out.println();
        }
    }
    public static void getURLContent(String urlString) throws IOException
    {
        var url = new URL(urlString);
        InputStream inStream = url.openStream();
        var in = new Scanner(inStream, StandardCharsets.UTF_8);
        while ( in.hasNextLine())
        {
            System.out.println(in.nextLine());
        }
        in.close();

    }
}
