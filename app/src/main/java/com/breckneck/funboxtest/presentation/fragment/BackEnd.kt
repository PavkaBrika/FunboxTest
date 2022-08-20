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
import com.breckneck.funboxtest.domain.model.ItemDomain
import com.breckneck.funboxtest.domain.usecase.GetAllItemsUseCase
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.androidx.scope.fragmentScope

class BackEnd : Fragment() {

    private val getAllItems: GetAllItemsUseCase by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_back_end, container, false)

        val recyclerView : RecyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.addItemDecoration(DividerItemDecoration(view.context, DividerItemDecoration.VERTICAL))

        val addButton: ImageButton = view.findViewById(R.id.addButton)
        addButton.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_backEnd_to_addItem)
        }

        val itemClickListener = object: RecyclerViewAdapter.OnItemClickListener {
            override fun onItemClick(item: ItemDomain, position: Int) {
                val action = BackEndDirections.actionBackEndToAddItem(itemId = item.id)
                Navigation.findNavController(view).navigate(action)
            }
        }

        fragmentScope().lifecycleOwner.lifecycleScope.launch {
            Log.e("TAG", "Back End Adapter")
            val items = getAllItems.execute()
            val adapter = RecyclerViewAdapter(items, itemClickListener)
            recyclerView.adapter = adapter
        }



        return view
    }


}