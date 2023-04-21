package com.vsantos1.legacy.core.db;

import com.vsantos1.legacy.core.config.YamlFile;
import org.hibernate.cfg.AvailableSettings;
import org.yaml.snakeyaml.Yaml;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class DatabaseFactory {

    private static final Yaml yaml = new Yaml();

    private static String URL;
    private static String HOST;
    private static String PORT;
    private static String DDL;

    private static String SHOW_SQL;
    private static String FORMAT_SQL;
    private static String USERNAME;
    private static String PASSWORD;

    private static String DIALECT;
    private static final String PERSISTENCE_UNIT_NAME = "HireMe";

    public static EntityManagerFactory getEntityManagerFactory() {


        Map<String, String> properties = new HashMap<>();
        properties.put(AvailableSettings.DIALECT, DIALECT);
        properties.put(AvailableSettings.HBM2DDL_AUTO, DDL);
        properties.put(AvailableSettings.SHOW_SQL, SHOW_SQL);
        properties.put(AvailableSettings.FORMAT_SQL, FORMAT_SQL);
        properties.put(AvailableSettings.JPA_JDBC_USER, USERNAME);
        properties.put(AvailableSettings.JPA_JDBC_PASSWORD, PASSWORD);
        properties.put(AvailableSettings.URL, "jdbc:mysql://localhost:3306/hireme?useTimezone=true&serverTimezone=UTC");

        return Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME, properties);
    }

    public static void loadYaml() {
        try {
            var inputStream = DatabaseFactory.class.getClassLoader().getResourceAsStream("application.yml");
            YamlFile yamlFile = yaml.loadAs(inputStream, YamlFile.class);
            HOST = yamlFile.getHost();
            PORT = yamlFile.getPort();
            USERNAME = yamlFile.getUsername();
            PASSWORD = yamlFile.getPassword();
            DIALECT = yamlFile.getdialect();
            DDL = yamlFile.getDdl();
            SHOW_SQL = yamlFile.isShowSql() ? "true" : "false";
            FORMAT_SQL = yamlFile.isFormatSql() ? "true" : "false";
            URL = yamlFile.getUrl() == null ? "" : yamlFile.getUrl();
        } catch (Exception e) {
            System.out.println("Error loading yaml file: " + e.getMessage());
        }
    }

}
