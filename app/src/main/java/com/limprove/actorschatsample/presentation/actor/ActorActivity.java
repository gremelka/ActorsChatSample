package com.limprove.actorschatsample.presentation.actor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.limprove.actorschatsample.R;
import com.limprove.actorschatsample.databinding.ActivityActorBinding;
import com.limprove.actorschatsample.util.InjectorUtil;
import com.limprove.actorschatsample.util.ViewModelFactory;

public class ActorActivity extends AppCompatActivity {

    private ActorViewModel viewModel;
    private ActorAdapter adapter = new ActorAdapter();
    private ActivityActorBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_actor);

        ViewModelFactory factory = InjectorUtil.getInstance().getViewModelFactory();
        viewModel = new ViewModelProvider(this, factory).get(ActorViewModel.class);

        binding.recyclerMessageList.setAdapter(adapter);

        viewModel.getActors().observe(this, adapter::submitList);
    }
}
