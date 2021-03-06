package utility;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Troy on 4/18/2015.
 */
public class BidirectionalMap<K, V> {

    private Map<K, V> keyToValueMap;
    private Map<V, K> valueToKeyMap;

    public BidirectionalMap() {
        keyToValueMap = new HashMap<K, V>();
        valueToKeyMap = new HashMap<V, K>();
    }

    public void insert( K key, V value ) {
        keyToValueMap.put(key, value);
        valueToKeyMap.put(value, key);
    }

    public void clear() {
        keyToValueMap.clear();
        valueToKeyMap.clear();
    }

    public boolean containsKey( K key  ) {
        return keyToValueMap.containsKey(key);
    }

    public boolean containsValue( V value ) {
        return keyToValueMap.containsValue(value);
    }

    public V getValue( K key ) {
        // If shit starts going cray when querying for MapObject's Location in the GameMap, this is
        // what you need to uncomment.
//        for (K k : keys()) { // <== LOLOLOLOLOL
//            if (k.equals(key)) {
//                return keyToValueMap.get(k);
//            }
//        }

        return keyToValueMap.get(key);
    }

    public K getKey( V value ) {
        for (V v : values()) { // <== LOLOLOLOLOL
            if (v.equals(value)) {
                return valueToKeyMap.get(v);
            }
        }

        return valueToKeyMap.get(value);
    }

    public boolean isEmpty() {
        return keyToValueMap.isEmpty();
    }

    public void removeKey( K key ) {
        V v = keyToValueMap.get( key );
        keyToValueMap.remove( key );
        valueToKeyMap.remove( v );
    }

    public void removeValue( V value ) {
        K k = valueToKeyMap.get( value );
        keyToValueMap.remove( value );
        valueToKeyMap.remove( k );
    }

    public void replace( K key, V value ) {
        keyToValueMap.replace( key, value );
        valueToKeyMap.replace( value, key );
    }

    public int size() {
        return keyToValueMap.size();
    }

    public Collection<K> keys() {
        return valueToKeyMap.values();
    }

    public Collection<V> values() {
        return keyToValueMap.values();
    }
}
