package Security.hash;

import java.io.*;
import java.nio.file.*;
import java.security.*;
import java.util.*;



/**
 * This program computes the message digest of a file
 * @version 1.0 2024-09-23
 * @author Neekon
 */
public class Digest {

    /**
     * 
     * @param args[0] is the filename, args[1] is optionally the algorithm
     * (SHA-1, SHA-256 or MD5)
     * @throws NoSuchAlgorithmException 
     * @throws IOException 
     */
    public static void main(String[] args) throws GeneralSecurityException, IOException {
        var in = new Scanner(System.in);
        String filename;
        if(args.length >= 1)
         filename = args[0];
        else
        {
            System.out.println("File name: ");
            filename = in.nextLine();
        }
        String algname;
        if (args.length >=2)
            algname = args[1];
        else
        {
            System.out.println("Select one of the following algorithms: ");
            for (Provider p : Security.getProviders())
                for (Provider.Service s : p.getServices())
                 if(s.getType().equals("MessageDigest"))
                  System.out.println(s.getAlgorithm());
            System.out.println("Algorithm: ");
            algname = in.nextLine();
        }
        MessageDigest alg = MessageDigest.getInstance(algname);
        byte[] input = Files.readAllBytes(Paths.get(filename));
        byte[] hash = alg.digest(input);
        for (int i =0; i<hash.length;i++)
         System.out.printf("%02X", hash[i] & 0xFF);
    }

}
