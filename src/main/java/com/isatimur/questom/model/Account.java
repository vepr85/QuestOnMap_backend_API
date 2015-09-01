package com.isatimur.questom.model;

import java.util.List;

/**
 * Created by tisachenko on 01.09.15.
 */
public class Account extends AbstractEntityId {

    private String login;

    private String username;

    private String password;

    private String avatarUrl;

    private AccountInfo info;

    private List<Account> followers;

    private List<Account> followedByMe;

    private List<BoxItem> boxesLeftByMe;

    private List<BoxItem> boxesOpenedByMe;


}
