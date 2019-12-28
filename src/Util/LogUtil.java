package Util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author lenovo2
 */
public class LogUtil {
    public static void info(String s) {
        Logger logger = LogManager.getLogger();
        logger.info(s);
    }

    public static void error(String s) {
        Logger logger = LogManager.getLogger();
        logger.error(s);
    }
}
