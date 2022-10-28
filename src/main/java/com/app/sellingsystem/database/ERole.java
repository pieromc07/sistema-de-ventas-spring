package com.app.sellingsystem.database;

public enum ERole {
    ADMIN, VENTA;

    private final String PREFIX = "ROLE_";

    public String getFullRoleName() {
        return this.PREFIX + this.name();
    }
}
