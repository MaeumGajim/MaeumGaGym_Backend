package com.info.maeumgagym.core.purpose.port.`in`

import com.info.maeumgagym.core.purpose.dto.response.PurposeListResponse

interface ReadAllMyPurposeUseCase {

    fun readAllMyPurpose(index: Int): com.info.maeumgagym.core.purpose.dto.response.PurposeListResponse
}
