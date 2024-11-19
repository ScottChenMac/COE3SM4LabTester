import java.io.*;

public class TestHelloWorld {
    
    private static boolean passed = true;
    
    public static void Test1()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        HelloWorld.main(null);

        // assertion
        passed &= assertEqualString("3 + 4 = 11 \n", bos.toString());

        // undo the binding in System
        System.setOut(originalOut);
    }   
    
    public static void main(String[] args)
    {
        Test1();

        // so to force a usable return code
        if(passed)  System.exit(0);
        else        System.exit(-1);
    }

    private static boolean assertEqualString(String a, String b)
    {
        return a.equals(b);
    }
}
