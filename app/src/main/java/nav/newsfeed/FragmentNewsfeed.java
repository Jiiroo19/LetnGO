package nav.newsfeed;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.example.letngo.R;


public class FragmentNewsfeed extends Fragment {


    public FragmentNewsfeed() {
        // Required empty public constructor
    }


    public static FragmentNewsfeed newInstance(String param1, String param2) {
        FragmentNewsfeed fragment = new FragmentNewsfeed();

        return fragment;


    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.newsfeed_newsfeed, container, false);

       ImageView imageView = (ImageView) view.findViewById(R.id.imageMessage);

        Button createpost = (Button) view.findViewById(R.id.createpost);
        createpost.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), Create_post.class);
                startActivity(in);
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show_Message();

            }
        });



        return view;
    }

    private void show_Message() {
        startActivity(new Intent((getActivity()), messages.class));

    }


}
