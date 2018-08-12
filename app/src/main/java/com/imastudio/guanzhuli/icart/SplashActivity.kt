package com.imastudio.guanzhuli.icart

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.imastudio.guanzhuli.icart.utils.SessionManager
import com.paypal.android.sdk.payments.LoginActivity
import org.jetbrains.anko.startActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        var sesi = SessionManager(this)
        //TODO 23
        Handler().postDelayed(Runnable {

            //todo 70
            if(sesi.isLoggedIn)startActivity<MainActivity>()
            else startActivity<SignInActivity>()
            finish()

        },5000)

    }


}
