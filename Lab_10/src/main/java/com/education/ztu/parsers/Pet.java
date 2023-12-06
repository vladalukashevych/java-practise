package com.education.ztu.parsers;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Pet {
    public String id;
    public String name;
    public String age;
    public String owner;
    public Pet() {}
    public Pet(@JsonProperty("id") String id, @JsonProperty("name") String name,
               @JsonProperty("age") String age, @JsonProperty("owner") String owner) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.owner = owner;
    }

    public String toString() {
        return "id: " + this.id + ", name: " + this.name + ", age: " + this.age + ", owner: " + this.owner;
    }
}
