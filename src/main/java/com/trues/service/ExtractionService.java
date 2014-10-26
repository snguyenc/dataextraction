package com.trues.service;

import com.trues.config.model.Env;
import com.trues.config.model.Report;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.List;

/**
 * User: son.nguyen
 * Date: 10/27/13
 * Time: 9:16 AM
 */
public class ExtractionService {

    private Logger logger = LoggerFactory.getLogger(ExtractionService.class);

    private Env config;

    public ExtractionService(Env config) {
        this.config = config;
    }


    public void doExtractText() throws Exception {
        List<Report> reports = config.getReports();
        for (Report report : reports) {
            logger.info("extrac for report {} ", report.getName());
            File folder = new File(report.getDirectory());
            folder.mkdirs();

            File file = new File(folder, "aa.csv");
            if ("SQL".equals(report.getQueryType())) {
                logger.info(" query type {} {}", report.getQueryType(), report.getQuery());

            }



        }

    }


}
