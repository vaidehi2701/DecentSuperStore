package com.example.decentsuperstore.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.decentsuperstore.Model.ContactModel;
import com.example.decentsuperstore.R;

import java.util.List;


public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {
    private List<ContactModel> contactModels;
    private Context context;

    public ContactAdapter(List<ContactModel> contactModels, Context context) {
        this.contactModels = contactModels;
        this.context = context;
    }

    public ContactAdapter(List<ContactModel> contactModels) {
        this.contactModels = contactModels;
    }

    @Override
    public ContactAdapter.ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflate the layout file
        View ContactView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact, parent, false);
        ContactAdapter.ContactViewHolder gvh = new ContactAdapter.ContactViewHolder(ContactView);
        return gvh;
    }

    @Override
    public void onBindViewHolder(ContactAdapter.ContactViewHolder holder, final int position) {
        holder.tvMainBranchName.setText(contactModels.get(position).getBranchName());
//            holder.imageView.setOnClickListener(new View.OnClickListener() {
////                @Override
////                public void onClick(View v) {
////                    //String productName = StoryList.get(position).getProductImage().toString();
////                    // Toast.makeText(context, productName + " is selected", Toast.LENGTH_SHORT).show();
////                }
////            });
    }

    @Override
    public int getItemCount() {
        return contactModels.size();
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder {
        TextView tvMainBranchName;


        public ContactViewHolder(View view) {
            super(view);
            context = itemView.getContext();
            tvMainBranchName = view.findViewById(R.id.tvMainBranchName);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();


                    switch (position) {
                        case 0:
                            openVadodara();
                            break;

                        case 1:
                            openSurat();
                            break;
                        case 2:
                            openAhemdabad();
                            break;
                        case 3:
                            openMumbai();
                            break;
                        case 4:
                            openPune();
                            break;
                        case 5:
                            openDelhi();
                            break;
                        case 6:
                            openNagpur();
                            break;

                        default:
                            openVadodara();
                            break;
                    }


//                    Snackbar.make(v, "Click detected on item " + position,
//                            Snackbar.LENGTH_LONG)
//                            .setAction("Action", null).show();
                }
            });

        }

        private void openVadodara() {
            LayoutInflater alertDialog = LayoutInflater.from(context);
            View view = alertDialog.inflate(R.layout.custom_vadodara, null);


            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
            alertDialogBuilder.setView(view);

            alertDialogBuilder.show();

        }

        private void openSurat() {
            LayoutInflater alertDialog = LayoutInflater.from(context);
            View view = alertDialog.inflate(R.layout.custom_surat, null);


            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
            alertDialogBuilder.setView(view);

            alertDialogBuilder.show();


        }

        private void openAhemdabad() {
            LayoutInflater alertDialog = LayoutInflater.from(context);
            View view = alertDialog.inflate(R.layout.custom_ahemdabad, null);


            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
            alertDialogBuilder.setView(view);

            alertDialogBuilder.show();


        }

        private void openMumbai() {
            LayoutInflater alertDialog = LayoutInflater.from(context);
            View view = alertDialog.inflate(R.layout.custom_mumbai, null);


            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
            alertDialogBuilder.setView(view);

            alertDialogBuilder.show();


        }

        private void openPune() {
            LayoutInflater alertDialog = LayoutInflater.from(context);
            View view = alertDialog.inflate(R.layout.custom_pune, null);


            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
            alertDialogBuilder.setView(view);

            alertDialogBuilder.show();


        }

        private void openDelhi() {
            LayoutInflater alertDialog = LayoutInflater.from(context);
            View view = alertDialog.inflate(R.layout.custom_delhi, null);


            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
            alertDialogBuilder.setView(view);

            alertDialogBuilder.show();


        }

        private void openNagpur() {
            LayoutInflater alertDialog = LayoutInflater.from(context);
            View view = alertDialog.inflate(R.layout.custom_nagpur, null);


            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
            alertDialogBuilder.setView(view);

            alertDialogBuilder.show();


        }
    }
}



