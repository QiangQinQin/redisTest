package com.example.redistest.redis.test;

import java.io.*;
// 将内存中的对象通过序列化的方式存储到本地的某个文件中
public class JavaSerialization {
    private static final File SAVE_FILE = new File("D:" + File.separator + "demo.Class");

    public static void saveObject(Object object) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_FILE));
        oos.writeObject(object); // 序列化
        oos.close();
    }

    public static Object loadObject() throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(SAVE_FILE));
        Object obj = ois.readObject(); // 反序列化
        ois.close();
        return obj;
    }


    public static void main(String[] args) throws Exception {
        saveObject(new Class(new Person("p",11),"class",12));// 序列化
        Class c = (Class)loadObject();
        System.out.println(c); // 反序列化


        saveObject(new Person("p",11));// 序列化
        Person person = (Person) loadObject();
        System.out.println(person); // 反序列化
    }

    public static class Person implements Serializable {
        private String name;
        private int age;
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public int getAge() {
            return age;
        }
        public void setAge(int age) {
            this.age = age;
        }
        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }


    public static class Class implements Serializable{
        private Person person;
        private String name;
        private int age;
        public Person getPerson() {
            return person;
        }
        public void setPerson(Person person) {
            this.person = person;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public int getAge() {
            return age;
        }
        public void setAge(int age) {
            this.age = age;
        }
        @Override
        public String toString() {
            return "Class{" +
                    "person=" + person +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
        public Class(Person person) {
            this.person = person;
        }
        public Class(Person person, String name, int age) {
            this.person = person;
            this.name = name;
            this.age = age;
        }
    }
}