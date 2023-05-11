package com.vsantos1.legacy.core.config;


public class YamlFile {

    private String url;

    private String host;

    private String port;
    private String password;

    private String username;

    private String dialect;

    private String ddl;

    private String driverClassName;
    private boolean showSql;

    private boolean formatSql;


    public YamlFile() {
    }
    public YamlFile(String url, String host, String port, String password, String username, String dialect, String ddl, String driverClassName, boolean showSql, boolean formatSql) {
        this.url = url;
        this.host = host;
        this.port = port;
        this.password = password;
        this.username = username;
        this.dialect = dialect;
        this.ddl = ddl;
        this.driverClassName = driverClassName;
        this.showSql = showSql;
        this.formatSql = formatSql;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getdialect() {
        return dialect;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public void setdialect(String dialect) {
        this.dialect = dialect;
    }

    public String getDdl() {
        return ddl;
    }

    public void setDdl(String ddl) {
        this.ddl = ddl;
    }

    public boolean isShowSql() {
        return showSql;
    }

    public void setShowSql(boolean showSql) {
        this.showSql = showSql;
    }

    public boolean isFormatSql() {
        return formatSql;
    }

    public String getDialect() {
        return dialect;
    }

    public void setDialect(String dialect) {
        this.dialect = dialect;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public void setFormatSql(boolean formatSql) {
        this.formatSql = formatSql;
    }
}
