package Version2;

import java.util.ArrayList;
import java.util.Arrays;

public class Knowledge {

    public static Context GOTO(Context context, Location u, Location v){
        AT requiredAT = new AT(Object.Monkey, u);
        ONBOX requiredOnbox = new ONBOX(false);
        Context newContext = new Context(context);
        if(newContext.suitTargetStatue(new 
        ArrayList<BaseStatue>(Arrays.asList(requiredAT,requiredOnbox)))){
            ArrayList<BaseStatue> statues = newContext.getStatue();
            int index = newContext.findStatue(requiredAT);
            statues.remove(index);
            AT newAT = new AT(Object.Monkey, v);
            statues.add(newAT);
            newContext.setStatue(statues);
        }
        return newContext;
    }

    public static Context PUSHBOX(Context context, Location v, Location w){
        AT requiredAT1 = new AT(Object.Monkey, v);
        AT requiredAT2 = new AT(Object.Box, v);
        ONBOX requiredOnbox = new ONBOX(false);
        Context newContext = new Context(context);
        if(newContext.suitTargetStatue(new 
        ArrayList<BaseStatue>(Arrays.asList(requiredAT1,requiredAT2,requiredOnbox)))){
            ArrayList<BaseStatue> statues = newContext.getStatue();
            int index = newContext.findStatue(requiredAT1);
            statues.remove(index);
            index = newContext.findStatue(requiredAT2);
            statues.remove(index);

            AT newAT1 = new AT(Object.Monkey, w);
            AT newAT2 = new AT(Object.Box, w);
            statues.add(newAT1);
            statues.add(newAT2);
            
            newContext.setStatue(statues);
        }
        return newContext;
    }

    public static Context CLIMBBOX(Context context, Location w){
        AT requiredAT1 = new AT(Object.Monkey, w);
        AT requiredAT2 = new AT(Object.Box, w);
        ONBOX requiredOnbox = new ONBOX(false);
        Context newContext = new Context(context);
        if(newContext.suitTargetStatue(new 
        ArrayList<BaseStatue>(Arrays.asList(requiredAT1,requiredAT2,requiredOnbox)))){
            ArrayList<BaseStatue> statues = newContext.getStatue();
            int index = newContext.findStatue(requiredOnbox);
            statues.remove(index);

            ONBOX newOnbox = new ONBOX(true);
            statues.add(newOnbox);
            
            newContext.setStatue(statues);
        }
        return newContext;
    }

    public static Context GRASP(Context context){
        AT requiredAT = new AT(Object.Box, Location.C);
        ONBOX requiredOnbox = new ONBOX(true);
        HB requiredHB = new HB(false);

        Context newContext = new Context(context);
        if(newContext.suitTargetStatue(new 
        ArrayList<BaseStatue>(Arrays.asList(requiredAT,requiredHB,requiredOnbox)))){
            ArrayList<BaseStatue> statues = newContext.getStatue();
            int index = newContext.findStatue(requiredHB);
            statues.remove(index);

            HB newHB = new HB(true);
            statues.add(newHB);
            
            newContext.setStatue(statues);
        }
        return newContext;
    }    
}
