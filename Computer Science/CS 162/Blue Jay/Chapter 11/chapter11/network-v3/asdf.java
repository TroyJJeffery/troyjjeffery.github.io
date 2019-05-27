public class asdf
{
    private String test1;
    private String test2;
    private String test3;
    private String test4;
    public asdf()
    {
    }

    public void testVariable()
    {
        test1 = "Test";
        test1.concat(test1);
        
        System.out.println("Initial Value: Test");
        System.out.println("Expected Outcome: TestTest");
        System.out.println("Result: " + test1);
    }
    
    public void testString()
    {
        test2 = "Test";
        test2.concat("ABCDEFG");
        
        System.out.println("Initial Value: Test");
        System.out.println("Expected Outcome: TestABCDEFG");
        System.out.println("Result: " + test2);
    }
    
    public void testEmpty()
    {
        test3 = "";
        test3.concat("ZYX");
        
        System.out.println("Initial Value: " + "");
        System.out.println("Expected Outcome:  ZYX");
        System.out.println("Result: " + test3);
    }
    
    public void testVar()
    {
        test4 = "Var";
        
        test4 = test4.concat("iable");
        System.out.println(test4);
    }
    
    public void testAll()
    {
        
        testVariable();
        testString();
        testEmpty();
    }
    
}
