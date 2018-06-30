package com.acme.a3csci3130;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Class that defines how the data will be stored in the
 * Firebase databse. This is converted to a JSON format
 */

public class Contact implements Serializable {

    public  String businessid;
    public  String businessnumber;
    public  String businessname;
    public  String businesstype;
    public  String businessaddress;
    public  String businessprovince;

    public Contact() {
        // Default constructor required for calls to DataSnapshot.getValue
    }

    public Contact(String id, String number, String name, String type, String address, String province){
        businessid = id;
        businessnumber = number;
        businessname = name;
        businesstype = type;
        businessaddress = address;
        businessprovince = province;
    }

    @Exclude
    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("businessnumber", businessnumber);
        result.put("businessname", businessname);
        result.put("businesstype", businesstype);
        result.put("businessaddress", businessaddress);
        result.put("businessprovince", businessprovince);

        return result;
    }
}
