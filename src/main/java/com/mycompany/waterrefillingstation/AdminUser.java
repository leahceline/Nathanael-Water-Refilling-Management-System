package com.mycompany.waterrefillingstation;

public class AdminUser extends User {

    public AdminUser(int userId, String username) {
        super(userId, username, "Admin");
    }

    @Override
    public boolean canManageProducts() {
        return true;
    }

    @Override
    public boolean canAccessArchive() {
        return true;
    }
}
