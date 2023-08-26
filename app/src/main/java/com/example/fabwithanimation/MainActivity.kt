package com.example.fabwithanimation

import android.os.Bundle
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.example.fabwithanimation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val animation = AnimationUtils.loadAnimation(
            this,
            R.anim.circle_expolsion_animation
        ).apply {
            duration = 1500
            interpolator = AccelerateDecelerateInterpolator()
        }

        with(binding) {
            floatingActionButton.setOnClickListener {
                floatingActionButton.isVisible = false
                circle.isVisible = true

                circle.startAnimation(animation) {
                    root.setBackgroundColor(
                        ContextCompat.getColor(this@MainActivity, R.color.purple_500)
                    )
                    circle.isVisible = false
                }
            }
        }
    }
}