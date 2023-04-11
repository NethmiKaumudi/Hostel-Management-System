package lk.ijse.hostelmanagementsystem.repository;

public interface CrudRepository<T, ID> extends SuperRepository {
    public ID Save(T entity);

    public void delete(T entity);

    public void update(T entity);

    public T get(ID Id);

}
