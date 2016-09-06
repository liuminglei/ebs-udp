package com.ebs.common.jdbcspy;

import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

/**
 * Spy连接
 *
 * @工程： 核心4.0
 * @模块： 核心-常用-jdbcspy
 * 
 * @作者： 刘明磊
 * @创建日期： 2015年11月7日
 * 
 * @修改记录（修改时间、作者、原因）：
 */
public class SpyConnection implements Connection {
    private Connection realConnection;

    public SpyConnection(Connection connection) {
        this.realConnection = connection;
    }

    public void clearWarnings() throws SQLException {
        this.realConnection.clearWarnings();
    }

    public void close() throws SQLException {
        SpyLog.info(this, "close", null);
        this.realConnection.close();
    }

    public void commit() throws SQLException {
        SpyLog.info(this, "commit", null);
        this.realConnection.commit();
    }

    public Array createArrayOf(String typeName, Object[] elements) throws SQLException {
        return this.realConnection.createArrayOf(typeName, elements);
    }

    public Blob createBlob() throws SQLException {
        return this.realConnection.createBlob();
    }

    public Clob createClob() throws SQLException {
        return this.realConnection.createClob();
    }

    public NClob createNClob() throws SQLException {
        return this.realConnection.createNClob();
    }

    public SQLXML createSQLXML() throws SQLException {
        return this.realConnection.createSQLXML();
    }

    public Statement createStatement() throws SQLException {
        return new SpyStatement(this.realConnection.createStatement());
    }

    public Statement createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
        return new SpyStatement(this.realConnection.createStatement(resultSetType, resultSetConcurrency, resultSetHoldability));
    }

    public Statement createStatement(int resultSetType, int resultSetConcurrency) throws SQLException {
        return new SpyStatement(this.realConnection.createStatement(resultSetType, resultSetConcurrency));
    }

    public Struct createStruct(String typeName, Object[] attributes) throws SQLException {
        return this.realConnection.createStruct(typeName, attributes);
    }

    public boolean getAutoCommit() throws SQLException {
        return this.realConnection.getAutoCommit();
    }

    public String getCatalog() throws SQLException {
        return this.realConnection.getCatalog();
    }

    public Properties getClientInfo() throws SQLException {
        return this.realConnection.getClientInfo();
    }

    public String getClientInfo(String name) throws SQLException {
        return this.realConnection.getClientInfo(name);
    }

    public int getHoldability() throws SQLException {
        return this.realConnection.getHoldability();
    }

    public DatabaseMetaData getMetaData() throws SQLException {
        return this.realConnection.getMetaData();
    }

    public int getTransactionIsolation() throws SQLException {
        return this.realConnection.getTransactionIsolation();
    }

    public Map<String, Class<?>> getTypeMap() throws SQLException {
        return this.realConnection.getTypeMap();
    }

    public SQLWarning getWarnings() throws SQLException {
        return this.realConnection.getWarnings();
    }

    public boolean isClosed() throws SQLException {
        return this.realConnection.isClosed();
    }

    public boolean isReadOnly() throws SQLException {
        return this.realConnection.isReadOnly();
    }

    public boolean isValid(int timeout) throws SQLException {
        return this.realConnection.isValid(timeout);
    }

    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return this.realConnection.isWrapperFor(iface);
    }

    public String nativeSQL(String sql) throws SQLException {
        SpyLog.info(this, "nativeSQL", new Object[] { sql });
        return this.realConnection.nativeSQL(sql);
    }

    public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
        SpyLog.info(this, "prepareCall", new Object[] { sql });
        return new SpyCallableStatement(this.realConnection.prepareCall(sql, resultSetType, resultSetConcurrency, resultSetHoldability), sql);
    }

    public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
        SpyLog.info(this, "prepareCall", new Object[] { sql });
        return new SpyCallableStatement(this.realConnection.prepareCall(sql, resultSetType, resultSetConcurrency), sql);
    }

    public CallableStatement prepareCall(String sql) throws SQLException {
        SpyLog.info(this, "prepareCall", new Object[] { sql });
        return new SpyCallableStatement(this.realConnection.prepareCall(sql), sql);
    }

    public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
        SpyLog.info(this, "prepareStatement", new Object[] { sql });
        return new SpyPreparedStatement(this.realConnection.prepareStatement(sql, resultSetType, resultSetConcurrency, resultSetHoldability), sql);
    }

    public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
        SpyLog.info(this, "prepareStatement", new Object[] { sql });
        return new SpyPreparedStatement(this.realConnection.prepareStatement(sql, resultSetType, resultSetConcurrency), sql);
    }

    public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) throws SQLException {
        SpyLog.info(this, "prepareStatement", new Object[] { sql });
        return new SpyPreparedStatement(this.realConnection.prepareStatement(sql, autoGeneratedKeys), sql);
    }

    public PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws SQLException {
        SpyLog.info(this, "prepareStatement", new Object[] { sql });
        return new SpyPreparedStatement(this.realConnection.prepareStatement(sql, columnIndexes), sql);
    }

    public PreparedStatement prepareStatement(String sql, String[] columnNames) throws SQLException {
        SpyLog.info(this, "prepareStatement", new Object[] { sql });
        return new SpyPreparedStatement(this.realConnection.prepareStatement(sql, columnNames), sql);
    }

    public PreparedStatement prepareStatement(String sql) throws SQLException {
        SpyLog.info(this, "prepareStatement", new Object[] { sql });
        return new SpyPreparedStatement(this.realConnection.prepareStatement(sql), sql);
    }

    public void releaseSavepoint(Savepoint savepoint) throws SQLException {
        this.realConnection.releaseSavepoint(savepoint);
    }

    public void rollback() throws SQLException {
        SpyLog.info(this, "rollback", null);
        this.realConnection.rollback();
    }

    public void rollback(Savepoint savepoint) throws SQLException {
        SpyLog.info(this, "rollback", new Object[] { savepoint.getSavepointName() });
        this.realConnection.rollback(savepoint);
    }

    public void setAutoCommit(boolean autoCommit) throws SQLException {
        SpyLog.info(this, "setAutoCommit", new Object[] { autoCommit });
        this.realConnection.setAutoCommit(autoCommit);
    }

    public void setCatalog(String catalog) throws SQLException {
        this.realConnection.setCatalog(catalog);
    }

    public void setClientInfo(Properties properties) throws SQLClientInfoException {
        this.realConnection.setClientInfo(properties);
    }

    public void setClientInfo(String name, String value) throws SQLClientInfoException {
        this.realConnection.setClientInfo(name, value);
    }

    public void setHoldability(int holdability) throws SQLException {
        this.realConnection.setHoldability(holdability);
    }

    public void setReadOnly(boolean readOnly) throws SQLException {
        SpyLog.info(this, "setReadOnly", new Object[] { readOnly });
        this.realConnection.setReadOnly(readOnly);
    }

    public Savepoint setSavepoint() throws SQLException {
        SpyLog.info(this, "setSavepoint", null);
        return this.realConnection.setSavepoint();
    }

    public Savepoint setSavepoint(String name) throws SQLException {
        SpyLog.info(this, "setSavepoint", new Object[] { name });
        return this.realConnection.setSavepoint(name);
    }

    public void setTransactionIsolation(int level) throws SQLException {
        this.realConnection.setTransactionIsolation(level);
    }

    public void setTypeMap(Map<String, Class<?>> arg0) throws SQLException {
        this.realConnection.setTypeMap(arg0);
    }

    public <T> T unwrap(Class<T> iface) throws SQLException {
        return this.realConnection.unwrap(iface);
    }

    public void abort(Executor executor) throws SQLException {
        this.realConnection.abort(executor);
    }

    public int getNetworkTimeout() throws SQLException {
        return this.realConnection.getNetworkTimeout();
    }

    public String getSchema() throws SQLException {
        return this.realConnection.getSchema();
    }

    public void setNetworkTimeout(Executor executor, int milliseconds) throws SQLException {
        this.realConnection.setNetworkTimeout(executor, milliseconds);
    }

    public void setSchema(String schema) throws SQLException {
        this.realConnection.setSchema(schema);
    }
}