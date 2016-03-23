package Basic.test;

import com.robotium.solo.Solo;
import android.os.PowerManager;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;
import Basic.test.NetworkUtil;
import Basic.test.Util;

public class BasicTestCase extends ActivityInstrumentationTestCase2 {
	private Util util;
	private PowerManager.WakeLock wakeScreenObject = null;
	public static Solo solo;
	public Activity activity;
	private TextView view;
	private static Class launcherActivityClass;
	private static final String PackageName = "com.elianshang.yougong";
	private static final String MainActivity="com.elianshang.yougong.ui.activity.WelcomeActivity";
	static{
		try {
			launcherActivityClass = Class.forName(MainActivity);
		} 
		catch (ClassNotFoundException e){
			throw new RuntimeException(e);
		}
	}
	@SuppressWarnings({ "unchecked", "deprecation" })

	public BasicTestCase(){
		//super(PackageName,launcherActivityClass);
		super(launcherActivityClass);
	}

	// TODO Auto-generated constructor stub
	@Override
	protected void setUp() throws Exception {
		this.activity = this.getActivity();

		this.solo = new Solo(getInstrumentation(), getActivity());
		try{
			super.setUp();
			init();
		}catch(Throwable tr){
		solo.takeScreenshot(this.getClass().getSimpleName());
		//throw new Exception(tr);
		}
	}
	private void init(){
		solo = new Solo(getInstrumentation(), getActivity());
		//唤醒设备
		if(wakeScreenObject == null){
			wakeScreenObject = Util.wakeScreen(this);
		}
		//解锁
		Util.unlock(getInstrumentation());
		//连接网络
		NetworkUtil.setAirplaneModeOffAndNetworkOn(getInstrumentation().getTargetContext());
	}
	

	@Override
	//tearDown释放资源
	public void tearDown() throws Exception {
	try {
		solo.finishOpenedActivities();
		super.tearDown();
	} catch (Throwable th) {
		solo.takeScreenshot(this.getClass().getSimpleName());
		throw new Exception(th);
		}
	}
	
	
}




