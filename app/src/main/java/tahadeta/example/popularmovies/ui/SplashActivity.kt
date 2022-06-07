package tahadeta.example.popularmovies.ui

import android.animation.Animator
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView
import com.example.popularmovies.R

class SplashActivity : AppCompatActivity() {

    var isShow = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // get the instance of the animated JSON
        val animationView: LottieAnimationView = findViewById(R.id.animationView)

        animationView.addAnimatorListener(object : Animator.AnimatorListener {
            @RequiresApi(Build.VERSION_CODES.M)
            override fun onAnimationRepeat(animation: Animator?) {
                // Do nothing
                val internet = isOnline(applicationContext)
                if (internet && isShow) {
                    val intent = Intent(this@SplashActivity, MainActivity::class.java)
                    startActivity(intent)
                } else if(isShow){
                    isShow = false
                    showErrorPopUpNumeroErrone()
                }
            }

            override fun onAnimationEnd(animation: Animator?) {
                // Do nothing
            }

            override fun onAnimationCancel(animation: Animator?) {
                // Do nothing
            }

            override fun onAnimationStart(animation: Animator?) {
                // Do nothing
            }
        })
    }

    fun showErrorPopUpNumeroErrone() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.no_internet_view)

        var okTV = dialog.findViewById<TextView>(R.id.okBtn)

        okTV.setOnClickListener {
            dialog.dismiss()
        }

        // textViewTitle.text = if(title.isNullOrEmpty())  else title
        val width = resources.displayMetrics.widthPixels * 0.90
        val height = resources.displayMetrics.heightPixels * 0.40
        dialog.window?.setLayout(width.toInt(), height.toInt())
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.show()
    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun isOnline(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (connectivityManager != null) {
            val capabilities =
                connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            if (capabilities != null) {
                if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                    Log.i("Internet", "NetworkCapabilities.TRANSPORT_CELLULAR")
                    return true
                } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                    Log.i("Internet", "NetworkCapabilities.TRANSPORT_WIFI")
                    return true
                } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)) {
                    Log.i("Internet", "NetworkCapabilities.TRANSPORT_ETHERNET")
                    return true
                }
            }
        }
        return false
    }
}
