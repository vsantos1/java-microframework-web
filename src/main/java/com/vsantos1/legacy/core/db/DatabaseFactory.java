package com.vsantos1.legacy.core.db;

import com.vsantos1.legacy.core.config.LoadApplicationConfig;
import com.vsantos1.legacy.core.config.YamlFile;
import com.vsantos1.legacy.core.db.migrations.ApplicationMigrationRunner;
import org.hibernate.cfg.AvailableSettings;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

public class DatabaseFactory {


    private static final String PERSISTENCE_UNIT_NAME = "HireMe";


    public DatabaseFactory() {
        ApplicationMigrationRunner.run();
    }


    public static EntityManagerFactory getEntityManagerFactory(String persistenceUnitName) {

        YamlFile yamlFile = LoadApplicationConfig.loadYaml();

        Map<String, String> properties = new HashMap<>();
        properties.put(AvailableSettings.DIALECT, yamlFile.getdialect());
        properties.put(AvailableSettings.HBM2DDL_AUTO, yamlFile.getDdl());
        properties.put(AvailableSettings.DRIVER, yamlFile.getDriverClassName());
        properties.put(AvailableSettings.URL, yamlFile.getUrl());
        properties.put(AvailableSettings.USER, yamlFile.getUsername());
        properties.put(AvailableSettings.PASS, yamlFile.getPassword());
        properties.put(AvailableSettings.SHOW_SQL, String.valueOf(yamlFile.isShowSql()));
        properties.put(AvailableSettings.FORMAT_SQL, String.valueOf(yamlFile.isFormatSql()));
        properties.put(AvailableSettings.POOL_SIZE, String.valueOf(10));

        String persistenceUnit = persistenceUnitName == null ? PERSISTENCE_UNIT_NAME : persistenceUnitName;
        return Persistence.createEntityManagerFactory(persistenceUnit, properties);
    }


}
