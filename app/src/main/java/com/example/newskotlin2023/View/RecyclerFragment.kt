package com.example.newskotlin2023.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newskotlin2023.R
import com.example.newskotlin2023.reyclerAdapter.RecyclerAdapter
import com.example.newskotlin2023.viewModel.MainViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 * Use the [RecyclerFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RecyclerFragment : Fragment() {
    lateinit var adapter: RecyclerAdapter
    // TODO: Rename and change types of parameters




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
val view = inflater.inflate(R.layout.fragment_recycler, container, false)
        initView(view)
        initViewModel()
        return view
    }

    private fun initView(view: View){
        adapter= RecyclerAdapter()
       val recyc= view.findViewById<RecyclerView>(R.id.recycleree)
        recyc.layoutManager=LinearLayoutManager(activity)
        val decoration=DividerItemDecoration(activity,DividerItemDecoration.VERTICAL)
        recyc.addItemDecoration(decoration)
        recyc.setHasFixedSize(true)
        recyc.adapter=adapter

    }

    private fun initViewModel(){
        val viewModel=ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.getLiveData().observe(this, Observer {
            if (it !=null){
                adapter.setUP(it.items)
            }else{
                Toast.makeText(activity,"Null data error",Toast.LENGTH_LONG).show()
            }
        })
        viewModel.makeApiCall()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment RecyclerFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            RecyclerFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}