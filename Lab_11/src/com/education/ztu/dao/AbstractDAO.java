package com.education.ztu.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public abstract class AbstractDAO<T> {

    protected Connection connection;
    protected String tableName;

    public abstract T get(int id) throws SQLException;

    public abstract List<T> getAll() throws SQLException;

    public abstract int save(T t) throws SQLException;

    public abstract void update(int id, T t) throws SQLException;

    public abstract void delete(int id) throws SQLException;
}
