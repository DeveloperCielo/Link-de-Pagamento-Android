package br.com.cielo.librarycielolinkpagamentos.network

import br.com.cielo.librarycielolinkpagamentos.BuildConfig
import br.com.cielo.librarycielolinkpagamentos.extension.addBearerFormat
import br.com.cielo.librarycielolinkpagamentos.extension.toStatusCode
import br.com.cielo.librarycielolinkpagamentos.models.LinkPagamentosApi
import br.com.cielo.librarycielolinkpagamentos.models.Transaction
import br.com.cielo.librarycielolinkpagamentos.service.Environment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LinkPagamentosHttpClient(private val environment: Environment) {

    fun getLink(
        model: Transaction, token: String,
        onGetLinkCallback: (Transaction) -> Unit,
        onErrorCallback: (String) -> Unit
    ) {

        val authorizationFormat = token.addBearerFormat()

        val webClient =
            WebClient(useSandbox(environment))
        val call = webClient.createService(LinkPagamentosApi::class.java)
            .postTransaction(authorizationFormat, model)

        call.enqueue(object : Callback<Transaction> {
            override fun onFailure(call: Call<Transaction>, t: Throwable) {
                onErrorCallback.invoke(t.message.toString())
            }

            override fun onResponse(call: Call<Transaction>, response: Response<Transaction>) {
                val transaction = response.body()
                transaction?.let {
                    onGetLinkCallback.invoke(it)
                }
                if (transaction ==null) {
                    onErrorCallback.invoke("error ${response.code()} ${response.code().toStatusCode()}")
                }
            }
        })
    }

    private fun useSandbox(environment: Environment): String {
        return if (environment == Environment.SANDBOX)
            BuildConfig.URL_LINKPAGAMENTOS_SANDBOX
        else
            BuildConfig.URL_LINKPAGAMENTOS_PRODUCTION
    }
}