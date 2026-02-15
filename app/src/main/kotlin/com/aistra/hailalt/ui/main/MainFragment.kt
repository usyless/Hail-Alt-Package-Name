package com.aistra.hailalt.ui.main

import androidx.fragment.app.Fragment

abstract class MainFragment : Fragment() {
    protected val activity: MainActivity get() = requireActivity() as MainActivity
}