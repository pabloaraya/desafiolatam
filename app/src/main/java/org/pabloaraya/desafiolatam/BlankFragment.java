package org.pabloaraya.desafiolatam;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {

    private CallbackUser callbackUser;

    public BlankFragment() {
        // Required empty public constructor
    }

    public void setCallbackUser(CallbackUser callbackUser) {
        this.callbackUser = callbackUser;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }


    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button btnLt =(Button) view.findViewById(R.id.buttonLt);
        final EditText nameText=view.findViewById(R.id.nameText);
        final RadioGroup radioGroup=view.findViewById(R.id.fragRg);

         btnLt.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View button) {
                 Toast.makeText(getContext(), "test", Toast.LENGTH_SHORT).show();

                 RadioButton radioButton = view.findViewById(radioGroup.getCheckedRadioButtonId());

                 callbackUser.saveName(nameText.getText().toString());
                 callbackUser.saveAge(radioButton.getText().toString());
             }
         });


    }
}
