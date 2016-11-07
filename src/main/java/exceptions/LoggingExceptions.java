package exceptions;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

class LoggingExcetion extends Exception {
    private static Logger logger = Logger.getLogger("loggerException");

    public LoggingExcetion() {
        StringWriter sw = new StringWriter();
        printStackTrace(new PrintWriter(sw));
        logger.severe(sw.toString());
    }
}

public class LoggingExceptions {
    public static void main(String[] args) {
        try{
            throw new LoggingExcetion();
        }catch (LoggingExcetion e){
            System.err.println("Caught " + e);
        }


    }
}
