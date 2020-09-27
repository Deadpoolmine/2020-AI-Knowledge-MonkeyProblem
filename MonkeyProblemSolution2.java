import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import Version2.*;
import Version2.Object;

public class MonkeyProblemSolution2 {
    private static Context initContext;
    private static Context currentContext;
    private static Context targetContext;

    /**
     * currentContext = Knowledge.GOTO(initContext, Location.A, Location.B);
     * currentContext.checkStatues();
     * currentContext = Knowledge.PUSHBOX(currentContext, Location.B, Location.C);
     * currentContext.checkStatues();
     * currentContext = Knowledge.CLIMBBOX(currentContext, Location.C);
     * currentContext.checkStatues();
     * currentContext = Knowledge.GRASP(currentContext);
     * currentContext.checkStatues();
     */
            
    public static void solve() {
        System.out.println("");
        System.out.println("----------------Solution2:---------------");
        initContexts();
        Queue<Context> contextQueue = new LinkedList<>();
        contextQueue.add(currentContext);
        
        while (!contextQueue.isEmpty() && !currentContext.suitTargetContext(targetContext)) {
            currentContext = contextQueue.poll();
            /**
             * Process GOTO
             */
            for (Location locationU : Location.values()) {
                for(Location locationV : Location.values()){
                    Context newContext = Knowledge.GOTO(currentContext, locationU, locationV);
                    if(!newContext.suitTargetContext(currentContext)){
                        newContext.setBornRule("GOTO"+"("+locationU.name()+","+locationV.name()+")");
                        newContext.setParent(currentContext);
                        contextQueue.offer(newContext);
                    }
                    
                }
            }
            /**
             * Process PUSH
             */
            for (Location locationU : Location.values()) {
                for(Location locationV : Location.values()){
                    Context newContext = Knowledge.PUSHBOX(currentContext, locationU, locationV);
                    if(!newContext.suitTargetContext(currentContext)){
                        newContext.setBornRule("PUSHBOX"+"("+locationU.name()+","+locationV.name()+")");
                        newContext.setParent(currentContext);
                        contextQueue.offer(newContext);
                    }
                }
            }
            /**
             * Process ClIMB
             */
            for (Location location : Location.values()) {
                Context newContext = Knowledge.CLIMBBOX(currentContext, location);
                if(!newContext.suitTargetContext(currentContext)){
                    newContext.setBornRule("CLIMB"+"("+location.name()+")");
                    newContext.setParent(currentContext);
                    contextQueue.offer(newContext);
                }
            }
            /**
             * Process GRASP
             */
            Context newContext = Knowledge.GRASP(currentContext);
            if(!newContext.suitTargetContext(currentContext)){
                newContext.setBornRule("GRASP"+"("+")");
                newContext.setParent(currentContext);
                contextQueue.offer(newContext);
            }
        }

        Stack<Context> contextStack = new Stack<>();
        while(currentContext != null){
            contextStack.add(currentContext);
            currentContext = currentContext.getParent();
        }
        while(!contextStack.isEmpty()){
            Context context = contextStack.pop();
            context.checkStatues();
        }
        
    }

    public static void initContexts() {
        AT atMonkey = new AT(Object.Monkey, Location.A);
        AT atBox = new AT(Object.Box, Location.B);
        ONBOX onbox = new ONBOX(false);
        HB hb = new HB(false);
        initContext = new Context(new ArrayList<BaseStatue>(
            Arrays.asList(
                atMonkey,
                atBox,
                onbox,
                hb  
            )
        ));
        initContext.setParent(null);

        AT atTargetMonkey = new AT(Object.Monkey, Location.C);
        AT atTargetBox = new AT(Object.Box, Location.C);
        ONBOX onboxTarget = new ONBOX(true);
        HB hbTarget = new HB(true);
        targetContext = new Context(new ArrayList<BaseStatue>(
            Arrays.asList(
                atTargetMonkey,
                atTargetBox,
                onboxTarget,
                hbTarget  
            )
        ));
        targetContext.setParent(null);

        currentContext = initContext;
    }


}
