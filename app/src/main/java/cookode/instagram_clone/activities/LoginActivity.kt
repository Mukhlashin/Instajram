package cookode.instagram_clone.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import cookode.instagram_clone.MainActivity
import cookode.instagram_clone.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    val mAuth : FirebaseAuth = FirebaseAuth.getInstance()
    val email : String = edt_email_login.text.toString()
    val password : String = edt_password_login.text.toString()
    val progressBar = ProgressBar(this@LoginActivity)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btn_login.setOnClickListener {
            loginUser()
        }

        btn_signup_link.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }

    private fun loginUser() {
        when {
            TextUtils.isEmpty(email) ->
                Toast.makeText(this, "Email tidak boleh kosong", Toast.LENGTH_LONG).show()
            TextUtils.isEmpty(password) ->
                Toast.makeText(this, "Password tidak boleh kosong", Toast.LENGTH_LONG).show()
            else -> {
                progressBar.visibility = View.VISIBLE
                mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {task ->
                    if (task.isSuccessful) {
                        progressBar.visibility = View.GONE
                        startActivity(Intent(this, MainActivity::class.java)
                            .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK))
                        finish()
                    } else {
                        progressBar.visibility = View.GONE
                        mAuth.signOut()
                        Toast.makeText(this, "Email atau Password salah", Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }

    override fun onStart() {
        if (mAuth.currentUser != null) {
            startActivity(Intent(this, MainActivity::class.java)
                .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK))
            finish()
        }
        super.onStart()
    }

}
