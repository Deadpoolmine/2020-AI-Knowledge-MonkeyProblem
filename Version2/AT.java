package Version2;


public class AT extends BaseStatue {
    
    private Object who;
    public Object getWho(){
        return this.who;
    }

    private Location where;
    public Location getWhere(){
        return this.where;
    }

    public AT(Object who, Location where){
        this.who = who;
        this.where = where;
        setType(getClass().getSimpleName());
    }

    public int checkAT(boolean isCheckLenthOnly){
        if(!isCheckLenthOnly){
            System.out.print("AT"+"("+who.name() +","+ where.name() +")");
        }
        
        return ("AT"+"("+who.name() +","+ where.name() +")").length();
    }
    
}
