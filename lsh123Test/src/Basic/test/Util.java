package Basic.test;


import android.app.Instrumentation;
import android.app.KeyguardManager;
import android.app.KeyguardManager.KeyguardLock;
import android.content.Context;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.test.InstrumentationTestCase;
import android.util.Log;

public class Util {

	/**
	 * wake up screen if needed
	 * 
	 * @param owner
	 * @return return wakeLock object,it will release after class done
	 */
	public static WakeLock wakeScreen(InstrumentationTestCase owner) {
		PowerManager pm = (PowerManager) owner.getInstrumentation()
				.getTargetContext().getSystemService(Context.POWER_SERVICE);
		WakeLock wakeLock = pm.newWakeLock(PowerManager.SCREEN_BRIGHT_WAKE_LOCK
				| PowerManager.FULL_WAKE_LOCK
				| PowerManager.ACQUIRE_CAUSES_WAKEUP, owner.getClass()
				.getSimpleName());
		wakeLock.acquire();
		return wakeLock;
	}

	public static void unlock(Instrumentation instr) {
		try {
			Context targetContext = instr.getTargetContext();
			KeyguardManager keyGuardManager = (KeyguardManager) targetContext
					.getSystemService(Context.KEYGUARD_SERVICE);
			KeyguardLock mLock = keyGuardManager.newKeyguardLock("");
			mLock.disableKeyguard();
		} catch (Throwable e) {
			Log.e("", "disableKeyguard:", e);
		}
	}

}