package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        taskManager.add(new Task("coding", "learning"));
        taskManager.getTask().forEach( task -> {
            System.out.println(task.getDescription());
        });
    }
}