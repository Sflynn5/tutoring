package com.ark.my_app_firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button1;
    private Button button2;
    private EditText  input_email ;
    private EditText  input_pass ;
    private ProgressBar progressBar1;
    //private EditText  input_name ;

    // private EditText  input_phone ;
    private TextView output1;

    private FirebaseAuth mAuth;

    //private FirebaseDatabase db;
    //private DatabaseReference db_ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // button_send = (Button) findViewById(R.id.button_send_firebase);


        input_email = (EditText)findViewById(R.id.editText4);
        input_pass = (EditText)findViewById(R.id.editText5);
        progressBar1 = (ProgressBar)findViewById(R.id.progressBar);


       // output1 = (TextView) findViewById(R.id.textView_1);

        button2=(Button)findViewById(R.id.button_register);
        button1=(Button)findViewById(R.id.button_login);
        //calling the registerUser function:
       /* button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(this,SignupActivity.class));
            }
        });*/

       button2.setOnClickListener(this);

        //firebase objects
        //db = FirebaseDatabase.getInstance();//gives path of the root paernt of the db
        //db_ref = db.getReference();

        //authentication
        mAuth = FirebaseAuth.getInstance();

        button1.setOnClickListener(this);


    }//end of oncreate




    private void userLogin(){

        String mail= input_email.getText().toString();
        String password = input_pass.getText().toString();

        if(mail.isEmpty()){
            input_email.setError("Email is required!");
            input_email.requestFocus();
            return;
        }
    /*
        if(Patterns.EMAIL_ADDRESS.matcher(mail).matches()){
            email.setError("Email is Invalid!");
            email.requestFocus();
            return;
        }*/

        if(password.length() < 6){
            input_pass.setError("Password should be atleast 6 characters long!");
            input_pass.requestFocus();
            return;

        }

        if(password.isEmpty()){
            input_pass.setError("Passwod is required!");
            input_pass.requestFocus();
            return;

        }

        progressBar1.setVisibility(View.VISIBLE);
            //code for logging user into the firebase  auth db
            mAuth.signInWithEmailAndPassword(mail,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    progressBar1.setVisibility(View.GONE);
                    if (task.isSuccessful()) {
                        finish();
                        Intent intent = new Intent(MainActivity.this, profileActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);//CLEARS ALL ACTIVITIES ON TOP OF STACK
                        startActivity(intent);

                    } else {
                        Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_LONG).show();
                    }
                 }
                });

    }

    @Override
    protected void onStart() {
        super.onStart();

        if(mAuth.getCurrentUser() != null){//means user is already signed in
            //handle the already loged in user
            finish();
            startActivity(new Intent(this,profileActivity.class));
        }
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.button_register: // Toast.makeText(MainActivity.this, "button pressed", Toast.LENGTH_LONG).show();
                                            startActivity(new Intent(this, SignupActivity.class));
                                            break;
            case R.id.button_login: // Toast.makeText(MainActivity.this, "button pressed", Toast.LENGTH_LONG).show();
                                            userLogin();
                                            break;

        }

    }
}// end of main activity
