package com.capstone.residentialcommunicationsapp.datamodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.capstone.residentialcommunicationsapp.api.ApiForAuthentication.propertyApi
import com.capstone.residentialcommunicationsapp.repositories.PropertyRepository
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class PropertyViewModel : ViewModel(){

    private val parentJob = Job()

    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Default

    private val scope = CoroutineScope(coroutineContext)

    private val repository : PropertyRepository = PropertyRepository(propertyApi)

    val propertyLiveData = MutableLiveData<MutableList<Property>>()


    fun fetchProperty(){
        scope.launch {
            val property = repository.getProperty()
            propertyLiveData.postValue(property)
        }
    }

    fun cancelAllRequests() = coroutineContext.cancel()
}
