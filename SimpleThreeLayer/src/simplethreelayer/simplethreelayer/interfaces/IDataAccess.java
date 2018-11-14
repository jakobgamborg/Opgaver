package simplethreelayer.simplethreelayer.interfaces;

import java.util.List;

public interface IDataAccess {
    public List<String> load();

    public void save(List<String> data);
}
