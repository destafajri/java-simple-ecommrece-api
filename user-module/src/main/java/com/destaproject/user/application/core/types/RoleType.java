package com.destaproject.user.application.core.types;

public enum RoleType {
    ADMIN(1), SELLER(2), BUYER(3);
    private final int id;

    RoleType(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static RoleType fromId(int id) {
        for (RoleType roleType : values()) {
            if (roleType.id == id) {
                return roleType;
            }
        }
        throw new IllegalArgumentException("Invalid RoleType ID: " + id);
    }
}
