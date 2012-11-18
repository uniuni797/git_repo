package unispe.open.gl.renderer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.opengl.GLSurfaceView.Renderer;

public class OpenGLSample_1_3 implements Renderer {

	private int displayWidth;
	private int displayHeight;
	
	@Override
	public void onDrawFrame(GL10 gl) {
		// TODO Auto-generated method stub
		gl.glClearColor(0.0f, 1.0f, 1.0f, 1);
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		gl.glColor4f(1.0f, 0.0f, 0.0f, 1.0f);
		this.drawQuad(gl, 50, 50, 128, 128);
		
		this.drawQuad(gl, 100, 200, 300, 400);
		
		gl.glColor4f(0.0f, 0.0f, 1.0f, 1.0f);
		this.drawQuad(gl, displayWidth/2, displayHeight/2, 256, 128);
	}
	
	private void drawQuad(GL10 gl , int x , int y , int w , int h){
		//３角形２つ
//		float position[] = {
//				0.0f,1.0f,0.0f,		//左上
//				0.0f,0.0f,0.0f,		//左下
//				1.0f,1.0f,0.0f,		//右上
//				
//				0.0f,0.0f,0.0f,
//				1.0f,1.0f,0.0f,
//				1.0f,0.0f,0.0f
//		};
		
//		//TRIANGLE_STRIPなので２つめの三角は１つめの頂点を利用する
//		float position[] = {
//		0.0f,1.0f,0.0f,		//左上
//		0.0f,0.0f,0.0f,		//左下
//		1.0f,1.0f,0.0f,		//右上
//		1.0f,0.0f,0.0f
//};
		//正規化座標系の座標 = (ウィンドウ座標/ディスプレイピクセル数) * 2.0 - 1.0
		float left = ((float)x / (float) displayWidth) * 2.0f - 1.0f;
		float top = ((float)y / (float) displayHeight) * 2.0f - 1.0f;
		float right = left + ((float)x / (float) displayWidth) * 2.0f;
		float bottom = top + ((float)y / (float) displayHeight) * 2.0f;
		
		//上下を反転させる
		top = -top;
		bottom = -bottom;
		
		float position[] = {
			left , top , 0.0f,
			left , bottom , 0.0f,
			right , top , 0.0f ,
			right , bottom , 0.0f

		};
		
		//CPUごとのネイティブエンディアンで数値を伝える必要がある
		//そのためJavaヒープを直接的には扱えず、Java.nioは以下のクラスへ一度値を格納剃る必要がある
		//Floatは4byteであるため、配列数に4Byteをかける
		ByteBuffer bb = ByteBuffer.allocateDirect(position.length*4);
		//CPU依存のバイトオーダーを設定
		bb.order(ByteOrder.nativeOrder());
		
		FloatBuffer fb = bb.asFloatBuffer();
		//書きこむ毎にOffsetが進むので、putが終わったら初期位置に戻す
		fb.put(position);
		fb.position(0);
		
		//頂点の位置を格納する
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
		//VertexPointerは頂点の位置情報の関連付けでのみ使用する
		gl.glVertexPointer(3,GL10.GL_FLOAT,0,fb);
		
		gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0,4);
		
	}

	@Override
	public void onSurfaceChanged(GL10 gl, int width, int height) {
		// TODO Auto-generated method stub
		gl.glViewport(0, 0, width, height);
		displayWidth = width;
		displayHeight = height;
	}

	@Override
	public void onSurfaceCreated(GL10 gl, EGLConfig config) {
		// TODO Auto-generated method stub
		
	}

	
	
}
