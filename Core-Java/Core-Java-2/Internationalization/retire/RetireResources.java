package Internationalization.retire;
import java.awt.*;

/**
 * These are the English non-string resources for the retirement calculator
 * @version 1.0 2024-09-12
 * @author Neekon
 */
public class RetireResources extends java.util.ListResourceBundle {
    private static final Object[][] contents = {
        //BEGIN LOCALIZE
        {"colorPre",  Color.blue}, {"colorGain", Color.white}, {"colorLoss", Color.red}
        //END LOCALIZE
    };

    public Object[][] getContents()
    {
        return contents;
    }

}
