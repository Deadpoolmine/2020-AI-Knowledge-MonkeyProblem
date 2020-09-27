package Version2;


public class BaseStatue {
    
    public static final String AT = "AT";
    public static final String HB = "HB";
    public static final String ONBOX = "ONBOX";

    private String type;
    public String getType(){
        return this.type;
    }
    public void setType(String type){
        this.type = type;
    }

    public boolean sameAs(BaseStatue statue){
        boolean isSame = false;
        if(statue.getType() == getType()){
            switch (statue.getType()) {
                case AT:
                    if(((AT)statue).getWho() == ((AT)this).getWho()
                    && ((AT)statue).getWhere() == ((AT)this).getWhere())
                        isSame = true;
                    break;
                case ONBOX:
                    if(((ONBOX)statue).getIsOnBOX() == ((ONBOX)this).getIsOnBOX())
                        isSame = true;
                    break;
                case HB:
                    if(((HB)statue).getIsHB() == ((HB)this).getIsHB())
                        isSame = true;
                    break;
                default:
                    break;
            }
        }
        return isSame;
    }
}
