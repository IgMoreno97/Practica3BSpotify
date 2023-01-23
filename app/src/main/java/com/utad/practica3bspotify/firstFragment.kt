package com.utad.practica3bspotify

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.disklrucache.DiskLruCache.open
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.gson.Gson
import com.utad.practica3bspotify.databinding.FragmentFirstBinding
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.nio.channels.AsynchronousFileChannel.open
import java.nio.channels.Selector.open

class firstFragment : Fragment() {
    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        (activity as AppCompatActivity).supportActionBar?.setTitle("PlayList Populares")
        return binding.root
    }
        @SuppressLint("SuspiciousIndentation")
        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

        val json = readJsonFromFile("playlist.json")
        val users = Gson().fromJson(json, PlaylistsResponse::class.java)
        Log.i("MainActivity", users.data.toString())
        val bottom_navigation_view = view?.findViewById<BottomNavigationView>(R.id.bottom_navigation_view)


        val mainRecyclerView = view?.findViewById<RecyclerView>(R.id.mainRecyclerView)

        val mAdapter = MainAdapter(users.data) {
        val action = firstFragmentDirections.actionFirstFragmentToSecondFragment(it)
            findNavController().navigate(action)
        //Toast.makeText(this, it.name, Toast.LENGTH_SHORT).show()
        }
        mainRecyclerView?.layoutManager = GridLayoutManager(this.context,  2)
        mainRecyclerView?.adapter = mAdapter
    }
    //Funcion para leer archivos Json
    private fun readJsonFromFile(fileName: String): String {
        var json = ""
        val assets = requireContext().resources.assets
        try {
            val bufferedReader = BufferedReader(
                InputStreamReader(assets.open(fileName))
            )
            val paramsBuilder = StringBuilder()
            var line: String? = bufferedReader.readLine()
            while (line != null) {
                paramsBuilder.append(line)
                line = bufferedReader.readLine()
            }
            json = paramsBuilder.toString()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return json
    }
}