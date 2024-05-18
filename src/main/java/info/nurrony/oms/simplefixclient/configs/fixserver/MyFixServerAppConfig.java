package info.nurrony.oms.simplefixclient.configs.fixserver;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import quickfix.Application;
import quickfix.ConfigError;
import quickfix.Initiator;
import quickfix.JdbcLogFactory;
import quickfix.JdbcStoreFactory;
import quickfix.LogFactory;
import quickfix.MessageFactory;
import quickfix.MessageStoreFactory;
import quickfix.SessionSettings;
import quickfix.ThreadedSocketInitiator;

@Configuration
public class MyFixServerAppConfig {

    @Bean
    public Application clientApplication(final SessionSettings sessionSettings) {
        return new MyQuickfixApplication(sessionSettings);
    }

    @Bean
    public Initiator clientInitiator(Application clientApplication,
            MessageStoreFactory clientMessageStoreFactory,
            SessionSettings clientSessionSettings, LogFactory clientLogFactory,
            MessageFactory clientMessageFactory) throws ConfigError {

        return new ThreadedSocketInitiator(clientApplication, clientMessageStoreFactory, clientSessionSettings,
                clientLogFactory, clientMessageFactory);
    }

    // @Bean
    // public LogFactory clientLogFactory(SessionSettings clientSessionSettings) {
    // return new FileLogFactory(clientSessionSettings);
    // }

    @Bean
    public MessageStoreFactory clientMessageStoreFactory(SessionSettings clientSessionSettings, DataSource dataSource) {
        JdbcStoreFactory jdbcStoreFactory = new JdbcStoreFactory(clientSessionSettings);
        jdbcStoreFactory.setDataSource(dataSource);
        return jdbcStoreFactory;
    }

    @Bean
    public LogFactory clientLogFactory(SessionSettings clientSessionSettings, DataSource dataSource) {
        JdbcLogFactory jdbcLogFactory = new JdbcLogFactory(clientSessionSettings);
        jdbcLogFactory.setDataSource(dataSource);
        return jdbcLogFactory;
    }
}
