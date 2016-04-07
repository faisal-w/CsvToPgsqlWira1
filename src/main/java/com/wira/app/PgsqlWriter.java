package com.wira.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

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

    public void insertData(final List<Location> locations) throws Exception{
        //SimpleJdbcCall call = new SimpleJdbcCall(this.getJdbcTemplate());
        //call.withSchemaName("gis_project");
        String qTemplUpdate = "UPDATE gis_project.info_aset_bangunan " +
                              "SET location = ST_GeomFromText('POINT(?,?)',4326) " +
                              "WHERE fid = ?";
        //http://docs.spring.io/spring-framework/docs/2.0.x/api/org/springframework/jdbc/core/JdbcTemplate.html#update%28java.lang.String,%20java.lang.Object[]%29
        //http://www.mkyong.com/spring/spring-jdbctemplate-batchupdate-example/
        getJdbcTemplate().batchUpdate(qTemplUpdate, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Location loc = locations.get(i);
                ps.setObject(1,loc.getX());
                ps.setObject(2,loc.getY());
                ps.setInt(3,loc.getFid());
            }

            @Override
            public int getBatchSize() {
                return 0;
            }
        });
    }

}
