package com.inonitylab.checklist.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

import com.inonitylab.checklist.CheckListApp;
import com.inonitylab.checklist.R;
import com.inonitylab.checklist.db.PreferencesHelper;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {
    @BindView(R.id.etName)
    EditText editTextName;

    @Inject
    PreferencesHelper preferencesHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ((CheckListApp) getApplication()).getApplicationComponent().inject(this);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.buttonStart)
    public void onBttonStartClicked() {
        if (!editTextName.getText().toString().isEmpty()) {
            saveUserName();
            gotoLogin();
        } else if (preferencesHelper.getUserName() == null) {
            Toast.makeText(getApplicationContext(), "Please Enter Your Name", Toast.LENGTH_LONG).show();
        } else {
            gotoLogin();
        }
    }

    private void saveUserName() {
        preferencesHelper.setUserName(editTextName.getText().toString());
    }

    private void gotoLogin() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
