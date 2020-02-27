package com.ark.my_app_firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.database.FirebaseDatabase;

public  class SignupActivity extends AppCompatActivity implements View.OnClickListener {

    //variable views for the signup activity
    private Button button_signup;
    private EditText email ;
    private EditText pass ;

    private EditText name ;
    private EditText phone ;
    private EditText type ;

    private ProgressBar progressBar2;
    //declaring instance of firebase auth
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        //Initializing views for this activity
        email = (EditText)findViewById(R.id.editText_signup_email);
        pass = (EditText)findViewById(R.id.editText2_signup_pass);
        name = (EditText)findViewById(R.id.editText);
        phone = (EditText)findViewById(R.id.editText2_signup_phone);
        type = (EditText)findViewById(R.id.editText3_signup_op);


        button_signup=(Button)findViewById(R.id.button_signup_page);
        progressBar2 = (ProgressBar)findViewById(R.id.progressBar_signup);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        button_signup.setOnClickListener(this);

    }


    public void registerUser(){
        final String name1 =name.getText().toString().trim();
        final String phone1 = phone.getText().toString().trim();
        final String type1 = type.getText().toString().trim();
        final String mail= email.getText().toString();
        String password = pass.getText().toString();

        if(mail.isEmpty()){
            email.setError("Email is required!");
            email.requestFocus();
            return;
        }
    /*
        if(Patterns.EMAIL_ADDRESS.matcher(mail).matches()){
            email.setError("Email is Invalid!");
            email.requestFocus();
            return;
        }*/

        if(password.length() < 6){
            pass.setError("Password should be atleast 6 characters long!");
            pass.requestFocus();
            return;

        }

        if(password.isEmpty()){
            pass.setError("Passwod is required!");
            pass.requestFocus();
            return;

        }

        progressBar2.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(mail,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                  @Override
                                  public void onComplete(@NonNull Task<AuthResult> task) {
                                      progressBar2.setVisibility(View.GONE);
                                        if(task.isSuccessful()) {

                                            //string additional fields like name, type ,phone number
                                            User user = new User(name1,mail,phone1,type1);

                                            FirebaseDatabase.getInstance().getReference("Users")
                                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                                @Override
                                                public void onComplete(@NonNull Task<Void> task) {
                                                    if(task.isSuccessful()){
                                                        //Toast.makeText(getApplicationContext(), "Successfully registered!", Toast.LENGTH_LONG).show();
                                                        finish();
                                                        Intent intent = new Intent(SignupActivity.this,profileActivity.class);
                                                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);//CLEARS ALL ACTIVITIES ON TOP OF STACK
                                                        startActivity(intent);

                                                    }else{
                                                        //display any other msg
                                                        Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_LONG).show();
                                                    }
                                                }
                                            });


                                            //CODE FOR INTENT TO THE NEXT PAGE->DASH BOARD FOR STUDENT/TUTOR
                                        }else if (task.getException() instanceof FirebaseAuthUserCollisionException){
                                            Toast.makeText(getApplicationContext(), "You are already registered!", Toast.LENGTH_LONG).show();

                                        }else{
                                            Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_LONG).show();
                                        }
                                  }
                              });



    }


   @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.button_signup_page:
                                        registerUser();
                                        break;
          /*  case  R.id.button_login:finish();
                                    startActivity(new Intent(this,MainActivity.class));
                                    break;*/
        }
    }
}
