package com.msewa.testvpqaar

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.msewa.vpqlib.model.merchant.Merchant
import com.msewa.vpqlib.model.merchant.PayQwikInit
import com.msewa.vpqlib.util.MerchantGateway

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val token = "MTUwMTA5MzU3NjIxNzM1NjAwMDAwMDAwMDAwMDU="
    private val secret_key = "5CF67A47D71A60F6759DDDC44C41D36E3B1E0D75"

    private val base_url = "http://106.51.8.246/Api/v1/User/Android/en/sdk/api/payment/";
    private val trans_url = "SuccessTransaction"
    private val init_url = "InitiateTransaction"
    private val mobileNum = "8800241872"

    private val deviceID = "TestDeviceID"



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLive.setOnClickListener {
            Toast.makeText(this@MainActivity, "You clicked live.", Toast.LENGTH_SHORT).show()
        }

        btnTest.setOnClickListener {

            //Generate Transaction ID at Merchant side, which can be a random order id.
            val merchant = Merchant(token, "TEST MERCHANT", secret_key, base_url, init_url, trans_url, mobileNum, deviceID)
            val api = MerchantGateway(PayQwikInit(this@MainActivity))
            api.begin(merchant)
        }

    }
}
