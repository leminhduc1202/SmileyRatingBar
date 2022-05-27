package com.mdapp.smileyrating.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.mdapp.smileyrating.R

abstract class BaseContainerFragment : Fragment() {
    fun replaceFragment(fragment: Fragment, addToBackStack: Boolean) {
        val transaction = childFragmentManager
            .beginTransaction()
        if (addToBackStack) {
            transaction.addToBackStack(fragment.tag)
            transaction.setCustomAnimations(
                R.anim.slide_right_in,
                R.anim.slide_left_out,
                R.anim.slide_left_in,
                R.anim.slide_right_out
            )
        }
        transaction.replace(R.id.frameLayoutContainer, fragment)
        transaction.commitAllowingStateLoss()
        childFragmentManager.executePendingTransactions()
    }

    fun addFragment(fragment: Fragment, addToBackStack: Boolean) {
        val transaction = childFragmentManager
            .beginTransaction()
        if (addToBackStack) {
            transaction.addToBackStack(fragment.tag)
        }
        transaction.add(R.id.frameLayoutContainer, fragment)
        transaction.commitAllowingStateLoss()
        childFragmentManager.executePendingTransactions()
    }

    /**
     * @return true if popFragment - false if backStackEntry is empty
     */
    fun popFragment(): Boolean {
        if (childFragmentManager.backStackEntryCount > 1) {
            childFragmentManager.popBackStack()
            return true
        }
        return false
    }

    /**
     * Find current Fragment, that can be null
     */
    val currentFragment: Fragment?
        get() = childFragmentManager.findFragmentById(R.id.frameLayoutContainer)

    /**
     * This function is used to pop all fragment
     */
    fun popAllFragment() {
        if (childFragmentManager.backStackEntryCount > 1) {
            childFragmentManager.popBackStack(
                childFragmentManager.getBackStackEntryAt(1).id,
                FragmentManager.POP_BACK_STACK_INCLUSIVE
            )
        }
    }

    abstract fun resetPageViewPager()
}
