package com.sennohananto.retrofitkoin.ui

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.sennohananto.retrofitkoin.MoviesAdapter
import com.sennohananto.retrofitkoin.R
import com.sennohananto.retrofitkoin.data.Status
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val viewModel: MainActivityViewModel by viewModel()
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerView)

        val progressDialog = ProgressDialog(this)
        viewModel.movies.observe(this){ resource ->
            when(resource.status){
                Status.LOADING -> {
                    progressDialog.setMessage("Loading")
                    progressDialog.show()
                }

                Status.SUCCESS -> {
                    resource.data?.movies?.let {

                        val adapter = MoviesAdapter(it)
                        recyclerView.adapter = adapter

                    }
                    progressDialog.dismiss()
                }

                Status.ERROR -> {
                    Toast.makeText(this, "Error : ${resource.message}", Toast.LENGTH_SHORT).show()
                    progressDialog.dismiss()
                }
            }
        }

        viewModel.getAllPopularMovies()
    }
}