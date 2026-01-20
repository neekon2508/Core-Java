package timer;

 
 import java.awt.*;
  import java.awt.event.*; import java.time.*;
 import javax.swing.*;
 
public class TimerTest
{ 
public static void main(String[] args)
 { 
    var listener = new TimePrinter();
    var timer = new Timer(1000, listener);
    timer.start();
   


}
 }
 
class TimePrinter implements ActionListener
{

    @Override
    public void actionPerformed(ActionEvent e) {
       System.out.println(Instant.ofEpochMilli(e.getWhen()));
       Toolkit.getDefaultToolkit().beep();
    }
    
}
