package com.inonitylab.checklist.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.inonitylab.checklist.CheckListApp;
import com.inonitylab.checklist.R;
import com.inonitylab.checklist.db.DataManager;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {
    @BindView(R.id.etName)
    EditText editTextName;

    @Inject
    DataManager mDataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ((CheckListApp) getApplication()).getApplicationComponent().inject(this);
        ButterKnife.bind(this);
    }
    
    @OnClick(R.id.buttonStart)
    public void onBttonStartClicked(){
        if (editTextName.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(),"Please Enter Your Name",Toast.LENGTH_LONG).show();
        }else {
            saveUserName();
            Intent intent = new Intent(LoginActivity.this,MainActivity.class);
            startActivity(intent);
        }
    }

    private void saveUserName() {
        mDataManager.setUserName(editTextName.getText().toString());
    }
}
