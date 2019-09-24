package br.com.cielo.librarycielolinkpagamentos.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

open class Links(
    @SerializedName("method")
    @Expose
    var method: String? = null,

    @SerializedName("rel")
    @Expose
    var rel: String? = null,

    @SerializedName("href")
    @Expose
    var href: String? = null
)