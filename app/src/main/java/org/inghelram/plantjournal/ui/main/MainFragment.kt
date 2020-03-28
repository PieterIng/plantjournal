package org.inghelram.plantjournal.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import org.inghelram.plantjournal.R
import org.inghelram.plantjournal.data.OverviewItem
import org.inghelram.plantjournal.data.Resource
import org.inghelram.plantjournal.data.Status
import org.inghelram.plantjournal.databinding.FragmentMainBinding

private const val NUM_OF_COLUMS = 2
class MainFragment : Fragment() {
    private lateinit var viewModel: MainViewModel
    private lateinit var dataBinding: FragmentMainBinding

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)

        dataBinding.lifecycleOwner = activity
        dataBinding.mainViewModel = viewModel

        val recyclerView = dataBinding.listOverview
        recyclerView.layoutManager = GridLayoutManager(activity, NUM_OF_COLUMS)
        recyclerView.setHasFixedSize(true)

        val mainAdapter = MainAdapter(emptyList())
        val listObserver = Observer<Resource<List<OverviewItem>>> { resource ->
            if (resource.status == Status.SUCCESS) {
                mainAdapter.replaceData(resource.data)
            } else {
                Toast.makeText(activity, resource.message, Toast.LENGTH_LONG).show()
            }
        }
        viewModel.overviewItems.observe(viewLifecycleOwner, listObserver)
        viewModel.getOverViewData()

        return dataBinding.root
    }
}