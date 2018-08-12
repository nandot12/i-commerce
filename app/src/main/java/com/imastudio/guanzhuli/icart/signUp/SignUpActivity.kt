package com.imastudio.guanzhuli.icart.signUp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.imastudio.guanzhuli.icart.MainActivity
import com.imastudio.guanzhuli.icart.R
import com.imastudio.guanzhuli.icart.SignInActivity
import com.paypal.android.sdk.payments.LoginActivity
import kotlinx.android.synthetic.main.activity_signup.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.noButton
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.yesButton


//TODO 15 set view di activity
class SignUpActivity : AppCompatActivity(),SignUpView {


    //TODO 16 deklrasi presenter SignUp
    var presenter : SignUpPresenterImp? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        //TODO 17 inisialisasi presenter
        presenter = SignUpPresenterImp(this)

        //TODO 18 listener button
        button_sign_up.onClick {

            //TODO 19 get logic presenter
            presenter?.signUp(sign_up_username.text.toString(),
                    sign_up_email.text.toString(),
                    sign_up_alamat.text.toString(),
                    sign_up_password.text.toString(),
                    sign_up_password2.text.toString(),
                    sign_up_mobile.text.toString())
        }

    }



    override fun onSuccess(msg: String, status: Boolean) {
        //TODO 20 eksekusi response dari presenter
        if(status) startActivity<SignInActivity>()
        else tampilAlert(msg)
    }

    override fun onError(msg: String) {
        //todo 21
        tampilAlert(msg)
    }
//todo 22 create alert
    private fun tampilAlert(msg: String) {
    alert {
        title = "Information"
        message = msg
        noButton {  }
        yesButton {  }
    }.show()
}


}
