package com.isolina.demo.data.impl.entity

import com.isolina.demo.domain.models.DataIssue

data class IssuesResponse(
    val error: Boolean,
    val data: DataIssue
)