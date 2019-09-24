package br.com.cielo.librarycielolinkpagamentos.extension

fun Int.toStatusCode(): HttpStatusCode = when (this) {
    200 -> HttpStatusCode.Ok
    201 -> HttpStatusCode.Created
    202 -> HttpStatusCode.Accepted
    204 -> HttpStatusCode.NoContent
    304 -> HttpStatusCode.NotModified
    400 -> HttpStatusCode.BadRequest
    401 -> HttpStatusCode.Unauthorized
    403 -> HttpStatusCode.Forbidden
    404 -> HttpStatusCode.NotFound
    408 -> HttpStatusCode.RequestTimeout
    409 -> HttpStatusCode.Conflict
    412 -> HttpStatusCode.PreconditionFailure
    413 -> HttpStatusCode.EntityTooLarge
    429 -> HttpStatusCode.TooManyRequests
    449 -> HttpStatusCode.RetryWith
    500 -> HttpStatusCode.InternalServerError
    503 -> HttpStatusCode.ServiceUnavailable
    else -> HttpStatusCode.Unknown
}

fun String.addBearerFormat(): String = "Bearer $this"