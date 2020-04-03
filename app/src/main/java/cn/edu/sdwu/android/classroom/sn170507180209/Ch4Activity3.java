package cn.edu.sdwu.android.classroom.sn170507180209;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class Ch4Activity3 extends AppCompatActivity {

    private ArrayList list;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_ch4_3);

        list = new ArrayList();

        textView =(TextView) findViewById(R.id.ch4_3_tv);

        //通过容器找到它所包含的所有子元素，再来注册监听器
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ch4_3_ll);
        int count = linearLayout.getChildCount();
        for (int i = 0; i < count; i++) {
            View view = linearLayout.getChildAt(i);
            if(view instanceof CheckBox){
                CheckBox checkBox = (CheckBox)view;
                checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        //参数b代表是否打勾
                        if (b){
                            list.add(compoundButton);
                        }else{
                            list.remove(compoundButton);
                        }
                        String content = "you select：";
                        for (int i=0;i<list.size();i++){
                            CheckBox checkBox1 = (CheckBox) list.get(i);
                            String text = checkBox1.getText().toString();
                            if((i+1)==list.size()){
                                content+=text;
                            }else{
                                content+=text+"，";
                            }
                        }
                        if (list.size()==0){
                            textView.setText("");
                        }else {
                            textView.setText(content);
                        }
                    }
                });
            }
        }
    }
}
