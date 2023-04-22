package com.vsantos1.legacy.core.db.migrations;

import com.vsantos1.legacy.core.db.DatabaseFactory;

import javax.persistence.EntityManagerFactory;

public class ApplicationMigrationRunner {

    private static final EntityManagerFactory FACTORY = DatabaseFactory.getEntityManagerFactory(null);

    public static void run() {
        if (FACTORY == null) {
            System.out.println("Database connection failed");
            return;
        }

        FACTORY.createEntityManager().getTransaction().begin();
        FACTORY.createEntityManager().getTransaction().commit();
        FACTORY.createEntityManager().close();
        System.out.println();
    }


}
