package com.info.maeumgagym.auth.dto.response

data class ApplePublicKeysResponse(
    val keys: MutableList<ApplePublicKeyResponse>
) {

    fun matchesKey(alg: String, kid: String): ApplePublicKeyResponse? =
        keys.singleOrNull { it.alg == alg && it.kid == kid }
}
