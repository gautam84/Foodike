package com.example.foodike.presentation.onboarding.util

import com.example.foodike.R

class OnBoardingItem(
    val title: Int,
    val text: Int,
    val image: Int
) {
    companion object {
        fun get(): List<OnBoardingItem> {
            return listOf(
                OnBoardingItem(
                    R.string.onboardingHeading1,
                    R.string.onboardingText1,
                    R.drawable.chinese_bowl
                ),
                OnBoardingItem(
                    R.string.onboardingHeading2,
                    R.string.onboardingText2,
                    R.drawable.rider
                ),
                OnBoardingItem(
                    R.string.onboardingHeading3,
                    R.string.onboardingText3,
                    R.drawable.clock
                )

            )

        }
    }
}