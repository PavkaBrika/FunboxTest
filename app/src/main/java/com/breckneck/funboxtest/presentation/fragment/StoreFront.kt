package com.breckneck.funboxtest.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.breckneck.funboxtest.R
import kotlinx.coroutines.launch
import org.koin.androidx.scope.fragmentScope


class StoreFront : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_store_front, container, false)

        fragmentScope().lifecycleOwner.lifecycleScope.launch {

        }

        return view
    }
}