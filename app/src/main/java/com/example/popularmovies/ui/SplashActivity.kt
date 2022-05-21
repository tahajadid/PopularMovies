package com.example.popularmovies.ui

import android.animation.Animator
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView
import com.example.popularmovies.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // get the instance of the animated JSON
        val animationView: LottieAnimationView = findViewById(R.id.animationView)

        animationView.addAnimatorListener(object : Animator.AnimatorListener {
            override fun onAnimationRepeat(animation: Animator?) {
                // Do nothing
                val intent = Intent(this@SplashActivity, MainActivity::class.java)
                startActivity(intent)
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
}
