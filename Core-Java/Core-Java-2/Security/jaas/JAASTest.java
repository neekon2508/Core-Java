package Security.jaas;

import java.awt.*;
import javax.swing.*;

/**
 * This program authenticates a user via a custom login and then looks up a system property 
 * with the user's privileges
 * @version 1.0 2024-09-23
 * @author Neekon
 */
public class JAASTest {
    public static void main(String[] args) {
        System.setSecurityManager(new SecurityManager());
      EventQueue.invokeLater(() ->
         {
            var frame = new JAASFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setTitle("JAASTest");
            frame.setVisible(true);
         });
    }
}
