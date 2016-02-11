package com.example.rucha.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Rucha on 2/10/2016.
 */
public class SignUp extends Activity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

    }


    public void OnSignUpClick(View v)
    {
        if(v.getId()==R.id.Bsignup){

            EditText name = (EditText)findViewById(R.id.TFname);
            EditText email = (EditText)findViewById(R.id.TFemail);
            EditText username = (EditText)findViewById(R.id.TFuser);
            EditText pass1 = (EditText)findViewById(R.id.TFpass1);
            EditText pass2 = (EditText)findViewById(R.id.TFpass2);

            String namestr =name.getText().toString();
            String emailstr =name.getText().toString();
            String unamestr =name.getText().toString();
            String pass1str =name.getText().toString();
            String pass2str =name.getText().toString();

            if(!pass1.equals(pass2))
            {
                //Display pop-up msg :
                Toast pass= Toast.makeText(SignUp.this,"Passwords Do not Match!",Toast.LENGTH_SHORT);
                pass.show();
            }
        }
    }
}
