package br.com.cielo.librarycielolinkpagamentos.models.oauth

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class AuthClientModel(
    @SerializedName("access_token")
    @Expose
    val accessToken: String,

    @SerializedName("token_type")
    @Expose
    val tokenType: String,

    @SerializedName("expires_in")
    @Expose
    val expiresIn: Int
)