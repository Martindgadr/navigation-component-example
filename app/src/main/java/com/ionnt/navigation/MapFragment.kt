package com.ionnt.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_map_pois.*

/**
 * Created by Martin De Girolamo on 19/10/2018.
 */
class MapFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_map_pois, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button_home.setOnClickListener{ Navigation.findNavController(it).navigate(R.id.next_action) }

        arguments?.let {
            val safeArgs = MapFragmentArgs.fromBundle(it)
            textView_num.text = "Number of POIs: ${safeArgs.numOfPois}"
        }
    }

}
