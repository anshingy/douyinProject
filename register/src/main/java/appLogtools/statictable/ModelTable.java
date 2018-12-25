package appLogtools.statictable;

import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/**
 * @program: hehedada
 * @description: 用到的静态数据管理类（就是方便修改罢了）
 * @author: Mr.gao
 * @create: 2018-10-24 21:05
 **/
public class ModelTable {
    //时间戳的英文表示待定
    public static final String[] hehe = new String[]{"id", "name", "duration", "session_id"};
    static final String[] d = new String[]{"id", "value", "is_crash", "timestamp", "retry_count", "retry_time", "log_type"};
    static final String[] e = new String[]{"id", "value", "timestamp", "duration", "non_page", "app_version", "version_code", "pausetime", "launch_sent"};
    static final String[] f = new String[]{"id", "category", "tag", "label", "value", "ext_value", "ext_json", "user_id", "timestamp", "session_id"};
    static final String[] g = new String[]{"id", "log_type", "value", "session_id"};
    static final String[] h = new String[]{"id", "log_type", "value"};
    static final SimpleDateFormat T = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
    //目前不知道做什么
    //static final String[] b = new String[]{"appkey", "udid", "openudid", "sdk_version", "package", "channel", x.g, "app_version", "version_code", x.E, x.I, "os", x.q, "os_api", x.v, x.x, x.z, "language", x.r, "display_density", "density_dpi", x.s, "carrier", "mcc_mnc", "clientudid", "install_id", "device_id", "sig_hash", "aid", "push_sdk", "rom", "aliyun_uuid", "release_build", "update_version_code", "manifest_version_code", "cpu_abi", "build_serial", "app_track", "serial_number", "sim_serial_number", "not_request_sender", "rom_version", "region", "tz_name", "tz_offset", "sim_region", "UMessage.DISPLAY_TYPE_CUSTOM", "google_aid", "app_language", "app_region"};
    private static Set<String> b = new HashSet();
    private static Set<String> c = new HashSet();
    static {
        b.add("ThreadPlus");
        b.add("ApiDispatcher");
        b.add("ApiLocalDispatcher");
        b.add("AsyncLoader");
        b.add("AsyncTask");
        b.add("Binder");
        b.add("PackageProcessor");
        b.add("SettingsObserver");
        b.add("WifiManager");
        b.add("JavaBridge");
        b.add("Compiler");
        b.add("Signal Catcher");
        b.add("GC");
        b.add("ReferenceQueueDaemon");
        b.add("FinalizerDaemon");
        b.add("FinalizerWatchdogDaemon");
        b.add("CookieSyncManager");
        b.add("RefQueueWorker");
        b.add("CleanupReference");
        b.add("VideoManager");
        b.add("DBHelper-AsyncOp");
        b.add("InstalledAppTracker2");
        b.add("AppData-AsyncOp");
        b.add("IdleConnectionMonitor");
        b.add("LogReaper");
        b.add("ActionReaper");
        b.add("Okio Watchdog");
        b.add("CheckWaitingQueue");
        c.add("com.facebook.imagepipeline.core.PriorityThreadFactory");
        c.add("com.ss.android.common.util.SimpleThreadFactory");
    }
}
