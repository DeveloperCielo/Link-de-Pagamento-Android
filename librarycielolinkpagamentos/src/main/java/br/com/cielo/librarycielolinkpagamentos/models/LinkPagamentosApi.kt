package br.com.cielo.librarycielolinkpagamentos.models

import br.com.cielo.librarycielolinkpagamentos.models.Transaction
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface LinkPagamentosApi {

    @POST("v1/products/")
    fun postTransaction(
        @Header("Authorization") authorization: String,
        @Body model: Transaction
    ): Call<Transaction>
}