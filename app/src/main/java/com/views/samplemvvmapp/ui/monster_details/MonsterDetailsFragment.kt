package com.views.samplemvvmapp.ui.monster_details

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import coil3.load
import coil3.request.crossfade
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
        val monsterId = arguments?.getString("monster_id")

        monsterId?.let {
            viewModel.getMonsterDetails(monsterId)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view =  inflater.inflate(R.layout.fragment_monster_details, container, false)

        viewModel.state.observe(requireActivity(), Observer { state ->
            val progressBar = view.findViewById<ProgressBar>(R.id.progress_circular_details)
            val detailsView = view.findViewById<ConstraintLayout>(R.id.monster_details)

            progressBar.visibility = if (state.isLoading) View.VISIBLE else View.GONE
            detailsView.visibility = if (state.isLoading) View.INVISIBLE else View.VISIBLE

            with(detailsView) {
                val image = detailsView.findViewById<ImageView>(R.id.imageView)
                val title = detailsView.findViewById<TextView>(R.id.monster_title)
                val desc = detailsView.findViewById<TextView>(R.id.monster_description)
                if (!state.details.image.isNullOrEmpty()) {
                    Log.i("TAG", "onCreateView: Data Loaded URL: https://www.dnd5eapi.co/${state.details.image}")
                    image.load(
                        "https://www.dnd5eapi.co" + state.details.image!!
                    ) {
                        crossfade(true)
                    }
                }
                desc.text = context.getString(R.string.description, state.details.desc ?: "None")
                title.text = state.details.name ?: "Monster"
            }
        })

        return view
    }
}