package School.hello.Service;

import java.util.List;

public interface GenericService<T> {
	
	public List<T> getAll();
	public T getById(int id);
	public void createObject(T Object);
	public void deleteObject(int id);
	public void updateObject(T object, int id);

}
