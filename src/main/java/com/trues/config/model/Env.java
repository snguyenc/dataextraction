package com.trues.config.model;

import com.trues.util.TrueUtils;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class Env {

    private String name;
    private String starDate;
    private String endDate;

    private DataSource dataSource;
    private javax.sql.DataSource realDataSource;
    private JdbcTemplate jdbcTemplate;

    private String connectionString;

    List<Report> reports = new ArrayList<Report>();

    public void intDatasource() {
        realDataSource = TrueUtils.initDataSource(dataSource);
        jdbcTemplate = TrueUtils.initJdbcTemplate(realDataSource);
        jdbcTemplate.setResultsMapCaseInsensitive(true);
        connectionString = dataSource.getUrl() + "/" + dataSource.getUsername();
    }
    public String getName() {
        return name;
    }


    public String getStarDate() {
        return starDate;
    }

    public String getSubStarDate() {
        return starDate.substring(0, 8);
    }

    public void setStarDate(String starDate) {
        this.starDate = starDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public javax.sql.DataSource getRealDataSource() {
        return realDataSource;
    }

    public void setRealDataSource(javax.sql.DataSource realDataSource) {
        this.realDataSource = realDataSource;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String getConnectionString() {
        return connectionString;
    }

    public void setConnectionString(String connectionString) {
        this.connectionString = connectionString;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Report> getReports() {
        return reports;
    }

    public void setReports(List<Report> reports) {
        this.reports = reports;
    }
}
