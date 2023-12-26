package com.info.maeumgagym.controller.pickle.dto.request

import com.info.maeumgagym.pickle.dto.request.PickleUploadRequest
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Pattern

data class PickleUploadWebRequest(

    @field:NotBlank(message = "null일 수 없습니다")
    val title: String?,

    val description: String?,

    val tags: MutableSet<String> = mutableSetOf(),

    @field:NotBlank(message = "null일 수 없습니다")
    @field:Pattern(regexp = "^(https://[\\w.-]+)/\\d{10}/m3u8.index", message = "올바른 url이 아닙니다")
    val videoUrl: String?
) {

    fun toRequest() = PickleUploadRequest(
        title = title!!,
        description = description,
        tags = tags,
        videoUrl = videoUrl!!
    )
}
