package com.example.foodike.presentation.onboarding.util

import com.example.foodike.R

class OnboardingItem(
    val title: Int,
    val text: Int,
    val image: Int
) {
    companion object {
        fun get(): List<OnboardingItem> {
            return listOf(
                OnboardingItem(
                    R.string.onboardingHeading1,
                    R.string.onboardingText1,
                    R.drawable.chinese_bowl
                ),
                OnboardingItem(
                    R.string.onboardingHeading2,
                    R.string.onboardingText2,
                    R.drawable.rider
                ),
                OnboardingItem(
                    R.string.onboardingHeading3,
                    R.string.onboardingText3,
                    R.drawable.clock
                )

            )

        }
    }
}