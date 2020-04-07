package cn.edu.sdwu.android.classroom.sn170507180209;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.makeText;

public class Ch5Activity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_ch5_1);
    }

    public void toast1(View view){
        makeText(this,"toast1",Toast.LENGTH_LONG).show();
    }

    public void toast2(View view){
        Toast toast = Toast.makeText(this,"toast2",Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();
    }

    public void toast3(View view){
        //加载自定义布局文件，将其转换为一个View类的实例
        LayoutInflater layoutInflater = getLayoutInflater();
        View view1 = layoutInflater.inflate(R.layout.layout_toast,null);

        //设置文本
        TextView textView = (TextView)view1.findViewById(R.id.toast_tv);
        textView.setText("toast3");
        Toast toast = new Toast(this);
        toast.setView(view1);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();
    }

    public void notification(View view){
        Notification.Builder builder = new Notification.Builder(this);
        //在构造器中，完成各种通知的属性的设置
        builder.setContentTitle("title");
        builder.setContentText("message");
        builder.setWhen(System.currentTimeMillis());
        builder.setSmallIcon(android.R.drawable.ic_input_delete);//引用系统资源
        //调用build方法，完成构造
        Notification notification = builder.build();
        //使用NotificationManager,发送通知
        NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(101,notification);
    }

    public void cancel_notification(View view){
        //使用NotificationManager,取消通知
        NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        notificationManager.cancel(101);
    }

    public void alert_dialog(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("title");
        builder.setMessage("message");
        builder.setIcon(android.R.drawable.ic_dialog_alert);
        builder.setPositiveButton("confirm", new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(Ch5Activity1.this,"confirm",Toast.LENGTH_LONG).show();
            }
        });
        builder.setNegativeButton("exit",new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(Ch5Activity1.this,"exit",Toast.LENGTH_LONG).show();
            }
        });
        builder.setNeutralButton("cancel",new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(Ch5Activity1.this,"cancel",Toast.LENGTH_LONG).show();
            }
        });
        builder.create().show();
    }
}
