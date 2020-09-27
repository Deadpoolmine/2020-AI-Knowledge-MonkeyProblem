package Version2;

public class HB extends BaseStatue {
    private boolean isHB;
    public void setIsHB(boolean isHB){
        this.isHB = isHB;
    }

    public boolean getIsHB(){
        return this.isHB;
    }
    
    public HB(boolean isHB) {
        setIsHB(isHB);
        setType(getClass().getSimpleName());
    }

    public int checkHB(boolean isCheckLenthOnly){
        if(!isCheckLenthOnly){
            System.out.print("HB"+":"+isHB);
        }
       
        return ("HB"+":"+isHB).length();
    }
}
