package com.wira.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

/**
 * From tutorial here :
 * http://postgresintl.blogspot.co.id/2014/04/using-postgresql-jdbc-with-spring.html
 */

@Transactional
@Repository
public class PgsqlWriter extends JdbcDaoSupport {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public PgsqlWriter(DataSource dataSource){
        setDataSource(dataSource);
    }

    public void insertData() throws Exception{
        //SimpleJdbcCall call = new SimpleJdbcCall(this.getJdbcTemplate());
        //call.withSchemaName("gis_project");
        String myQuery = "UPDATE x FROM gis_project.info_aset_bangunan WHERE ";
        jdbcTemplate.query(myQuery);

    }

}
