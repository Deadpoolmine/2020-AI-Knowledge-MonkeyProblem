import java.util.ArrayList;
import java.util.Arrays;
import Version1.*;
public class MonkeyProblemSolution1 {
   
//#region Version 1 A little Hard Code
    private static ArrayList<Production> knowledges;
    private static Statue initStatu;
    private static Statue currentStatu;
    private static Statue endStatu;

    public static void solve() {
        System.out.println("");
        System.out.println("----------------Solution2:---------------");
        initStatue();
        constructKnowledge();
        while(!currentStatu.suitTargetStatue(endStatu)){
            for (Production production : knowledges) {
                if(production.suitPre(currentStatu)){
                    changeStatus(production.getCons());
                    break;
                }
            }
        }        
    }    
    private static void changeStatus(Statue cons) {
        System.out.println("从状态：");
        currentStatu.printStatue();
        System.err.println("到状态：");
        cons.printStatue();
        currentStatu = cons;
    }
    public static void initStatue() {
        initStatu = new Statue(new ArrayList<>(Arrays.asList(
           KnowledgeForProduction.MONKEY_AT_A,
           KnowledgeForProduction.BOX_AT_B,
           KnowledgeForProduction.MONKEY_NOT_ON_BOX 
        )));

        endStatu = new Statue(new ArrayList<>(Arrays.asList(
           KnowledgeForProduction.MONKEY_GOT_BALANA 
        )));

        currentStatu = initStatu;
    }
    public static void constructKnowledge() {
        knowledges = new ArrayList<Production>();
        Production production1 = new Production(
            new Statue(new ArrayList<KnowledgeForProduction>(Arrays.asList(
                KnowledgeForProduction.MONKEY_AT_A,
                KnowledgeForProduction.MONKEY_NOT_ON_BOX,
                KnowledgeForProduction.BOX_AT_B))),
            new Statue(new ArrayList<KnowledgeForProduction>(Arrays.asList(
                KnowledgeForProduction.MONKEY_AT_C,
                KnowledgeForProduction.MONKEY_NOT_ON_BOX,
                KnowledgeForProduction.BOX_AT_B))) 
            );

        Production production2 = new Production(
            new Statue(new ArrayList<KnowledgeForProduction>(Arrays.asList(
                KnowledgeForProduction.MONKEY_AT_C,
                KnowledgeForProduction.MONKEY_NOT_ON_BOX,
                KnowledgeForProduction.BOX_AT_B))),
            new Statue(new ArrayList<KnowledgeForProduction>(Arrays.asList(
                KnowledgeForProduction.MONKEY_AT_B,
                KnowledgeForProduction.MONKEY_NOT_ON_BOX,
                KnowledgeForProduction.BOX_AT_B))) 
            );

        Production production3 = new Production(
            new Statue(new ArrayList<KnowledgeForProduction>(Arrays.asList(
                KnowledgeForProduction.MONKEY_AT_B,
                KnowledgeForProduction.MONKEY_NOT_ON_BOX,
                KnowledgeForProduction.BOX_AT_B))),
            new Statue(new ArrayList<KnowledgeForProduction>(Arrays.asList(
                KnowledgeForProduction.MONKEY_AT_C,
                KnowledgeForProduction.BOX_AT_C,
                KnowledgeForProduction.MONKEY_NOT_ON_BOX))) 
            );

        Production production4 = new Production(
            new Statue(new ArrayList<KnowledgeForProduction>(Arrays.asList(
                KnowledgeForProduction.MONKEY_AT_C,
                KnowledgeForProduction.MONKEY_NOT_ON_BOX,
                KnowledgeForProduction.BOX_AT_C))),
            new Statue(new ArrayList<KnowledgeForProduction>(Arrays.asList(
                KnowledgeForProduction.MONKEY_AT_C,
                KnowledgeForProduction.BOX_AT_C,
                KnowledgeForProduction.MONKEY_ON_BOX))) 
            );

        Production production5 = new Production(
            new Statue(new ArrayList<KnowledgeForProduction>(Arrays.asList(
                KnowledgeForProduction.MONKEY_AT_C,
                KnowledgeForProduction.MONKEY_ON_BOX,
                KnowledgeForProduction.BOX_AT_C))),
            new Statue(new ArrayList<KnowledgeForProduction>(Arrays.asList(
                KnowledgeForProduction.MONKEY_GRASP_BALANA,
                KnowledgeForProduction.BOX_AT_C,
                KnowledgeForProduction.MONKEY_AT_C))) 
            );

        Production production6 = new Production(
            new Statue(new ArrayList<KnowledgeForProduction>(Arrays.asList(
                KnowledgeForProduction.MONKEY_GRASP_BALANA,
                KnowledgeForProduction.BOX_AT_C,
                KnowledgeForProduction.MONKEY_AT_C))),
            new Statue( new ArrayList<KnowledgeForProduction>(Arrays.asList(
                KnowledgeForProduction.MONKEY_GOT_BALANA))) 
            );

        
        knowledges.add(production1);
        knowledges.add(production2);
        knowledges.add(production3);
        knowledges.add(production4);
        knowledges.add(production5);
        knowledges.add(production6);
            
    }
//#endregion

}
