package org.pabloaraya.desafiolatam;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Tab1Fragment extends Fragment {


    public Tab1Fragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tab1, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final RadioGroup radiogroup = view.findViewById(R.id.mascotaRg);
        Button button = view.findViewById(R.id.sendBtn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int id = radiogroup.getCheckedRadioButtonId();

                if (id != -1) {

                    RadioButton radiobutton = radiogroup.findViewById(id);
                    String answer = radiobutton.getText().toString();
                    showDialog(answer);

                } else {
                    Toast.makeText(getContext(), "Marca una respuesta", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    private void showDialog(String answer){

        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
        alertDialog.setTitle("Hola AnimalLover");
        alertDialog.setMessage("Te gustan los " + answer);
        alertDialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        alertDialog.show();

    }
}
