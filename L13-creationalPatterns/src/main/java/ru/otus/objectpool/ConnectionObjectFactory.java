package ru.otus.objectpool;

/**
 * @author sergey created on 19.09.18.
 */
@SuppressWarnings("java:S106")
class ConnectionObjectFactory implements ObjectFactory<Connection> {
    @Override
    public Connection create() {
        System.out.println("Create new Connection");
        return new ConnectionPostgres();
    }
}
