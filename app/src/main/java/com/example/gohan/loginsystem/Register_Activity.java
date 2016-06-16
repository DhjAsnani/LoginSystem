package com.example.gohan.loginsystem;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Register_Activity extends Activity {

    EditText ET_NAME,ET_USER_NAME,ET_USER_PASS;
    String name,user_name,user_pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ET_NAME = (EditText) findViewById(R.id.edit_reg_name);
        ET_USER_NAME= (EditText) findViewById(R.id.edit_reg_user_name);
        ET_USER_PASS = (EditText) findViewById(R.id.edit_reg_pass);

    }
        public void registerMe(View view)
        {
            name = ET_NAME.getText().toString();
            user_name =ET_USER_NAME.getText().toString();
            user_pass = ET_USER_PASS.getText().toString();
            String method = "register";
            BackgroudTask backgroudTask = new BackgroudTask(this);
            backgroudTask.execute(method,name,user_name,user_pass);
            finish();
            //now add interner permissions
        }

}
