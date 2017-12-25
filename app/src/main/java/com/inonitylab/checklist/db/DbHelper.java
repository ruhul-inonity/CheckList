package com.inonitylab.checklist.db;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.inonitylab.checklist.model.Task;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * Created by ruhul-inonity on 12/23/17.
 */

public class DbHelper extends SQLiteOpenHelper implements IDbHelper  {
    public static final String TAG = "DbHelper";

    public static final String DB_NAME = "CheckListDb";
    public static final int DB_VERSION = 1;

    public static final String TABLE_TASKLIST = "tasks";
    public static final String COLUMN_TASK_ID = "id";
    public static final String COLUMN_TASK_NAME = "task";
    public static final String COLUMN_TASK_DATE = "dateTime";
    public static final String COLUMN_TASK_ISDONE = "isDone";


    @Inject
    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        createTaskTable(sqLiteDatabase);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    private void createTaskTable(SQLiteDatabase db) {
        try {
            db.execSQL(
                    "CREATE TABLE IF NOT EXISTS "
                            + TABLE_TASKLIST + "("
                            + COLUMN_TASK_ID + " INTEGER PRIMARY KEY,"
                            + COLUMN_TASK_NAME + " TEXT,"
                            + COLUMN_TASK_ISDONE + " TEXT,"
                            + COLUMN_TASK_DATE + " TEXT" + ")"
            );

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public Long insertTask(Task task) throws Exception {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(COLUMN_TASK_NAME, task.getTask());
            contentValues.put(COLUMN_TASK_DATE, task.getDateTime());
            return db.insert(TABLE_TASKLIST, null, contentValues);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public ArrayList<Task> getAllTask() throws Resources.NotFoundException, NullPointerException {
        Cursor cursor = null;
        ArrayList<Task> taskList = new ArrayList<>();
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            cursor = db.rawQuery(
                    "SELECT * FROM "
                            + TABLE_TASKLIST
                            + " ORDER BY "
                            + COLUMN_TASK_ISDONE,
                            null);


            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                Task task = new Task();

                task.setTaskId(cursor.getInt(cursor.getColumnIndex(COLUMN_TASK_ID)));
                task.setTask(cursor.getString(cursor.getColumnIndex(COLUMN_TASK_NAME)));
                task.setIsDone(cursor.getString(cursor.getColumnIndex(COLUMN_TASK_ISDONE)));
                task.setDateTime(cursor.getString(cursor.getColumnIndex(COLUMN_TASK_DATE)));

                Log.d(TAG, "getAllTask: .......................... "+task.getTask());
                taskList.add(task);
                //return taskList;
            } else {
                throw new Resources.NotFoundException("does not exists");
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (cursor != null)
                cursor.close();
            return taskList;
        }

    }
}
