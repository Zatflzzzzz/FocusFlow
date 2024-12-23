package com.project.FocusFlow.database.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.relational.core.mapping.Table;

import java.util.ArrayList;

@EqualsAndHashCode(callSuper = true)
@Data
@Table("Admins")
public class Admin extends Person{
    private int id;
    private int permissionLevel;
    private Boolean canAddAdmins;
    private Boolean canEditAdmins;
    private Boolean canDeleteAdmins;
    private Boolean canOverridePermissions;
    private ArrayList<String> activityLog;
    private Boolean canManageContent;

    Admin(){
    }

    public Admin(String email, String password, String username, String role, String telegramName, String profilePicture) {
        super(email, password, username, role, telegramName, profilePicture);
    }
}
