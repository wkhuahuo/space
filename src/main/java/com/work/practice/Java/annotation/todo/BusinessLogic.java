package com.work.practice.Java.annotation.todo;

/**
 * Created by wangkai43 on 2017/6/21.
 */
public class BusinessLogic {
    public BusinessLogic() {
        super();
    }

    public void compltedMethod() {
        System.out.println("This method is complete");
    }

    @Todo(priority = Todo.Priority.HIGH)
    public void notYetStartedMethod() {
        // No Code Written yet
        System.out.println("not yet started method");
    }

    @Todo(priority = Todo.Priority.MEDIUM, author = "Uday", status = Todo.Status.STARTED)
    public void incompleteMethod1() {
        //Some business logic is written
        //But its not complete yet
        System.out.println("incomplete Method1");
    }

    @Todo(priority = Todo.Priority.LOW, status = Todo.Status.STARTED )
    public void incompleteMethod2() {
        //Some business logic is written
        //But its not complete yet
        System.out.println("incomplete Method2");
    }
}
