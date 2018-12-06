package com.example.death.walkrenger;

import java.util.ArrayList;

/**
 * Created by Vincent on 14/3/2559.
 */
public class UserInfoThisSession {
    static String user_name;
    static String user_id;
    static String FB_ID;
    static int step;
    static int range;
    static ArrayList<String> groupsName = new ArrayList<>();
    static ArrayList<group_class> groupList = new ArrayList<>();
    static ArrayList<user_class> dummyRUsers = new ArrayList<>();
    static ArrayList<user_class> dummyIUsers = new ArrayList<>();
    static String recentGroup;

    public static ArrayList<user_class> getDummyIUsers() {
        return dummyIUsers;
    }

    public static void setDummyIUsers(ArrayList<user_class> dummyIUsers) {
        UserInfoThisSession.dummyIUsers = dummyIUsers;
    }

    public static user_class getUserIByName(String userName) {
        if(UserInfoThisSession.dummyIUsers != null) {
            for(user_class groupInArray : UserInfoThisSession.dummyIUsers) {
                if(groupInArray.getUser_name().matches(userName)) {
                    return groupInArray;
                }
            }
        }
        return null;
    }

    public static void addUserIByName(String newUserName) {
        user_class newUser = new user_class();
        newUser.setUser_name(newUserName);
        newUser.setUser_id("0000");
        newUser.setProfilePic(R.drawable.ic_add_member);
        UserInfoThisSession.dummyIUsers.add(newUser);
    }

    public static void delUserIByPosition(int position) {
        if (!UserInfoThisSession.dummyIUsers.isEmpty()) {
            UserInfoThisSession.dummyIUsers.remove(position);
        }
    }

    public static ArrayList<user_class> getDummyRUsers() {
        return dummyRUsers;
    }

    public static void setDummyRUsers(ArrayList<user_class> dummyRUsers) {
        UserInfoThisSession.dummyRUsers = dummyRUsers;
    }

    public static user_class getUserRByName(String userName) {
        if(UserInfoThisSession.dummyRUsers != null) {
            for(user_class groupInArray : UserInfoThisSession.dummyRUsers) {
                if(groupInArray.getUser_name().matches(userName)) {
                    return groupInArray;
                }
            }
        }
        return null;
    }

    public static void addUserRByName(String newUserName) {
        user_class newUser = new user_class();
        newUser.setUser_name(newUserName);
        newUser.setUser_id("0000");
        newUser.setProfilePic(R.drawable.ic_add_member);
        UserInfoThisSession.dummyRUsers.add(newUser);
    }

    public static void delUserRByPosition(int position) {
        if (!UserInfoThisSession.dummyRUsers.isEmpty()) {
            UserInfoThisSession.dummyRUsers.remove(position);
        }
    }

    public static ArrayList<group_class> getGroupList() {
        return groupList;
    }

    public static void setGroupList(ArrayList<group_class> groupList) {
        UserInfoThisSession.groupList = groupList;
    }

    public static group_class getGroupByName(String groupName) {
        if(UserInfoThisSession.groupList != null) {
            for(group_class groupInArray : UserInfoThisSession.groupList) {
                if(groupInArray.getGroup_name().matches(groupName)) {
                    return groupInArray;
                }
            }
        }
        return null;
    }

    public static void addGroupByName(String newGroupName, String newGroupTag) {
        group_class newGroup = new group_class();
        newGroup.setGroup_name(newGroupName);
        newGroup.setGroup_name_short(newGroupTag);
        newGroup.setGroup_code("0000");
        newGroup.setGroup_emblem(R.drawable.ic_add_member);
        UserInfoThisSession.groupList.add(newGroup);
    }

    public static String getRecentGroup() {
        return recentGroup;
    }

    public static void setRecentGroup(String recentGroups) {
        UserInfoThisSession.recentGroup = recentGroups;
    }

    public static String getUser_name() {
        return user_name;
    }

    public static void setUser_name(String user_name) {
        UserInfoThisSession.user_name = user_name;
    }

    public static String getUser_id() {
        return user_id;
    }

    public static void setUser_id(String user_id) {
        UserInfoThisSession.user_id = user_id;
    }

    public static String getFbId() {
        return FB_ID;
    }

    public static void setFbId(String fbId) {
        UserInfoThisSession.FB_ID = fbId;
    }

    public static int getStep() {
        return step;
    }

    public static void setStep(int step) {
        UserInfoThisSession.step = step;
    }

    public static int getRange() {
        return range;
    }

    public static void setRange(int range) {
        UserInfoThisSession.range = range;
    }

    public static ArrayList<String> getGroupsName() {
        return groupsName;
    }

    public static void setGroupsName(ArrayList<String> groups) {
        UserInfoThisSession.groupsName = groups;
    }

    public static String callGroupByName(String groupName) {
        if(UserInfoThisSession.groupsName != null) {
            for(String groupNameInArray : UserInfoThisSession.groupsName) {
                if(groupNameInArray.matches(groupName)) {
                    return groupNameInArray;
                }
            }
        }
        return null;
    }

    public static void addGroupNameByName(String newGroupName) {
        UserInfoThisSession.groupsName.add(newGroupName);
    }

    public UserInfoThisSession() {

    }
}