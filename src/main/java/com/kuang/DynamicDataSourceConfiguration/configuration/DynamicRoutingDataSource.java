package com.kuang.DynamicDataSourceConfiguration.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/*
 *@Author WN
 *@date 2020/4/20 18:02
 */
public class DynamicRoutingDataSource extends AbstractRoutingDataSource {
    public static final Logger LOG = LoggerFactory.getLogger(DynamicRoutingDataSource.class);
    @Override
    protected Object determineCurrentLookupKey() {
        LOG.info("当前数据源：{}"+ DynamicDataSourceContextHolder.get());
        return DynamicDataSourceContextHolder.get();
    }
}
