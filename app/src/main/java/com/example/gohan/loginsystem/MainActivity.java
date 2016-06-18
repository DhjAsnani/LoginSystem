package com.example.gohan.loginsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText ET_NAME,ET_PASS;
    String login_name,login_pass;
    Button Login,gotoRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gotoRegister = (Button) findViewById(R.id.reg_button);
        ET_NAME= (EditText) findViewById(R.id.edit_name);
        ET_PASS = (EditText)findViewById(R.id.edit_pass);


    }
    public void gotoReg(View view)
    {
        Intent intent = new Intent(this,Register_Activity.class);
        startActivity(intent);
    }
    public void loginuser(View view)
    {
        login_name = ET_NAME.getText().toString();
        login_pass = ET_PASS.getText().toString();
        String method = "login";
        BackgroudTask backgroudTask = new BackgroudTask(this);
        backgroudTask.execute(method,login_name,login_pass);
    }
}
