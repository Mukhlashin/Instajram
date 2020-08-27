package cookode.instagram_clone.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

import cookode.instagram_clone.R
import cookode.instagram_clone.activities.AccountSettingActivity
import kotlinx.android.synthetic.main.fragment_profile.view.*

/**
 * A simple [Fragment] subclass.
 */
class ProfileFragment : Fragment() {

    private lateinit var profileId : String
    private lateinit var firebaseUser : FirebaseUser

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewProfile = inflater.inflate(R.layout.fragment_profile, container, false)

        firebaseUser = FirebaseAuth.getInstance().currentUser!!

        val pref = context?.getSharedPreferences("Prefs", Context.MODE_PRIVATE)
        if (pref != null) {
            this.profileId = pref.getString("profileId", "none")!!
        }

        if (profileId == firebaseUser.uid) {
            view?.btn_edit_account?.text = "Edit Profile"
        } else if (profileId != firebaseUser.uid) {
            cekFollowAndFollowingButtonStatus()
        }
        viewProfile.btn_edit_account.setOnClickListener {
            startActivity(Intent(context, AccountSettingActivity::class.java))
        }

        getFollowers()
        getFollowings()
        userInfo()

        return viewProfile
    }

    private fun cekFollowAndFollowingButtonStatus() {

    }

    private fun getFollowers() {

    }

    private fun getFollowings() {

    }

    private fun userInfo() {

    }
}
