package Model;

import com.mysql.cj.jdbc.MysqlDataSource;

/**
 *
 * @author Martin Frederiksen
 */
public class DataSourceMySql {

    private static MysqlDataSource dataSource = new MysqlDataSource();
    private static MysqlDataSource localDataSource = new MysqlDataSource();

    public DataSourceMySql() {
        {
            try {
                dataSource.setServerName("127.0.0.1");
                dataSource.setPort(3306);
                dataSource.setDatabaseName("LegoHouse");
                dataSource.setUser("root");
                dataSource.setPassword("root");
                dataSource.setUseSSL(false);
                
                localDataSource.setServerName("localhost");
                localDataSource.setPort(3306);
                localDataSource.setDatabaseName("cupcake");
                localDataSource.setUser("transform");
                localDataSource.setPassword("transform");
                localDataSource.setUseSSL(false);
                
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public MysqlDataSource getDataSource() {
        return dataSource;
    }
}
