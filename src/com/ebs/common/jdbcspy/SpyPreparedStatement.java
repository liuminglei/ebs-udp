package com.ebs.common.jdbcspy;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;
import java.sql.NClob;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLXML;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * SpyPreparedStatement
 *
 * @工程： 核心4.0
 * @模块： 核心-常用-jdbcspy
 * 
 * @作者： 刘明磊
 * @创建日期： 2015年11月7日
 * 
 * @修改记录（修改时间、作者、原因）：
 */
public class SpyPreparedStatement extends SpyStatement implements PreparedStatement {
    private PreparedStatement realPreparedStatement;
    private String preparedQuery;
    private Map<Integer, String> parameterMap;

    public SpyPreparedStatement(PreparedStatement preparedStatement, String preparedQuery) {
        super(preparedStatement);
        this.realPreparedStatement = preparedStatement;
        this.parameterMap = new LinkedHashMap<Integer, String>();
        this.preparedQuery = preparedQuery;
    }

    public void addBatch() throws SQLException {
        SpyLog.info(this, "addBatch", new Object[] { connCode(), getQueryFromPreparedStatement() });
        this.realPreparedStatement.addBatch();
    }

    public void clearParameters() throws SQLException {
        this.parameterMap.clear();
        this.realPreparedStatement.clearParameters();
    }

    public boolean execute() throws SQLException {
        SpyLog.info(this, "execute", new Object[] { connCode(), getQueryFromPreparedStatement() });
        return this.realPreparedStatement.execute();
    }

    public ResultSet executeQuery() throws SQLException {
        SpyLog.info(this, "executeQuery", new Object[] { connCode(), getQueryFromPreparedStatement() });
        long t = System.currentTimeMillis();
        ResultSet resultSet = new SpyResultSet(this.realPreparedStatement.executeQuery());
        SpyLog.info(this, "executeQueryTime", new Object[] { connCode(), " " + (System.currentTimeMillis() - t) + " 毫秒" });
        return resultSet;
    }

    public int executeUpdate() throws SQLException {
        SpyLog.info(this, "executeUpdate", new Object[] { connCode(), getQueryFromPreparedStatement() });
        return this.realPreparedStatement.executeUpdate();
    }

    public ResultSetMetaData getMetaData() throws SQLException {
        return this.realPreparedStatement.getMetaData();
    }

    public ParameterMetaData getParameterMetaData() throws SQLException {
        return this.realPreparedStatement.getParameterMetaData();
    }

    public void setArray(int parameterIndex, Array x) throws SQLException {
        this.realPreparedStatement.setArray(parameterIndex, x);
        saveQueryParamValue(parameterIndex, x);
    }

    public void setAsciiStream(int parameterIndex, InputStream x, int length) throws SQLException {
        this.realPreparedStatement.setAsciiStream(parameterIndex, x, length);
        saveQueryParamValue(parameterIndex, x, length);
    }

    public void setAsciiStream(int parameterIndex, InputStream x, long length) throws SQLException {
        this.realPreparedStatement.setAsciiStream(parameterIndex, x, length);
        saveQueryParamValue(parameterIndex, x, length);
    }

    public void setAsciiStream(int parameterIndex, InputStream x) throws SQLException {
        this.realPreparedStatement.setAsciiStream(parameterIndex, x);
        saveQueryParamValue(parameterIndex, x);
    }

    public void setBigDecimal(int parameterIndex, BigDecimal x) throws SQLException {
        this.realPreparedStatement.setBigDecimal(parameterIndex, x);
        saveQueryParamValue(parameterIndex, x);
    }

    public void setBinaryStream(int parameterIndex, InputStream x, int length) throws SQLException {
        this.realPreparedStatement.setBinaryStream(parameterIndex, x, length);
        saveQueryParamValue(parameterIndex, x, length);
    }

    public void setBinaryStream(int parameterIndex, InputStream x, long length) throws SQLException {
        this.realPreparedStatement.setBinaryStream(parameterIndex, x, length);
        saveQueryParamValue(parameterIndex, x, length);
    }

    public void setBinaryStream(int parameterIndex, InputStream x) throws SQLException {
        this.realPreparedStatement.setBinaryStream(parameterIndex, x);
        saveQueryParamValue(parameterIndex, x);
    }

    public void setBlob(int parameterIndex, Blob x) throws SQLException {
        this.realPreparedStatement.setBlob(parameterIndex, x);
        saveQueryParamValue(parameterIndex, x);
    }

    public void setBlob(int parameterIndex, InputStream inputStream, long length) throws SQLException {
        this.realPreparedStatement.setBlob(parameterIndex, inputStream, length);
        saveQueryParamValue(parameterIndex, inputStream, length);
    }

    public void setBlob(int parameterIndex, InputStream inputStream) throws SQLException {
        this.realPreparedStatement.setBlob(parameterIndex, inputStream);
        saveQueryParamValue(parameterIndex, inputStream);
    }

    public void setBoolean(int parameterIndex, boolean x) throws SQLException {
        this.realPreparedStatement.setBoolean(parameterIndex, x);
        saveQueryParamValue(parameterIndex, Boolean.valueOf(x));
    }

    public void setByte(int parameterIndex, byte x) throws SQLException {
        this.realPreparedStatement.setByte(parameterIndex, x);
        saveQueryParamValue(parameterIndex, Byte.valueOf(x));
    }

    public void setBytes(int parameterIndex, byte[] x) throws SQLException {
        this.realPreparedStatement.setBytes(parameterIndex, x);
        saveQueryParamValue(parameterIndex, x);
    }

    public void setCharacterStream(int parameterIndex, Reader reader, int length) throws SQLException {
        this.realPreparedStatement.setCharacterStream(parameterIndex, reader, length);
        saveQueryParamValue(parameterIndex, reader, length);
    }

    public void setCharacterStream(int parameterIndex, Reader reader, long length) throws SQLException {
        this.realPreparedStatement.setCharacterStream(parameterIndex, reader, length);
        saveQueryParamValue(parameterIndex, reader, length);
    }

    public void setCharacterStream(int parameterIndex, Reader reader) throws SQLException {
        this.realPreparedStatement.setCharacterStream(parameterIndex, reader);
        saveQueryParamValue(parameterIndex, reader);
    }

    public void setClob(int parameterIndex, Clob x) throws SQLException {
        this.realPreparedStatement.setClob(parameterIndex, x);
        saveQueryParamValue(parameterIndex, x);
    }

    public void setClob(int parameterIndex, Reader reader, long length) throws SQLException {
        this.realPreparedStatement.setClob(parameterIndex, reader, length);
        saveQueryParamValue(parameterIndex, reader, length);
    }

    public void setClob(int parameterIndex, Reader reader) throws SQLException {
        this.realPreparedStatement.setClob(parameterIndex, reader);
        saveQueryParamValue(parameterIndex, reader);
    }

    public void setDate(int parameterIndex, Date x, Calendar cal) throws SQLException {
        this.realPreparedStatement.setDate(parameterIndex, x, cal);
        saveQueryParamValue(parameterIndex, x);
    }

    public void setDate(int parameterIndex, Date x) throws SQLException {
        this.realPreparedStatement.setDate(parameterIndex, x);
        saveQueryParamValue(parameterIndex, x);
    }

    public void setDouble(int parameterIndex, double x) throws SQLException {
        this.realPreparedStatement.setDouble(parameterIndex, x);
        saveQueryParamValue(parameterIndex, Double.valueOf(x));
    }

    public void setFloat(int parameterIndex, float x) throws SQLException {
        this.realPreparedStatement.setFloat(parameterIndex, x);
        saveQueryParamValue(parameterIndex, Float.valueOf(x));
    }

    public void setInt(int parameterIndex, int x) throws SQLException {
        this.realPreparedStatement.setInt(parameterIndex, x);
        saveQueryParamValue(parameterIndex, Integer.valueOf(x));
    }

    public void setLong(int parameterIndex, long x) throws SQLException {
        this.realPreparedStatement.setLong(parameterIndex, x);
        saveQueryParamValue(parameterIndex, Long.valueOf(x));
    }

    public void setNCharacterStream(int parameterIndex, Reader value, long length) throws SQLException {
        this.realPreparedStatement.setNCharacterStream(parameterIndex, value, length);
        saveQueryParamValue(parameterIndex, value, length);
    }

    public void setNCharacterStream(int parameterIndex, Reader value) throws SQLException {
        this.realPreparedStatement.setNCharacterStream(parameterIndex, value);
        saveQueryParamValue(parameterIndex, value);
    }

    public void setNClob(int parameterIndex, NClob value) throws SQLException {
        this.realPreparedStatement.setNClob(parameterIndex, value);
        saveQueryParamValue(parameterIndex, value);
    }

    public void setNClob(int parameterIndex, Reader reader, long length) throws SQLException {
        this.realPreparedStatement.setNClob(parameterIndex, reader, length);
        saveQueryParamValue(parameterIndex, reader, length);
    }

    public void setNClob(int parameterIndex, Reader reader) throws SQLException {
        this.realPreparedStatement.setNClob(parameterIndex, reader);
        saveQueryParamValue(parameterIndex, reader);
    }

    public void setNString(int parameterIndex, String value) throws SQLException {
        this.realPreparedStatement.setNString(parameterIndex, value);
        saveQueryParamValue(parameterIndex, value);
    }

    public void setNull(int parameterIndex, int sqlType, String typeName) throws SQLException {
        this.realPreparedStatement.setNull(parameterIndex, sqlType, typeName);
        saveQueryParamValue(parameterIndex, null);
    }

    public void setNull(int parameterIndex, int sqlType) throws SQLException {
        this.realPreparedStatement.setNull(parameterIndex, sqlType);
        saveQueryParamValue(parameterIndex, null);
    }

    public void setObject(int parameterIndex, Object x, int targetSqlType, int scaleOrLength) throws SQLException {
        this.realPreparedStatement.setObject(parameterIndex, x, targetSqlType, scaleOrLength);
        saveQueryParamValue(parameterIndex, x);
    }

    public void setObject(int parameterIndex, Object x, int targetSqlType) throws SQLException {
        this.realPreparedStatement.setObject(parameterIndex, x, targetSqlType);
        saveQueryParamValue(parameterIndex, x);
    }

    public void setObject(int parameterIndex, Object x) throws SQLException {
        this.realPreparedStatement.setObject(parameterIndex, x);
        saveQueryParamValue(parameterIndex, x);
    }

    public void setRef(int parameterIndex, Ref x) throws SQLException {
        this.realPreparedStatement.setRef(parameterIndex, x);
        saveQueryParamValue(parameterIndex, x);
    }

    public void setRowId(int parameterIndex, RowId x) throws SQLException {
        this.realPreparedStatement.setRowId(parameterIndex, x);
        saveQueryParamValue(parameterIndex, x);
    }

    public void setShort(int parameterIndex, short x) throws SQLException {
        this.realPreparedStatement.setShort(parameterIndex, x);
        saveQueryParamValue(parameterIndex, Short.valueOf(x));
    }

    public void setSQLXML(int parameterIndex, SQLXML xmlObject) throws SQLException {
        this.realPreparedStatement.setSQLXML(parameterIndex, xmlObject);
        saveQueryParamValue(parameterIndex, xmlObject);
    }

    public void setString(int parameterIndex, String x) throws SQLException {
        this.realPreparedStatement.setString(parameterIndex, x);
        saveQueryParamValue(parameterIndex, x);
    }

    public void setTime(int parameterIndex, Time x, Calendar cal) throws SQLException {
        this.realPreparedStatement.setTime(parameterIndex, x, cal);
        saveQueryParamValue(parameterIndex, x);
    }

    public void setTime(int parameterIndex, Time x) throws SQLException {
        this.realPreparedStatement.setTime(parameterIndex, x);
        saveQueryParamValue(parameterIndex, x);
    }

    public void setTimestamp(int parameterIndex, Timestamp x, Calendar cal) throws SQLException {
        this.realPreparedStatement.setTimestamp(parameterIndex, x, cal);
        saveQueryParamValue(parameterIndex, x);
    }

    public void setTimestamp(int parameterIndex, Timestamp x) throws SQLException {
        this.realPreparedStatement.setTimestamp(parameterIndex, x);
        saveQueryParamValue(parameterIndex, x);
    }

    @Deprecated
    public void setUnicodeStream(int parameterIndex, InputStream x, int length) throws SQLException {
        this.realPreparedStatement.setUnicodeStream(parameterIndex, x, length);
        saveQueryParamValue(parameterIndex, x, length);
    }

    public void setURL(int parameterIndex, URL x) throws SQLException {
        this.realPreparedStatement.setURL(parameterIndex, x);
        saveQueryParamValue(parameterIndex, x);
    }

    private void saveQueryParamValue(int position, Object obj, long length) {
        String strValue;
        if ((obj instanceof String) || (obj instanceof Date)) {
            strValue = "'" + obj + "'";
        } else {
            if (obj == null) {
                strValue = "null";
            } else {
                strValue = obj.toString();
            }
        }
        this.parameterMap.put(Integer.valueOf(position), strValue);
    }

    private void saveQueryParamValue(int position, Object obj) {
        saveQueryParamValue(position, obj, 0L);
    }

    protected final String getQueryFromPreparedStatement() {
        if (this.parameterMap.size() > 0) {
            int start = 0;
            int i = 1;
            int end = this.preparedQuery.indexOf("?", start);
            if (end == -1) {
                return this.preparedQuery;
            }
            int replLength = "?".length();
            StringBuffer buf = new StringBuffer();
            for (; end != -1; end = this.preparedQuery.indexOf("?", start)) {
                buf.append(this.preparedQuery.substring(start, end)).append((String) this.parameterMap.get(Integer.valueOf(i++)));
                start = end + replLength;
            }
            buf.append(this.preparedQuery.substring(start));
            return buf.toString();
        }
        return this.preparedQuery;
    }

    private String connCode() throws SQLException {
        return "CONN[" + this.realPreparedStatement.getConnection().hashCode() + "]";
    }
}