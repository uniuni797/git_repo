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
        
        //�^�C�g����ʂ��Z�b�g����B
        
        
        
        //�u���E�U�p�A�N�e�B�r�e�B���N������B
        Intent intent = new Intent(getApplicationContext(),BrowserActivity.class);
        startActivity(intent);
    }
}