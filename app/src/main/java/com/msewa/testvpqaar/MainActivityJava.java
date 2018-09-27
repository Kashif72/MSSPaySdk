package com.msewa.testvpqaar;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.msewa.vpqlib.model.merchant.Merchant;
import com.msewa.vpqlib.model.merchant.PayQwikInit;
import com.msewa.vpqlib.util.MerchantGateway;


public class MainActivityJava extends AppCompatActivity {


    private String token = "MTUwMTA5MzU3NjIxNzM1NjAwMDAwMDAwMDAwMDU=";
    private String secret_key = "5CF67A47D71A60F6759DDDC44C41D36E3B1E0D75";
    private String base_url = "http://106.51.8.246/Api/v1/User/Android/en/sdk/api/payment/";
    private String trans_url = "SuccessTransaction";
    private String init_url = "InitiateTransaction";
    private String mobileNum = "8800241872";
    private String deviceID = "TestDeviceID";





    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Generate Transaction ID at Merchant side, which can be a random order id.
        Button btnCheck = (Button) findViewById(R.id.btnTest);

        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Generate Transaction ID at Merchant side, which can be a random order id.
                Merchant merchant = new Merchant(token, "TEST MERCHANT", secret_key, base_url, init_url, trans_url, mobileNum, deviceID);
                MerchantGateway api = new MerchantGateway(new PayQwikInit(MainActivityJava.this));
                api.begin(merchant);
            }
        });

    }



}
