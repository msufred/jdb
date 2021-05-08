package org.gemseeker.jdb;

import java.sql.ResultSet;
import java.util.HashMap;

public interface IDatabase {

    ResultSet all(String tableName);
    ResultSet all(String tableName, String where);
    ResultSet get(String tableName, String keyColumn, String keyValue);
    boolean add(IDataEntry entry);
    boolean delete(IDataEntry entry);
    boolean update(String tableName, String keyColumn, String keyValue, HashMap<String, Object> pairValues);

}
