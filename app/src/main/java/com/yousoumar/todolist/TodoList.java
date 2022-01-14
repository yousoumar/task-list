package com.yousoumar.todolist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TodoList extends Fragment {
    private static TodoList instance = null;

    private final MainActivity mActivity;
    private RecyclerView taskRecyclerView;
    private TodoListAdapter taskAdapter;

    private List<TodoModel> taskList;

    public TodoList(MainActivity activity) {
        super();
        mActivity = activity;
    }

    public static void setInstance(TodoList taskListTab) {
        instance = taskListTab;
    }

    public static TodoList getInstance() {
        return instance;
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ) {
        View root = inflater.inflate(R.layout.task_list, container, false);

        taskList = new ArrayList<>();

        taskRecyclerView = root.findViewById(R.id.task_list_recycler_view);
        taskRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        taskAdapter = new TodoListAdapter(mActivity);
        taskRecyclerView.setAdapter(taskAdapter);

        return root;
    }

    public void addTodo(TodoModel task) {
        taskList.add(task);
        taskAdapter.setTodos(taskList);
    }
}
