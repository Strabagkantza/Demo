package com.isolina.demo.data.remote

import com.isolina.demo.data.base.BaseRemoteDataSource
import com.isolina.demo.data.impl.entity.IssuesResponse
import com.isolina.demo.data.impl.entity.PublicationsResponse
import com.isolina.demo.data.service.ApiService
import com.isolina.demo.domain.base.Output
import retrofit2.Retrofit
import javax.inject.Inject

class RepositoryDataSource @Inject constructor(
    private val apiService: ApiService, retrofit: Retrofit
) : BaseRemoteDataSource(retrofit) {

    suspend fun publications(): Output<PublicationsResponse> {
        return getResponse(
            request = { apiService.publications() },
            defaultErrorMessage = "C'è stato un errore. Ti preghiamo di riprovare"
        )
    }

    suspend fun issues(id: String): Output<IssuesResponse> {
        return getResponse(
            request = { apiService.issues(id) },
            defaultErrorMessage = "C'è stato un errore. Ti preghiamo di riprovare"
        )
    }
}