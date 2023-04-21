package com.vsantos1.legacy.core.enums;

public enum DDL {

        CREATE("create"),
        CREATE_DROP("create-drop"),
        UPDATE("update"),
        VALIDATE("validate");

        private String ddl;

        DDL(String ddl) {
            this.ddl = ddl;
        }

        public String getDdl() {
            return ddl;
        }

        public void setDdl(String ddl) {
            this.ddl = ddl;
        }
}
