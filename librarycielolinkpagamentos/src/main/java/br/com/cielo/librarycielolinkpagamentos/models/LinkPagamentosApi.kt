package br.com.cielo.librarycielolinkpagamentos.models

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface LinkPagamentosApi {

    @POST("v1/products/")
    fun postTransaction(
        @Header("Authorization") authorization: String,
        @Header("x-sdk-version") x_sdk_version: String,
        @Body model: Transaction
    ): Call<Transaction>
}