package com.movies.stegobe.helper;

import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.DbSetupTracker;
import com.ninja_squad.dbsetup.destination.DataSourceDestination;
import com.ninja_squad.dbsetup.destination.Destination;
import com.ninja_squad.dbsetup.operation.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;

import javax.sql.DataSource;

import static com.ninja_squad.dbsetup.operation.CompositeOperation.sequenceOf;

/**
 * データベースを使用するテストのベースクラス
 */
@ActiveProfiles(value = "test")
public abstract class DbTest {

    /** データベースセットアップトラッカー */
    protected static final DbSetupTracker tracker = new DbSetupTracker();

    @Autowired
    protected DataSource dataSource;

    @Autowired
    protected JdbcTemplate jdbcTemplate;

    /**
     * テストデータセットアップの操作先（データベース）を表すオブジェクトを返す
     * <br/>
     * {@link DbSetup}ではこのオブジェクトを{@link Destination}と呼ぶ
     * @return 操作先オブジェクト
     */
    protected Destination getDestination() {
        return DataSourceDestination.with(dataSource);
    }

    protected void setUp(Operation... operations) {
        setUpDbWith(operations);
    }

    @SuppressWarnings("UnusedReturnValue")
    protected DbSetup setUpDbWith(Operation... operations) {
        var setup = new DbSetup(getDestination(), sequenceOf(operations));
        tracker.launchIfNecessary(setup);
        return setup;
    }
}
