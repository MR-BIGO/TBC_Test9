package com.example.tbc_test8.presentation.screen.home

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.tbc_test8.databinding.FragmentHomeBinding
import com.example.tbc_test8.presentation.event.HomeEvent
import com.example.tbc_test8.presentation.screen.base.BaseFragment
import com.example.tbc_test8.presentation.state.home.HomeState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    private val viewModel: HomeFragmentViewModel by viewModels()
    private lateinit var pagerAdapter: PlacePagerAdapter

    override fun setUp() {
        setUpPager()
        bindObservers()
    }

    private fun setUpPager() = with(binding) {
        pagerAdapter = PlacePagerAdapter()
        pager.adapter = pagerAdapter
    }

    private fun handleState(state: HomeState) {

        state.error?.let {
            Toast.makeText(context, state.error, Toast.LENGTH_SHORT).show()
            viewModel.onEvent(HomeEvent.ResetError)
        }

        state.data?.let {
            pagerAdapter.setItems(state.data)
            pagerAdapter.notifyItemRangeChanged(0, state.data.size)
        }
    }

    private fun bindObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.homeState.collect {
                    handleState(it)
                }
            }
        }
    }
}