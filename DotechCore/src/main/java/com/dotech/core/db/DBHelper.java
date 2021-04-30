package com.dotech.core.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Esta clase nos ayudara en hacer la conexion a la base de datos y establecer los metodos CRUD
 * Nota: Se necesita la libreria ORMLITE v5.3
 * @author Sebastian Bonilla
 */
public class DBHelper extends OrmLiteSqliteOpenHelper {

    /**
     * Constructor de la clase DBHelper
     * @param context
     * @param dbName
     * @param dbVersion
     */
    public DBHelper(Context context, String dbName, int dbVersion) {
        super(context, dbName, null, dbVersion);
        getWritableDatabase();
    }


    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        // No hay necesidad de construir la base de datos, la aplicacion ya debe de contar con el archivo correspondiente
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        // No hay necesidad de actualizar la base de datos, la aplicacion ya debe de contar con el archivo correspondiente
    }

    /**
     * Obtiene todos los registros de la tabla
     *
     * @param clazz
     * @param <T>
     * @return
     * @throws SQLException
     */
    public <T> List<T> getAll(Class<T> clazz) throws SQLException {
        Dao<T, ?> dao = getDao(clazz);
        return dao.queryForAll();
    }

    /**
     * Obtiene los registros de acuerdo al HashMap (Filtra la informacion como si fuera un Where)
     *
     * @param clazz
     * @param aMap
     * @param <T>
     * @return
     * @throws SQLException
     */
    public <T> List<T> query(Class<T> clazz, Map<String, Object> aMap) throws SQLException {
        Dao<T, ?> dao = getDao(clazz);
        return dao.queryForFieldValues(aMap);
    }

    /**
     * Crear o actualizar un registro de la tabla
     *
     * @param obj
     * @param <T>
     * @return
     * @throws SQLException
     */
    public <T> Dao.CreateOrUpdateStatus createOrUpdate(T obj) throws SQLException {
        Dao<T, ?> dao = (Dao<T, ?>) getDao(obj.getClass());
        return dao.createOrUpdate(obj);
    }

    /**
     * Elimina los registros de la tabla
     *
     * @param clazz
     * @param aObjList
     * @param <T>
     * @return
     * @throws SQLException
     */
    public <T> int deleteObjects(Class<T> clazz, Collection<T> aObjList) throws SQLException {
        Dao<T, ?> dao = getDao(clazz);
        return dao.delete(aObjList);
    }

    /**
     * Regresa el Dao de la tabla correspondiente, nos ayudara cuando necesitemos realizar
     * inner join o consultas personalizados
     *
     * @param clazz
     * @param <T>
     * @return
     * @throws SQLException
     */
    public <T> Dao<T, ?> getDaoImpl(Class<T> clazz) throws SQLException {
        return getDao(clazz);
    }

}
