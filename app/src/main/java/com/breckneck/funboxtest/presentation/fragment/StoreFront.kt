package com.breckneck.funboxtest.presentation.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.viewpager2.widget.ViewPager2
import com.breckneck.funboxtest.R
import com.breckneck.funboxtest.adapter.ViewPagerAdapter
import com.breckneck.funboxtest.domain.model.ItemDomain
import com.breckneck.funboxtest.domain.usecase.AddItemUseCase
import com.breckneck.funboxtest.domain.usecase.CheckWasOpenedUseCase
import com.breckneck.funboxtest.domain.usecase.GetAllItemsUseCase
import com.breckneck.funboxtest.domain.usecase.UpdateItemUseCase
import com.breckneck.funboxtest.presentation.activity.MainActivity
import com.breckneck.funboxtest.presentation.viewmodel.MainViewModel
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.androidx.scope.fragmentScope
import org.koin.androidx.viewmodel.ext.android.viewModel


class StoreFront : Fragment() {

    private val addItem: AddItemUseCase by inject()
    private val wasOpened: CheckWasOpenedUseCase by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_store_front, container, false)
        val viewPager : ViewPager2 = view.findViewById(R.id.viewPager)

        val vm by requireActivity().viewModel<MainViewModel>()

        val buyButtonClickListener = object: ViewPagerAdapter.OnBuyButtonClickListener {
            override fun onBuyButtonClick(item: ItemDomain) {
                vm.buyItem(ItemDomain(id = item.id, name = item.name, price = item.price, quantity = item.quantity))
                Toast.makeText(view.context, resources.getString(R.string.toastBuy), Toast.LENGTH_SHORT).show()
            }
        }

        fragmentScope().lifecycleOwner.lifecycleScope.launch {
            if (!wasOpened.execute()) {
                Log.e("TAG", "Test data uploaded")
                addItem.execute(name = "Apple iPod touch 5 32Gb", price = 8888.0, quantity = 5)
                addItem.execute(name = "Samsung Galaxy S Duos S7562", price = 7230.0, quantity = 2)
                addItem.execute(name = "Canon EOS 600D Kit", price = 15659.0, quantity = 4)
                addItem.execute(name = "Samsung Galaxy Tab 2 10.1 P5100 16Gb", price = 13290.0, quantity = 9)
                addItem.execute(name = "PocketBook Touch", price = 5197.0, quantity = 2)
                addItem.execute(name = "Samsung Galaxy Note II 16Gb", price = 17049.50, quantity = 2)
                addItem.execute(name = "Nikon D3100 Kit", price = 12190.0, quantity = 4)
                addItem.execute(name = "Canon EOS 1100D Kit", price = 10985.0, quantity = 2)
                addItem.execute(name = "Sony Xperia acro S", price = 11800.99, quantity = 1)
                addItem.execute(name = "Lenovo G580", price = 8922.0, quantity = 1)
            }
        }

        Log.e("TAG", "Store Front adapter")
        vm.getAllItems()

        vm.resultItemList.observe(viewLifecycleOwner) { items ->
            val adapter = ViewPagerAdapter(items, buyButtonClickListener)
            viewPager.adapter = adapter
        }

        return view
    }
}