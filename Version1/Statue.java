package Version1;
import java.util.ArrayList;

public class Statue {
    private ArrayList<KnowledgeForProduction> statue;
    public ArrayList<KnowledgeForProduction> getStatue() {
        return statue;
    }
    public void setStatue(ArrayList<KnowledgeForProduction> statue) {
        this.statue = statue;
    }

    public Statue(ArrayList<KnowledgeForProduction> statue){
        setStatue(statue);
    }

    public boolean suitTargetStatue(Statue targetStatue){
        return targetStatue.getStatue().containsAll(statue);
    }

    public void printStatue(){
        System.out.println("--------------Statue START---------------");
        for (KnowledgeForProduction knowledgeForProduction : statue) {
            System.out.println(knowledgeForProduction);
        }
        System.out.println("--------------Statue END  ---------------");
    }
}
