package com.info.maeumgagym.pose.port.`in`

import com.info.maeumgagym.pose.dto.request.ReadAllPoseRequest
import com.info.maeumgagym.pose.dto.response.PoseListResponse

interface ReadAllPoseUseCase {

    fun readAll(req: ReadAllPoseRequest): PoseListResponse
}