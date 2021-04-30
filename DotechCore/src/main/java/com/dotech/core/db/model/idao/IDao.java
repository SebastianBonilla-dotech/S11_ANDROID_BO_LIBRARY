package com.dotech.core.db.model.idao;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Interface para la clase DaoImpl, establece todos los metodos a usar
 * @param <T>
 */
public interface IDao<T> {

    /**
     * Obttiene todos los registros
     * @return
     * @throws SQLException
     */
    List<T> selectAll() throws SQLException;

    /**
     * Obtiene los registros de acuerdo al HashMap (Filtra la informacion como si fuera un Where)
     * @param query
     * @return
     * @throws SQLException
     */
    List<T> select(Map<String, Object> query) throws SQLException;

    /**
     * Crear o actualizar un registro de la tabla
     * @param entity
     * @return
     * @throws SQLException
     */
    boolean insertOrUpdate(T entity) throws SQLException;

    /**
     * Elimina los registros de la tabla
     * @param entities
     * @return
     * @throws SQLException
     */
    boolean delete(Collection<T> entities) throws SQLException;

    /**
     * Regresa el Dao de la tabla correspondiente, nos ayudara cuando necesitemos realizar
     * inner join o consultas personalizados
     * @return
     * @throws SQLException
     */
    Dao<T, ?> getDao() throws SQLException;

}