package com.yousoumar.todolist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TodoListAdapter extends RecyclerView.Adapter<TodoListAdapter.ViewHolder> {
    private List<TodoModel> taskList = new ArrayList<>();

    private MainActivity activity;

    public TodoListAdapter(MainActivity activity) {
        this.activity = activity;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.task_layout, parent, false);

        return new ViewHolder(itemView);
    }

    public void onBindViewHolder(ViewHolder holder, int position) {
        TodoModel item = taskList.get(position);
        holder.checkBox.setText(item.getTitle());
        holder.checkBox.setChecked(item.isDone());

        holder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taskList.remove(item);
                notifyDataSetChanged();
            }
        });
    }

    public int getItemCount() {
        return taskList.size();
    }

    public void setTodos(List<TodoModel> taskList) {
        this.taskList = taskList;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        CheckBox checkBox;
        ImageButton deleteButton;

        ViewHolder(View view) {
            super(view);
            checkBox = view.findViewById(R.id.task_check_box);
            deleteButton = view.findViewById(R.id.task_delete_btn);
        }
    }
}

