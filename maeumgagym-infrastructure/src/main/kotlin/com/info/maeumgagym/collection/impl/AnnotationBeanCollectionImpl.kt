package com.info.maeumgagym.collection.impl

import com.info.maeumgagym.collection.AnnotationBeanCollection
import org.springframework.context.ApplicationContext
import org.springframework.stereotype.Component
import kotlin.reflect.KClass

@Component
open class AnnotationBeanCollectionImpl(
    private val applicationContext: ApplicationContext
) : AnnotationBeanCollection {

    override fun getBeans(subject: KClass<Annotation>): Map<String, Any> =
        applicationContext.getBeansWithAnnotation(subject.java)
}