package main.java;

import com.google.gson.Gson;

import java.io.Serializable;

public class Student implements Serializable {
        private String name;
        private byte date;
        private char sex;
        private String group;

        public Student(String name, byte date, String group, char sex ) {
            this.name = name;
            this.date = date;
            this.group = group;
            this.sex = sex;

        }
        public Student(){};

        public void setName(String name) {
            this.name = name;
        }


        public void setDate(byte date) {
            this.date = date;
        }

        public void setSex(Character sex) {
            this.sex = sex;
        }

        public void setGroup(String group) {
            this.group = group;
        }

        public String getName() {
            return name;
        }

        public byte getDate() {
            return date;
        }

        public char getSex() {
            return sex;
        }

        public String getGroup() {
            return group;
        }


}


