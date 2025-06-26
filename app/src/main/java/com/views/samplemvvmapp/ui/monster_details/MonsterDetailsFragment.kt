package com.views.samplemvvmapp.ui.monster_details

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.views.samplemvvmapp.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MonsterDetailsFragment : Fragment() {

    companion object {
        fun newInstance() = MonsterDetailsFragment()
    }

    private val viewModel: MonsterDetailsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view =  inflater.inflate(R.layout.fragment_monster_details, container, false)

        viewModel.state.observe(requireActivity(), Observer {

        })

        return view
    }
}