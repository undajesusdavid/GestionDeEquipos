package com.undabits;

import com.undabits.persistence.Persistence;
import org.json.JSONObject;

import java.util.List;

public class User {

    private final static Persistence USERS = new Persistence("users");

    public static List<JSONObject> all(){
        return USERS.get().getDataList();
    }


}
