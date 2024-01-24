package com.info.maeumgagym.domain.routine

import com.info.common.PersistenceAdapter
import com.info.maeumgagym.domain.routine.mapper.RoutineMapper
import com.info.maeumgagym.domain.routine.repository.RoutineRepository
import com.info.maeumgagym.routine.model.Routine
import com.info.maeumgagym.routine.port.out.DeleteRoutinePort
import com.info.maeumgagym.routine.port.out.ReadAllRoutineByUserIdPort
import com.info.maeumgagym.routine.port.out.ReadRoutineByIdPort
import com.info.maeumgagym.routine.port.out.SaveRoutinePort
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import java.util.*

@PersistenceAdapter
internal class RoutinePersistenceAdapter(
    private val routineMapper: RoutineMapper,
    private val routineRepository: RoutineRepository
) : SaveRoutinePort, ReadAllRoutineByUserIdPort, DeleteRoutinePort, ReadRoutineByIdPort {

    @Transactional(propagation = Propagation.MANDATORY)
    override fun saveRoutine(routine: Routine): Routine {
        val routineJpaEntity = routineRepository.save(routineMapper.toEntity(routine))
        return routineMapper.toDomain(routineJpaEntity)
    }

    override fun readAllRoutineByUserId(userId: UUID): List<Routine> {
        val routineEntityList = routineRepository.findAllByUserId(userId)
        return routineEntityList.map { routineMapper.toDomain(it) }
    }

    @Transactional(propagation = Propagation.MANDATORY)
    override fun deleteRoutine(routine: Routine) =
        routineRepository.delete(routineMapper.toEntity(routine))

    override fun readRoutineById(routineId: Long): Routine? =
        routineRepository.findById(routineId)?.let { routineMapper.toDomain(it) }
}
