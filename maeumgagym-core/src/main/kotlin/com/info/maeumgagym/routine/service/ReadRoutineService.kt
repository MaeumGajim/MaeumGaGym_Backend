package com.info.maeumgagym.routine.service

import com.info.common.UseCase
import com.info.maeumgagym.common.exception.BusinessLogicException
import com.info.maeumgagym.routine.dto.response.RoutineResponse
import com.info.maeumgagym.routine.port.`in`.ReadRoutineUseCase
import com.info.maeumgagym.routine.port.out.ReadRoutinePort

@UseCase
internal class ReadRoutineService(
    private val readRoutinePort: ReadRoutinePort
) : ReadRoutineUseCase {
    override fun readFromId(routineId: Long): RoutineResponse {
        val routine = readRoutinePort.readById(routineId) ?: throw BusinessLogicException.ROUTINE_NOT_FOUND
        return routine.toResponse()
    }
}
