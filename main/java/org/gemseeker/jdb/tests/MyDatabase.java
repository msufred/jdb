package org.gemseeker.jdb.tests;

import org.gemseeker.jdb.AbstractDatabase;
import org.gemseeker.jdb.IDataEntry;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Properties;

public class MyDatabase extends AbstractDatabase {

    private static MyDatabase instance;

    public static MyDatabase getInstance() throws Exception {
        if (instance == null) {
            Properties properties = new Properties();
            properties.put("host", "localhost");
            properties.put("port", "3307");
            properties.put("user", "root");
            properties.put("password", "root");
            properties.put("db", "mydb");
            instance = new MyDatabase(properties);
        }
        return instance;
    }

    private MyDatabase(Properties properties) throws Exception {
        super(properties);
    }

    @Override
    public ResultSet all(String tableName) {
        return null;
    }

    @Override
    public ResultSet all(String tableName, String where) {
        return null;
    }

    @Override
    public ResultSet get(String tableName, String keyColumn, String keyValue) {
        return null;
    }

    @Override
    public boolean add(IDataEntry entry) {
        return false;
    }

    @Override
    public boolean delete(IDataEntry entry) {
        return false;
    }

    @Override
    public boolean update(String tableName, String keyColumn, String keyValue, HashMap<String, Object> pairValues) {
        return false;
    }
}
