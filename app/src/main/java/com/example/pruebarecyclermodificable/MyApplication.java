package com.example.pruebarecyclermodificable;

import android.app.Application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyApplication extends Application {

    private static List<President> presidentList = new ArrayList<President>();
    private static int nextId=presidentList.size();

    public MyApplication() {
        fillPresidentList();
    }

    private void fillPresidentList() {

        President p0 = new President(0, "george", 1899, "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b6/Gilbert_Stuart_Williamstown_Portrait_of_George_Washington.jpg/220px-Gilbert_Stuart_Williamstown_Portrait_of_George_Washington.jpg");
        President p1 = new President(1, "asier", 1997, "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8c/Cristiano_Ronaldo_2018.jpg/245px-Cristiano_Ronaldo_2018.jpg");

        presidentList.addAll(Arrays.asList(new President[]{p0, p1}));

    }

    public static List<President> getPresidentList() {
        return presidentList;
    }

    public static void setPresidentList(List<President> presidentList) {
        MyApplication.presidentList = presidentList;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nexId) {
        MyApplication.nextId = nexId;
    }
}
