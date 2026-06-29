import java.util.*;

class RandomizedSet {
    private List<Integer> list = new ArrayList<>();
    private Random rand = new Random();

    public boolean insert(int val) {
        if (list.contains(val)) return false;
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        return list.remove(Integer.valueOf(val));
    }

    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}