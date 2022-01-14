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

public class Planning extends Fragment {
    private static Planning instance = null;

    private final MainActivity mActivity;
    private RecyclerView planningRecyclerView;
    private Adapter planningAdapter;

    private List<TodoModel> eventList;

    public Planning(MainActivity activity) {
        super();
        mActivity = activity;
    }

    public static void setInstance(Planning planningTab) {
        instance = planningTab;
    }

    public static Planning getInstance() {
        return instance;
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ) {
        View root = inflater.inflate(R.layout.planning, container, false);

        eventList = new ArrayList<>();

        planningRecyclerView = root.findViewById(R.id.planning_recycler_view);
        planningRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        planningAdapter = new Adapter(mActivity);
        planningRecyclerView.setAdapter(planningAdapter);

        return root;
    }

    public void addEvent(TodoModel event) {
        eventList.add(event);
        planningAdapter.setEvents(eventList);
    }
}
