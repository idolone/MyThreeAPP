package com.example.mysp.room.manager;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.mysp.room.Student;
import com.example.mysp.room.StudentDao;
import com.example.mysp.room.StudentDatabase;

import java.util.List;

public class DBEngine {
    private StudentDao studentDao;
    private static final String TAG = "KIN" ;

    public DBEngine(Context context) {

        StudentDatabase studentDatabase = StudentDatabase.getmInstance(context);

        studentDao = studentDatabase.getStudentDao();


    }

    //dao 增删改查
    //insert
    public  void insertStudents(Student ... students)
    {
        new InsertAsyncTask(studentDao).execute(students);
    }

    //如果我们想玩数据库，默认是异步线程-------异步操作
    static class InsertAsyncTask extends AsyncTask<Student,Void,Void>{

        private  StudentDao dao;

        public InsertAsyncTask(StudentDao studentDao) {
            dao = studentDao;
        }

        @Override
        protected Void doInBackground(Student... students) {
            dao.insertStudent(students);
            return null;
        }
    }

    //Update
    public  void UpdateStudents(Student ... students)
    {
        new UpdateAsyncTask(studentDao).execute(students);
    }

    //如果我们想玩数据库，默认是异步线程-------异步操作
    static class UpdateAsyncTask extends AsyncTask<Student,Void,Void>{

        private  StudentDao dao;

        public UpdateAsyncTask(StudentDao studentDao) {
            dao = studentDao;
        }

        @Override
        protected Void doInBackground(Student... students) {
            dao.modifyStudent(students);
            return null;
        }
    }

    //delete
    public  void DeleteStudents(Student ... students)
    {
        new DeleteAsyncTask(studentDao).execute(students);
    }

    //如果我们想玩数据库，默认是异步线程-------异步操作
    static class DeleteAsyncTask extends AsyncTask<Student,Void,Void>{

        private  StudentDao dao;

        public DeleteAsyncTask(StudentDao studentDao) {
            dao = studentDao;
        }

        @Override
        protected Void doInBackground(Student... students) {
            dao.deleteStudents(students);
            return null;
        }
    }

    //delete all
    public  void DeleteAllStudents()
    {
        new DeleteAllAsyncTask(studentDao).execute();
    }

    //如果我们想玩数据库，默认是异步线程-------异步操作
    static class DeleteAllAsyncTask extends AsyncTask<Void,Void,Void>{

        private  StudentDao dao;

        public DeleteAllAsyncTask(StudentDao studentDao) {
            dao = studentDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            dao.deleteAllStudents();
            return null;
        }
    }

    //query all
    public  void QueryAllStudents()
    {
        new QueryAllAsyncTask(studentDao).execute();
    }

    //如果我们想玩数据库，默认是异步线程-------异步操作
    static class QueryAllAsyncTask extends AsyncTask<Void,Void,Void>{


        private  StudentDao dao;

        public QueryAllAsyncTask(StudentDao studentDao) {
            dao = studentDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            List<Student> allstudents = dao.getAllStudent();
            for (Student student : allstudents) {
                Log.e(TAG, "doInBackground: "+ student.toString() );

            }

            return null;
        }
    }





}
