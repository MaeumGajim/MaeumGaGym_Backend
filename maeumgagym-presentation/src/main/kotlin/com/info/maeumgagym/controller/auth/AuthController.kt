package com.info.maeumgagym.controller.auth

import com.info.common.WebAdapter
import com.info.maeumgagym.controller.auth.dto.request.ReissueWebRequest
import com.info.maeumgagym.controller.auth.dto.response.TokenWebResponse
import com.info.maeumgagym.auth.port.`in`.DuplicatedNicknameCheckUseCase
import com.info.maeumgagym.auth.port.`in`.ReissueUseCase
import com.info.maeumgagym.auth.port.`in`.WithdrawalUserUseCase
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RequestMapping("/auth")
@WebAdapter
class AuthController(
    private val withdrawalUserUseCase: WithdrawalUserUseCase,
    private val duplicatedNicknameCheckUseCase: DuplicatedNicknameCheckUseCase,
    private val reissueUseCase: ReissueUseCase
) {
    @DeleteMapping
    fun userWithdrawal() {
        withdrawalUserUseCase.withdrawal()
    }

    @GetMapping
    fun duplicatedNicknameCheck(@RequestParam("nickname", required = true) nickname: String): Boolean =
        duplicatedNicknameCheckUseCase.existByNickname(nickname)

    @PostMapping("/reissue")
    fun reissue(
        @RequestBody @Valid
        req: ReissueWebRequest
    ): TokenWebResponse =
        TokenWebResponse.toWebResponse(reissueUseCase.reissue(req.refreshToken!!))
}
