package com.isolina.demo.data.repository

import com.isolina.demo.data.impl.entity.IssuesResponse
import com.isolina.demo.data.impl.entity.PublicationsResponse
import com.isolina.demo.domain.base.Output

interface Repository {
    suspend fun publications(): Output<PublicationsResponse> = publications()
    suspend fun issues(id: String): Output<IssuesResponse> = issues(id)
}