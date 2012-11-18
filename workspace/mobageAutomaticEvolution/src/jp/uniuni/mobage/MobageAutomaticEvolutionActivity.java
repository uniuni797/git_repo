package jp.uniuni.mobage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class MobageAutomaticEvolutionActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        //タイトル画面をセットする。
        
        
        
        //ブラウザ用アクティビティを起動する。
        Intent intent = new Intent(getApplicationContext(),BrowserActivity.class);
        startActivity(intent);
    }
}