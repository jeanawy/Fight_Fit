package th.fight.fit.mpybackoffice.dao;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BaseDao  {

	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	protected static final String CREATE_DATE = "CREATE_DATE";
	protected static final String CREATE_BY = "CREATE_BY";
	protected static final String UPDATE_DTTM = "UPDATE_DATE";
	protected static final String UPDATE_BY = "UPDATE_BY";
	
	@PostConstruct
    public void afterPropertiesSet() throws Exception {
        if (dataSource == null) {
            throw new BeanCreationException("Must set dataSource on " + this.getClass().getName());
        }
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        
    }
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

}
