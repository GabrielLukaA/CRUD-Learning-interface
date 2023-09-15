import java.util.ArrayList;

public class BDAlimento implements ICrud<Integer, Alimento> {

    private static ArrayList<Alimento> alimentos = new ArrayList<>();

    @Override
    public Alimento create(Alimento alimento) {
        if (alimentos.add(alimento)) {
            return alimento;
        }
        return null;
    }

    @Override
    public Alimento update(Alimento alimento) {
        for (Alimento alimentoFor: alimentos) {
            if (alimentoFor.getId() == alimento.getId()){
                alimentos.set(alimentos.indexOf(alimentoFor), alimento);
                return alimentoFor;
            }
        }
        return null;
    }

    @Override
    public Alimento read(Integer id) {
        for (Alimento alimento : alimentos) {
            if (alimento.getId() == id) {
                return alimento;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Alimento> read() {
        return alimentos;
    }

    @Override
    public boolean delete(Alimento alimento) {
        for (Alimento alimentoFor : alimentos) {
            if (alimentoFor.equals(alimento)) {
                alimentos.remove(alimento);
                return true;
            }
        }
        return false;
    }

    public static ArrayList<Alimento> getAlimentos() {
        return alimentos;
    }
}
