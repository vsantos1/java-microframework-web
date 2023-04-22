package com.vsantos1.legacy;

import com.vsantos1.legacy.core.db.migrations.ApplicationMigrationRunner;

public class WebApplicationContext {


    public static void main(String[] args) {
        ApplicationMigrationRunner.run();
    }
}
