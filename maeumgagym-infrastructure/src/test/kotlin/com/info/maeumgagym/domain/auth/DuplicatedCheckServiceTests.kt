package com.info.maeumgagym.domain.auth

import com.info.maeumgagym.auth.port.`in`.DuplicatedNicknameCheckUseCase
import com.info.maeumgagym.domain.user.UserTestModule
import com.info.maeumgagym.domain.user.UserTestModule.saveInRepository
import com.info.maeumgagym.domain.user.repository.UserRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional

@Transactional
@SpringBootTest
class DuplicatedCheckServiceTests @Autowired constructor(
    private val duplicatedCheckUseCase: DuplicatedNicknameCheckUseCase,
    private val userRepository: UserRepository
) {

    /**
     * @see DuplicatedNicknameCheckUseCase.existByNickname
     * @when 성공 상황
     * @fail 다중 책임을 가졌던 Query 문이 수정되었는지 확인
     * @fail UserJpaEntity가 정상적으로 저장되는지 확인
     * @fail nickname이 UserJpaEntity에 정상적으로 주입되는지 확인
     */
    @Test
    fun checkExistsUserNickname() {
        UserTestModule.createTestUser().saveInRepository(userRepository)
        userRepository.delete(UserTestModule.createOtherUser().saveInRepository(userRepository))
        Assertions.assertTrue(duplicatedCheckUseCase.existByNickname(UserTestModule.TEST_USER_NICKNAME))
        Assertions.assertTrue(duplicatedCheckUseCase.existByNickname(UserTestModule.OTHER_USER_NICKNAME))
    }

    /**
     * @see DuplicatedNicknameCheckUseCase.existByNickname
     * @when 성공 상황
     * @fail 다중 책임을 가졌던 Query 문이 수정되었는지 확인
     */
    @Test
    fun checkNonExistsUserNickname() {
        Assertions.assertFalse(duplicatedCheckUseCase.existByNickname(UserTestModule.TEST_USER_NICKNAME + "a"))
    }
}
