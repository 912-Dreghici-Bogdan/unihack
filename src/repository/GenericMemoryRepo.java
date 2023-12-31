package src.repository;

import src.domain.Identifiable;

import java.util.ArrayList;

public class GenericMemoryRepo<T extends Identifiable> implements IRepository<T>{
    private ArrayList<T> Items;
    public GenericMemoryRepo()
    {
        Items = new ArrayList<>();
    }

    @Override
    public void addItem(T item) {
        Items.add(item);
    }

    @Override
    public void removeItem(T item) {
        Items.remove(item);
    }
    @Override
    public Iterable<T> getAllItems() {
        return Items;
    }
}
