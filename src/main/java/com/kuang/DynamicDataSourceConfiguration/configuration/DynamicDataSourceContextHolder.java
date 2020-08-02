package com.kuang.DynamicDataSourceConfiguration.configuration;

import com.kuang.configuraction.enumconfig.DataSourceKey;
import org.apache.commons.lang.math.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

/*
 *@Author WN
 *@date 2020/4/20 17:59
 */
public class DynamicDataSourceContextHolder {

    private static final Logger LOG = LoggerFactory.getLogger(DynamicDataSourceContextHolder.class);

    private static final ThreadLocal<DataSourceKey> currentDatesource = new ThreadLocal<>();

    /**
     * 清除当前数据源
     */
    public static void clear() {
        currentDatesource.remove();
    }

    /**
     * 获取当前使用的数据源
     *
     * @return 当前使用数据源的ID
     */
    public static DataSourceKey get() {
        return currentDatesource.get();
    }

    /**
     * 设置当前使用的数据源
     *
     * @param value 需要设置的数据源ID
     */
    public static void set(DataSourceKey value) {
        currentDatesource.set(value);
    }

    /**
     * 设置从从库读取数据
     * 采用简单生成随机数的方式切换不同的从库
     */
    public static void setSlave() {
        if (RandomUtils.nextInt(new Random(), 2) > 0) {
            DynamicDataSourceContextHolder.set(DataSourceKey.DB_SLAVE2);
        } else {
            DynamicDataSourceContextHolder.set(DataSourceKey.DB_SLAVE1);
        }
    }
}
