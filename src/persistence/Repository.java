package persistence;

import java.util.List;

public interface Repository<T> {
  boolean save(T entidade);
  boolean remove(T entidade);
  List<T> listarTodos();
  T buscarPorId(String id);
}
