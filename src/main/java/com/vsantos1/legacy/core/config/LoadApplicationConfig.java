package com.vsantos1.legacy.core.config;

import com.vsantos1.legacy.core.db.DatabaseFactory;
import org.yaml.snakeyaml.Yaml;

public class LoadApplicationConfig extends YamlFile {

    private static final Yaml yaml = new Yaml();

    public LoadApplicationConfig(String url, String host, String port, String password, String username, String dialect, String ddl, String driverClassName, boolean showSql, boolean formatSql) {
        super(url, host, port, password, username, dialect, ddl, driverClassName, showSql, formatSql);
    }

    public static YamlFile loadYaml() {
        try {
            var inputStream = DatabaseFactory.class.getClassLoader().getResourceAsStream("application.yml");
            YamlFile yamlFile = yaml.loadAs(inputStream, YamlFile.class);

            String URL = yamlFile.getUrl() == null ? "" : yamlFile.getUrl();
            return new LoadApplicationConfig(URL, yamlFile.getHost(), yamlFile.getPort(),
                    yamlFile.getPassword(), yamlFile.getUsername(), yamlFile.getdialect(),
                    yamlFile.getDdl(), yamlFile.getDriverClassName(), yamlFile.isShowSql(), yamlFile.isFormatSql());

        } catch (Exception e) {
            System.out.println("Error loading yaml file: " + e.getMessage());
        }
        return null;
    }


}
