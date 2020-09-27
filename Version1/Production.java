package Version1;
/**
 * Production
 */
public class Production {
    private Statue pre;
    private Statue cons;
    
    public Statue getPre() {
        return pre;
    }

    public void setStatue(Statue pre){
        this.pre = pre;
    }

    public Statue getCons() {
        return cons;
    }

    public void setCons(Statue cons){
        this.cons = cons;
    }

    public Production(Statue pre, Statue cons){
        this.pre = pre;
        this.cons = cons;
    }
    
    /**
     * 
     * @param pre   前置条件
     * @return      返回前置条件是否满足
     */
    public boolean suitPre(Statue pre) {
        for (KnowledgeForProduction knowledgeForProduction : this.pre.getStatue()) {
            if(pre.getStatue().contains(knowledgeForProduction) == false){
                return false;
            }
        }
        return true;
    }    
}
