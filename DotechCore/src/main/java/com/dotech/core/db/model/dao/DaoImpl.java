package com.dotech.core.db.model.dao;

import com.dotech.core.db.DBHelper;
import com.dotech.core.db.model.idao.IDao;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Clase que implementa las funciones DAO y Operaciones CRUD
 *
 * @param <T>
 */
public class DaoImpl<T> implements IDao<T> {

    private final DBHelper dbHelper;
    private final Class<T> type;

    /**
     * Constructor
     * @param type
     * @param dbHelper
     */
    public DaoImpl(Class<T> type, DBHelper dbHelper) {
        this.dbHelper = dbHelper;
        this.type = type;
    }

    /**
     * Obttiene todos los registros
     *
     * @return
     * @throws SQLException
     */
    @Override
    public List<T> selectAll() throws SQLException {
        return dbHelper.getAll(getMyType());
    }

    /**
     * Obtiene los registros de acuerdo al HashMap (Filtra la informacion como si fuera un Where)
     *
     * @param query
     * @return
     * @throws SQLException
     */
    @Override
    public List<T> select(Map<String, Object> query) throws SQLException {
        return dbHelper.query(getMyType(), query);
    }

    /**
     * Crear o actualizar un registro de la tabla
     *
     * @param entity
     * @return
     * @throws SQLException
     */
    @Override
    public boolean insertOrUpdate(T entity) throws SQLException {
        dbHelper.createOrUpdate(entity);
        return true;
    }

    /**
     * Elimina los registros de la tabla
     *
     * @param entities
     * @return
     * @throws SQLException
     */
    @Override
    public boolean delete(Collection<T> entities) throws SQLException {
        dbHelper.deleteObjects(getMyType(), entities);
        return true;
    }

    /**
     * Regresa el Dao de la tabla correspondiente, nos ayudara cuando necesitemos realizar
     * inner join o consultas personalizados
     *
     * @return
     * @throws SQLException
     */
    @Override
    public Dao<T, ?> getDao() throws SQLException {
        return dbHelper.getDaoImpl(getMyType());
    }

    /**
     * Regresa la clase que se utilizo para la clase generic
     * @return
     */
    private Class<T> getMyType() {
        return this.type;
    }

}

