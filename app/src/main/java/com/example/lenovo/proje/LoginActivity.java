package com.example.lenovo.proje;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private EditText mEmail2;
    private EditText mPassword2;
    private Button mCreateBtn2;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

        mEmail2=(EditText) findViewById(R.id.reg_email2);
        mPassword2=(EditText) findViewById(R.id.reg_password2);
        mCreateBtn2=(Button) findViewById(R.id.reg_create_btn2);

        mCreateBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email=mEmail2.getText().toString();
                String password=mPassword2.getText().toString();

                loginUser(email,password);
            }
        });

    }

    private void loginUser(String email, String password) {
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){

                    Intent mainIntent= new Intent(LoginActivity.this,Filler.class);
                    startActivity(mainIntent);
                    finish();

                } else {
                    Toast.makeText(LoginActivity.this,"you got some error",Toast.LENGTH_LONG).show();

                }
            }
        });

    }
}
