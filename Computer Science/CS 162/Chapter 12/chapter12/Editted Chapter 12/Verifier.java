import java.util.HashMap;
import java.util.ArrayList;
/**
 * Write a description of class Verifier here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Verifier{
    private HashMap<String, Integer> field;
    private HashMap<String, Integer> simulator;


    public Verifier()
    {
        
    }
    
    public boolean compare(HashMap<String, Integer> field, HashMap<String, Integer> simulator){
    {
        this.field = field;
        this.simulator = simulator;
        ArrayList<String> keys = new ArrayList<String>(field.keySet());
        boolean fail = false;
        
        for(String s:keys){
            if(!fail){
                if(field.get(s) != simulator.get(s)){
                    fail = true;
                }
            }
        }
        System.out.println(fail);
        return fail;
    }
}
}