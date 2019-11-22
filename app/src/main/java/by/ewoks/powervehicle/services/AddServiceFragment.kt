package by.ewoks.powervehicle.services

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import by.ewoks.powervehicle.Fragment
import by.ewoks.powervehicle.R

class AddServiceFragment : Fragment(R.layout.fragment_add_service) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }
    }
}