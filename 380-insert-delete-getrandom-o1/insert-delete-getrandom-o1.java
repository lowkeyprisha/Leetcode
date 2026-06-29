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
/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */