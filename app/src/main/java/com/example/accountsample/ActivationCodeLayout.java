package com.example.accountsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.accountsample.Api.ApiService;
import com.example.accountsample.Api.RetrofitClient;
import com.example.accountsample.Models.ActivationAccountModel;
import com.example.accountsample.Models.ResponseModel;
import com.example.accountsample.Models.StaticVars;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivationCodeLayout extends AppCompatActivity {

    private ApiService _ApiService;
    EditText codeEditText;
    String userId = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activation_code_layout);
        codeEditText = (EditText) findViewById(R.id.activation_code);

        userId=getIntent().getExtras().getString("userId");
    }

    public void ActivateClick(View view) {
        String code=codeEditText.getText().toString();

        ActivationAccountModel model=new ActivationAccountModel();
        model.setActivationCode(code);
        model.setUserId(userId);
        _ApiService = RetrofitClient.getAPIService(StaticVars.BaseUrl);
        _ApiService.ActivationAccount(model).enqueue(new Callback<ResponseModel<Boolean>>() {
            @Override
            public void onResponse(Call<ResponseModel<Boolean>> call, Response<ResponseModel<Boolean>> response) {
                finish();
            }

            @Override
            public void onFailure(Call<ResponseModel<Boolean>> call, Throwable t) {

            }
        });
    }

}
