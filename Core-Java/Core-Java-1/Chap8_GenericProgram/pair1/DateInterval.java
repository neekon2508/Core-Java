package Chap8_GenericProgram.pair1;
import java.time.*;
public class DateInterval extends Pair<LocalDate>{

    @Override
    public void setSecond(LocalDate second) {
        if(second.compareTo(getFirst()) >= 0)
        super.setSecond(second);
    }
    
}
