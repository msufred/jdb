package org.gemseeker.jdb.utils;

public class DBUtils {

    // Database Drivers
    public static final String DRIVER_H2                    = "org.h2.Driver";
    public static final String DRIVER_IBM_DB2_APP           = "com.ibm.db2.jdbc.app.DB2Driver";
    public static final String DRIVER_IBM_DB2_NET           = "com.ibm.db2.jdbc.net.DB2Driver";
    public static final String DRIVER_MICROSOFT_SQL_SERVER  = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public static final String DRIVER_MS_ACCESS             = "sun.jdbc.odbc.JdbcOdbcDriver";
    public static final String DRIVER_MYSQL                 = "com.mysql.jdbc.Driver";
    public static final String DRIVER_ORACLE                = "oracle.jdbc.driver.OracleDriver";
    public static final String DRIVER_POSTGRE               = "org.postgresql.Driver";
    public static final String DRIVER_SYBASE                = "com.sybase.jdbc.SybDriver";
    public static final String DRIVER_TERADATA              = "com.teradata.jdbc.TeraDriver";

    // Database Connection Templates
    public static final String FORMAT_H2 = "";

    /** jdbc:db2:<databaseName> */
    public static final String FORMAT_IBM_DB2_APP = "jdbc:db2:%s";

    /** jdbc:db2//<server>:<port>/<databaseName> */
    public static final String FORMAT_IBM_DB2_NET = "jdbc:db2//%s:%s/$s";

    /** jdbc:sqlserver://<server>:<port>;databaseName=<databaseName> */
    public static final String FORMAT_MICROSOFT_SQL_SERVER = "jdbc:sqlserver://%s:%s;databaseName=%s";

    /** jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=<myDBName.mdb>; */
    public static final String FORMAT_MS_ACCESS = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=%s;";

    /** jdbc:mysql://<server>:<port>/<databaseName> */
    public static final String FORMAT_MYSQL = "jdbc:mysql://%s:%s/%s";

    /** jdbc:oracle:thin:@<server>:<port>:<databaseName> */
    public static final String FORMAT_ORACLE = "jdbc:oracle:thin:@%s:%s:%s";

    /** jdbc:postgresql://<server>:<port>/<databaseName> */
    public static final String FORMAT_POSTGRE = "jdbc:postgresql://%s:%s/%s";

    /** jdbc:sybase:Tds:<server>:<port>/<databaseName> */
    public static final String FORMAT_SYBASE = "jdbc:sybase:Tds:%s:%s/%s";

    /** jdbc:teradata://<server>/database=<databaseName>,tmode=ANSI,charset=UTF8 */
    public static final String FORMAT_TERADATA = "jdbc:teradata://%s%s/database=%s,tmode=ANSI,charset=UTF8";


    /**
     * Returns the proper driver of the given database name. If no driver is available,
     * an Exception is thrown.
     *
     * @param name Name of the database. Valid values are:
     *             <ul>
     *             <li>h2</li>
     *             <li>ibm_db2_app</li>
     *             <li>ibm_db2_net</li>
     *             <li>microsoft_sql_server</li>
     *             <li>ms_access</li>
     *             <li>mysql</li>
     *             <li>oracle</li>
     *             <li>postgre</li>
     *             <li>sybase</li>
     *             <li>teradata</li>
     *             </ul>
     * @return String value of database driver
     * @throws Exception Thrown if database driver is not supported
     */
    public static String getDriver(String name) throws Exception {
        return switch (name) {
            case "h2"                   -> DBUtils.DRIVER_H2;
            case "ibm_db2_app"          -> DBUtils.DRIVER_IBM_DB2_APP;
            case "ibm_db2_net"          -> DBUtils.DRIVER_IBM_DB2_NET;
            case "microsoft_sql_server" -> DBUtils.DRIVER_MICROSOFT_SQL_SERVER;
            case "ms_access"            -> DBUtils.DRIVER_MS_ACCESS;
            case "mysql"                -> DBUtils.DRIVER_MYSQL;
            case "oracle"               -> DBUtils.DRIVER_ORACLE;
            case "postgre"              -> DBUtils.DRIVER_POSTGRE;
            case "sybase"               -> DBUtils.DRIVER_SYBASE;
            case "teradata"             -> DBUtils.DRIVER_TERADATA;
            default                     -> throw new Exception("Unsupported database driver");
        };
    }


    public static String getUrl(String name, String host, String port, String dbname) throws Exception {
        String format = switch (name) {
            case "h2"                   -> DBUtils.FORMAT_H2;
            case "ibm_db2_app"          -> DBUtils.FORMAT_IBM_DB2_APP;
            case "ibm_db2_net"          -> DBUtils.FORMAT_IBM_DB2_NET;
            case "microsoft_sql_server" -> DBUtils.FORMAT_MICROSOFT_SQL_SERVER;
            case "ms_access"            -> DBUtils.FORMAT_MS_ACCESS;
            case "mysql"                -> DBUtils.FORMAT_MYSQL;
            case "oracle"               -> DBUtils.FORMAT_ORACLE;
            case "postgre"              -> DBUtils.FORMAT_POSTGRE;
            case "sybase"               -> DBUtils.FORMAT_SYBASE;
            case "teradata"             -> DBUtils.FORMAT_TERADATA;
            default                     -> throw new Exception("Unsupported database driver");
        };

        return String.format(format, host, port, dbname);
    }
}
