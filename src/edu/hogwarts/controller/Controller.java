package src.edu.hogwarts.controller;

import java.util.ArrayList;
import java.util.UUID;

public abstract class Controller<T> {

    public abstract void add(T entity);

    public abstract void add(T[] entities);

    public abstract T get(UUID id);

    public abstract ArrayList<T> getAll();

}