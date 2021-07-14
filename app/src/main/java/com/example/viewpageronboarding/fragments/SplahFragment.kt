package com.example.viewpageronboarding.fragments

import android.animation.Animator
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.airbnb.lottie.LottieAnimationView
import com.example.viewpageronboarding.R

class SplahFragment: Fragment() {
    private lateinit var animation: LottieAnimationView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_splash,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        animation = view.findViewById(R.id.animation_view)
        //listens the animation
        animation.addAnimatorListener(object:Animator.AnimatorListener{
            override fun onAnimationStart(animation: Animator?) {

            }
            //moves to onBoarding fragment when it finishes
            override fun onAnimationEnd(animation: Animator?) {
                findNavController().navigate(R.id.action_splahFragment_to_onBoardingFragment)
            }

            override fun onAnimationCancel(animation: Animator?) {
            }

            override fun onAnimationRepeat(animation: Animator?) {

            }

        })

    }

}