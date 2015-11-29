package es.enbinario.dao;

import java.io.Serializable;
/**
 * Implementa las opciones basicas y comunes a todas las entidades
 * @author 0010789
 *
 * @param <T>
 * @param <K>
 */
public interface BaseDAO <T, K extends Serializable> {

	public T create(T entity);

	public T update(T entity);

	public void delete(T entity);

	public T findById(K key);
	
	public void save(T entity);

}