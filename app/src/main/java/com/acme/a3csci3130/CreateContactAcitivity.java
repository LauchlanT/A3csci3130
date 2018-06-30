package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class CreateContactAcitivity extends Activity {

    private Button submitButton;
    private EditText nameField, addressField;
    private Spinner typeField, provinceField;
    private MyApplicationData appState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact_acitivity);
        //Get the app wide shared variables
        appState = ((MyApplicationData) getApplicationContext());

        submitButton = (Button) findViewById(R.id.submitButton);
        nameField = (EditText) findViewById(R.id.businessname);
        typeField = (Spinner) findViewById(R.id.businesstype);
        addressField = (EditText) findViewById(R.id.businessaddress);
        provinceField = (Spinner) findViewById(R.id.businessprovince);
    }

    public void submitInfoButton(View v) {
        //each entry needs a unique ID
        String businessID = appState.firebaseReference.push().getKey();
        String name = nameField.getText().toString();
        String type = typeField.getSelectedItem().toString();
        String address = addressField.getText().toString();
        String province = provinceField.getSelectedItem().toString();

        Contact business = new Contact(businessID, name, type, address, province);

        appState.firebaseReference.child(businessID).setValue(business);

        finish();

    }
}
