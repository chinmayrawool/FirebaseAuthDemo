package com.mad.firebaseauthdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileActivity extends AppCompatActivity {
    private TextView textViewHi;
    private Button btnLogout;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        firebaseAuth = FirebaseAuth.getInstance();
        textViewHi = (TextView) findViewById(R.id.textViewHi);
        btnLogout = (Button) findViewById(R.id.btn_logout);

        FirebaseUser user = firebaseAuth.getCurrentUser();
        if(user!=null) {
            String name = user.getEmail();
            textViewHi.setText("HI " + name);
        }else{
            textViewHi.setText("No User");
        }
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseAuth.signOut();
                startActivity(new Intent(getApplicationContext(),LoginActivity.class));
            }
        });
    }
}
