package com.example.mangaapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.mangaapp.R;
import com.example.mangaapp.databinding.ActivityLoginBinding;
import com.example.mangaapp.fragment.UserFragment;
import com.example.mangaapp.viewmodel.LoginViewModel;

public class LoginActivity extends AppCompatActivity {
    private ActivityLoginBinding binding;
    private LoginViewModel loginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);

        binding = DataBindingUtil.setContentView(this,R.layout.activity_login);
        String user = String.valueOf(binding.editTextUsername.getText());
        String pass = String.valueOf(binding.editTextPassword.getText());
        binding.buttonLogin.setOnClickListener(v -> {
            if(checkData(user,pass)) {
                Toast.makeText(this, "Success", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(this, UserFragment.class);
                startActivity(intent);
            }
            else Toast.makeText(this, "Failed", Toast.LENGTH_LONG).show();
        });

    }


    private boolean checkData(String user, String pass) {
        Log.d("BBBB", String.valueOf(loginViewModel.fetchUser(user,pass)));
        if(loginViewModel.fetchUser(user,pass)) {
            return true;
        }
        return false;
    }
}