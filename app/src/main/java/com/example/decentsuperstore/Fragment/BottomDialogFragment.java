package com.example.decentsuperstore.Fragment;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Button;
        import android.widget.TextView;

        import androidx.annotation.Nullable;

        import com.example.decentsuperstore.Activity.CartActivity;
        import com.example.decentsuperstore.R;
        import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class BottomDialogFragment extends BottomSheetDialogFragment {

    private Button btnApply,btnApply2;
    public static BottomDialogFragment getInstance() {
        return new BottomDialogFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.offer_bottom_sheet, container, false);

        btnApply=view.findViewById(R.id.btnApply);
        btnApply2=view.findViewById(R.id.btnApply2);

        btnApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), CartActivity.class);
                startActivity(intent);

            }
        });
        btnApply2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), CartActivity.class);
                startActivity(intent);

            }
        });

        return view;
    }

}
