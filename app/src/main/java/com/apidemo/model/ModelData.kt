package com.apidemo.model

data class ModelDataItem(
    val alpha_two_code: String,
    val country: String,
    val domains: List<String>,
    val name: String,
    val web_pages: List<String>
)