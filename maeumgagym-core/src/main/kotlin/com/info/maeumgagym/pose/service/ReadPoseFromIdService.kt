package com.info.maeumgagym.pose.service

import com.info.common.responsibility.ReadOnlyUseCase
import com.info.maeumgagym.common.exception.BusinessLogicException
import com.info.maeumgagym.pose.dto.response.PoseDetailResponse
import com.info.maeumgagym.pose.port.`in`.ReadPoseFromIdUseCase
import com.info.maeumgagym.pose.port.out.ReadPosePort

@ReadOnlyUseCase
internal class ReadPoseFromIdService(
    private val readPosePort: ReadPosePort
) : ReadPoseFromIdUseCase {

    override fun detailResponseById(id: Long): PoseDetailResponse =
        // (pose.id = id)라면 -> response, else -> 예외 처리
        readPosePort.readById(id)?.toDetailResponse() ?: throw BusinessLogicException.POSE_NOT_FOUND
}
