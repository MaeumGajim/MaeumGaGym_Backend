package com.info.maeumgagym.routine.model

import com.info.maeumgagym.pose.model.Pose
import com.info.maeumgagym.routine.dto.response.ExerciseInfoResponse

data class ExerciseInfoModel(
    var routineId: Long? = null,
    var pose: Pose,
    var repetitions: Int,
    var sets: Int,
    var id: Long? = null
) {
    fun toResponse(): ExerciseInfoResponse = ExerciseInfoResponse(
        pose = pose.toInfoResponse(),
        repetitions = repetitions,
        sets = sets
    )
}
