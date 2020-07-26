package com.wong.o2o.dao.split;

import java.util.Locale;
import java.util.Properties;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.keygen.SelectKeyGenerator;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Intercepts({ @Signature(type = Executor.class, method = "update", args = { MappedStatement.class, Object.class }),
		@Signature(type = Executor.class, method = "query", args = { MappedStatement.class, Object.class,
				RowBounds.class, ResultHandler.class }) })
public class DynamicDataSourceInterceptor implements Interceptor {

	private static final String REGEX = ".*insert\\u0020.*|.*delete\\u0020.*|.*update\\u0020.*";

	private static Logger logger = LoggerFactory.getLogger(DynamicDataSourceInterceptor.class);

	@Override
	public Object intercept(Invocation invocation) throws Throwable {

		// TODO Auto-generated method stub
		boolean synchronizationActive = TransactionSynchronizationManager.isActualTransactionActive();

		Object[] objects = invocation.getArgs();

		MappedStatement ms = (MappedStatement) objects[0];

		String lookUpKey = DynamicDataSourceHolder.DB_MASTER;

		// None Transaction
		if (synchronizationActive != true) {
			// Judge Read TYPE
			if (ms.getSqlCommandType().equals(SqlCommandType.SELECT)) {
				// Auto Increment id Select
				if (ms.getId().contains(SelectKeyGenerator.SELECT_KEY_SUFFIX)) {
					lookUpKey = DynamicDataSourceHolder.DB_MASTER;
				} else {
					BoundSql boundSql = ms.getSqlSource().getBoundSql(objects[1]);
					String sql = boundSql.getSql().toLowerCase(Locale.CHINA).replaceAll("[\\t\\n\\r]", " ");
					if (sql.matches(REGEX)) {
						lookUpKey = DynamicDataSourceHolder.DB_MASTER;
					} else {
						lookUpKey = DynamicDataSourceHolder.DB_SLAVE;
					}
				}
			}

		}
		// Transaction
		else {
			lookUpKey = DynamicDataSourceHolder.DB_MASTER;
		}
		logger.debug("Setting Method = [{}] Using [{}] Strategy, SQLCommandType [{}]..", ms.getId(), lookUpKey,
				ms.getSqlCommandType().name());
		DynamicDataSourceHolder.setDbType(lookUpKey);
		return invocation.proceed();
	}

	@Override
	public Object plugin(Object target) {
		// TODO Auto-generated method stub
		if (target instanceof Executor) {
			return Plugin.wrap(target, this);
		} else {
			return target;
		}
	}

	@Override
	public void setProperties(Properties properties) {
		// TODO Auto-generated method stub

	}

}
