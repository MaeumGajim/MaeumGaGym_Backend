package com.info.maeumgagym.domain.user.mapper

import com.info.maeumgagym.domain.user.entity.DeletedAtJpaEntity
import com.info.maeumgagym.domain.user.entity.UserJpaEntity
import com.info.maeumgagym.user.model.DeletedAt
import com.info.maeumgagym.user.model.User
import org.springframework.stereotype.Component

@Component
class UserMapper {

    fun toEntity(domain: User): UserJpaEntity =
        domain.run {
            UserJpaEntity(
                id = id,
                nickname = nickname,
                oauthId = oauthId,
                roles = roles,
                profileImage = profileImage,
                isDelete = isDeleted,
                lastSaved = lastSaved,
                dayCount = dayCount,
                todayWaka = todayWaka,
                waka = waka
            )
        }

    fun toDomain(entity: UserJpaEntity): User =
        entity.run {
            User(
                id = id!!,
                nickname = nickname,
                oauthId = oauthId,
                roles = roles,
                profileImage = profileImage,
                isDeleted = isDeleted,
                lastSaved = lastSaved,
                dayCount = dayCount,
                todayWaka = todayWaka,
                waka = waka
            )
        }

    fun toEntity(domain: DeletedAt) = DeletedAtJpaEntity(
        domain.userId,
        domain.date
    )

    fun toDomain(entity: DeletedAtJpaEntity) = DeletedAt(
        entity.userId,
        entity.date
    )
}
