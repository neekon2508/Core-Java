package Input_Output;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;
import java.util.stream.*;
import java.util.zip.*;

public class Test {
    public static void main(String[] args) throws IOException {
        // //delete directory
        // deleteDirectory(Paths.get("Stream1"));
        zipFileSystem("test.zip");
    }
    public static void writeTextOutput() throws IOException
    {
        var out = new PrintWriter("test.txt",StandardCharsets.UTF_8);
        String name = "Harry Potter";
        double salary = 75000;
        out.print(name);
        out.print(' ');
        out.print(salary);
        out.close();
    }
    public static void BinaryData() throws FileNotFoundException, IOException
    {
        try(var out = new DataOutputStream(new FileOutputStream("test.txt")))
        {
            out.writeChars("Nghia");
        }
        try (var in = new DataInputStream(new FileInputStream("test.txt")))
        {
            char word = in.readChar();
            System.out.println(word);
        }
    }
    public static void RandomAccess() throws FileNotFoundException, IOException
    {
        try(var in = new RandomAccessFile("test.txt", "r"))
        {
            in.seek(2);
            char word = in.readChar();
            System.out.println(word);
        }
        try(var out = new RandomAccessFile("test.txt", "rw"))
        {
            out.seek(10);
            out.writeChar('T');
        }
    }
    public static void ZipArchive() throws IOException
    {
        var zout = new ZipOutputStream(new FileOutputStream("test.zip"));
        var ze = new ZipEntry("test.txt");
        zout.putNextEntry(ze);
        zout.closeEntry();
        zout.close();

        var zin = new ZipInputStream(new FileInputStream("test.zip"));
        ZipEntry entry;
        while((entry=zin.getNextEntry()) != null)
        {
            System.out.println(entry.getName());
            zin.closeEntry();
        }
        zin.close();
    }
    public static void testPath()
    {
        String userDir = System.getProperty("user.dir");
        Path userPath = Paths.get(userDir);
        System.out.println(userPath);
        Path p1 = Paths.get("/home/fred/input.txt");
        System.out.println(p1.toAbsolutePath());
        Path p2 = Paths.get("/home/harry");
        Path p3 = p1.relativize(p2);
        System.out.println(p3);
        Path p4 = Paths.get("/home/harry/../fried/./input.txt");
        System.out.println(p4.normalize().toAbsolutePath());
    }
    public static void testPath1() throws IOException
    {
        Path p = Paths.get("/home","fred","myprog.properties");
        System.out.println(p.toAbsolutePath());
        System.out.println(p.getParent().toAbsolutePath());
        System.out.println(Paths.get("test1.txt").toAbsolutePath());
        System.out.println(p.getFileName().toAbsolutePath());
        System.out.println(p.getRoot().toAbsolutePath());
        var in = new Scanner(Paths.get("test.txt"));
        System.out.println(in.nextLine());
        in.close();
    }
    public static void ReadWriteFile() throws IOException
    {
        Path p = Paths.get("test1.txt");
        //Write
        // String text = "Cr7\nMessi10\n";
        // Files.write(p, text.getBytes(StandardCharsets.UTF_16));
        // Files.write(p,text.getBytes(StandardCharsets.UTF_16), StandardOpenOption.APPEND);
        var collec = new ArrayList<String>();
        for(int i =0;i<10;++i)
        collec.add(String.valueOf(i));
        Files.write(p, collec, StandardCharsets.UTF_16);
        //Read
       
        byte[] bytes = Files.readAllBytes(p);
        String str = new String(bytes, StandardCharsets.UTF_16);
        System.out.println(str);
        var content = Files.readString(p,StandardCharsets.UTF_16);
        System.out.println(content);
        List<String> lines = Files.readAllLines(p, StandardCharsets.UTF_16);
        for(var line: lines)
        System.out.println(line);
    }
    public static void visitDirectory() throws IOException
    {
        Path p = Paths.get("Stream");
       try(Stream<Path> entries = Files.walk(p))
       {
        entries.forEach(q->System.out.println(q));
       }
        
    }
    public static void copyDirectory(Path source, Path target) throws IOException
    {
        Files.walk(source).forEach(p->
        {
            try
            {
                Path q = target.resolve(source.relativize(p));
                if (Files.isDirectory(p))
                  Files.createDirectories(q);
                else
                  Files.copy(p, q);
                
            }
            catch  (IOException e)
            {
                throw new UncheckedIOException(e);
            }
        });
    }
    public static void directStream(Path source) throws IOException
    {
        try(DirectoryStream<Path> entries = Files.newDirectoryStream(source))
        {
            for (Path entry : entries)
             System.out.println(entry);
        }
    }
    /**
     * Show the entries in directory by walkFileTree() and FileVisitor interface
     * @throws IOException
     */
    public static void directStream1() throws IOException
    {
        Files.walkFileTree(Paths.get("/"), new SimpleFileVisitor<Path>()
        {
            public FileVisitResult preVisitDirectory(Path path, BasicFileAttributes attrs) throws IOException
            {
                System.out.println(path);
                return FileVisitResult.CONTINUE;
            }

            public FileVisitResult postVisitDirectory(Path dir, IOException exc)
            {
                return FileVisitResult.CONTINUE;   
            }

            public FileVisitResult visitFileFailed(Path path, IOException exc) throws IOException
                {
                    return FileVisitResult.SKIP_SUBTREE;
                }
        });
    }
    /**
     * Delete the directory tree starting at root
     * @param source
     */
    public static void deleteDirectory(Path source) throws IOException
    {
        Files.walkFileTree(source, new SimpleFileVisitor<Path>()
        {
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException
            {
                Files.delete(file);
                return FileVisitResult.CONTINUE;
            }

            public FileVisitResult postVisitDirectory(Path dir, IOException e) throws IOException
            {
                if (e!= null) throw e;
                Files.delete(dir);
                return FileVisitResult.CONTINUE;
            }
        });
    }
    public static void zipFileSystem(String zipname) throws IOException
    {
        FileSystem fs = FileSystems.newFileSystem(Paths.get(zipname));
        //Files.copy(fs.getPath("test.txt"), Paths.get("test.txt"));
        Files.walkFileTree(fs.getPath("/"), new SimpleFileVisitor<Path>()
        {
            public FileVisitResult visitFile(Path file,BasicFileAttributes attrs) throws IOException
            {
                System.out.println(file);
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
