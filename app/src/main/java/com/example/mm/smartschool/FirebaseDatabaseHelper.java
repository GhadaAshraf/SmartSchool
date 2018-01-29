package com.example.mm.smartschool;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FirebaseDatabaseHelper {

    private static final String TAG = FirebaseDatabaseHelper.class.getSimpleName();

    private DatabaseReference databaseReference;

    public FirebaseDatabaseHelper(){
        databaseReference = FirebaseDatabase.getInstance().getReference();
    }

    public void createUserInFirebaseDatabase(String userId, FirebaseUserEntity firebaseUserEntity){
        Map<String, FirebaseUserEntity> user = new HashMap<String, FirebaseUserEntity>();
        user.put(userId, firebaseUserEntity);
        databaseReference.child("users").setValue(user);
    }

    private List<UserProfile> adapterSourceData(DataSnapshot dataSnapshot, String uId){
        List<UserProfile> allUserData = new ArrayList<UserProfile>();
        if(dataSnapshot.getKey().equals(uId)){

            //data put in profile
           // FirebaseUserEntity userInformation = dataSnapshot.getValue(FirebaseUserEntity.class);
            //allUserData.add(new UserProfile(userInformation.getName());
            //allUserData.add(new UserProfile(Helper.EMAIL, userInformation.getEmail()));
            //allUserData.add(new UserProfile(Helper.BIRTHDAY, userInformation.getBirthday()));
            //allUserData.add(new UserProfile(Helper.PHONE_NUMBER, userInformation.getPhone()));
            //allUserData.add(new UserProfile(Helper.HOBBY_INTEREST, userInformation.getHobby()));
        }
        return allUserData;
    }
}
