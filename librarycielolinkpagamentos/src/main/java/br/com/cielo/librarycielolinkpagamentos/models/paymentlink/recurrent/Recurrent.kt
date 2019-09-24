package br.com.cielo.librarycielolinkpagamentos.models.paymentlink.recurrent

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Recurrent(
    @SerializedName("interval")
    @Expose
    var interval: String?,

    @SerializedName("endDate")
    @Expose
    var endDate: String?
)