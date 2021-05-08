package org.gemseeker.jdb;

import org.gemseeker.jdb.utils.DBUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public abstract class AbstractDatabase implements IDatabase {

    protected Connection connection;
    protected Properties properties;

    public AbstractDatabase(Properties properties) throws Exception {
        if (properties.isEmpty()) throw new Exception("ERR001: Database properties is empty");
        if (!properties.containsKey("host")) throw  new Exception("ERR002: Database host not defined");
        if (!properties.containsKey("port")) throw new Exception("ERR003: Database port not defined");
        if (!properties.containsKey("user")) throw new Exception("ERR004: Database user not defined");
        if (!properties.containsKey("password")) throw new Exception("ERR005: Database password not defined");
        if (!properties.containsKey("db")) throw new Exception("ERR006: Database name not defined");
        if (!properties.containsKey("driver")) throw new Exception("ERR007: Database driver not defined");

        this.properties = properties;

        loadDriver();
        openDatabase();
        createTables();
    }

    protected void loadDriver() throws Exception {
        String driverName = String.valueOf(properties.get("driver"));
        Class.forName(DBUtils.getDriver(driverName));
    }

    protected void openDatabase() throws Exception {
        String driverName = String.valueOf(properties.get("driver"));
        String url = DBUtils.getUrl(driverName,
                properties.get("host").toString(),
                properties.get("port").toString(),
                properties.get("db").toString());
        connection = DriverManager.getConnection(url, properties);
    }

    protected void createTables() throws Exception {
        if (connection == null) throw new Exception("ERR09: Connection is null");
    }
}
