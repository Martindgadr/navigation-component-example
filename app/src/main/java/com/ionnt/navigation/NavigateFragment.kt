package com.ionnt.navigation

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.fragment_navigate.*
import java.util.*

/**
 * Created by Martin De Girolamo on 19/10/2018.
 */
class NavigateFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_navigate, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button_photos.setOnClickListener {
            val random = Random()

            val nextAction = NavigateFragmentDirections.nextAction()
            nextAction.setNumOfPois(random.nextInt(100))

            Navigation.findNavController(it).navigate(nextAction)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater?.inflate(R.menu.menu_camera, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val navController = NavHostFragment.findNavController(this)
        val navigated = NavigationUI.onNavDestinationSelected(item!!, navController)
        return navigated || super.onOptionsItemSelected(item)
    }
}
