class Pair{
    int timestamp;
    String value;

    public Pair(String value, int timestamp) {
        this.timestamp = timestamp;
        this.value = value;
    }
}
class TimeMap {

    private HashMap<String, ArrayList<Pair>> hashmap;

    public TimeMap() {
        hashmap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(hashmap.containsKey(key)){
            hashmap.get(key).add(new Pair(value, timestamp));
        } else{
            ArrayList<Pair> list = new ArrayList<>();
            list.add(new Pair(value, timestamp));
            hashmap.put(key,list);
        }
    }
    
    public String get(String key, int timestamp) {
        String result = "";
        if(hashmap.containsKey(key)){
            ArrayList<Pair> list = hashmap.get(key);
            int left = 0;
            int right = list.size() -1;

            while(left <= right){
                int mid = (left + right)/2;
                int time = list.get(mid).timestamp;
                if(timestamp == time){
                    return list.get(mid).value;
                } else if(time<timestamp){
                    result = list.get(mid).value;
                    left = mid + 1;
                } else {
                    right = mid -1;
                }
            }
        }
        return result;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */