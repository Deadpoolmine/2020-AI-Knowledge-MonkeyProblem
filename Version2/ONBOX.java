package Version2;

public class ONBOX extends BaseStatue {
    private boolean isONBOX;
    public void setIsOnBOX(boolean isONBOX){
        this.isONBOX = isONBOX;
    }

    public boolean getIsOnBOX(){
        return this.isONBOX;
    }
    
    public ONBOX(boolean isONBOX) {
        setIsOnBOX(isONBOX);
        setType(getClass().getSimpleName());
    }

    public int checkONBOX(boolean isCheckLengthOnly){
        if(!isCheckLengthOnly){
            System.out.print("ONBOX"+":"+isONBOX);
        }
        return ("ONBOX"+":"+isONBOX).length();
    }
}
