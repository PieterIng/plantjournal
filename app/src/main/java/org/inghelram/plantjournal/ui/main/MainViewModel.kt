package org.inghelram.plantjournal.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.inghelram.plantjournal.data.OverviewItem
import org.inghelram.plantjournal.data.Response
import org.inghelram.plantjournal.repository.OverviewRepository

class MainViewModel : ViewModel() {
    val overviewItems = MutableLiveData<Response<ArrayList<OverviewItem>>>()

    fun getOverViewData(): List<OverviewItem> {
        val overviewRepository = OverviewRepository()
        //todo
        return emptyList()
    }
}
