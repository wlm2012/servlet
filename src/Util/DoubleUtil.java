package Util;

import java.math.BigDecimal;

public class DoubleUtil {
    public static double format(int n,double d){
        BigDecimal bigDecimal=BigDecimal.valueOf(d);
        return bigDecimal.setScale(n,BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
