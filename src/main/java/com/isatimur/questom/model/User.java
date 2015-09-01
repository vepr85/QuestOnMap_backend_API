package com.isatimur.questom.model;

import java.util.List;

/**
 * Created by tisachenko on 01.09.15.
 */
public class User extends AbstractEntityId {

    private String login;

    private String username;

    private String password;

    private String avatarUrl;

    private UserInfo info;

    private List<User> followers;

    private List<User> followedByMe;

    private List<Box> boxesLeftByMe;

    private List<Box> boxesOpenedByMe;


}
