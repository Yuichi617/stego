package com.movies.stegobe.domain.exception

import kotlin.reflect.KClass

/**
 * 外部キー制約違反例外
 */
class FkConstraintViolationException(
    private val entityType: KClass<out Any>,
    private val column: String,
    private val value: Any
) : RuntimeException("$entityType.$column: $value")
