package com.example.death.walkrenger;

/**
 * Created by Death on 3/12/2016.
 */
import java.util.ArrayList;

public class user_class {
    String user_name; //represent name
    String user_id; //id call
    int profilePic;
    String FB_ID;
    int gender; //male = 1 ; female = 2 ; unknown = 0
    int age;
    int steps;
    int weeklyStep;
    int montlyStep;
    int ranges;
    int calsburn;
    int weight;
    int height;
    ArrayList<String> groupJoined = new ArrayList<>();

    public int getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(int profilePic) {
        this.profilePic = profilePic;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getFB_ID() {
        return FB_ID;
    }

    public void setFB_ID(String FB_ID) {
        this.FB_ID = FB_ID;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public int getWeeklyStep() {
        return weeklyStep;
    }

    public void setWeeklyStep(int weeklyStep) {
        this.weeklyStep = weeklyStep;
    }

    public int getMontlyStep() {
        return montlyStep;
    }

    public void setMontlyStep(int montlyStep) {
        this.montlyStep = montlyStep;
    }

    public int getRanges() {
        return ranges;
    }

    public void setRanges(int ranges) {
        this.ranges = ranges;
    }

    public int getCalsburn() {
        return calsburn;
    }

    public void setCalsburn(int calsburn) {
        this.calsburn = calsburn;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public ArrayList<String> getGroupJoined() {
        return groupJoined;
    }

    public void setGroupJoined(ArrayList<String> groupJoined) {
        this.groupJoined = groupJoined;
    }

    public user_class() {

    }
}