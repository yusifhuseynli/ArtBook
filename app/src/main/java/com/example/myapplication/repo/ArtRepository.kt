package com.example.myapplication.repo

import androidx.lifecycle.LiveData
import com.example.myapplication.api.RetrofitAPI
import com.example.myapplication.model.ImageResponse
import com.example.myapplication.roomdb.Art
import com.example.myapplication.roomdb.ArtDao
import com.example.myapplication.util.Resource
import javax.inject.Inject

class ArtRepository @Inject constructor(
    private val artDao:ArtDao,
    private val retrofitAPI: RetrofitAPI

                                        ):ArtRepositoryinterface {
    override suspend fun insertArt(art: Art) {
        artDao.insertArt(art)
    }

    override suspend fun deleteArt(art: Art) {
        artDao.deleteArt(art)
    }

    override fun grtArt(): LiveData<List<Art>> {
        return artDao.observeArts()
    }

    override suspend fun searchImage(imageString: String): Resource<ImageResponse> {
        return try {

            val response=retrofitAPI.imageSearch(imageString)
            if (response.isSuccessful)
            {
              response.body().let {
                  return@let Resource.success(it)
              }  ?:Resource.error("Error",null)
            } else{
                Resource.error("ERROR",null)
            }
        } catch (e:Exception){
            Resource.error("No INTERNET",null)
        }
    }
}