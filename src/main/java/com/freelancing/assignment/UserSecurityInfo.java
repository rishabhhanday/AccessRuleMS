package com.freelancing.assignment;

import lombok.Data;

@Data
public class UserSecurityInfo {
    private String adminUserID;
    private UserList userList;
    private UserData data;
}
