package nav.categories;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.letngo.R;

import java.util.ArrayList;

import nav.categories.recycleview.MyAdapter;
import nav.categories.recycleview.MyAdapter2;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragementCategories2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragementCategories2 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ArrayList<CatLabel> catLabelArrayList;
    private int[] imageResourceId;
    private String[] catHeading;
    private RecyclerView recyclerView;

    public FragementCategories2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragementCategories2.
     */
    // TODO: Rename and change types and number of parameters
    public static FragementCategories2 newInstance(String param1, String param2) {
        FragementCategories2 fragment = new FragementCategories2();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragement_categories2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        dataInitialize();
        
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        MyAdapter2 myAdapter2 = new MyAdapter2(getContext(),catLabelArrayList);
        recyclerView.setAdapter(myAdapter2);
        myAdapter2.notifyDataSetChanged();

    }

    private void dataInitialize() {

        catLabelArrayList = new ArrayList<>();
        catHeading = new String[]{
                "Beach",
                "Treehouse",
                "Camping",
                "Beach",
                "Treehouse",
                "Camping",
                "Beach",
                "Treehouse",
                "Camping"
        };

        imageResourceId = new int[]{

        };

        for(int i=0;i<catHeading.length;i++){

            CatLabel catlabel = new CatLabel(catHeading[i],imageResourceId[i]);
            catLabelArrayList.add(catlabel);

        }
        
    }
}