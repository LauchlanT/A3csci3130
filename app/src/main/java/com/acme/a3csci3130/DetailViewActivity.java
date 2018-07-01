package com.acme.a3csci3130;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

public class DetailViewActivity extends Activity {

    private EditText nameField, numberField, addressField;
    private Spinner typeField, provinceField;
    Business receivedPersonInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
        receivedPersonInfo = (Business)getIntent().getSerializableExtra("Business");

        nameField = (EditText) findViewById(R.id.businessname);
        numberField = (EditText) findViewById(R.id.businessnumber);
        typeField = (Spinner) findViewById(R.id.businesstype);
        addressField = (EditText) findViewById(R.id.businessaddress);
        provinceField = (Spinner) findViewById(R.id.businessprovince);

        if(receivedPersonInfo != null){
            nameField.setText(receivedPersonInfo.businessname);
            for (int i=0;i<typeField.getCount();i++){
                if (typeField.getItemAtPosition(i).toString().equals(receivedPersonInfo.businesstype)){
                    typeField.setSelection(i);
                }
            }
            numberField.setText(receivedPersonInfo.businessnumber);
            addressField.setText(receivedPersonInfo.businessaddress);
            for (int i=0;i<provinceField.getCount();i++){
                if (provinceField.getItemAtPosition(i).toString().equals(receivedPersonInfo.businessprovince)){
                    provinceField.setSelection(i);
                }
            }
        }
    }

    /**
     *
     * @param v the view of the business
     *          Updates the business
     */
    public void updateBusiness(View v){
        receivedPersonInfo.businessname = nameField.getText().toString();
        receivedPersonInfo.businessnumber = numberField.getText().toString();
        receivedPersonInfo.businesstype = typeField.getSelectedItem().toString();
        receivedPersonInfo.businessaddress = addressField.getText().toString();
        receivedPersonInfo.businessprovince = provinceField.getSelectedItem().toString();
        MyApplicationData appData = (MyApplicationData)getApplication();
        appData.firebaseReference.child(receivedPersonInfo.businessid).setValue(receivedPersonInfo);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    /**
     *
     * @param v the view of the business
     *          Deletes the business
     */
    public void eraseBusiness(View v)
    {
        MyApplicationData appData = (MyApplicationData)getApplication();
        appData.firebaseReference.child(receivedPersonInfo.businessid).removeValue();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
