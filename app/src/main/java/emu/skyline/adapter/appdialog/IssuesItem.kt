/*
 * SPDX-License-Identifier: MPL-2.0
 * Copyright © 2022 Skyline Team and Contributors (https://github.com/skyline-emu/)
 */

package emu.skyline.adapter.appdialog

import android.view.View
import android.view.ViewGroup
import emu.skyline.adapter.GenericListItem
import emu.skyline.adapter.ViewBindingFactory
import emu.skyline.adapter.inflater
import emu.skyline.databinding.AppDialogIssuesItemBinding

object AppDialogIssuesItemBindingFactory : ViewBindingFactory {
    override fun createBinding(parent : ViewGroup) = AppDialogIssuesItemBinding.inflate(parent.inflater(), parent, false)
}

class IssuesItem(private val title : String, private val description : String) : GenericListItem<AppDialogIssuesItemBinding>() {
    override fun getViewBindingFactory() = AppDialogIssuesItemBindingFactory

    override fun bind(binding : AppDialogIssuesItemBinding, position : Int) {
        binding.title.text = title
        binding.description.text = description

        binding.root.setOnClickListener {
            if (binding.expandButton.isActivated) {
                binding.expandButton.rotation = 0F
                binding.description.visibility = View.GONE
                binding.title.isSingleLine = true
            } else {
                binding.expandButton.rotation = 180F
                binding.description.visibility = View.VISIBLE
                binding.title.isSingleLine = false
            }
            binding.expandButton.isActivated = !binding.expandButton.isActivated
        }
    }
}