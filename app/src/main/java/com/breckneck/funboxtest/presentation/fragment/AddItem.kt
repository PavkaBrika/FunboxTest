package com.breckneck.funboxtest.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.breckneck.funboxtest.R
import com.breckneck.funboxtest.domain.model.ItemDomain
import com.breckneck.funboxtest.domain.usecase.AddItemUseCase
import com.breckneck.funboxtest.domain.usecase.GetItemByIdUseCase
import com.breckneck.funboxtest.domain.usecase.UpdateItemUseCase
import com.breckneck.funboxtest.presentation.viewmodel.MainViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.androidx.scope.fragmentScope
import org.koin.androidx.viewmodel.ext.android.viewModel

class AddItem : Fragment() {

    private val args: AddItemArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add_item, container, false)

        val vm by requireActivity().viewModel<MainViewModel>()

        val itemNameEditText: EditText = view.findViewById(R.id.itemNameEditText)
        val itemPriceEditText: EditText = view.findViewById(R.id.itemPriceEditText)
        val itemQuantityEditText: EditText = view.findViewById(R.id.itemQuantityEditText)

        lateinit var item: ItemDomain
        val itemId = args.itemId
        fragmentScope().lifecycleOwner.lifecycleScope.launch {
            if (itemId != -1) {
                vm.getItemById(id = itemId)
                vm.resultItem.observe(viewLifecycleOwner) {
                    item = it
                    itemNameEditText.setText(item.name)
                    itemPriceEditText.setText(item.price.toString())
                    itemQuantityEditText.setText(item.quantity.toString())
                }
            }
        }

        val saveButton: Button = view.findViewById(R.id.saveButton)
        saveButton.setOnClickListener {
            if (itemId != -1) {
                if ((itemQuantityEditText.text.toString().trim().isNotEmpty()) && (itemPriceEditText.text.toString().trim().isNotEmpty()) && (itemNameEditText.text.toString().trim().isNotEmpty())) {
                    if ((itemPriceEditText.text.toString().toDouble() > 0) && (itemQuantityEditText.text.toString().toInt() > 0)) {
                        vm.updateItem(item = ItemDomain(id = item.id, name = itemNameEditText.text.toString().trim(), price = itemPriceEditText.text.toString().toDouble(), quantity = itemQuantityEditText.text.toString().toInt()))
                        Toast.makeText(view.context, resources.getString(R.string.toastUpdate), Toast.LENGTH_SHORT).show()
                        Navigation.findNavController(view).navigate(R.id.action_addItem_to_backEnd)

                    } else {
                        Toast.makeText(view.context, resources.getString(R.string.toastError), Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(view.context, resources.getString(R.string.toastError), Toast.LENGTH_SHORT).show()
                }
            } else {
                if ((itemQuantityEditText.text.toString().trim().isNotEmpty()) && (itemPriceEditText.text.toString().trim().isNotEmpty()) && (itemNameEditText.text.toString().trim().isNotEmpty())) {
                    if ((itemPriceEditText.text.toString().toDouble() > 0) && (itemQuantityEditText.text.toString().toInt() > 0)) {
                        vm.addItem(name = itemNameEditText.text.toString().trim(), price = itemPriceEditText.text.toString().toDouble(), quantity = itemQuantityEditText.text.toString().toInt())
                        Toast.makeText(view.context, resources.getString(R.string.toastSave), Toast.LENGTH_SHORT).show()
                        Navigation.findNavController(view).navigate(R.id.action_addItem_to_backEnd)
                    } else {
                        Toast.makeText(view.context, resources.getString(R.string.toastError), Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(view.context, resources.getString(R.string.toastError), Toast.LENGTH_SHORT).show()
                }
            }
        }

        val cancelButton : Button = view.findViewById(R.id.cancelButton)
        cancelButton.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_addItem_to_backEnd)
        }

        return view
    }
}