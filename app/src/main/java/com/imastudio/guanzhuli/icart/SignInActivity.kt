package com.imastudio.guanzhuli.icart

import android.app.ProgressDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.imastudio.guanzhuli.icart.signIn.SignInPresenter
import com.imastudio.guanzhuli.icart.signIn.SignInView
import com.imastudio.guanzhuli.icart.signIn.model.Data
import com.imastudio.guanzhuli.icart.signUp.SignUpActivity
import kotlinx.android.synthetic.main.activity_signin.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import android.content.Intent
import com.google.android.gms.tasks.Task
import com.imastudio.guanzhuli.icart.utils.SessionManager


// http://rjtmobile.com/ansari/shopingcart/androidapp/shop_login.php?mobile=123456&password=ansari
class SignInActivity : SignInView ,AppCompatActivity(){


    //todo 67

    var sesi : SessionManager? = null

    //TODO 31
    val RC_SIGN_IN = 1
    //TODO 28
    var mGoogleSignInClient : GoogleSignInClient? = null
    var progress : ProgressDialog? = null

    var presenter : SignInPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)


        initGmail()
        //todo 68
        sesi = SessionManager(this)

        progress = ProgressDialog(this)

        presenter = SignInPresenter(this)

        button_sign_in.onClick {
            presenter?.login(Sign_in_username.text.toString(),
                    sign_in_password.text.toString())
        }

        to_sign_up.onClick {
            startActivity<SignUpActivity>()
        }

        //TODO 34
        button_fb_sign_in.onClick {

            signIn()
        }


    }

    private fun initGmail() {
        //TODO 27
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build()

        //todo 28
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        GoogleSignIn.getLastSignedInAccount(this)
                //updateUI(account)
    }

    //TODO 30
    private fun signIn() {
        val signInIntent = mGoogleSignInClient?.getSignInIntent()
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    override fun showLoading() {
        progress?.show()
    }

    override fun hideLoading() {

        progress?.dismiss()
    }

    override fun onSuccess(pesan: String, status: Boolean, data: Data) {

        //todo 68 set informasi user to session
        sesi?.nama = data.userNama
        sesi?.email = data.userEmail
        sesi?.hp = data.userNohp
        sesi?.createLoginSession("1")
        startActivity<MainActivity>()

    }

    override fun onError(msg: String) {
        toast(msg)
    }

    //TODO 32
    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        super.onActivityResult(requestCode, resultCode, data)

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            handleSignInResult(task)
        }
    }

    //TODO 33
    private fun handleSignInResult(task: Task<GoogleSignInAccount>?) {

        val email = task?.result?.email
        val name = task?.result?.displayName
        val a = task?.result?.photoUrl
        //todo 69
        sesi?.nama = name
        sesi?.email = email

        sesi?.createLoginSession("1")
        //toast(name)
       presenter?.loginGoogle(email!!,name!!)


        toast(email!!)

    }
    override fun onSucessGoogle(pesan: String?, status: Boolean?) {
        //todo 45
        if(status!!)startActivity<MainActivity>()
        else toast(pesan!!)
    }

}

