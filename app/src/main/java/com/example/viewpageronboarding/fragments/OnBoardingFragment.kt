package com.example.viewpageronboarding.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.viewpageronboarding.R
import com.example.viewpageronboarding.adapter.ViewPagerAdapter
import com.example.viewpageronboarding.fragments.onboarding.DateFagment
import com.example.viewpageronboarding.fragments.onboarding.DestinationFragment
import com.example.viewpageronboarding.fragments.onboarding.RelaxingFragment
import com.example.viewpageronboarding.utils.ZoomOutPageTransformer
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator

class OnBoardingFragment: Fragment() {
    private lateinit var nextButton: Button
    private lateinit var prevButton: Button
    lateinit var viewPager: ViewPager2
    private lateinit var dots: DotsIndicator
    private var fragments = ArrayList<Fragment>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_onboarding,container,false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
        initViewPager(view)
    }
    //initialize the views
    private fun initViews(view: View) {
        nextButton = view.findViewById(R.id.next_button)
        prevButton = view.findViewById(R.id.prev_button)


    }
    //initialize the viewpager
    private fun initViewPager(view:View) {
        fragments.add(DestinationFragment())
        fragments.add(DateFagment())
        fragments.add(RelaxingFragment())
        dots = view.findViewById<DotsIndicator>(R.id.worm_dots_indicator)
        val adapter = ViewPagerAdapter(requireActivity(), fragments)
        viewPager = view.findViewById(R.id.viewPager)
        viewPager.setPageTransformer(ZoomOutPageTransformer())
        viewPager.adapter = adapter
        dots.setViewPager2(viewPager)

        //provides moving back and forward between fragments
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                if(position == 0){
                    prevButton.visibility = View.GONE
                }
                else if (position == fragments.size - 1) {
                    prevButton.visibility = View.VISIBLE
                    nextButton.text = "Finish"
                    nextButton.setOnClickListener {
                        findNavController().navigate(R.id.action_onBoardingFragment_to_homeFragment)
                    }
                } else {
                    prevButton.visibility = View.VISIBLE
                    nextButton.text = "Next"
                    nextButton.setOnClickListener {
                        viewPager.currentItem = viewPager.currentItem + 1
                    }
                    prevButton.setOnClickListener{
                        viewPager.currentItem = viewPager.currentItem - 1
                    }

                }
            }
        })

    }
}
