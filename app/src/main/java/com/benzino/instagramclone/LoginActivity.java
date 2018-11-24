package com.benzino.instagramclone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText edtEmailLogin, edtPasswordLogin;
    private Button btnLoginLogin, btnSignupLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setTitle("Instagram Clone");

        edtEmailLogin = findViewById(R.id.edtEmailLogin);
        edtPasswordLogin = findViewById(R.id.edtPasswordLogin);
        btnLoginLogin = findViewById(R.id.btnLoginLogin);
        btnSignupLogin = findViewById(R.id.btnSignupLogin);


        btnSignupLogin.setOnClickListener(this);
        btnLoginLogin.setOnClickListener(this);

        if(ParseUser.getCurrentUser() != null){
            ParseUser.getCurrentUser().logOut();
        }else {

        }


    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){

            case R.id.btnLoginLogin:
                ParseUser.logInInBackground(edtEmailLogin.getText().toString(),
                                            edtPasswordLogin.getText().toString(), new LogInCallback() {
                    @Override
                    public void done(ParseUser user, ParseException e) {
                        if(user != null && e == null){

                            FancyToast.makeText(LoginActivity.this,
                                    user.getUsername().toString() + " is logged in successfully",
                                    Toast.LENGTH_LONG, FancyToast.SUCCESS,
                                    true).show();
                            transitionToSocialMediaActivity();
                        }
                    }
                });

                break;

            case R.id.btnSignupLogin:
                break;
        }
    }

    private void transitionToSocialMediaActivity() {
        Intent intent = new Intent(LoginActivity.this, SocialMediaActivity.class);
        startActivity(intent);
    }
}
