package com.movies.stegobe.helper.operation;

import com.movies.stegobe.helper.TestUtils;
import com.ninja_squad.dbsetup.Operations;
import com.ninja_squad.dbsetup.operation.Insert;
import com.ninja_squad.dbsetup.operation.Operation;
import org.springframework.beans.BeanWrapperImpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.stream.Stream;

import static com.ninja_squad.dbsetup.Operations.deleteAllFrom;

public class CommonOperations {

    /**
     * 今日の日付
     */
    public static final LocalDateTime CURRENT_TIMESTAMP = LocalDate.now().atStartOfDay();

    /**
     * 今日の日付（短縮バージョン）
     */
    public static final LocalDateTime CT = CURRENT_TIMESTAMP;

    /**
     * 全テーブルのレコードを削除するOperation
     */
    public static final Operation DELETE_ALL =
            deleteAllFrom(
                    "movies",
                    "users",
                    "genres"
            );

    /**
     * エンティティコレクションをINSERTするOperation作成
     *
     * @param table テーブル名
     * @param entities エンティティ
     * @param columns カラム名
     * @return {@link Insert}
     */
    public static Insert buildInsert(String table, Collection<?> entities, String... columns) {
        var builder = Operations.insertInto(table).columns(columns);
        for (var entity: entities) {
            var wrapper = new BeanWrapperImpl(entity);
            var values = Stream.of(columns)
                    .map(TestUtils::toCamelCase)
                    .map(wrapper::getPropertyValue)
                    .toArray(Object[]::new);
            builder.values(values);
        }
        return builder.build();
    }
}
