package com.info.maeumgagym.domain.purpose

import com.info.common.PersistenceAdapter
import com.info.maeumgagym.domain.purpose.mapper.PurposeMapper
import com.info.maeumgagym.domain.purpose.repository.PurposeRepository
import com.info.maeumgagym.purpose.model.Purpose
import com.info.maeumgagym.purpose.port.out.SavePurposePort

@PersistenceAdapter
internal class PurposePersistenceAdapter(
    private val purposeRepository: PurposeRepository,
    private val purposeMapper: PurposeMapper
) : SavePurposePort {

    override fun save(purpose: Purpose): Purpose =
        purposeMapper.toDomain(
            purposeRepository.save(purposeMapper.toEntity(purpose))
        )
}