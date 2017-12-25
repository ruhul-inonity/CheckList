package com.inonitylab.checklist.model;

import java.io.Serializable;

/**
 * Created by ruhul on 12/23/17.
 */

public class Task implements Serializable {
    int taskId;
    private String task;
    private String isDone;
    private String dateTime;

    public Task() {
    }

    public Task(String task, String isDone, String dateTime) {
        this.task = task;
        this.isDone = isDone;
        this.dateTime = dateTime;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getIsDone() {
        return isDone;
    }

    public void setIsDone(String isDone) {
        this.isDone = isDone;
    }
}
