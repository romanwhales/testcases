package com.eppress.demo.entities;

import javax.annotation.Generated;
import javax.persistence.*;

@Entity
@Table(name="todos")
public class Todo {
    @Id
    @SequenceGenerator(name="todo_id_generator",sequenceName=
            "todo_id_sequence",initialValue = 3)
    @GeneratedValue(generator = "todo_id_generator")
    private Integer id;
    private String text;
    private boolean done;

    public Todo(){

    }

    public Todo(Integer id,String text,boolean done){
        this.id = id;
        this.text = text;
        this.done = done;
    }

    @Override
    public String toString() {
        return "Todo [id=" + id + ", text=" + text + ", done=" + done + "]";
    }

    public Integer getId(){
        return id;
    }
    public void setInteger(Integer id){
        this.id = id;
    }

    public String getText(){
        return text;
    }

    public void setText(String text){
        this.text = text;
    }
    public Boolean isDone(){
        return done;
    }

    public void setDone(Boolean done){
        this.done = done;
    }
}
