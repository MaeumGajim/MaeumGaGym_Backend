package com.info.maeumgagym.core.pose.dto.response

data class PoseDetailResponse(

    val id: Long,

    val needMachine: Boolean,

    val category: MutableSet<String>,

    val simpleName: String,

    val exactName: String,

    val thumbnail: String,

    val video: String,

    val simplePart: MutableSet<String>,

    val exactPart: MutableSet<String>,

    val startPose: MutableSet<String>,

    val exerciseWay: MutableSet<String>,

    val breatheWay: MutableSet<String>?,

    val caution: MutableSet<String>?
)
