package unispe.open.gl;

import unispe.open.gl.renderer.OpenGLSample_1_3;
import unispe.open.gl.renderer.RendererSample1;
import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;

public class Main extends Activity {
    /** Called when the activity is first created. */
	
	private GLSurfaceView glSurfaceView = null;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        glSurfaceView = new GLSurfaceView(this);
        
        //glSurfaceView.setRenderer(new RendererSample1());
        glSurfaceView.setRenderer(new OpenGLSample_1_3());
        setContentView(glSurfaceView);
    }
    
    @Override
    protected void onPause(){
    	super.onPause();
    	glSurfaceView.onPause();
    }
    
    @Override
    protected void onResume(){
    	super.onResume();
    	glSurfaceView.onResume();
    }
}