package src.edu.hogwarts.controller;

import java.util.ArrayList;

public abstract class Controller<T> {

    public abstract void add(T entity);

    public abstract void add(T[] entities);

    public abstract ArrayList<T> getAll();

}