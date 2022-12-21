package com.isolina.demo.usecases.impl

import com.isolina.demo.data.repository.Repository
import com.isolina.demo.domain.base.Output
import com.isolina.demo.domain.models.Data
import com.isolina.demo.domain.models.DataIssue
import com.isolina.demo.usecases.UseCase
import javax.inject.Inject

internal class UseCaseImpl @Inject constructor(private val repository: Repository) :
    UseCase {

    override suspend fun executePublications(): Output<Data> {
        val res = repository.publications()
        if (res.status == Output.Status.SUCCESS) {
            res.data?.let {
                return Output(status = res.status, data = it.data, message = res.message, error = res.error, headers = res.headers)
            }
        }
        return Output(status = res.status, data = null, message = res.message, error = res.error, headers = null)
    }

    override suspend fun executeIssues(id: String): Output<DataIssue> {
        val res = repository.issues(id)
        if (res.status == Output.Status.SUCCESS) {
            res.data?.let {
                return Output(status = res.status, data = it.data, message = res.message, error = res.error, headers = res.headers)
            }
        }
        return Output(status = res.status, data = null, message = res.message, error = res.error, headers = null)
    }

}