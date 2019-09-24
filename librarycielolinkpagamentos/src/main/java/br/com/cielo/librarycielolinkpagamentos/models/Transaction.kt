package br.com.cielo.librarycielolinkpagamentos.models

import br.com.cielo.librarycielolinkpagamentos.models.paymentlink.recurrent.Recurrent
import br.com.cielo.librarycielolinkpagamentos.models.paymentlink.shipping.Shipping
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.ArrayList

open class Transaction(

    @SerializedName("id")
    @Expose
    var id: String? = null,

    @SerializedName("name")
    @Expose
    var name: String?,

    @SerializedName("shortUrl")
    @Expose
    var shortUrl: String? = null,

    @SerializedName("type")
    @Expose
    var type: String?,

    @SerializedName("sku")
    @Expose
    var sku: String? = null,

    @SerializedName("showDescription")
    @Expose
    var showDescription: String? = null,

    @SerializedName("description")
    @Expose
    var description: String? = null,

    @SerializedName("quantity")
    @Expose
    var quantity: Int? = null,

    @SerializedName("price")
    @Expose
    var price: String?,

    @SerializedName("weight")
    @Expose
    var weight: Int? = null,

    @SerializedName("shipping")
    @Expose
    var shipping: Shipping,

    @SerializedName("recurrent")
    @Expose
    var recurrent: Recurrent,

    @SerializedName("expirationDate")
    @Expose
    var expirationDate: String? = null,

    @SerializedName("maxNumberOfInstallments")
    @Expose
    var maxNumberOfInstallments: Int? = null,

    @SerializedName("links")
    @Expose
    var links: ArrayList<Links> = ArrayList(),

    @SerializedName("softDescriptor")
    @Expose
    var softDescriptor: String? = null
)