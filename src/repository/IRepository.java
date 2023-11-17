package src.repository;

import src.domain.Identifiable;

public interface IRepository<T extends Identifiable> {
    public void addItem(T item);
    public void removeItem(T item);
    public Iterable<T> getAllItems();

}
