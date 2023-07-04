package com.undabits.models;

import com.undabits.persistence.Persistence;
import com.undabits.persistence.result_structuring.QueryResult;
import org.json.JSONObject;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Component {

    private final static Persistence COMPONENTS = new Persistence("components");

    private String code;
    private String name;
    private String asset_code;
    private String serial;
    private String color;
    private String brand;
    private String model;
    private Boolean is_operative;
    private Boolean in_use;
    private LocalDateTime creation_date;
    private LocalDateTime update_date;

    private Component(JSONObject data){
        this.code = data.getString("code");
        this.name = data.getString("name");
        this.asset_code = data.getString("asset_code");
        this.serial = data.getString("serial");
        this.color = data.getString("color");
        this.brand = data.getString("brand");
        this.model = data.getString("model");
        this.is_operative = data.getBoolean("is_operative");
        this.in_use = data.getBoolean("in_use");
        this.creation_date = (LocalDateTime) data.get("creation_date");
        this.update_date =(LocalDateTime) data.get("update_date");

    }

    public static List<Component> get(){
        QueryResult result = COMPONENTS.get();
        List<Component> components = new ArrayList<>();
        for (JSONObject data: result.getDataList()){
            Component component = new Component(data);
            components.add(component);
        }

        return components;
    }

    public void print(){
        System.out.println("Componente: "+ this.name);
        System.out.println("Marca: "+this.brand);
        System.out.println("Modelo: "+this.model);
    }
}
