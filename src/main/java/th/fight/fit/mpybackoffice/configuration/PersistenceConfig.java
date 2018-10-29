package th.fight.fit.mpybackoffice.configuration;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jndi.JndiTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource(value = {"classpath:FightFitSecretsResources.properties"})
@EnableTransactionManagement
public class PersistenceConfig {

    @Autowired
    private Environment env;

    @Bean
    public DataSource dataSource() throws Exception {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
        dataSource.setUrl(env.getProperty("jdbc.url"));
        dataSource.setUsername(env.getProperty("jdbc.username"));
        dataSource.setPassword(env.getProperty("jdbc.password"));
        return dataSource;

        //return (DataSource) new JndiTemplate().lookup(env.getProperty("datasource.jndi"));
    }

    @Bean
    public DataSourceTransactionManager getTransactionManager() throws Exception {
        DataSourceTransactionManager txManager = new DataSourceTransactionManager();

        DataSource dataSource = this.dataSource();
        txManager.setDataSource(dataSource);

        return txManager;
    }
}
