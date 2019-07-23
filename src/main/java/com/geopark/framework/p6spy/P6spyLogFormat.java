package com.geopark.framework.p6spy;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.p6spy.engine.spy.appender.MessageFormattingStrategy;

/**
 * P6spy SQL Log Format
 *
 * @author lichee
 */
public class P6spyLogFormat implements MessageFormattingStrategy {

    @Override
    public String formatMessage(final int connectionId, final String now, final long elapsed, final String category, final String prepared, final String sql, final String url) {

        return StringUtils.isNotEmpty(sql) ? new StringBuilder().append(" Execute SQL：").append(sql.replaceAll("[\\s]+", StringPool.SPACE)).toString() : null;
    }
}
