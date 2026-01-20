package Security.jaas;

import java.security.*;
import java.util.*;

/**
 * A principal with a named value (such as "role=HR" or "username=harry")
 */
public class SimplePrincipal implements Principal{

    private String descr;
    //private String value;

    /**
     * Constructs a SimplePrincipal to hold a description and a value
     * @param descr the description
     * @param value the associated value
     */
    public SimplePrincipal(String descr)
    {
        this.descr = descr;
        //this.value = value;
    }
    @Override
    public String getName() {
       return descr;
    }

    public boolean equals(Object o)
    {
        if (o == null)
                return false;

        if (this == o)
            return true;

        if (!(o instanceof SimplePrincipal))
            return false;
        SimplePrincipal that = (SimplePrincipal)o;

        return descr.equals(that.getName());
    }

    public int hashCode()
    {
        return Objects.hashCode(getName());
    }

}
