package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.Properties;

public class ReadConfigFiles {
    private static final Logger LOGGER= LogManager.getLogger(ReadConfigFiles.class);

    public Properties getPropertyValue() throws IOException {
        Properties prop=new Properties();
        InputStream inputStream=null;
        try{
            String propFileName="config.properties";
            inputStream=getClass().getClassLoader().getResourceAsStream(propFileName);
            if(inputStream !=null){
                prop.load(inputStream);
            }else {
                throw new FileNotFoundException("property file"+propFileName+"not found in the classpath");
            }

        }catch(Exception e){
      LOGGER.error("Exception is:"+e.getMessage());
        }finally {
            inputStream.close();
        }


        return prop;
    }
}
