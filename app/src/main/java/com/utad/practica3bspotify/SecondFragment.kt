package com.utad.practica3bspotify

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.gson.Gson
import com.utad.practica3bspotify.databinding.FragmentFirstBinding
import com.utad.practica3bspotify.databinding.FragmentSecondBinding
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader


class SecondFragment : Fragment() {
    val args: SecondFragmentArgs by navArgs()
    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        (activity as AppCompatActivity).supportActionBar?.setTitle(args.playlist.name + " " + args.playlist.surname)
        return binding.root
    }
    @SuppressLint("SuspiciousIndentation")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val playlist = args.playlist

        val bottom_navigation_view = view?.findViewById<BottomNavigationView>(R.id.bottom_navigation_view)


        val mainRecyclerView2 = view?.findViewById<RecyclerView>(R.id.mainRecyclerView2)

        val mAdapter = Main2Adapter(playlist.canciones) {

            //Toast.makeText(this, it.name, Toast.LENGTH_SHORT).show()
        }
        mainRecyclerView2?.layoutManager = GridLayoutManager(this.context,  1)
        mainRecyclerView2?.adapter = mAdapter


    }


}