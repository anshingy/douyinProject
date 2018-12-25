package appLogtools.statictable;

/**
 * 目测时作为操作的元数据，目前还没有看到应用的位置
 */
public enum b {
    PAGE_START(0),
    PAGE_END(1),
    EVENT(2),
    IMAGE_SAMPLE(3),
    CONFIG_UPDATE(4),
    API_SAMPLE(5),
    UA_UPDATE(6),
    SAVE_ANR_TAG(7),
    SAVE_DNS_REPORT(8),
    SAVE_MISC_LOG(9),
    DEVICE_ID_UPDATE(10),
    CUSTOMER_HEADER_UPDATE(11),
    UPDATE_GOOGLE_AID(12),
    UPDATE_APP_LANGUAGE_REGION(13);

    //public static ChangeQuickRedirect changeQuickRedirect;
    final int a;

    private b(int i) {
        this.a = i;
    }
}
