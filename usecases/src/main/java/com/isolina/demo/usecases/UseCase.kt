package com.isolina.demo.usecases

import com.isolina.demo.domain.base.Output
import com.isolina.demo.domain.models.Data
import com.isolina.demo.domain.models.DataIssue

interface UseCase {
    suspend fun executePublications(): Output<Data>
    suspend fun executeIssues(id: String): Output<DataIssue>
}