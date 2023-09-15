import java.util.ArrayList;

public class BDEletronico implements ICrud<Integer, Eletronico> {


    private static ArrayList<Eletronico> eletronicos = new ArrayList<>();

    @Override
    public Eletronico create(Eletronico eletronico) {
        if (eletronicos.add(eletronico)) {
            return eletronico;
        }
        return null;
    }

    @Override
    public Eletronico update(Eletronico eletronico) {
        for (Eletronico eletronicoFor: eletronicos) {
            if (eletronicoFor.getId() == eletronico.getId()){
                eletronicoFor = eletronico;
                    return eletronicoFor;
            }
        }
        return null;
    }

    @Override
    public Eletronico read(Integer id) {
        for (Eletronico
                eletronico : eletronicos) {
            if (eletronico.getId() == id) {
                return eletronico;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Eletronico> read() {
        return eletronicos;
    }

    @Override
    public boolean delete(Eletronico eletronico) {
        for (Eletronico eletronicoFor : eletronicos) {
            if (eletronicoFor.equals(eletronico)) {
                eletronicos.remove(eletronico);
                return true;
            }
        }
        return false;
    }

    public static ArrayList<Eletronico> getEletronicos() {
        return eletronicos;
    }
}
