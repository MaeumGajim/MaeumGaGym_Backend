package com.info.maeumgagym.security.authentication.provider

import org.springframework.security.core.Authentication

/**
 * [Authentication] 객체를 생성해주는 클래스
 *
 * 기본 구현체 : [UserModelAuthenticationManager]
 *
 * @author Daybreak312
 * @since 20-03-2024
 */
interface AuthenticationManager {

    /**
     * 기본 구현체로부터 [Authentication]을 반환
     */
    fun getAuthentication(username: String): Authentication
}
