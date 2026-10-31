package com.mycompany.waterrefillingstation;

public class StaffUser extends User {

    public StaffUser(int userId, String username) {
        super(userId, username, "Staff");
    }

    @Override
    public boolean canManageProducts() {
        return false;
    }

    @Override
    public boolean canAccessArchive() {
        return false;
    }
}