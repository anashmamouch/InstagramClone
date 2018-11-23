package com.benzino.instagramclone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnSave;
    private EditText edtName, edtPunchSpeed, edtPunchPower, edtKickSpeed, edtKickPower;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        btnSave = findViewById(R.id.btnSave);

        edtName = findViewById(R.id.edtName);
        edtPunchSpeed = findViewById(R.id.edtPunchSpeed);
        edtPunchPower = findViewById(R.id.edtPunchPower);
        edtKickPower = findViewById(R.id.edtKickPower);
        edtKickSpeed = findViewById(R.id.edtKickSpeed);

        btnSave.setOnClickListener(SignUpActivity.this);
    }


    @Override
    public void onClick(View view) {

        try{

            final ParseObject kickBoxer = new ParseObject("KickBoxer" );
            kickBoxer.put("name", edtName.getText().toString());
            kickBoxer.put("punchSpeed",Integer.parseInt( edtPunchSpeed.getText().toString()));
            kickBoxer.put("punchPower", Integer.parseInt(edtPunchPower.getText().toString()));
            kickBoxer.put("kickSpeed", Integer.parseInt(edtKickSpeed.getText().toString()));
            kickBoxer.put("kickPower",  Integer.parseInt(edtKickPower.getText().toString()));

            kickBoxer.saveInBackground(new SaveCallback() {
                @Override
                public void done(ParseException e) {
                    if(e == null){

                        FancyToast.makeText(SignUpActivity.this,kickBoxer.get("name").toString() + "is saved to server",FancyToast.LENGTH_LONG,FancyToast.SUCCESS,true).show();

                        //Toast.makeText(SignUpActivity.this, kickBoxer.get("name").toString() + "is saved to server",Toast.LENGTH_SHORT ).show();

                    }else {
                        FancyToast.makeText(SignUpActivity.this,e.getMessage().toString(),FancyToast.LENGTH_LONG,FancyToast.ERROR,true).show();
                        //Toast.makeText(SignUpActivity.this, e.getMessage().toString(),Toast.LENGTH_LONG ).show();
                    }
                }
            });

        }catch(Exception e){
            FancyToast.makeText(SignUpActivity.this,e.getMessage().toString(),FancyToast.LENGTH_LONG,FancyToast.ERROR,true).show();
        }

    }
}
