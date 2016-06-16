package com.example.gohan.loginsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView Login,gotoRegister,Register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gotoRegister = (TextView) findViewById(R.id.reg_button);

    }
    public void gotoReg(View view)
    {
        Intent intent = new Intent(this,Register_Activity.class);
        startActivity(intent);
    }
}
