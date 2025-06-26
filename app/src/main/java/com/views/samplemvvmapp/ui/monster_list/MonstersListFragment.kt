package com.views.samplemvvmapp.ui.monster_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.views.samplemvvmapp.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

/**
 * A fragment representing a list of Items.
 */
@AndroidEntryPoint
class MonstersListFragment : Fragment() {
    private val viewModel by viewModels<MonsterListViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_monsters_list, container, false)
//        val navController

        lifecycleScope.launch {
            viewModel.state.observe(requireActivity(), Observer { state ->
                val progressBar = view.findViewById<ProgressBar>(R.id.progress_circular)
                val recyclerView = view.findViewById<RecyclerView>(R.id.list)

                progressBar.visibility = if (state.isLoading) View.VISIBLE else View.GONE
                recyclerView.visibility = if (state.isLoading) View.INVISIBLE else View.VISIBLE

                with(recyclerView) {
                    layoutManager = LinearLayoutManager(context)
                    adapter = MyMonstersListDetailsRecyclerViewAdapter(
                        values = state.list,
                        onItemClick = {
                            val bundle = Bundle()
                            bundle.putString("monster_id", it.index)
                            findNavController().navigate(
                                R.id.action_monsterListFragment_to_monsterDetailFragment,
                                bundle
                            )
                        }
                    )
                }
            })
        }

        return view
    }
}