package com.example.Hash_Map;


import org.junit.Assert;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = HashMapApplicationTests.class)
public class HashTableTest {

//    @Test(description = """
//            size() method
//            empty hashtable must return 0
//            """)
//    public void iter01() {
//        var ht = new Iter01_HashTable<Object, Object>();
//        assertEquals(ht.size(), 0);
//    }


    @Test(description = """
  put() method

  - it must reject null keys
  - it must reject null values
  """)
    public void iter02() {
        var ht = new Iter02_HashTable<String, String>();
        assertEquals(ht.size(), 0);

        try {
            ht.put(null, "non-null value");

            Assert.fail("Expected a NPE");
        } catch (NullPointerException expected) {
            assertEquals(expected.getMessage(), "key is null");
        }

        try {
            ht.put("non-null key", null);

            Assert.fail("Expected a NPE");
        } catch (NullPointerException expected) {
            assertEquals(expected.getMessage(), "value is null");
        }

        assertEquals(ht.size(), 0);
    }

    @Test(description = """
  put() and size() methods

  - positive hash codes
  - no hash collisions
  - no value replacements
  """)
    public void iter03(){
        var ht = new Iter03_HashTable<Integer,String>();
        assertEquals(ht.size(),0);

        assertEquals(ht.put(1,"One"),null);
        assertEquals(ht.size(),1);

        assertEquals(ht.put(2,"Two"),null);
        assertEquals(ht.size(),2);

    }


        @Test(description = """
    get() method

  - hash table contains the mapping
  - no hash collisions
  - positive hash codes
  """) public void iter04() {
        var ht = new Iter04_HashTable<Integer, String>();
        assertEquals(ht.size(), 0);

         assertEquals(ht.put(1, "One"), null);
         assertEquals(ht.size(), 1);
         assertEquals(ht.get(1), "One");

         assertEquals(ht.put(2, "Two"), null);
         assertEquals(ht.size(), 2);
         assertEquals(ht.get(2), "Two");
    }

    @Test(description = """
  put() & get() methods

  - negative hash code
  """)
    public void iter05() {
        var ht = new Iter05_HashTable<Integer, String>();
        assertEquals(ht.size(), 0);

        assertEquals(ht.put(-1, "Minus One"), null);
        assertEquals(ht.size(), 1);
        assertEquals(ht.get(-1), "Minus One");

        assertEquals(ht.put(-2, "Minus Two"), null);
        assertEquals(ht.size(), 2);
        assertEquals(ht.get(-2), "Minus Two");
    }

    @Test(description = """
  put() & get() methods

  - negative hash code
  - positive hash code
  """)
    public void iter06() {
        var ht = new Iter06_HashTable<Integer, String>();
        assertEquals(ht.size(), 0);

        assertEquals(ht.put(-3, "Minus Three"), null);
        assertEquals(ht.size(), 1);
        assertEquals(ht.get(-3), "Minus Three");

        assertEquals(ht.put(3, "Three"), null);
        assertEquals(ht.size(), 2);
        assertEquals(ht.get(3), "Three");
    }

    @Test(description = """
  put() method

  - replace the value mapped to an existing key
  """)
    public void iter07() {
        var ht = new Iter07_HashTable<Integer, String>();
        assertEquals(ht.size(), 0);

        assertEquals(ht.put(1, "Won"), null);
        assertEquals(ht.size(), 1);

        assertEquals(ht.put(1, "One"), "Won");
        assertEquals(ht.size(), 1);

        assertEquals(ht.put(2, "Two"), null);
        assertEquals(ht.size(), 2);

        assertEquals(ht.get(1), "One");
        assertEquals(ht.get(2), "Two");
    }

    @Test(description = """
  get() method

  - non-existing key should return null
  """)
    public void iter08() {
        var ht = new Iter08_HashTable<Integer, String>();

        assertEquals(ht.get(1), null);

        assertEquals(ht.put(1, "One"), null);

        assertEquals(ht.get(1), "One");
    }


    @Test(description = """
  toString() method

  - renders an ascii table with columns:

  1. array index
  2. key toString()
  3. value toString()
  """)
    public void iter09() {
        var ht = new Iter09_HashTable<Key, String>();

        var a = new Key("AAA", 4);
        var c = new Key("CCC", 6);

        ht.put(a, "aaa");
        ht.put(c, "ccc");

        assertEquals(
                ht.toString(),
                """
                +-----+-----+-----+
                | idx | key | val |
                +-----+-----+-----+
                |   0 | AAA | aaa |
                |   1 |     |     |
                |   2 | CCC | ccc |
                |   3 |     |     |
                +-----+-----+-----+
                """
        );
    }

    @Test(description = """
  put() method

  - handle hash collisions
  - no value replacement
  """)
    public void iter10() {
        var ht = new Iter10_HashTable<Key, String>();

        var a = new Key("AAA", 2);
        var b = new Key("BBB", 2);
        var c = new Key("CCC", 2);

        assertEquals(ht.put(a, "aaa"), null);
        assertEquals(ht.put(b, "bbb"), null);
        assertEquals(ht.put(c, "ccc"), null);

        assertEquals(
                ht.toString(),
                """
                +-----+-----+-----+
                | idx | key | val |
                +-----+-----+-----+
                |   0 | CCC | ccc |
                |   1 |     |     |
                |   2 | AAA | aaa |
                |   3 | BBB | bbb |
                +-----+-----+-----+
                """
        );
    }

    @Test(description = """
  put() method

  - hash collision
  - value replacement
  """)
    public void iter11() {
        var ht = new Iter11_HashTable<Key, String>();

        var a = new Key("AAA", 2);
        var b = new Key("BBB", 2);

        assertEquals(ht.put(a, "aaa"), null);
        assertEquals(ht.put(b, "123"), null);
        assertEquals(ht.put(b, "bbb"), "123", "\n" + ht.toString());

        var c = new Key("CCC", 3);

        assertEquals(ht.put(c, "ccc"), null);

        assertEquals(
                ht.toString(),
                """
                +-----+-----+-----+
                | idx | key | val |
                +-----+-----+-----+
                |   0 | CCC | ccc |
                |   1 |     |     |
                |   2 | AAA | aaa |
                |   3 | BBB | bbb |
                +-----+-----+-----+
                """
        );
    }

    @Test(description = """
  get() test case

  - hash collision
  - non existing key
  """)
    public void iter12() {
        var ht = new Iter12_HashTable<Key, String>();

        var a = new Key("AAA", 3);
        var b = new Key("BBB", 3);
        var c = new Key("CCC", 3);

        assertEquals(ht.put(a, "aaa"), null);
        assertEquals(ht.put(b, "bbb"), null);
        assertEquals(ht.put(c, "ccc"), null);

        assertEquals(ht.get(a), "aaa");
        assertEquals(ht.get(b), "bbb");
        assertEquals(ht.get(c), "ccc");

        var d = new Key("DDD", 3);

        assertEquals(ht.get(d), null);
    }

    @Test(description = """
  Why do we need a rehash operation?
  """)
    public void iter13() {
        var ht = new Iter14_HashTable<Key, String>();

        var a = new Key("AAA", 1);
        var b = new Key("BBB", 2);
        var c = new Key("CCC", 3);
        var d = new Key("DDD", 4);
        var e = new Key("EEE", 5);

        ht.put(a, "aaa");
        ht.put(b, "bbb");
        ht.put(c, "ccc");
        ht.put(d, "ddd");
        ht.put(e, "eee");

        assertEquals(ht.get(a), "aaa");
        assertEquals(ht.get(b), "bbb");
        assertEquals(ht.get(c), "ccc");
        assertEquals(ht.get(d), "ddd");
        assertEquals(ht.get(e), "eee");
    }

    @Test(description = """
            added containsKey method""")
    public void iter14(){
        var ht = new Iter16_HashTable<Key, String>();

        var a = new Key("AAA", 1);
        var b = new Key("BBB", 2);
        var c = new Key("CCC", 8);
        var d = new Key("DDD", 4);
        var e = new Key("EEE", 5);

        ht.put(a, "aaa");
        ht.put(b, "bbb");
        ht.put(c, "ccc");
        assertEquals(true,ht.containsKey(a));
        assertEquals(false,ht.containsKey(d));

    }

    @Test(description = """
            checking remove method""")
    public void iter15(){
        var ht = new Iter17_HashTable<Key, String>();

        var a = new Key("AAA", 1);
        var b = new Key("BBB", 2);

        ht.put(a, "aaa");
        ht.put(b, "bbb");

        assertEquals("aaa",ht.remove(a));
        assertEquals("bbb",ht.remove(b));
        assertEquals(null,ht.remove(a));

    }

    @Test(description = """
            cheking dynamic change in the array size""")

    public void iter16(){
        var ht = new Iter17_HashTable<Key, String>();

        var a = new Key("AAA", 1);
        var b = new Key("BBB", 2);
        var c = new Key("CCC", 3);
        var d = new Key("DDD", 4);
        var e = new Key("EEE", 5);

        ht.put(a, "aaa");
        ht.put(b, "bbb");
        ht.put(c, "ccc");
        ht.put(d, "ddd");
        ht.put(e, "eee");

        assertEquals("aaa",ht.remove(a));
        assertEquals("bbb",ht.remove(b));
        assertEquals("ccc",ht.remove(c));
        assertEquals("ddd",ht.remove(d));
        assertEquals("eee",ht.remove(e));
        assertEquals(null,ht.remove(e));

    }


}