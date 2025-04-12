package model;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class Student {
    
    @Id
    private int id;

    private String name;
    private String address;
    private int age;

    @Column(name = "joined_date")
    private java.sql.Date joinedDate;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public java.sql.Date getJoinedDate() { return joinedDate; }
    public void setJoinedDate(java.sql.Date joinedDate) { this.joinedDate = joinedDate; }
}