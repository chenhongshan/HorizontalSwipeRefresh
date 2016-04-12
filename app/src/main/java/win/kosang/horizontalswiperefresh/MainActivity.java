package win.kosang.horizontalswiperefresh;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import win.kosang.hsrlayout.HSRLayout;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
     HSRLayout swipLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swipLayout = (HSRLayout) findViewById(R.id.swipe_layout);
        swipLayout.setOnRefreshListener(new HSRLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // TODO Auto-generated method stub
                        swipLayout.setRefreshing(false);
                    }
                }, 6000);
            }
        });
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(new MyAdapter());
    }


    class MyAdapter extends RecyclerView.Adapter<MyHolder> {

        @Override
        public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new MyHolder(getLayoutInflater().inflate(R.layout.item, null));
        }

        @Override
        public void onBindViewHolder(MyHolder holder, int position) {
        }

        @Override
        public int getItemCount() {
            return 30;
        }
    }

    class MyHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public MyHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.text);
        }
    }
}
