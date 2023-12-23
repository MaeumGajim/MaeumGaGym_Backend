package com.info.maeumgagym.domain.routine

import com.info.common.PersistenceAdapter
import com.info.maeumgagym.domain.routine.mapper.RoutineMapper
import com.info.maeumgagym.domain.routine.repository.RoutineRepository
import com.info.maeumgagym.routine.model.Routine
import com.info.maeumgagym.routine.port.out.SaveRoutinePort
import org.springframework.transaction.annotation.Transactional

@Transactional
@PersistenceAdapter
class RoutinePersistenceAdapter(
    private val routineMapper: RoutineMapper,
    private val routineRepository: RoutineRepository
) : SaveRoutinePort {
    override fun saveRoutine(routine: Routine): Routine {
        val routineJpaEntity = routineRepository.save(routineMapper.toEntity(routine))
        return routineMapper.toDomain(routineJpaEntity)
    }
}