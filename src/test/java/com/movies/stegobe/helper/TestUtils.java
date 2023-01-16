package com.movies.stegobe.helper;

import org.apache.commons.lang3.StringUtils;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * テストユーティリティ
 */
public class TestUtils {

    /**
     * 小文字スネークケースをキャメルケースに変換
     *
     * @param lowerSnakeCase 小文字スネークケース文字列
     * @return キャメルケース文字列
     */
    public static String toCamelCase(String lowerSnakeCase) {
        return StringUtils.uncapitalize(
                Stream.of(StringUtils.split(lowerSnakeCase, '_'))
                .map(StringUtils::capitalize)
                .collect(Collectors.joining())
        );
    }
}
