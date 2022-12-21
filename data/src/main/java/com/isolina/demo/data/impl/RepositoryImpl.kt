package com.isolina.demo.data.impl

import com.isolina.demo.data.impl.entity.IssuesResponse
import com.isolina.demo.data.impl.entity.PublicationsResponse
import com.isolina.demo.data.remote.RepositoryDataSource
import com.isolina.demo.data.repository.Repository
import com.isolina.demo.domain.base.Output
import javax.inject.Inject

internal class RepositoryImpl @Inject constructor(
    private val repositoryDataSource: RepositoryDataSource
) : Repository {

    override suspend fun publications(): Output<PublicationsResponse> = repositoryDataSource.publications()

    override suspend fun issues(id: String): Output<IssuesResponse> = repositoryDataSource.issues(id)

}