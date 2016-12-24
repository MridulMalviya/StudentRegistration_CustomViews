package malviya.com.studentregistration_customviews.utils;

import android.content.Context;
import android.content.Intent;

/**
 * Created by Prafulla on 12/24/2016.
 */

public class NavigateClass {
    public static void navigateTo(Context pContext, Class pNavigateClass) {
        Intent intent = new Intent(pContext, pNavigateClass);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        pContext.startActivity(intent);
    }
}
