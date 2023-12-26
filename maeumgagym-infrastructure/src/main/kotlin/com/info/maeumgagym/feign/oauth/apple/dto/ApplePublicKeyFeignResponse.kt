package com.info.maeumgagym.feign.oauth.apple.dto

import com.info.maeumgagym.auth.dto.response.ApplePublicKeyResponse

data class ApplePublicKeyFeignResponse(
    val kty: String,
    val kid: String,
    val use: String,
    val alg: String,
    val n: String,
    val e: String
) {

    fun toResponse() = ApplePublicKeyResponse(
        kty,
        kid,
        use,
        alg,
        n,
        e
    )
}
