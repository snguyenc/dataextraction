package com.trues.service;

import com.trues.config.ServiceConfig;
import com.trues.config.model.Env;
import com.trues.config.model.Environments;
import com.trues.util.TrueUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * User: son.nguyen
 * Date: 10/24/13
 * Time: 9:36 PM
 * This is  main class for init the resource (dbconfig.xml) from local file and init database connection pool...
 * This class is also entry point for calling the services , it provide some static method for you can call everywhere.
 * AISService.GetPackagePrepaid("aa",123);
 */
public class TRUEExtractionService {

    private static Logger logger = LoggerFactory.getLogger(TRUEExtractionService.class);
    private static String DEFAULT_CONFIG_PATH = "data-extraction.xml";
    private static ExtractionService extractionService;

    private final static String dateFormat = "yyyyMMddHHmmss";

    private static Env activeEnv;


    private static boolean serviceStart = false;

    public static void main(String args[]) {
        String startDate, endDate;
        try {
            initService();
            if (args != null && args.length >= 2) {
                startDate = args[0];
                endDate = args[1];
                logger.info("reading params from stdin {} {}", startDate, endDate);
            } else {
                String[] beforeDate = TrueUtils.getBeforeDate(dateFormat);
                startDate = beforeDate[0];
                endDate = beforeDate[1];
                logger.info("get default date {} {}", startDate, endDate);
            }
            activeEnv.setStarDate(startDate);
            activeEnv.setEndDate(endDate);
            extractionService.doExtractText();
        } catch (Exception e) {
            logger.error("", e);
        }
    }
    /**
     * for init the service at beginning.
     * @throws Exception
     */
    public static void initService() throws Exception {
        if (serviceStart == false) {
            String path = TrueUtils.getConfigFile(null, DEFAULT_CONFIG_PATH, 0);
            InputStream inputStream = null;
            if (path != null) {
                logger.info("===== Init service ===== " + path);
                inputStream = new FileInputStream(new File(path));
            } else {
                //load config from classpath
                logger.info("===== Init service from Class path =====");
                ClassPathResource cpr = new ClassPathResource(DEFAULT_CONFIG_PATH);
                inputStream = cpr.getInputStream();
            }
            //map xml config to object
            Environments environments = ServiceConfig.parse(inputStream);
            //get active environment
            activeEnv = environments.getActiveEnv();
            logger.info("===== Using profile: " + activeEnv.getName());
            //init database connection and convert all config list to map
            activeEnv.intDatasource();
            extractionService = new ExtractionService(activeEnv);
            serviceStart = true;
        }
    }





}
