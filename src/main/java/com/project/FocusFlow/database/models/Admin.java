package com.project.FocusFlow.database.models;

import java.util.ArrayList;

public class Admin extends Person{
    private int id;
    private int permissionLevel;
    private Boolean canAddAdmins;
    private Boolean canEditAdmins;
    private Boolean canDeleteAdmins;
    private Boolean canOverridePermissions;
    private ArrayList<String> activityLog;
    private Boolean canManageContent;
}
