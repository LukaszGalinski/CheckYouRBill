package com.galinski.lukasz.checkbill.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.galinski.lukasz.checkbill.R
import com.galinski.lukasz.checkbill.databinding.MainMenuBinding
import com.galinski.lukasz.checkbill.presentation.MainViewModel
import devs.mulham.horizontalcalendar.HorizontalCalendar
import org.koin.androidx.viewmodel.ext.android.viewModel
class MainActivity : AppCompatActivity() {
    private val viewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: MainMenuBinding = DataBindingUtil.setContentView(this, R.layout.main_menu)
        binding.lifecycleOwner = this
        binding.mainViewModel = viewModel
        createHorizontalCalendar()
    }

    private fun createHorizontalCalendar() {
        val horizontalCalendar: HorizontalCalendar =
            HorizontalCalendar.Builder(this, R.id.horizontal_calendar)
                .range(viewModel.createStartDate(), viewModel.createEndDate())
                .build()
    }
}

