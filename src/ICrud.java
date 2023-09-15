import java.util.ArrayList;

public interface ICrud<ID, T> {
    T create(T object);

    T update(T object);

    T read(ID id);

    ArrayList<T> read();

    boolean delete(T object);
}
