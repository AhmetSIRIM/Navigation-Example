package com.whale.navigationexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.navigate_from_first_fragment).setOnClickListener {

            val articleName =
                view.findViewById<TextView>(R.id.text_view_article_name).text.toString()

            findNavController().navigate(
                FirstFragmentDirections
                    .actionFirstFragmentToSecondFragment(articleName + "\n\nAdditionally I came from ${this.javaClass.simpleName}")
            )
        }

        view.findViewById<Button>(R.id.navigate_from_first_fragment_to_nested).setOnClickListener {
            findNavController().navigate(
                FirstFragmentDirections
                    .actionFirstFragmentToNestedNavigation()
            )
        }

    }

}