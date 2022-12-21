package com.isolina.demo.data.service

import com.isolina.demo.data.base.Constants
import com.isolina.demo.data.impl.entity.IssuesResponse
import com.isolina.demo.data.impl.entity.PublicationsResponse
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @Headers("Authorization: ${Constants.AUTHENTICATION}")
    @GET("publications")
    suspend fun publications(): Response<PublicationsResponse>

    @Headers("Authorization: ${Constants.AUTHENTICATION}")
    @GET("issues/{id}")
    suspend fun issues(@Path("id") id: String): Response<IssuesResponse>
}