package com.ebs.common.jdbcspy;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.NClob;
import java.sql.ParameterMetaData;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Map;

public class SpyCallableStatement extends SpyPreparedStatement implements CallableStatement {
    private CallableStatement realCallableStatement;

    public SpyCallableStatement(CallableStatement callableStatement, String sql) {
        super(callableStatement, sql);
        this.realCallableStatement = callableStatement;
    }

    public Array getArray(int parameterIndex) throws SQLException {
        return this.realCallableStatement.getArray(parameterIndex);
    }

    public Array getArray(String parameterName) throws SQLException {
        return this.realCallableStatement.getArray(parameterName);
    }

    @Deprecated
    public BigDecimal getBigDecimal(int parameterIndex, int scale) throws SQLException {
        return this.realCallableStatement.getBigDecimal(parameterIndex, scale);
    }

    public BigDecimal getBigDecimal(int parameterIndex) throws SQLException {
        return this.realCallableStatement.getBigDecimal(parameterIndex);
    }

    public BigDecimal getBigDecimal(String parameterName) throws SQLException {
        return this.realCallableStatement.getBigDecimal(parameterName);
    }

    public Blob getBlob(int parameterIndex) throws SQLException {
        return this.realCallableStatement.getBlob(parameterIndex);
    }

    public Blob getBlob(String parameterName) throws SQLException {
        return this.realCallableStatement.getBlob(parameterName);
    }

    public boolean getBoolean(int parameterIndex) throws SQLException {
        return this.realCallableStatement.getBoolean(parameterIndex);
    }

    public boolean getBoolean(String parameterName) throws SQLException {
        return this.realCallableStatement.getBoolean(parameterName);
    }

    public byte getByte(int parameterIndex) throws SQLException {
        return this.realCallableStatement.getByte(parameterIndex);
    }

    public byte getByte(String parameterName) throws SQLException {
        return this.realCallableStatement.getByte(parameterName);
    }

    public byte[] getBytes(int parameterIndex) throws SQLException {
        return this.realCallableStatement.getBytes(parameterIndex);
    }

    public byte[] getBytes(String parameterName) throws SQLException {
        return this.realCallableStatement.getBytes(parameterName);
    }

    public Reader getCharacterStream(int parameterIndex) throws SQLException {
        return this.realCallableStatement.getCharacterStream(parameterIndex);
    }

    public Reader getCharacterStream(String parameterName) throws SQLException {
        return this.realCallableStatement.getCharacterStream(parameterName);
    }

    public Clob getClob(int parameterIndex) throws SQLException {
        return this.realCallableStatement.getClob(parameterIndex);
    }

    public Clob getClob(String parameterName) throws SQLException {
        return this.realCallableStatement.getClob(parameterName);
    }

    public Date getDate(int parameterIndex, Calendar cal) throws SQLException {
        return this.realCallableStatement.getDate(parameterIndex, cal);
    }

    public Date getDate(int parameterIndex) throws SQLException {
        return this.realCallableStatement.getDate(parameterIndex);
    }

    public Date getDate(String parameterName, Calendar cal) throws SQLException {
        return this.realCallableStatement.getDate(parameterName, cal);
    }

    public Date getDate(String parameterName) throws SQLException {
        return this.realCallableStatement.getDate(parameterName);
    }

    public double getDouble(int parameterIndex) throws SQLException {
        return this.realCallableStatement.getDouble(parameterIndex);
    }

    public double getDouble(String parameterName) throws SQLException {
        return this.realCallableStatement.getDouble(parameterName);
    }

    public float getFloat(int parameterIndex) throws SQLException {
        return this.realCallableStatement.getFloat(parameterIndex);
    }

    public float getFloat(String parameterName) throws SQLException {
        return this.realCallableStatement.getFloat(parameterName);
    }

    public int getInt(int parameterIndex) throws SQLException {
        return this.realCallableStatement.getInt(parameterIndex);
    }

    public int getInt(String parameterName) throws SQLException {
        return this.realCallableStatement.getInt(parameterName);
    }

    public long getLong(int parameterIndex) throws SQLException {
        return this.realCallableStatement.getLong(parameterIndex);
    }

    public long getLong(String parameterName) throws SQLException {
        return this.realCallableStatement.getLong(parameterName);
    }

    public Reader getNCharacterStream(int parameterIndex) throws SQLException {
        return this.realCallableStatement.getNCharacterStream(parameterIndex);
    }

    public Reader getNCharacterStream(String parameterName) throws SQLException {
        return this.realCallableStatement.getNCharacterStream(parameterName);
    }

    public NClob getNClob(int parameterIndex) throws SQLException {
        return this.realCallableStatement.getNClob(parameterIndex);
    }

    public NClob getNClob(String parameterName) throws SQLException {
        return this.realCallableStatement.getNClob(parameterName);
    }

    public String getNString(int parameterIndex) throws SQLException {
        return this.realCallableStatement.getNString(parameterIndex);
    }

    public String getNString(String parameterName) throws SQLException {
        return this.realCallableStatement.getNString(parameterName);
    }

    public Object getObject(int arg0, Map<String, Class<?>> arg1) throws SQLException {
        return this.realCallableStatement.getObject(arg0, arg1);
    }

    public Object getObject(int parameterIndex) throws SQLException {
        return this.realCallableStatement.getObject(parameterIndex);
    }

    public Object getObject(String arg0, Map<String, Class<?>> arg1) throws SQLException {
        return this.realCallableStatement.getObject(arg0, arg1);
    }

    public Object getObject(String parameterName) throws SQLException {
        return this.realCallableStatement.getObject(parameterName);
    }

    public Ref getRef(int parameterIndex) throws SQLException {
        return this.realCallableStatement.getRef(parameterIndex);
    }

    public Ref getRef(String parameterName) throws SQLException {
        return this.realCallableStatement.getRef(parameterName);
    }

    public RowId getRowId(int parameterIndex) throws SQLException {
        return this.realCallableStatement.getRowId(parameterIndex);
    }

    public RowId getRowId(String parameterName) throws SQLException {
        return this.realCallableStatement.getRowId(parameterName);
    }

    public short getShort(int parameterIndex) throws SQLException {
        return this.realCallableStatement.getShort(parameterIndex);
    }

    public short getShort(String parameterName) throws SQLException {
        return this.realCallableStatement.getShort(parameterName);
    }

    public SQLXML getSQLXML(int parameterIndex) throws SQLException {
        return this.realCallableStatement.getSQLXML(parameterIndex);
    }

    public SQLXML getSQLXML(String parameterName) throws SQLException {
        return this.realCallableStatement.getSQLXML(parameterName);
    }

    public String getString(int parameterIndex) throws SQLException {
        return this.realCallableStatement.getString(parameterIndex);
    }

    public String getString(String parameterName) throws SQLException {
        return this.realCallableStatement.getString(parameterName);
    }

    public Time getTime(int parameterIndex, Calendar cal) throws SQLException {
        return this.realCallableStatement.getTime(parameterIndex, cal);
    }

    public Time getTime(int parameterIndex) throws SQLException {
        return this.realCallableStatement.getTime(parameterIndex);
    }

    public Time getTime(String parameterName, Calendar cal) throws SQLException {
        return this.realCallableStatement.getTime(parameterName, cal);
    }

    public Time getTime(String parameterName) throws SQLException {
        return this.realCallableStatement.getTime(parameterName);
    }

    public Timestamp getTimestamp(int parameterIndex, Calendar cal) throws SQLException {
        return this.realCallableStatement.getTimestamp(parameterIndex, cal);
    }

    public Timestamp getTimestamp(int parameterIndex) throws SQLException {
        return this.realCallableStatement.getTimestamp(parameterIndex);
    }

    public Timestamp getTimestamp(String parameterName, Calendar cal) throws SQLException {
        return this.realCallableStatement.getTimestamp(parameterName, cal);
    }

    public Timestamp getTimestamp(String parameterName) throws SQLException {
        return this.realCallableStatement.getTimestamp(parameterName);
    }

    public URL getURL(int parameterIndex) throws SQLException {
        return this.realCallableStatement.getURL(parameterIndex);
    }

    public URL getURL(String parameterName) throws SQLException {
        return this.realCallableStatement.getURL(parameterName);
    }

    public void registerOutParameter(int parameterIndex, int sqlType, int scale) throws SQLException {
        this.realCallableStatement.registerOutParameter(parameterIndex, sqlType, scale);
    }

    public void registerOutParameter(int parameterIndex, int sqlType, String typeName) throws SQLException {
        this.realCallableStatement.registerOutParameter(parameterIndex, sqlType, typeName);
    }

    public void registerOutParameter(int parameterIndex, int sqlType) throws SQLException {
        this.realCallableStatement.registerOutParameter(parameterIndex, sqlType);
    }

    public void registerOutParameter(String parameterName, int sqlType, int scale) throws SQLException {
        this.realCallableStatement.registerOutParameter(parameterName, sqlType, scale);
    }

    public void registerOutParameter(String parameterName, int sqlType, String typeName) throws SQLException {
        this.realCallableStatement.registerOutParameter(parameterName, sqlType, typeName);
    }

    public void registerOutParameter(String parameterName, int sqlType) throws SQLException {
        this.realCallableStatement.registerOutParameter(parameterName, sqlType);
    }

    public void setAsciiStream(String parameterName, InputStream x, int length) throws SQLException {
        this.realCallableStatement.setAsciiStream(parameterName, x, length);
    }

    public void setAsciiStream(String parameterName, InputStream x, long length) throws SQLException {
        this.realCallableStatement.setAsciiStream(parameterName, x, length);
    }

    public void setAsciiStream(String parameterName, InputStream x) throws SQLException {
        this.realCallableStatement.setAsciiStream(parameterName, x);
    }

    public void setBigDecimal(String parameterName, BigDecimal x) throws SQLException {
        this.realCallableStatement.setBigDecimal(parameterName, x);
    }

    public void setBinaryStream(String parameterName, InputStream x, int length) throws SQLException {
        this.realCallableStatement.setBinaryStream(parameterName, x, length);
    }

    public void setBinaryStream(String parameterName, InputStream x, long length) throws SQLException {
        this.realCallableStatement.setBinaryStream(parameterName, x, length);
    }

    public void setBinaryStream(String parameterName, InputStream x) throws SQLException {
        this.realCallableStatement.setBinaryStream(parameterName, x);
    }

    public void setBlob(String parameterName, Blob x) throws SQLException {
        this.realCallableStatement.setBlob(parameterName, x);
    }

    public void setBlob(String parameterName, InputStream inputStream, long length) throws SQLException {
        this.realCallableStatement.setBlob(parameterName, inputStream, length);
    }

    public void setBlob(String parameterName, InputStream inputStream) throws SQLException {
        this.realCallableStatement.setBlob(parameterName, inputStream);
    }

    public void setBoolean(String parameterName, boolean x) throws SQLException {
        this.realCallableStatement.setBoolean(parameterName, x);
    }

    public void setByte(String parameterName, byte x) throws SQLException {
        this.realCallableStatement.setByte(parameterName, x);
    }

    public void setBytes(String parameterName, byte[] x) throws SQLException {
        this.realCallableStatement.setBytes(parameterName, x);
    }

    public void setCharacterStream(String parameterName, Reader reader, int length) throws SQLException {
        this.realCallableStatement.setCharacterStream(parameterName, reader, length);
    }

    public void setCharacterStream(String parameterName, Reader reader, long length) throws SQLException {
        this.realCallableStatement.setCharacterStream(parameterName, reader, length);
    }

    public void setCharacterStream(String parameterName, Reader reader) throws SQLException {
        this.realCallableStatement.setCharacterStream(parameterName, reader);
    }

    public void setClob(String parameterName, Clob x) throws SQLException {
        this.realCallableStatement.setClob(parameterName, x);
    }

    public void setClob(String parameterName, Reader reader, long length) throws SQLException {
        this.realCallableStatement.setClob(parameterName, reader, length);
    }

    public void setClob(String parameterName, Reader reader) throws SQLException {
        this.realCallableStatement.setClob(parameterName, reader);
    }

    public void setDate(String parameterName, Date x, Calendar cal) throws SQLException {
        this.realCallableStatement.setDate(parameterName, x, cal);
    }

    public void setDate(String parameterName, Date x) throws SQLException {
        this.realCallableStatement.setDate(parameterName, x);
    }

    public void setDouble(String parameterName, double x) throws SQLException {
        this.realCallableStatement.setDouble(parameterName, x);
    }

    public void setFloat(String parameterName, float x) throws SQLException {
        this.realCallableStatement.setFloat(parameterName, x);
    }

    public void setInt(String parameterName, int x) throws SQLException {
        this.realCallableStatement.setInt(parameterName, x);
    }

    public void setLong(String parameterName, long x) throws SQLException {
        this.realCallableStatement.setLong(parameterName, x);
    }

    public void setNCharacterStream(String parameterName, Reader value, long length) throws SQLException {
        this.realCallableStatement.setNCharacterStream(parameterName, value, length);
    }

    public void setNCharacterStream(String parameterName, Reader value) throws SQLException {
        this.realCallableStatement.setNCharacterStream(parameterName, value);
    }

    public void setNClob(String parameterName, NClob value) throws SQLException {
        this.realCallableStatement.setNClob(parameterName, value);
    }

    public void setNClob(String parameterName, Reader reader, long length) throws SQLException {
        this.realCallableStatement.setNClob(parameterName, reader, length);
    }

    public void setNClob(String parameterName, Reader reader) throws SQLException {
        this.realCallableStatement.setNClob(parameterName, reader);
    }

    public void setNString(String parameterName, String value) throws SQLException {
        this.realCallableStatement.setNString(parameterName, value);
    }

    public void setNull(String parameterName, int sqlType, String typeName) throws SQLException {
        this.realCallableStatement.setNull(parameterName, sqlType, typeName);
    }

    public void setNull(String parameterName, int sqlType) throws SQLException {
        this.realCallableStatement.setNull(parameterName, sqlType);
    }

    public void setObject(String parameterName, Object x, int targetSqlType, int scale) throws SQLException {
        this.realCallableStatement.setObject(parameterName, x, targetSqlType, scale);
    }

    public void setObject(String parameterName, Object x, int targetSqlType) throws SQLException {
        this.realCallableStatement.setObject(parameterName, x, targetSqlType);
    }

    public void setObject(String parameterName, Object x) throws SQLException {
        this.realCallableStatement.setObject(parameterName, x);
    }

    public void setRowId(String parameterName, RowId x) throws SQLException {
        this.realCallableStatement.setRowId(parameterName, x);
    }

    public void setShort(String parameterName, short x) throws SQLException {
        this.realCallableStatement.setShort(parameterName, x);
    }

    public void setSQLXML(String parameterName, SQLXML xmlObject) throws SQLException {
        this.realCallableStatement.setSQLXML(parameterName, xmlObject);
    }

    public void setString(String parameterName, String x) throws SQLException {
        this.realCallableStatement.setString(parameterName, x);
    }

    public void setTime(String parameterName, Time x, Calendar cal) throws SQLException {
        this.realCallableStatement.setTime(parameterName, x, cal);
    }

    public void setTime(String parameterName, Time x) throws SQLException {
        this.realCallableStatement.setTime(parameterName, x);
    }

    public void setTimestamp(String parameterName, Timestamp x, Calendar cal) throws SQLException {
        this.realCallableStatement.setTimestamp(parameterName, x, cal);
    }

    public void setTimestamp(String parameterName, Timestamp x) throws SQLException {
        this.realCallableStatement.setTimestamp(parameterName, x);
    }

    public void setURL(String parameterName, URL val) throws SQLException {
        this.realCallableStatement.setURL(parameterName, val);
    }

    public boolean wasNull() throws SQLException {
        return this.realCallableStatement.wasNull();
    }

    public void addBatch() throws SQLException {
        this.realCallableStatement.addBatch();
    }

    public void addBatch(String sql) throws SQLException {
        this.realCallableStatement.addBatch(sql);
    }

    public void cancel() throws SQLException {
        this.realCallableStatement.cancel();
    }

    public void clearBatch() throws SQLException {
        this.realCallableStatement.clearBatch();
    }

    public void clearParameters() throws SQLException {
        this.realCallableStatement.clearParameters();
    }

    public void clearWarnings() throws SQLException {
        this.realCallableStatement.clearWarnings();
    }

    public void close() throws SQLException {
        this.realCallableStatement.close();
    }

    public void closeOnCompletion() throws SQLException {
        this.realCallableStatement.closeOnCompletion();
    }

    public boolean execute() throws SQLException {
        return this.realCallableStatement.execute();
    }

    public boolean execute(String sql, int autoGeneratedKeys) throws SQLException {
        return this.realCallableStatement.execute(sql, autoGeneratedKeys);
    }

    public boolean execute(String sql, int[] columnIndexes) throws SQLException {
        return this.realCallableStatement.execute(sql, columnIndexes);
    }

    public boolean execute(String sql, String[] columnNames) throws SQLException {
        return this.realCallableStatement.execute(sql, columnNames);
    }

    public boolean execute(String sql) throws SQLException {
        return this.realCallableStatement.execute(sql);
    }

    public int[] executeBatch() throws SQLException {
        return this.realCallableStatement.executeBatch();
    }

    public ResultSet executeQuery() throws SQLException {
        return this.realCallableStatement.executeQuery();
    }

    public ResultSet executeQuery(String sql) throws SQLException {
        return this.realCallableStatement.executeQuery(sql);
    }

    public int executeUpdate() throws SQLException {
        return this.realCallableStatement.executeUpdate();
    }

    public int executeUpdate(String sql, int autoGeneratedKeys) throws SQLException {
        return this.realCallableStatement.executeUpdate(sql, autoGeneratedKeys);
    }

    public int executeUpdate(String sql, int[] columnIndexes) throws SQLException {
        return this.realCallableStatement.executeUpdate(sql, columnIndexes);
    }

    public int executeUpdate(String sql, String[] columnNames) throws SQLException {
        return this.realCallableStatement.executeUpdate(sql, columnNames);
    }

    public int executeUpdate(String sql) throws SQLException {
        return this.realCallableStatement.executeUpdate(sql);
    }

    public Connection getConnection() throws SQLException {
        return this.realCallableStatement.getConnection();
    }

    public int getFetchDirection() throws SQLException {
        return this.realCallableStatement.getFetchDirection();
    }

    public int getFetchSize() throws SQLException {
        return this.realCallableStatement.getFetchSize();
    }

    public ResultSet getGeneratedKeys() throws SQLException {
        return this.realCallableStatement.getGeneratedKeys();
    }

    public int getMaxFieldSize() throws SQLException {
        return this.realCallableStatement.getMaxFieldSize();
    }

    public int getMaxRows() throws SQLException {
        return this.realCallableStatement.getMaxRows();
    }

    public ResultSetMetaData getMetaData() throws SQLException {
        return this.realCallableStatement.getMetaData();
    }

    public boolean getMoreResults() throws SQLException {
        return this.realCallableStatement.getMoreResults();
    }

    public boolean getMoreResults(int current) throws SQLException {
        return this.realCallableStatement.getMoreResults(current);
    }

    public <T> T getObject(int parameterIndex, Class<T> type) throws SQLException {
        return this.realCallableStatement.getObject(parameterIndex, type);
    }

    public <T> T getObject(String parameterName, Class<T> type) throws SQLException {
        return this.realCallableStatement.getObject(parameterName, type);
    }

    public ParameterMetaData getParameterMetaData() throws SQLException {
        return this.realCallableStatement.getParameterMetaData();
    }

    public int getQueryTimeout() throws SQLException {
        return this.realCallableStatement.getQueryTimeout();
    }

    public ResultSet getResultSet() throws SQLException {
        return this.realCallableStatement.getResultSet();
    }

    public int getResultSetConcurrency() throws SQLException {
        return this.realCallableStatement.getResultSetConcurrency();
    }

    public int getResultSetHoldability() throws SQLException {
        return this.realCallableStatement.getResultSetHoldability();
    }

    public int getResultSetType() throws SQLException {
        return this.realCallableStatement.getResultSetType();
    }

    public int getUpdateCount() throws SQLException {
        return this.realCallableStatement.getUpdateCount();
    }

    public SQLWarning getWarnings() throws SQLException {
        return this.realCallableStatement.getWarnings();
    }

    public boolean isClosed() throws SQLException {
        return this.realCallableStatement.isClosed();
    }

    public boolean isCloseOnCompletion() throws SQLException {
        return this.realCallableStatement.isCloseOnCompletion();
    }

    public boolean isPoolable() throws SQLException {
        return this.realCallableStatement.isPoolable();
    }

    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return this.realCallableStatement.isWrapperFor(iface);
    }

    public void setArray(int parameterIndex, Array x) throws SQLException {
        this.realCallableStatement.setArray(parameterIndex, x);
    }

    public void setAsciiStream(int parameterIndex, InputStream x, int length) throws SQLException {
        this.realCallableStatement.setAsciiStream(parameterIndex, x, length);
    }

    public void setAsciiStream(int parameterIndex, InputStream x, long length) throws SQLException {
        this.realCallableStatement.setAsciiStream(parameterIndex, x, length);
    }

    public void setAsciiStream(int parameterIndex, InputStream x) throws SQLException {
        this.realCallableStatement.setAsciiStream(parameterIndex, x);
    }

    public void setBigDecimal(int parameterIndex, BigDecimal x) throws SQLException {
        this.realCallableStatement.setBigDecimal(parameterIndex, x);
    }

    public void setBinaryStream(int parameterIndex, InputStream x, int length) throws SQLException {
        this.realCallableStatement.setBinaryStream(parameterIndex, x, length);
    }

    public void setBinaryStream(int parameterIndex, InputStream x, long length) throws SQLException {
        this.realCallableStatement.setBinaryStream(parameterIndex, x, length);
    }

    public void setBinaryStream(int parameterIndex, InputStream x) throws SQLException {
        this.realCallableStatement.setBinaryStream(parameterIndex, x);
    }

    public void setBlob(int parameterIndex, Blob x) throws SQLException {
        this.realCallableStatement.setBlob(parameterIndex, x);
    }

    public void setBlob(int parameterIndex, InputStream inputStream, long length) throws SQLException {
        this.realCallableStatement.setBlob(parameterIndex, inputStream, length);
    }

    public void setBlob(int parameterIndex, InputStream inputStream) throws SQLException {
        this.realCallableStatement.setBlob(parameterIndex, inputStream);
    }

    public void setBoolean(int parameterIndex, boolean x) throws SQLException {
        this.realCallableStatement.setBoolean(parameterIndex, x);
    }

    public void setByte(int parameterIndex, byte x) throws SQLException {
        this.realCallableStatement.setByte(parameterIndex, x);
    }

    public void setBytes(int parameterIndex, byte[] x) throws SQLException {
        this.realCallableStatement.setBytes(parameterIndex, x);
    }

    public void setCharacterStream(int parameterIndex, Reader reader, int length) throws SQLException {
        this.realCallableStatement.setCharacterStream(parameterIndex, reader, length);
    }

    public void setCharacterStream(int parameterIndex, Reader reader, long length) throws SQLException {
        this.realCallableStatement.setCharacterStream(parameterIndex, reader, length);
    }

    public void setCharacterStream(int parameterIndex, Reader reader) throws SQLException {
        this.realCallableStatement.setCharacterStream(parameterIndex, reader);
    }

    public void setClob(int parameterIndex, Clob x) throws SQLException {
        this.realCallableStatement.setClob(parameterIndex, x);
    }

    public void setClob(int parameterIndex, Reader reader, long length) throws SQLException {
        this.realCallableStatement.setClob(parameterIndex, reader, length);
    }

    public void setClob(int parameterIndex, Reader reader) throws SQLException {
        this.realCallableStatement.setClob(parameterIndex, reader);
    }

    public void setCursorName(String name) throws SQLException {
        this.realCallableStatement.setCursorName(name);
    }

    public void setDate(int parameterIndex, Date x, Calendar cal) throws SQLException {
        this.realCallableStatement.setDate(parameterIndex, x, cal);
    }

    public void setDate(int parameterIndex, Date x) throws SQLException {
        this.realCallableStatement.setDate(parameterIndex, x);
    }

    public void setDouble(int parameterIndex, double x) throws SQLException {
        this.realCallableStatement.setDouble(parameterIndex, x);
    }

    public void setEscapeProcessing(boolean enable) throws SQLException {
        this.realCallableStatement.setEscapeProcessing(enable);
    }

    public void setFetchDirection(int direction) throws SQLException {
        this.realCallableStatement.setFetchDirection(direction);
    }

    public void setFetchSize(int rows) throws SQLException {
        this.realCallableStatement.setFetchSize(rows);
    }

    public void setFloat(int parameterIndex, float x) throws SQLException {
        this.realCallableStatement.setFloat(parameterIndex, x);
    }

    public void setInt(int parameterIndex, int x) throws SQLException {
        this.realCallableStatement.setInt(parameterIndex, x);
    }

    public void setLong(int parameterIndex, long x) throws SQLException {
        this.realCallableStatement.setLong(parameterIndex, x);
    }

    public void setMaxFieldSize(int max) throws SQLException {
        this.realCallableStatement.setMaxFieldSize(max);
    }

    public void setMaxRows(int max) throws SQLException {
        this.realCallableStatement.setMaxRows(max);
    }

    public void setNCharacterStream(int parameterIndex, Reader value, long length) throws SQLException {
        this.realCallableStatement.setNCharacterStream(parameterIndex, value, length);
    }

    public void setNCharacterStream(int parameterIndex, Reader value) throws SQLException {
        this.realCallableStatement.setNCharacterStream(parameterIndex, value);
    }

    public void setNClob(int parameterIndex, NClob value) throws SQLException {
        this.realCallableStatement.setNClob(parameterIndex, value);
    }

    public void setNClob(int parameterIndex, Reader reader, long length) throws SQLException {
        this.realCallableStatement.setNClob(parameterIndex, reader, length);
    }

    public void setNClob(int parameterIndex, Reader reader) throws SQLException {
        this.realCallableStatement.setNClob(parameterIndex, reader);
    }

    public void setNString(int parameterIndex, String value) throws SQLException {
        this.realCallableStatement.setNString(parameterIndex, value);
    }

    public void setNull(int parameterIndex, int sqlType, String typeName) throws SQLException {
        this.realCallableStatement.setNull(parameterIndex, sqlType, typeName);
    }

    public void setNull(int parameterIndex, int sqlType) throws SQLException {
        this.realCallableStatement.setNull(parameterIndex, sqlType);
    }

    public void setObject(int parameterIndex, Object x, int targetSqlType, int scaleOrLength) throws SQLException {
        this.realCallableStatement.setObject(parameterIndex, x, targetSqlType, scaleOrLength);
    }

    public void setObject(int parameterIndex, Object x, int targetSqlType) throws SQLException {
        this.realCallableStatement.setObject(parameterIndex, x, targetSqlType);
    }

    public void setObject(int parameterIndex, Object x) throws SQLException {
        this.realCallableStatement.setObject(parameterIndex, x);
    }

    public void setPoolable(boolean poolable) throws SQLException {
        this.realCallableStatement.setPoolable(poolable);
    }

    public void setQueryTimeout(int seconds) throws SQLException {
        this.realCallableStatement.setQueryTimeout(seconds);
    }

    public void setRef(int parameterIndex, Ref x) throws SQLException {
        this.realCallableStatement.setRef(parameterIndex, x);
    }

    public void setRowId(int parameterIndex, RowId x) throws SQLException {
        this.realCallableStatement.setRowId(parameterIndex, x);
    }

    public void setShort(int parameterIndex, short x) throws SQLException {
        this.realCallableStatement.setShort(parameterIndex, x);
    }

    public void setSQLXML(int parameterIndex, SQLXML xmlObject) throws SQLException {
        this.realCallableStatement.setSQLXML(parameterIndex, xmlObject);
    }

    public void setString(int parameterIndex, String x) throws SQLException {
        this.realCallableStatement.setString(parameterIndex, x);
    }

    public void setTime(int parameterIndex, Time x, Calendar cal) throws SQLException {
        this.realCallableStatement.setTime(parameterIndex, x, cal);
    }

    public void setTime(int parameterIndex, Time x) throws SQLException {
        this.realCallableStatement.setTime(parameterIndex, x);
    }

    public void setTimestamp(int parameterIndex, Timestamp x, Calendar cal) throws SQLException {
        this.realCallableStatement.setTimestamp(parameterIndex, x, cal);
    }

    public void setTimestamp(int parameterIndex, Timestamp x) throws SQLException {
        this.realCallableStatement.setTimestamp(parameterIndex, x);
    }

    public void setUnicodeStream(int parameterIndex, InputStream x, int length) throws SQLException {
        this.realCallableStatement.setUnicodeStream(parameterIndex, x, length);
    }

    public void setURL(int parameterIndex, URL x) throws SQLException {
        this.realCallableStatement.setURL(parameterIndex, x);
    }

    public <T> T unwrap(Class<T> iface) throws SQLException {
        return this.realCallableStatement.unwrap(iface);
    }
}