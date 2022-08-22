package com.breckneck.funboxtest.presentation.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.breckneck.funboxtest.R
import com.breckneck.funboxtest.adapter.RecyclerViewAdapter
import com.breckneck.funboxtest.adapter.ViewPagerAdapter
import com.breckneck.funboxtest.domain.model.ItemDomain
import com.breckneck.funboxtest.domain.usecase.GetAllItemsUseCase
import com.breckneck.funboxtest.presentation.viewmodel.MainViewModel
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.androidx.scope.fragmentScope
import org.koin.androidx.viewmodel.ext.android.viewModel

class BackEnd : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_back_end, container, false)

        val vm by requireActivity().viewModel<MainViewModel>()

        val recyclerView : RecyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.addItemDecoration(DividerItemDecoration(view.context, DividerItemDecoration.VERTICAL))

        val addButton: ImageButton = view.findViewById(R.id.addButton)
        addButton.setOnClickListener {
            val action = BackEndDirections.actionBackEndToAddItem(itemId = -1)
            Navigation.findNavController(view).navigate(action)
        }

        val itemClickListener = object: RecyclerViewAdapter.OnItemClickListener {
            override fun onItemClick(item: ItemDomain, position: Int) {
                val action = BackEndDirections.actionBackEndToAddItem(itemId = item.id)
                Navigation.findNavController(view).navigate(action)
            }
        }

        vm.getAllItems()
        vm.resultItemList.observe(viewLifecycleOwner) { items ->
            val adapter = RecyclerViewAdapter(items, itemClickListener)
            recyclerView.adapter = adapter
        }

        return view
    }


}