package com.movies.stegobe.domain.exception

/**
 * 指定されたユーザアカウント等に処理実行権限がない場合にスローする例外
 */
class ForbiddenException(message: String) : RuntimeException(message) {
}