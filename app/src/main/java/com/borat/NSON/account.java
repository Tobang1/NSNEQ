package com.borat.NSON;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class account extends AppCompatActivity {
    TextView fullNames, mainName,email,phone;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    Button mUpdateBtn;
    String userId;
    TextView gContact;
    TextView gOutline;
    ImageView profilImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        fullNames = findViewById(R.id.full_name);
        email = findViewById(R.id.Email);
        phone = findViewById(R.id.phone);
        mainName = findViewById(R.id.MFullName);
        mUpdateBtn = findViewById(R.id.btn_update);
        gContact = findViewById(R.id.booking_label);
        gOutline = findViewById(R.id.payment_label);

        profilImage = findViewById(R.id.profile_image);


        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        userId = fAuth.getCurrentUser().getUid();


        DocumentReference documentReference = fStore.collection("users").document(userId);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable  DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                phone.setText(documentSnapshot.getString("phone"));
                email.setText(documentSnapshot.getString("email"));
                mainName.setText(documentSnapshot.getString("fName"));
                fullNames.setText(documentSnapshot.getString("fName"));
            }
        });

        mUpdateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        gOutline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(account.this, ScrollingActivity.class);
                startActivity(intent);
            }
        });


        gContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(account.this, ContactUs.class);
                startActivity(intent);
            }
        });



    }


    public void sign_out(View view) {
        Snackbar.make(view, "Please go to main menu and logout", Snackbar.LENGTH_LONG)
        .setAction("Action", null).show();

    }


}