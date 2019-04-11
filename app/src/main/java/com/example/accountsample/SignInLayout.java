package com.example.accountsample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.accountsample.Api.ApiService;
import com.example.accountsample.Api.RetrofitClient;
import com.example.accountsample.Models.ResponseModel;
import com.example.accountsample.Models.SignInModel;
import com.example.accountsample.Models.StaticVars;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignInLayout extends AppCompatActivity {

    private ApiService _ApiService;

    EditText fName;
    EditText lName;
    EditText nationalCode;
    EditText phoneNumber;
    EditText password;
    EditText confPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_layout);
        fName = (EditText) findViewById(R.id.signIn_fName);
        lName = (EditText) findViewById(R.id.signIn_lName);
        nationalCode = (EditText) findViewById(R.id.signIn_nationalCode);
        phoneNumber = (EditText) findViewById(R.id.signIn_phoneNumber);
        password = (EditText) findViewById(R.id.signIn_pass);
        confPassword = (EditText) findViewById(R.id.signIn_confPass);


        fName.setText("محمد");
        lName.setText("ربیعی");
        nationalCode.setText("0019139136");
        phoneNumber.setText("09128003185");
        password.setText("123456");
        confPassword.setText("123456");

    }

    public void CreateUser(View view) {


        SignInModel signInModel = new SignInModel();
        signInModel.setFirstName(fName.getText().toString());
        signInModel.setLastName(lName.getText().toString());
        signInModel.setConfirmPassword(confPassword.getText().toString());
        signInModel.setPassword(password.getText().toString());
        signInModel.setNationalNumber(nationalCode.getText().toString());
        signInModel.setPhoneNumber(phoneNumber.getText().toString());
        signInModel.setUserName(phoneNumber.getText().toString());

        _ApiService= RetrofitClient.getAPIService(StaticVars.BaseUrl);
        _ApiService.SignIn(signInModel).enqueue(new Callback<ResponseModel<String>>() {
            @Override
            public void onResponse(Call<ResponseModel<String>> call, Response<ResponseModel<String>> response) {
                if(response.body().getIsSuccess()) {
                    Intent intent = new Intent(SignInLayout.this, ActivationCodeLayout.class);
                    intent.putExtra("userId",response.body().getData());
                    startActivity(intent);
                    finish();
                }
            }
            @Override
            public void onFailure(Call<ResponseModel<String>> call, Throwable t) {
                int x=9;
            }
        });



    }

}
