package br.com.cielo.librarycielolinkpagamentos.models.oauth

import java.util.*

data class AccessToken(
    val token: String,
    val expiresIn: Int,
    val issuedAt: Date
) {
    fun isStillValid(): Boolean {
        val issMs = issuedAt.time
        val nowMs = Calendar.getInstance().time.time
        val expMs = (issMs + expiresIn * 1000)
        return nowMs in issMs until expMs
    }
}