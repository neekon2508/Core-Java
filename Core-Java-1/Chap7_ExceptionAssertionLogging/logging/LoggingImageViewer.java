package Chap7_ExceptionAssertionLogging.logging;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.logging.*;
import javax.swing.*;

/*
 * A modification of the image viewer program that logs various events
 * @Version 1.0 2024-07-10
 */
public class LoggingImageViewer {
    public static void main(String[] args) {
        if(System.getProperty("java.util.logging.config.class") == null
        && System.getProperty("java.util.logging.config.file") == null)
        {
            try {
                Logger.getLogger("Chap7_ExceptionAssertionLogging.logging").setLevel(Level.ALL);
                final int LOG_ROTATION_COUNT = 10;
                var handler = new FileHandler("%h/LoggingImageViewer.log", 0 ,LOG_ROTATION_COUNT);
                Logger.getLogger("Chap7_ExceptionAssertionLogging.logging").addHandler(handler);
            } catch (Exception e) {
                Logger.getLogger("Chap7_ExceptionAssertionLogging.logging").log(Level.SEVERE, "Can't create log file handler",e);
            }
        }
        EventQueue.invokeLater(() ->
        {
            var windowHandler = new WindowHandler();
            windowHandler.setLevel(Level.ALL);
            Logger.getLogger("Chap7_ExceptionAssertionLogging.logging").addHandler(windowHandler);
            

            var frame = new ImageViewerFrame();
            frame.setTitle("LoggingImageViewer");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Logger.getLogger("Chap7_ExceptionAssertionLogging.logging").fine("Showing frame");
            frame.setVisible(true);
           

        } );
    }
}
/**
 * The frame that shows the image
 */
class ImageViewerFrame extends JFrame
{
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 400;

    private JLabel label;
    private static Logger logger = Logger.getLogger("Chap7_ExceptionAssertionLogging.logging");

    public ImageViewerFrame()
    {
        logger.entering("ImageViewerFrame", "<init>");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        //set up menu bar
        var menuBar = new JMenuBar();
        setJMenuBar(menuBar);

         var menu = new JMenu("File");
         menuBar.add(menu);

         var openItem = new JMenuItem("Open");
         menu.add(openItem);
         openItem.addActionListener(new FileOpenListener());

         var exitItem = new JMenuItem("Exit");
         menu.add(exitItem);
         exitItem.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
                logger.fine("Exiting");
                System.exit(0);
            }
         });
        //use a label to display the images
        label = new JLabel();
        add(label);
        logger.exiting("ImageViewerFrame", "<init>");

    }
    private class FileOpenListener implements ActionListener
{

    @Override
    public void actionPerformed(ActionEvent e) {
       logger.entering("ImageViewerFrame.FileOpenListener", "actionPerformed", e);

       //set up file chooser
       var chooser = new JFileChooser();
       chooser.setCurrentDirectory(new File("log.txt"));

       //accect all files ending with .png
       chooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
            public boolean accept(File f)
            {
                return f.getName().toLowerCase().endsWith(".png") || f.isDirectory();
            }
            public String getDescription()
            {
                return "PNG Images";
            }
       });
       //show file chooser dialog
       int r = chooser.showOpenDialog(ImageViewerFrame.this);

       //if image file accepted, set it as icon of the label
       if (r == JFileChooser.APPROVE_OPTION)
       {
        String name = chooser.getSelectedFile().getPath();
        logger.log(Level.FINE, "Reading file {0}", name);
        label.setIcon(new ImageIcon(name));
       }
       else logger.fine(("File open dialog canceled."));
       logger.exiting("ImageViewerFrame.FileOpenListener", "actionPerformed");

    }
    
}
}


/**
 * A handler for displaying log records in a window
 */
class WindowHandler extends StreamHandler
{
    private JFrame frame;
    public WindowHandler()
    {
        frame = new JFrame();
        var output = new JTextArea();
        output.setEditable(false);
        frame.setSize(200,200);
        frame.add(new JScrollPane(output));
        frame.setFocusableWindowState(false);
        frame.setVisible(true);
        setOutputStream(new OutputStream() {
            public void write(int b)
            {

            }
            public void write(byte[] b, int off, int len) throws IOException
                {
                    output.append(new String(b,off,len));
                    try(var in = new PrintWriter("log.txt",StandardCharsets.UTF_8);)
                    {
                        in.println(new String(b,off,len));
                    }
                }
        });
    }
    public void publish(LogRecord record)
    {
        if(!frame.isVisible()) return;
        super.publish(record);
        flush();
    }
}