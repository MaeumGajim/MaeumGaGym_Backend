package com.info.maeumgagym.auth.controller

import com.info.maeumgagym.auth.dto.request.ReissueRequest
import com.info.maeumgagym.auth.dto.response.TokenResponse
import com.info.maeumgagym.auth.port.`in`.DuplicatedNicknameCheckUseCase
import com.info.maeumgagym.auth.port.`in`.ReissueUseCase
import com.info.maeumgagym.auth.port.`in`.WithdrawalUserUseCase
import org.springframework.web.bind.annotation.*

@RequestMapping("/auth")
@RestController
class AuthController(
    private val withdrawalUserUseCase: WithdrawalUserUseCase,
    private val duplicatedNicknameCheckUseCase: DuplicatedNicknameCheckUseCase,
    private val reissueUseCase: ReissueUseCase
) {
    @DeleteMapping
    fun withdrawal() = withdrawalUserUseCase.withdrawal()

    @GetMapping
    fun duplicatedNicknameCheck(
        @RequestParam("nickname", required = true)
        nickname: String
    ) = duplicatedNicknameCheckUseCase.existByNickname(nickname)

    @PostMapping("reissue")
    fun reissue(@RequestBody request: ReissueRequest): TokenResponse = reissueUseCase.reissue(request)
}
