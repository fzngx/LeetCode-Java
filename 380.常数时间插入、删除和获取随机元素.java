/*
 * @lc app=leetcode.cn id=380 lang=java
 *
 * [380] 常数时间插入、删除和获取随机元素
 */

// @lc code=start
class RandomizedSet {
    ArrayList<Integer> data;

    HashMap<Integer, Integer> valToIdx;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        data = new ArrayList<>();
        valToIdx = new HashMap<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (valToIdx.containsKey(val)) {
            return false;
        } else {
            valToIdx.put(val, data.size());
            data.add(val);
            return true;
        }
    }

    /** Swap data.get(a) and data.get(b) */
    private void swap(int a, int b) {
        int temp = data.get(a);
        data.set(a, data.get(b));
        data.set(b, temp);

    }


    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (valToIdx.containsKey(val)) {
            valToIdx.put(data.get(data.size() - 1), valToIdx.get(val));
            swap(valToIdx.get(val), data.size() - 1);
            data.remove(data.size() - 1);
            valToIdx.remove(val);
            return true;
        }
        return false;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return data.get(new Random().nextInt(data.size()));
    }

}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
// @lc code=end

