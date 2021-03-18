package test_loger;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class TestNGMavenTestLog4j {
    private static final Logger LOGGER= LogManager.getLogger(TestNGMavenTestLog4j.class);

    @Test
    public void run(){
        LOGGER.debug("This is debug message");
        LOGGER.info("This is info message");
        LOGGER.warn("This is warning");
        LOGGER.error("This is an error");
        LOGGER.fatal("This is dangerous");
    }


}
