import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Arrays;

/**
 * Write a description of class CompareList here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CompareList
{
    private LinkedList<String> link = new LinkedList<>();
    private ArrayList<String> array = new ArrayList<>();
    private List<String> digits = new ArrayList<>();
    private Random rand = new Random();
    
    public CompareList()
    {
      makeDigits();
    }

    public void printDigits()
    {
        makeDigits();
        System.out.println(digits);
    }
    
    private void makeDigits()
    { 
                String[] s = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
                              "k", "l", "m", "n", "o", "p", "q", "r", "s", 
                              "t", "u", "v", "w", "x", "y", "z"};
                digits.addAll(Arrays.asList(s));
    }
    
    private int getRandom()
    {
        int n = rand.nextInt(10) + 1;
        
        while(n>0 == false){
            n = rand.nextInt(10) + 1;
        }
        return n;
    }
    
    private String getDigit()
    {
        String d = new String();
        
        d = digits.get(rand.nextInt(25)+1);
        
        return d;
    }
    
    private String getWord()
    {
        int length = getRandom();
        String s = new String();
        
        for(int i = 0; i < length; i++){
            s = s.concat(getDigit());
        }
        return s;
    }
    
    private long makeLinkedList()
    {
        long startTime = System.currentTimeMillis();
        
        for(int i = 0;i <10000;i++){
            link.add(getWord());
        }
        long endTime = System.currentTimeMillis();
        
        long duration = (endTime - startTime);
        System.out.println("makeLinkList " + duration + " ms");
        return duration;
    }
    
    private long makeArrayList()
    {
        long startTime = System.currentTimeMillis();
        
        for(int i = 0;i <10000;i++){
            array.add(getWord());
        }
        long endTime = System.currentTimeMillis();
        
        long duration = (endTime - startTime);
        System.out.println("makeArrayList " + duration + " ms");
        return duration;
    }
    
    private long getArrayItem()
    {
        long startTime = System.currentTimeMillis();
        
        array.get(5000);
        
        long endTime = System.currentTimeMillis();
        
        long duration = (endTime - startTime);
        System.out.println("getArrayItem " + duration + " ms");
        return duration;
    }
    
    private long getLinkItem()
    {
        long startTime = System.currentTimeMillis();
        
        link.get(5000);
        
        long endTime = System.currentTimeMillis();
        
        long duration = (endTime - startTime);
        System.out.println("getLinkItem " + duration + " ms");
        return duration;
    }
    
    private long removeArrayItem()
    {
        long startTime = System.currentTimeMillis();
        
        array.remove(5000);
        
        long endTime = System.currentTimeMillis();
        
        long duration = (endTime - startTime);
        System.out.println("removeArrayItem " + duration + " ms");
        return duration;
    }
    
        private long removeLinkItem()
    {
        long startTime = System.currentTimeMillis();
        
        link.remove(5000);
        
        long endTime = System.currentTimeMillis();
        
        long duration = (endTime - startTime);
        System.out.println("removeLinkItem " + duration + " ms");
        return duration;
    }
    
    public void test()
    {
        long x = makeArrayList() + getArrayItem() + removeArrayItem();
        long y = makeLinkedList() + getLinkItem() + removeLinkItem();
        
        System.out.println("ArrayList Time: " + x);
        System.out.println("LinkedList Time: " + y);
    }
    
}