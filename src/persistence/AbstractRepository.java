package persistence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.Entidade;

public class AbstractRepository<T extends Entidade> implements Repository<T> {

  List<T> entidades = new ArrayList<>();

  @Override
  public boolean save(T entidade) {
    if(entidades.contains(entidade)) return false;

    entidades.add(entidade);
    return true;
  }

  @Override
  public boolean remove(T entidade) {
    if(!entidades.contains(entidade)) return false;

    entidades.remove(entidade);
    return true;
    
  }

  @Override
  public List<T> listarTodos() {
    return Collections.unmodifiableList(entidades);
  }

  @Override
  public T buscarPorId(String id) {
    return entidades.stream()
                    .filter(e -> e.getID().equalsIgnoreCase(id))
                    .findAny()
                    .orElse(null);
  }
  
}
