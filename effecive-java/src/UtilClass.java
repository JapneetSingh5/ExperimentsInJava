// Item 4: Enforce noninstantiability with a private constructor
public class UtilClass {
    // suppress default constructor to enforce non-instantiability
    private UtilClass(){
        throw new AssertionError();
    }
    // has utility methods which are closely related
}
