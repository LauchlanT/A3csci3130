package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class DetailViewActivity extends Activity {

    private EditText nameField, addressField;
    private Spinner typeField, provinceField;
    Contact receivedPersonInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
        receivedPersonInfo = (Contact)getIntent().getSerializableExtra("Contact");

        nameField = (EditText) findViewById(R.id.businessname);
        addressField = (EditText) findViewById(R.id.businessaddress);

        if(receivedPersonInfo != null){
            nameField.setText(receivedPersonInfo.businessname);
            addressField.setText(receivedPersonInfo.businessaddress);
        }
    }

    public void updateContact(View v){
        //TODO: Update contact funcionality
    }

    public void eraseContact(View v)
    {
        //TODO: Erase contact functionality
        MyApplicationData appData = (MyApplicationData)getApplication();
        appData.firebaseReference.child(receivedPersonInfo.businessid).removeValue();
    }
}
