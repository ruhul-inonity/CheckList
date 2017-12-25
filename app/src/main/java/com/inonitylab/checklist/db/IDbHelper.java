package com.inonitylab.checklist.db;

import android.content.res.Resources;

import com.inonitylab.checklist.model.Task;

import java.util.ArrayList;

/**
 * Created by ruhul-inonity on 12/23/17.
 */

public interface IDbHelper {
    Long insertTask(Task task) throws Exception;
    ArrayList<Task> getAllTask() throws Resources.NotFoundException, NullPointerException;
}
