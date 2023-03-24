package com.practicum.sharedpreferncesfragments

import androidx.fragment.app.Fragment

fun Fragment.navigator() : Navigator{
    return requireActivity() as Navigator
}

interface Navigator {

    fun showSecondFragment()

    fun goBack()
}