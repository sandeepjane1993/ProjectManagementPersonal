package com.example.sande.projectmanagementpersonal.assignteammembers;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sande.projectmanagementpersonal.R;
import com.example.sande.projectmanagementpersonal.allviewmodels.AssignTaskViewModel;
import com.example.sande.projectmanagementpersonal.databinding.AssignTaskBinding;
import com.example.sande.projectmanagementpersonal.pojo.AssignTaskPOJO;

public class AssignTaskMember extends Fragment {

    AssignTaskPOJO assignTaskPOJO;
    Button btn;
    EditText editText;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

       // View view = inflater.inflate(R.layout.fragment_assign_member_totask,container,false);

        AssignTaskBinding binding = DataBindingUtil.inflate(inflater,R.layout.fragment_assign_member_totask,container,false);
        View view = binding.getRoot();
        editText = view.findViewById(R.id.et_userId_ATM);
        btn = view.findViewById(R.id.btn_assignTaskToMember);

        AssignTaskViewModel viewModel = new AssignTaskViewModel(getActivity());
        binding.setViewModel(viewModel);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                viewModel.setUserId(editText.getText().toString());
                viewModel.getResponse();
                Toast.makeText(getActivity(), "" + viewModel.getResponse(), Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
