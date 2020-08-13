package com.example.materialdesign;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    private TextInputLayout mUsernameForm;
    private TextInputLayout mPasswordForm;
    private TextInputEditText mUsername;
    private TextInputEditText mPassword;
    private Button mSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();

        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validateInput())
                    Toast.makeText(MainActivity.this, getString(R.string.submit), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void initUI() {
        mPassword = findViewById(R.id.password);
        mUsername = findViewById(R.id.username);
        mUsernameForm = findViewById(R.id.username_form);
        mPasswordForm = findViewById(R.id.password_form);
        mSubmit = findViewById(R.id.submit);
    }

    private boolean validateInput() {
        if (mUsername.getText().toString().trim().isEmpty()) {
            mUsernameForm.setErrorEnabled(true);
            mUsernameForm.setError("Field cannot be empty!");
            return false;
        }
        mUsernameForm.setErrorEnabled(false);
        return true;
    }
}