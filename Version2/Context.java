package Version2;

import java.util.ArrayList;

public class Context {
    private ArrayList<BaseStatue> statue = new ArrayList<>();
    private Context parentContext;
    private String bornRule;

    public String getBornRule(){
        return bornRule;
    }

    public void setBornRule(String bornRule){
        this.bornRule = bornRule;
    }


    public Context getParent(){
        return parentContext;
    }

    public void setParent(Context parentContext){
        this.parentContext = parentContext;
    }


    public ArrayList<BaseStatue> getStatue(){
        return statue;
    }

    public void setStatue(ArrayList<BaseStatue> statue){
        //this.statue.clear();
        this.statue = statue;
    }

    public Context(ArrayList<BaseStatue> statue){
        this.statue.clear();
        this.statue.addAll(statue);
    }

    public Context(Context context){
        this.statue.addAll(context.getStatue());
        this.parentContext = context.getParent();
    }

    private void printLine(int spaceLen1, int spaceLen2, String content){
        for (int i = 1; i <= spaceLen1 ; i++) {
            System.out.print(" ");
        }
        System.out.print(content);
        for(int i = 1; i <= spaceLen2; i++) {
            System.out.print(" ");
        }
        System.out.println("");
    }

    public void checkStatues(){
        String startTip = "--------------Statue START---------------";
        String endTip = "--------------Statue End  ---------------";
        int totalLen = startTip.length();
        int len = 0;
        int spaceLen1 = 0;
        int spaceLen2 = 0;
        int spaceArrowLeft = 0;
        int spaceArrowRight = 0;

        len = "⬇".length();
        spaceArrowLeft = (totalLen - len)/ 2;
        spaceArrowRight = totalLen - spaceLen1 - len;

        
        /**
         * 打印下箭头
         */
        printLine(spaceArrowLeft, spaceArrowRight, "⬇");
        /**
         * 打印出生规则
         */
        if(getBornRule() != null){
            int lenRule = getBornRule().length();
            spaceLen1 = (totalLen - lenRule)/ 2;
            spaceLen2 = totalLen - spaceLen1 - lenRule;
            printLine(spaceLen1, spaceLen2, getBornRule());
            /**
             * 打印下箭头
             */
            printLine(spaceArrowLeft, spaceArrowRight, "⬇");
        }
        /**
         * 打印开头
         */
        System.out.println(startTip);
        /**
         * 打印所有状态
         */
        for (BaseStatue baseStatue : this.statue) {
            switch (baseStatue.getType()) {
                case BaseStatue.AT:
                    len = ((AT)baseStatue).checkAT(true);
                    spaceLen1 = (totalLen - len - 2) / 2;
                    spaceLen2 = totalLen - 2 - len - spaceLen1;
                    System.out.print("|");
                    for (int i = 1; i <= spaceLen1 ; i++) {
                        System.out.print(" ");
                    }
                    ((AT)baseStatue).checkAT(false);
                    for(int i = 1; i <= spaceLen2; i++) {
                        System.out.print(" ");
                    }
                    System.out.print("|");
                    
                    break;
                case BaseStatue.HB:
                    len = ((HB)baseStatue).checkHB(true);
                    spaceLen1 = (totalLen - len - 2) / 2;
                    spaceLen2 = totalLen - 2 - len - spaceLen1;
                    System.out.print("|");
                    for (int i = 1; i <= spaceLen1 ; i++) {
                        System.out.print(" ");
                    }
                    ((HB)baseStatue).checkHB(false);
                    for(int i = 1; i <= spaceLen2; i++) {
                        System.out.print(" ");
                    }
                    System.out.print("|");
                    break;
                case BaseStatue.ONBOX:
                    len = ((ONBOX)baseStatue).checkONBOX(true);
                    spaceLen1 = (totalLen - len - 2) / 2;
                    spaceLen2 = totalLen - 2 - len - spaceLen1;
                    System.out.print("|");
                    for (int i = 1; i <= spaceLen1 ; i++) {
                        System.out.print(" ");
                    }
                    ((ONBOX)baseStatue).checkONBOX(false);
                    for(int i = 1; i <= spaceLen2; i++) {
                        System.out.print(" ");
                    }
                    System.out.print("|");
                    break;
                default:
                    break;
            }
            System.out.println("");
        }
        System.out.println(endTip);

        
    }

    

    public boolean suitTargetContext(Context context){
        return suitTargetStatue(context.getStatue());
    }

    public boolean suitTargetStatue(ArrayList<BaseStatue> statues){
        for (BaseStatue requiredStatue : statues) {
            boolean isContain = false;
            for (BaseStatue thisStatue : this.statue) {
                if(thisStatue.sameAs(requiredStatue)){
                    isContain = true;
                    break;
                }
            }
            if(!isContain){
                return false;
            }
            /*if(!this.statue.contains(baseStatue)){
                return false;
            }*/
        }
        return true;
    }

    public int findStatue(BaseStatue statue){
        for (BaseStatue baseStatue : this.statue) {
            if(baseStatue.sameAs(statue)){
                return this.statue.indexOf(baseStatue);
            }
        }
        return -1;
    }

}
