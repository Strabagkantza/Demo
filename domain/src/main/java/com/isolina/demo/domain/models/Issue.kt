package com.isolina.demo.domain.models

data class Issue(
    val issueId: String? = "",
    val status: String? = "",
    val issueName: String? = "",
    val pdfSize: Long? = 0,
    val isForSale: Boolean
)