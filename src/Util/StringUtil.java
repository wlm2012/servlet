package Util;

public class StringUtil {
    public static Boolean isEmpty(String s){
        if (s==null){
            return true;
        }
        if (s.trim().length()==0){
            return true;
        }
        return false;
    }




}
