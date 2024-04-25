package com.info.maeumgagym.core.routine.service

import com.info.maeumgagym.common.annotation.responsibility.ReadOnlyUseCase
import com.info.maeumgagym.core.auth.port.out.ReadCurrentUserPort
import com.info.maeumgagym.common.exception.BusinessLogicException
import com.info.maeumgagym.core.routine.dto.response.RoutineResponse
import com.info.maeumgagym.core.routine.port.`in`.ReadTodayRoutineUseCase
import com.info.maeumgagym.core.routine.port.out.ExistsRoutineHistoryPort
import com.info.maeumgagym.core.routine.port.out.ReadRoutinePort
import java.time.LocalDate

@ReadOnlyUseCase
class ReadTodayRoutineService(
    private val readRoutinePort: ReadRoutinePort,
    private val readCurrentUserPort: ReadCurrentUserPort,
    private val existsRoutineHistoryPort: ExistsRoutineHistoryPort
) : ReadTodayRoutineUseCase {

    override fun readTodayRoutine(): RoutineResponse? {
        val userId = readCurrentUserPort.readCurrentUser().id!!

        val now = LocalDate.now()

        return readRoutinePort.readByUserIdAndDayOfWeekAndIsArchivedFalse(
            userId,
            now.dayOfWeek
        )?.run {
            toResponse(existsRoutineHistoryPort.exsitsByUserIdAndDate(userId, now))
        } ?: throw BusinessLogicException(204, "There's No Content Left")
    }
}