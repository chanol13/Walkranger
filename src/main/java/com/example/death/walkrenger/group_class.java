package com.example.death.walkrenger;

/**
 * Created by Death on 3/12/2016.
 */
import java.util.ArrayList;

public class group_class {
    String group_name;
    String group_code;
    String group_name_short;
    int group_emblem;
    int groupPoint;
    int groupRank;
    String leader; //Leader user_id
    ArrayList<String> memberList = new ArrayList<>(); //member user_id list
    //Challenge challenge_participating; AFTER CHECKPOINT
    String annoucement;


    public int getGroup_emblem() {
        return group_emblem;
    }

    public void setGroup_emblem(int group_emblem) {
        this.group_emblem = group_emblem;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public String getGroup_code() {
        return group_code;
    }

    public void setGroup_code(String group_code) {
        this.group_code = group_code;
    }

    public String getGroup_name_short() {
        return group_name_short;
    }

    public void setGroup_name_short(String group_name_short) {
        this.group_name_short = group_name_short;
    }

    public int getGroupPoint() {
        return groupPoint;
    }

    public void setGroupPoint(int groupPoint) {
        this.groupPoint = groupPoint;
    }

    public int getGroupRank() {
        return groupRank;
    }

    public void setGroupRank(int groupRank) {
        this.groupRank = groupRank;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public ArrayList<String> getMemberList() {
        return memberList;
    }

    public void setMemberList(ArrayList<String> memberList) {
        this.memberList = memberList;
    }

    /*public Challenge getChallenge_participating() {
        return challenge_participating;
    }

    public void setChallenge_participating(Challenge challenge_participating) {
        this.challenge_participating = challenge_participating;
    }*/

    public String getAnnoucement() {
        return annoucement;
    }

    public void setAnnoucement(String annoucement) {
        this.annoucement = annoucement;
    }

    public group_class() {

    }
}
