package com.demo.collection;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 *  -- 在java类库源码打断点注意，idea也是由java编写的，也会用到其中的某些类，所有在代码运行之前不要打断点
 */
public class CollectionTest {


    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<>();
        list1.addAll(Arrays.asList("a","b","c","d","e"));
        ArrayList<String> list2 = new ArrayList<>();
        list2.addAll(Arrays.asList("z","z","z","z","z","b","c","a"));
        boolean b = list1.retainAll(list2);


        list1.iterator();
        System.err.println(b);
        System.err.println(list1.toString());
    }

    @Test
    public void testFor(){

    }

    /**
     * -------------------------------------------------------------list-----------------------------------------------------------------------------------
     */
    @Test
    public void arrayListTest(){
        ArrayList<String> list = new ArrayList<>();
        //add
        list.add("a");
        list.add("b");
        list.addAll(Arrays.asList("c","d"));
        System.err.println(list.remove(0));
        list.trimToSize();
        boolean b = list.retainAll(Arrays.asList("c", "d"));
        System.err.println(b);
        System.err.println(list.toString());
    }

    @Test
    public void forEachTest(){
        ArrayList<String> list = new ArrayList<>();
        //add
        list.add("a");
        list.add("b");

        if(list.size()!=0){
            return;
        }

        list.forEach(x->{
            System.err.println(x);
            if(x.equals("a")){
                return;
            }
        });
    }

    @Test
    public void failFastTest(){
        ArrayList<String> list = new ArrayList<>();
        //add
        list.add("a");
        list.add("b");

        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            list.remove(0);
            String next = iterator.next();
            System.err.println(next);
        }

    }

    @Test
    public void vectorTest(){
        Vector<String> vector = new Vector<>();
//        Stack<String> stack = new Stack<>();
        vector.add("1");
    }

    @Test
    public void synchronizedListTest(){
        List<Object> list = Collections.synchronizedList(new ArrayList<>());
    }

    @Test
    public void copyOnWriteArrayListTest(){
        CopyOnWriteArrayList<Object> list = new CopyOnWriteArrayList<>();
    }

    @Test
    public void linkedListTest(){
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("a");
        System.err.println(linkedList.toString());
    }

    /**
     * -------------------------------------------------------------map-----------------------------------------------------------------------------------
     */
    @Test
    public void hashMapTest(){
        HashMap<String,String> map = new HashMap<>();
        map.put("ak","av");

    }

    @Test
    public void conCurrentHashmapTest(){
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.put("ak","av");

    }

    @Test
    public void treeMapList(){
        TreeMap<String, String> map = new TreeMap<>();
    }

    @Test
    public void hashTableTest(){
        Hashtable<String,String> map = new Hashtable<>();
        map.put("ak","av");

    }
    @Test
    public void testEquals(){
        Object[] emptyArray={};
        Object[] array =emptyArray;
        System.err.println(emptyArray.length);
//        System.err.println(emptyArray==array);
    }

    /**
     * -------------------------------------------------------------set-----------------------------------------------------------------------------------
     */
    @Test
    public void hashSetTest(){
        HashSet<String> set = new HashSet<>();
    }

    @Test
    public void treeSetTest(){
        TreeSet<String> set = new TreeSet<>();
    }

    @Test
    public void linkedHashSetTest(){
        LinkedList<String> set = new LinkedList<>();
    }

    @Test
    public void synchronizedSetTest(){
        Set<Object> set = Collections.synchronizedSet(new HashSet<>());
        set.add("a");
    }

    @Test
    public void copyOnWriteArraySetTest(){
        CopyOnWriteArraySet<Object> set = new CopyOnWriteArraySet<>();
        set.add("a");
    }

    /**
     * -------------------------------------------------------------Collection-----------------------------------------------------------------------------------
     */
}
