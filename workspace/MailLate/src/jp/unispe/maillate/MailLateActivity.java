package jp.unispe.maillate;

import android.app.Activity;
import android.os.Bundle;

public class MailLateActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        //一度もアプリを起動したことがない場合は、設定を行う通知をユーザにする。
        
        
    }
}