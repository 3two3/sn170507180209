package cn.edu.sdwu.android.classroom.sn170507180209;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;

public class Ch6Activity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_ch6_1);
        //在java中获取字符串资源
        String content = getString(R.string.hello);
        Log.i(Ch6Activity1.this.toString(), content);


        String sms = getString(R.string.sms);
        String s = String.format(sms, 100, "张三");
        Log.i(Ch6Activity1.this.toString(), s);

        Resources resources = getResources();

        int[] intArray = resources.getIntArray(R.array.intArr);
        for (int i = 0; i < intArray.length; i++) {
            Log.i(Ch6Activity1.this.toString(), intArray[i] + "");
        }

        String[] stringArray = resources.getStringArray(R.array.strArr);
        for (int i = 0; i < stringArray.length; i++) {
            Log.i(Ch6Activity1.this.toString(), stringArray[i]);
        }

        TypedArray typedArray = resources.obtainTypedArray(R.array.commanArr);
        ImageView imageView = (ImageView) findViewById(R.id.ch6_1_iv);
        int resourceId = typedArray.getResourceId(0, 0);
        imageView.setImageResource(resourceId);

        String str = typedArray.getString(1);
        Log.i(Ch6Activity1.this.toString(), str);

        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ch6_1_ll);
        registerForContextMenu(linearLayout);

        XmlPullParser xmlPullParser = resources.getXml(R.xml.words);
        try {
            while (xmlPullParser.getEventType() != XmlPullParser.END_DOCUMENT) {
                if (xmlPullParser.getEventType() == XmlPullParser.START_TAG) {
                    String word = xmlPullParser.getAttributeValue(0);
                    Log.e(Ch6Activity1.this.toString(),word);
                }
            }

        } catch (Exception e) {
            Log.e(Ch6Activity1.this.toString(),e.toString());
        }

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.mymenu1, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mymenu_item1:
                Toast.makeText(this, "item1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mymenu_item2:
                Toast.makeText(this, "item2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mymenu_item3:
                Toast.makeText(this, "item3", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //基于回调的事件处理
        //根据菜单项的ID进行区分
        switch (item.getItemId()) {
            case R.id.mymenu_item1:
                Toast.makeText(this, "item1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mymenu_item2:
                Toast.makeText(this, "item2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mymenu_item3:
                Toast.makeText(this, "item3", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.mymenu1, menu);
        return true;
    }
}
