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
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Spy结果集
 *
 * @工程： 核心4.0
 * @模块： 核心-常用-jdbcspy
 * 
 * @作者： 刘明磊
 * @创建日期： 2015年11月7日
 * 
 * @修改记录（修改时间、作者、原因）：
 */
public class SpyResultSet implements ResultSet {
    private ResultSet realResultSet;
    ColumnMapRowMapper mapper = new ColumnMapRowMapper();

    public SpyResultSet(ResultSet resultSet) {
        this.realResultSet = resultSet;
    }

    public boolean absolute(int row) throws SQLException {
        return this.realResultSet.absolute(row);
    }

    public void afterLast() throws SQLException {
        this.realResultSet.afterLast();
    }

    public void beforeFirst() throws SQLException {
        this.realResultSet.beforeFirst();
    }

    public void cancelRowUpdates() throws SQLException {
        this.realResultSet.cancelRowUpdates();
    }

    public void clearWarnings() throws SQLException {
        this.realResultSet.clearWarnings();
    }

    public void close() throws SQLException {
        this.realResultSet.close();
    }

    public void deleteRow() throws SQLException {
        this.realResultSet.deleteRow();
    }

    public int findColumn(String columnLabel) throws SQLException {
        return this.realResultSet.findColumn(columnLabel);
    }

    public boolean first() throws SQLException {
        return this.realResultSet.first();
    }

    public Array getArray(int columnIndex) throws SQLException {
        return this.realResultSet.getArray(columnIndex);
    }

    public Array getArray(String columnLabel) throws SQLException {
        return this.realResultSet.getArray(columnLabel);
    }

    public InputStream getAsciiStream(int columnIndex) throws SQLException {
        return this.realResultSet.getAsciiStream(columnIndex);
    }

    public InputStream getAsciiStream(String columnLabel) throws SQLException {
        return this.realResultSet.getAsciiStream(columnLabel);
    }

    @Deprecated
    public BigDecimal getBigDecimal(int columnIndex, int scale) throws SQLException {
        return this.realResultSet.getBigDecimal(columnIndex, scale);
    }

    public BigDecimal getBigDecimal(int columnIndex) throws SQLException {
        return this.realResultSet.getBigDecimal(columnIndex);
    }

    @Deprecated
    public BigDecimal getBigDecimal(String columnLabel, int scale) throws SQLException {
        return this.realResultSet.getBigDecimal(columnLabel, scale);
    }

    public BigDecimal getBigDecimal(String columnLabel) throws SQLException {
        return this.realResultSet.getBigDecimal(columnLabel);
    }

    public InputStream getBinaryStream(int columnIndex) throws SQLException {
        return this.realResultSet.getBinaryStream(columnIndex);
    }

    public InputStream getBinaryStream(String columnLabel) throws SQLException {
        return this.realResultSet.getBinaryStream(columnLabel);
    }

    public Blob getBlob(int columnIndex) throws SQLException {
        return this.realResultSet.getBlob(columnIndex);
    }

    public Blob getBlob(String columnLabel) throws SQLException {
        return this.realResultSet.getBlob(columnLabel);
    }

    public boolean getBoolean(int columnIndex) throws SQLException {
        return this.realResultSet.getBoolean(columnIndex);
    }

    public boolean getBoolean(String columnLabel) throws SQLException {
        return this.realResultSet.getBoolean(columnLabel);
    }

    public byte getByte(int columnIndex) throws SQLException {
        return this.realResultSet.getByte(columnIndex);
    }

    public byte getByte(String columnLabel) throws SQLException {
        return this.realResultSet.getByte(columnLabel);
    }

    public byte[] getBytes(int columnIndex) throws SQLException {
        return this.realResultSet.getBytes(columnIndex);
    }

    public byte[] getBytes(String columnLabel) throws SQLException {
        return this.realResultSet.getBytes(columnLabel);
    }

    public Reader getCharacterStream(int columnIndex) throws SQLException {
        return this.realResultSet.getCharacterStream(columnIndex);
    }

    public Reader getCharacterStream(String columnLabel) throws SQLException {
        return this.realResultSet.getCharacterStream(columnLabel);
    }

    public Clob getClob(int columnIndex) throws SQLException {
        return this.realResultSet.getClob(columnIndex);
    }

    public Clob getClob(String columnLabel) throws SQLException {
        return this.realResultSet.getClob(columnLabel);
    }

    public int getConcurrency() throws SQLException {
        return this.realResultSet.getConcurrency();
    }

    public String getCursorName() throws SQLException {
        return this.realResultSet.getCursorName();
    }

    public Date getDate(int columnIndex, Calendar cal) throws SQLException {
        return this.realResultSet.getDate(columnIndex, cal);
    }

    public Date getDate(int columnIndex) throws SQLException {
        return this.realResultSet.getDate(columnIndex);
    }

    public Date getDate(String columnLabel, Calendar cal) throws SQLException {
        return this.realResultSet.getDate(columnLabel, cal);
    }

    public Date getDate(String columnLabel) throws SQLException {
        return this.realResultSet.getDate(columnLabel);
    }

    public double getDouble(int columnIndex) throws SQLException {
        return this.realResultSet.getDouble(columnIndex);
    }

    public double getDouble(String columnLabel) throws SQLException {
        return this.realResultSet.getDouble(columnLabel);
    }

    public int getFetchDirection() throws SQLException {
        return this.realResultSet.getFetchDirection();
    }

    public int getFetchSize() throws SQLException {
        return this.realResultSet.getFetchSize();
    }

    public float getFloat(int columnIndex) throws SQLException {
        return this.realResultSet.getFloat(columnIndex);
    }

    public float getFloat(String columnLabel) throws SQLException {
        return this.realResultSet.getFloat(columnLabel);
    }

    public int getHoldability() throws SQLException {
        return this.realResultSet.getHoldability();
    }

    public int getInt(int columnIndex) throws SQLException {
        return this.realResultSet.getInt(columnIndex);
    }

    public int getInt(String columnLabel) throws SQLException {
        return this.realResultSet.getInt(columnLabel);
    }

    public long getLong(int columnIndex) throws SQLException {
        return this.realResultSet.getLong(columnIndex);
    }

    public long getLong(String columnLabel) throws SQLException {
        return this.realResultSet.getLong(columnLabel);
    }

    public ResultSetMetaData getMetaData() throws SQLException {
        return this.realResultSet.getMetaData();
    }

    public Reader getNCharacterStream(int columnIndex) throws SQLException {
        return this.realResultSet.getNCharacterStream(columnIndex);
    }

    public Reader getNCharacterStream(String columnLabel) throws SQLException {
        return this.realResultSet.getNCharacterStream(columnLabel);
    }

    public NClob getNClob(int columnIndex) throws SQLException {
        return this.realResultSet.getNClob(columnIndex);
    }

    public NClob getNClob(String columnLabel) throws SQLException {
        return this.realResultSet.getNClob(columnLabel);
    }

    public String getNString(int columnIndex) throws SQLException {
        return this.realResultSet.getNString(columnIndex);
    }

    public String getNString(String columnLabel) throws SQLException {
        return this.realResultSet.getNString(columnLabel);
    }

    public Object getObject(int arg0, Map<String, Class<?>> arg1) throws SQLException {
        return this.realResultSet.getObject(arg0, arg1);
    }

    public Object getObject(int columnIndex) throws SQLException {
        return this.realResultSet.getObject(columnIndex);
    }

    public Object getObject(String arg0, Map<String, Class<?>> arg1) throws SQLException {
        return this.realResultSet.getObject(arg0, arg1);
    }

    public Object getObject(String columnLabel) throws SQLException {
        return this.realResultSet.getObject(columnLabel);
    }

    public Ref getRef(int columnIndex) throws SQLException {
        return this.realResultSet.getRef(columnIndex);
    }

    public Ref getRef(String columnLabel) throws SQLException {
        return this.realResultSet.getRef(columnLabel);
    }

    public int getRow() throws SQLException {
        return this.realResultSet.getRow();
    }

    public RowId getRowId(int columnIndex) throws SQLException {
        return this.realResultSet.getRowId(columnIndex);
    }

    public RowId getRowId(String columnLabel) throws SQLException {
        return this.realResultSet.getRowId(columnLabel);
    }

    public short getShort(int columnIndex) throws SQLException {
        return this.realResultSet.getShort(columnIndex);
    }

    public short getShort(String columnLabel) throws SQLException {
        return this.realResultSet.getShort(columnLabel);
    }

    public SQLXML getSQLXML(int columnIndex) throws SQLException {
        return this.realResultSet.getSQLXML(columnIndex);
    }

    public SQLXML getSQLXML(String columnLabel) throws SQLException {
        return this.realResultSet.getSQLXML(columnLabel);
    }

    public Statement getStatement() throws SQLException {
        return this.realResultSet.getStatement();
    }

    public String getString(int columnIndex) throws SQLException {
        return decrypt(this.realResultSet.getString(columnIndex));
    }

    public String getString(String columnLabel) throws SQLException {
        return decrypt(this.realResultSet.getString(columnLabel));
    }

    private String decrypt(String str) {
        if (SpyConfiguration.isCryptEnable()) {
            if ((str != null) && (str.endsWith(SpyConfiguration.getCryptSuffix()))) {
                return OraCryptUtil.getInstance().decryptByChar(str, SpyConfiguration.getCryptSuffix());
            }
            return str;
        }

        return str;
    }

    public Time getTime(int columnIndex, Calendar cal) throws SQLException {
        return this.realResultSet.getTime(columnIndex, cal);
    }

    public Time getTime(int columnIndex) throws SQLException {
        return this.realResultSet.getTime(columnIndex);
    }

    public Time getTime(String columnLabel, Calendar cal) throws SQLException {
        return this.realResultSet.getTime(columnLabel, cal);
    }

    public Time getTime(String columnLabel) throws SQLException {
        return this.realResultSet.getTime(columnLabel);
    }

    public Timestamp getTimestamp(int columnIndex, Calendar cal) throws SQLException {
        return this.realResultSet.getTimestamp(columnIndex, cal);
    }

    public Timestamp getTimestamp(int columnIndex) throws SQLException {
        return this.realResultSet.getTimestamp(columnIndex);
    }

    public Timestamp getTimestamp(String columnLabel, Calendar cal) throws SQLException {
        return this.realResultSet.getTimestamp(columnLabel, cal);
    }

    public Timestamp getTimestamp(String columnLabel) throws SQLException {
        return this.realResultSet.getTimestamp(columnLabel);
    }

    public int getType() throws SQLException {
        return this.realResultSet.getType();
    }

    @Deprecated
    public InputStream getUnicodeStream(int columnIndex) throws SQLException {
        return this.realResultSet.getUnicodeStream(columnIndex);
    }

    @Deprecated
    public InputStream getUnicodeStream(String columnLabel) throws SQLException {
        return this.realResultSet.getUnicodeStream(columnLabel);
    }

    public URL getURL(int columnIndex) throws SQLException {
        return this.realResultSet.getURL(columnIndex);
    }

    public URL getURL(String columnLabel) throws SQLException {
        return this.realResultSet.getURL(columnLabel);
    }

    public SQLWarning getWarnings() throws SQLException {
        return this.realResultSet.getWarnings();
    }

    public void insertRow() throws SQLException {
        this.realResultSet.insertRow();
    }

    public boolean isAfterLast() throws SQLException {
        return this.realResultSet.isAfterLast();
    }

    public boolean isBeforeFirst() throws SQLException {
        return this.realResultSet.isBeforeFirst();
    }

    public boolean isClosed() throws SQLException {
        return this.realResultSet.isClosed();
    }

    public boolean isFirst() throws SQLException {
        return this.realResultSet.isFirst();
    }

    public boolean isLast() throws SQLException {
        return this.realResultSet.isLast();
    }

    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return this.realResultSet.isWrapperFor(iface);
    }

    public boolean last() throws SQLException {
        return this.realResultSet.last();
    }

    public void moveToCurrentRow() throws SQLException {
        this.realResultSet.moveToCurrentRow();
    }

    public void moveToInsertRow() throws SQLException {
        this.realResultSet.moveToInsertRow();
    }

    public boolean next() throws SQLException {
        boolean next = this.realResultSet.next();
        if (next) {
            SpyLog.info(this, "next", new Object[] { this.mapper.mapRow(this.realResultSet) });
        }
        return next;
    }

    public boolean previous() throws SQLException {
        return this.realResultSet.previous();
    }

    public void refreshRow() throws SQLException {
        this.realResultSet.refreshRow();
    }

    public boolean relative(int rows) throws SQLException {
        return this.realResultSet.relative(rows);
    }

    public boolean rowDeleted() throws SQLException {
        return this.realResultSet.rowDeleted();
    }

    public boolean rowInserted() throws SQLException {
        return this.realResultSet.rowInserted();
    }

    public boolean rowUpdated() throws SQLException {
        return this.realResultSet.rowUpdated();
    }

    public void setFetchDirection(int direction) throws SQLException {
        this.realResultSet.setFetchDirection(direction);
    }

    public void setFetchSize(int rows) throws SQLException {
        this.realResultSet.setFetchSize(rows);
    }

    public <T> T unwrap(Class<T> iface) throws SQLException {
        return this.realResultSet.unwrap(iface);
    }

    public void updateArray(int columnIndex, Array x) throws SQLException {
        this.realResultSet.updateArray(columnIndex, x);
    }

    public void updateArray(String columnLabel, Array x) throws SQLException {
        this.realResultSet.updateArray(columnLabel, x);
    }

    public void updateAsciiStream(int columnIndex, InputStream x, int length) throws SQLException {
        this.realResultSet.updateAsciiStream(columnIndex, x, length);
    }

    public void updateAsciiStream(int columnIndex, InputStream x, long length) throws SQLException {
        this.realResultSet.updateAsciiStream(columnIndex, x, length);
    }

    public void updateAsciiStream(int columnIndex, InputStream x) throws SQLException {
        this.realResultSet.updateAsciiStream(columnIndex, x);
    }

    public void updateAsciiStream(String columnLabel, InputStream x, int length) throws SQLException {
        this.realResultSet.updateAsciiStream(columnLabel, x, length);
    }

    public void updateAsciiStream(String columnLabel, InputStream x, long length) throws SQLException {
        this.realResultSet.updateAsciiStream(columnLabel, x, length);
    }

    public void updateAsciiStream(String columnLabel, InputStream x) throws SQLException {
        this.realResultSet.updateAsciiStream(columnLabel, x);
    }

    public void updateBigDecimal(int columnIndex, BigDecimal x) throws SQLException {
        this.realResultSet.updateBigDecimal(columnIndex, x);
    }

    public void updateBigDecimal(String columnLabel, BigDecimal x) throws SQLException {
        this.realResultSet.updateBigDecimal(columnLabel, x);
    }

    public void updateBinaryStream(int columnIndex, InputStream x, int length) throws SQLException {
        this.realResultSet.updateBinaryStream(columnIndex, x, length);
    }

    public void updateBinaryStream(int columnIndex, InputStream x, long length) throws SQLException {
        this.realResultSet.updateBinaryStream(columnIndex, x, length);
    }

    public void updateBinaryStream(int columnIndex, InputStream x) throws SQLException {
        this.realResultSet.updateBinaryStream(columnIndex, x);
    }

    public void updateBinaryStream(String columnLabel, InputStream x, int length) throws SQLException {
        this.realResultSet.updateBinaryStream(columnLabel, x, length);
    }

    public void updateBinaryStream(String columnLabel, InputStream x, long length) throws SQLException {
        this.realResultSet.updateBinaryStream(columnLabel, x, length);
    }

    public void updateBinaryStream(String columnLabel, InputStream x) throws SQLException {
        this.realResultSet.updateBinaryStream(columnLabel, x);
    }

    public void updateBlob(int columnIndex, Blob x) throws SQLException {
        this.realResultSet.updateBlob(columnIndex, x);
    }

    public void updateBlob(int columnIndex, InputStream inputStream, long length) throws SQLException {
        this.realResultSet.updateBlob(columnIndex, inputStream, length);
    }

    public void updateBlob(int columnIndex, InputStream inputStream) throws SQLException {
        this.realResultSet.updateBlob(columnIndex, inputStream);
    }

    public void updateBlob(String columnLabel, Blob x) throws SQLException {
        this.realResultSet.updateBlob(columnLabel, x);
    }

    public void updateBlob(String columnLabel, InputStream inputStream, long length) throws SQLException {
        this.realResultSet.updateBlob(columnLabel, inputStream, length);
    }

    public void updateBlob(String columnLabel, InputStream inputStream) throws SQLException {
        this.realResultSet.updateBlob(columnLabel, inputStream);
    }

    public void updateBoolean(int columnIndex, boolean x) throws SQLException {
        this.realResultSet.updateBoolean(columnIndex, x);
    }

    public void updateBoolean(String columnLabel, boolean x) throws SQLException {
        this.realResultSet.updateBoolean(columnLabel, x);
    }

    public void updateByte(int columnIndex, byte x) throws SQLException {
        this.realResultSet.updateByte(columnIndex, x);
    }

    public void updateByte(String columnLabel, byte x) throws SQLException {
        this.realResultSet.updateByte(columnLabel, x);
    }

    public void updateBytes(int columnIndex, byte[] x) throws SQLException {
        this.realResultSet.updateBytes(columnIndex, x);
    }

    public void updateBytes(String columnLabel, byte[] x) throws SQLException {
        this.realResultSet.updateBytes(columnLabel, x);
    }

    public void updateCharacterStream(int columnIndex, Reader x, int length) throws SQLException {
        this.realResultSet.updateCharacterStream(columnIndex, x, length);
    }

    public void updateCharacterStream(int columnIndex, Reader x, long length) throws SQLException {
        this.realResultSet.updateCharacterStream(columnIndex, x, length);
    }

    public void updateCharacterStream(int columnIndex, Reader x) throws SQLException {
        this.realResultSet.updateCharacterStream(columnIndex, x);
    }

    public void updateCharacterStream(String columnLabel, Reader reader, int length) throws SQLException {
        this.realResultSet.updateCharacterStream(columnLabel, reader, length);
    }

    public void updateCharacterStream(String columnLabel, Reader reader, long length) throws SQLException {
        this.realResultSet.updateCharacterStream(columnLabel, reader, length);
    }

    public void updateCharacterStream(String columnLabel, Reader reader) throws SQLException {
        this.realResultSet.updateCharacterStream(columnLabel, reader);
    }

    public void updateClob(int columnIndex, Clob x) throws SQLException {
        this.realResultSet.updateClob(columnIndex, x);
    }

    public void updateClob(int columnIndex, Reader reader, long length) throws SQLException {
        this.realResultSet.updateClob(columnIndex, reader, length);
    }

    public void updateClob(int columnIndex, Reader reader) throws SQLException {
        this.realResultSet.updateClob(columnIndex, reader);
    }

    public void updateClob(String columnLabel, Clob x) throws SQLException {
        this.realResultSet.updateClob(columnLabel, x);
    }

    public void updateClob(String columnLabel, Reader reader, long length) throws SQLException {
        this.realResultSet.updateClob(columnLabel, reader, length);
    }

    public void updateClob(String columnLabel, Reader reader) throws SQLException {
        this.realResultSet.updateClob(columnLabel, reader);
    }

    public void updateDate(int columnIndex, Date x) throws SQLException {
        this.realResultSet.updateDate(columnIndex, x);
    }

    public void updateDate(String columnLabel, Date x) throws SQLException {
        this.realResultSet.updateDate(columnLabel, x);
    }

    public void updateDouble(int columnIndex, double x) throws SQLException {
        this.realResultSet.updateDouble(columnIndex, x);
    }

    public void updateDouble(String columnLabel, double x) throws SQLException {
        this.realResultSet.updateDouble(columnLabel, x);
    }

    public void updateFloat(int columnIndex, float x) throws SQLException {
        this.realResultSet.updateFloat(columnIndex, x);
    }

    public void updateFloat(String columnLabel, float x) throws SQLException {
        this.realResultSet.updateFloat(columnLabel, x);
    }

    public void updateInt(int columnIndex, int x) throws SQLException {
        this.realResultSet.updateInt(columnIndex, x);
    }

    public void updateInt(String columnLabel, int x) throws SQLException {
        this.realResultSet.updateInt(columnLabel, x);
    }

    public void updateLong(int columnIndex, long x) throws SQLException {
        this.realResultSet.updateLong(columnIndex, x);
    }

    public void updateLong(String columnLabel, long x) throws SQLException {
        this.realResultSet.updateLong(columnLabel, x);
    }

    public void updateNCharacterStream(int columnIndex, Reader x, long length) throws SQLException {
        this.realResultSet.updateNCharacterStream(columnIndex, x, length);
    }

    public void updateNCharacterStream(int columnIndex, Reader x) throws SQLException {
        this.realResultSet.updateNCharacterStream(columnIndex, x);
    }

    public void updateNCharacterStream(String columnLabel, Reader reader, long length) throws SQLException {
        this.realResultSet.updateNCharacterStream(columnLabel, reader, length);
    }

    public void updateNCharacterStream(String columnLabel, Reader reader) throws SQLException {
        this.realResultSet.updateNCharacterStream(columnLabel, reader);
    }

    public void updateNClob(int columnIndex, NClob nClob) throws SQLException {
        this.realResultSet.updateNClob(columnIndex, nClob);
    }

    public void updateNClob(int columnIndex, Reader reader, long length) throws SQLException {
        this.realResultSet.updateNClob(columnIndex, reader, length);
    }

    public void updateNClob(int columnIndex, Reader reader) throws SQLException {
        this.realResultSet.updateNClob(columnIndex, reader);
    }

    public void updateNClob(String columnLabel, NClob nClob) throws SQLException {
        this.realResultSet.updateNClob(columnLabel, nClob);
    }

    public void updateNClob(String columnLabel, Reader reader, long length) throws SQLException {
        this.realResultSet.updateNClob(columnLabel, reader, length);
    }

    public void updateNClob(String columnLabel, Reader reader) throws SQLException {
        this.realResultSet.updateNClob(columnLabel, reader);
    }

    public void updateNString(int columnIndex, String nString) throws SQLException {
        this.realResultSet.updateNString(columnIndex, nString);
    }

    public void updateNString(String columnLabel, String nString) throws SQLException {
        this.realResultSet.updateNString(columnLabel, nString);
    }

    public void updateNull(int columnIndex) throws SQLException {
        this.realResultSet.updateNull(columnIndex);
    }

    public void updateNull(String columnLabel) throws SQLException {
        this.realResultSet.updateNull(columnLabel);
    }

    public void updateObject(int columnIndex, Object x, int scaleOrLength) throws SQLException {
        this.realResultSet.updateObject(columnIndex, x, scaleOrLength);
    }

    public void updateObject(int columnIndex, Object x) throws SQLException {
        this.realResultSet.updateObject(columnIndex, x);
    }

    public void updateObject(String columnLabel, Object x, int scaleOrLength) throws SQLException {
        this.realResultSet.updateObject(columnLabel, x, scaleOrLength);
    }

    public void updateObject(String columnLabel, Object x) throws SQLException {
        this.realResultSet.updateObject(columnLabel, x);
    }

    public void updateRef(int columnIndex, Ref x) throws SQLException {
        this.realResultSet.updateRef(columnIndex, x);
    }

    public void updateRef(String columnLabel, Ref x) throws SQLException {
        this.realResultSet.updateRef(columnLabel, x);
    }

    public void updateRow() throws SQLException {
        this.realResultSet.updateRow();
    }

    public void updateRowId(int columnIndex, RowId x) throws SQLException {
        this.realResultSet.updateRowId(columnIndex, x);
    }

    public void updateRowId(String columnLabel, RowId x) throws SQLException {
        this.realResultSet.updateRowId(columnLabel, x);
    }

    public void updateShort(int columnIndex, short x) throws SQLException {
        this.realResultSet.updateShort(columnIndex, x);
    }

    public void updateShort(String columnLabel, short x) throws SQLException {
        this.realResultSet.updateShort(columnLabel, x);
    }

    public void updateSQLXML(int columnIndex, SQLXML xmlObject) throws SQLException {
        this.realResultSet.updateSQLXML(columnIndex, xmlObject);
    }

    public void updateSQLXML(String columnLabel, SQLXML xmlObject) throws SQLException {
        this.realResultSet.updateSQLXML(columnLabel, xmlObject);
    }

    public void updateString(int columnIndex, String x) throws SQLException {
        this.realResultSet.updateString(columnIndex, x);
    }

    public void updateString(String columnLabel, String x) throws SQLException {
        this.realResultSet.updateString(columnLabel, x);
    }

    public void updateTime(int columnIndex, Time x) throws SQLException {
        this.realResultSet.updateTime(columnIndex, x);
    }

    public void updateTime(String columnLabel, Time x) throws SQLException {
        this.realResultSet.updateTime(columnLabel, x);
    }

    public void updateTimestamp(int columnIndex, Timestamp x) throws SQLException {
        this.realResultSet.updateTimestamp(columnIndex, x);
    }

    public void updateTimestamp(String columnLabel, Timestamp x) throws SQLException {
        this.realResultSet.updateTimestamp(columnLabel, x);
    }

    public boolean wasNull() throws SQLException {
        return this.realResultSet.wasNull();
    }

    public <T> T getObject(int columnIndex, Class<T> type) throws SQLException {
        return this.realResultSet.getObject(columnIndex, type);
    }

    public <T> T getObject(String columnLabel, Class<T> type) throws SQLException {
        return this.realResultSet.getObject(columnLabel, type);
    }

    public class ColumnMapRowMapper {
        public ColumnMapRowMapper() {
        }

        public Object mapRow(ResultSet rs) throws SQLException {
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            Map mapOfColValues = new LinkedHashMap();
            for (int i = 1; i <= columnCount; ++i) {
                String key = rsmd.getColumnName(i);
                Object obj = rs.getObject(i);
                mapOfColValues.put(key, obj);
            }
            return mapOfColValues;
        }
    }
}