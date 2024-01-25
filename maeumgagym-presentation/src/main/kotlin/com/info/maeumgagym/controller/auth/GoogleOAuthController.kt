package com.info.maeumgagym.controller.auth

import com.info.common.WebAdapter
import com.info.maeumgagym.auth.port.`in`.GoogleLoginUseCase
import com.info.maeumgagym.auth.port.`in`.GoogleRecoveryUseCase
import com.info.maeumgagym.auth.port.`in`.GoogleSignupUseCase
import com.info.maeumgagym.controller.auth.dto.SignupWebRequest
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import javax.validation.Valid
import javax.validation.constraints.NotNull

@Tag(name = "Google OAuth API")
@Validated
@WebAdapter
@RequestMapping("/google")
class GoogleOAuthController(
    private val googleLoginUseCase: GoogleLoginUseCase,
    private val googleSignupUseCase: GoogleSignupUseCase,
    private val googleRecoveryUseCase: GoogleRecoveryUseCase
) {
    @Operation(summary = "구글 OAuth 회원복구 API")
    @PutMapping("/recovery")
    fun recovery(@RequestParam("access_token") accessToken: String) {
        googleRecoveryUseCase.recovery(accessToken)
    }

    @Operation(summary = "구글 OAuth 로그인 API")
    @GetMapping("/login")
    fun login(@RequestParam("access_token") token: String): ResponseEntity<Any> =
        googleLoginUseCase.login(token).run {
            val responseHeaders = HttpHeaders().apply {
                add(HttpHeaders.SET_COOKIE, "RF-TOKEN=$second; Secure; HttpOnly; SameSite=Strict")
                add(HttpHeaders.AUTHORIZATION, "Bearer $first")
            }

            ResponseEntity.ok().headers(responseHeaders).build()
        }

    @Operation(summary = "구글 OAuth 회원가입 API")
    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    fun signup(
        @RequestParam("access_token")
        accessToken: String,
        @RequestBody
        @Valid
        @NotNull
        req: SignupWebRequest?
    ) {
        googleSignupUseCase.signup(accessToken, req!!.nickname!!)
    }
}
