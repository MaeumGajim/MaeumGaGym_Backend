package com.info.maeumgagym.pose.service

import com.info.common.ReadOnlyUseCase
import com.info.maeumgagym.common.exception.MaeumGaGymException
import com.info.maeumgagym.pose.dto.response.PoseListResponse
import com.info.maeumgagym.pose.port.`in`.ReadPoseFromTagUseCase
import com.info.maeumgagym.pose.port.out.ReadPosePort

@ReadOnlyUseCase
class ReadPoseFromTagService(
    private val readPosePort: ReadPosePort
) : ReadPoseFromTagUseCase {

    override fun readFromTag(tag: String): PoseListResponse {
        val poses = readPosePort.readByTag(tag)

        if (poses.isEmpty()) {
            throw MaeumGaGymException.NO_CONTENT
        }

        return PoseListResponse(
            poses.map {
                it.toInfoResponse()
            }
        )
    }
}
