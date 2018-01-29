package com.example.mm.smartschool;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class EditProfileActivity extends AppCompatActivity {

    private static final String TAG = EditProfileActivity.class.getSimpleName();

    private EditText editProfileName;

    private EditText editProfilePhoneNumber;

    private EditText editProfileEmail;

    private EditText editProfilePassword;

    private EditText editProfileStudent_class;

    private FirebaseAuth.AuthStateListener authStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        setTitle("Edit Profile Information");

        editProfileName = (EditText) findViewById(R.id.profile_name);
        editProfilePhoneNumber = (EditText) findViewById(R.id.student_phone);
        editProfileStudent_class = (EditText) findViewById(R.id.student_class);
        editProfileEmail = (EditText) findViewById(R.id.edit_e_mail);
        editProfilePassword = (EditText) findViewById(R.id.edit_password);

        Button saveEditButton = (Button) findViewById(R.id.save_edit_button);

        saveEditButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String profileName = editProfileName.getText().toString();
                String profilephonenumber = editProfilePhoneNumber.getText().toString();
                String profilestudentclass = editProfileStudent_class.getText().toString();
                String profileemail = editProfileEmail.getText().toString();
                String profilePassword = editProfilePassword.getText().toString();

                // update the user profile information in Firebase database.
                if (TextUtils.isEmpty(profileName) || TextUtils.isEmpty(profilephonenumber) || TextUtils.isEmpty(profilestudentclass)
                        || TextUtils.isEmpty(profileemail) || TextUtils.isEmpty(profilePassword)) {
                    Toast.makeText(EditProfileActivity.this, "All fields must be filled", Toast.LENGTH_SHORT).show();
                }

                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if (user == null) {
                    Intent firebaseUserIntent = new Intent(EditProfileActivity.this, LoginActivity.class);
                    startActivity(firebaseUserIntent);
                    finish();
                } else {
                    String userId = user.getProviderId();
                    String id = user.getUid();
                    String profileEmail = user.getEmail();

                    FirebaseUserEntity userEntity = new FirebaseUserEntity(id, profileEmail, profileName, profilephonenumber, profileEmail, profilestudentclass,profilePassword);
                    FirebaseDatabaseHelper firebaseDatabaseHelper = new FirebaseDatabaseHelper();
                    firebaseDatabaseHelper.createUserInFirebaseDatabase(id, userEntity);

                    editProfileName.setText("");
                    editProfileStudent_class.setText("");
                    editProfilePhoneNumber.setText("");
                    editProfileEmail.setText("");
                    editProfilePassword.setText("");
                }
            }
        });
    }
}