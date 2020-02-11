package com.limprove.actorschatsample.presentation.detail;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.limprove.actorschatsample.R;
import com.limprove.actorschatsample.databinding.ActivityDetailBinding;
import com.limprove.actorschatsample.util.InjectorUtil;
import com.limprove.actorschatsample.util.ViewModelFactory;

public class DetailActivity extends AppCompatActivity {

    private ActivityDetailBinding binding;
    private DetailViewModel viewModel;
    private DetailTagsAdapter adapter = new DetailTagsAdapter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail);

        createViewModel();
        int actorId = getIntent().getIntExtra("currentActor", 1);
        viewModel.provideActor(actorId);
        binding.recyclerTags.setAdapter(adapter);

        viewModel.getActor.observe(this, actor -> {
            viewModel.populateFields(actor);
            adapter.addTags(actor.tags);
            adapter.notifyDataSetChanged();
        });
    }

    private void createViewModel() {
        ViewModelFactory factory = InjectorUtil.getInstance().getViewModelFactory();
        viewModel = new ViewModelProvider(this, factory).get(DetailViewModel.class);
        binding.setViewModel(viewModel);
    }
}
