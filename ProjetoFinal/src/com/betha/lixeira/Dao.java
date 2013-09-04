package com.betha.lixeira;

public interface Dao<T> {

	public Object selectAll ();
	public void insert (T objeto);
	public Object selectOne (int id);
	public void delete (T objeto);
	
}
