package cn.myflv.noactive.core.hook.idle;

import java.util.List;

import cn.myflv.noactive.constant.ClassConstants;
import cn.myflv.noactive.constant.MethodConstants;
import cn.myflv.noactive.core.entity.MemData;
import cn.myflv.noactive.core.hook.base.AbstractReplaceHook;
import cn.myflv.noactive.core.hook.base.MethodHook;
import cn.myflv.noactive.core.utils.Log;
import de.robv.android.xposed.XC_MethodHook;

public class IdleWhiteListAddHook extends MethodHook {


    public IdleWhiteListAddHook(ClassLoader classLoader) {
        super(classLoader);
    }

    @Override
    public String getTargetClass() {
        return ClassConstants.DeviceIdleControllerBinderService;
    }

    @Override
    public String getTargetMethod() {
        return MethodConstants.addPowerSaveWhitelistApps;
    }

    @Override
    public Object[] getTargetParam() {
        return new Object[]{List.class};
    }

    @Override
    public XC_MethodHook getTargetHook() {
        return new AbstractReplaceHook() {
            @Override
            protected Object replaceMethod(MethodHookParam param) throws Throwable {
                Log.i("avoid add idle white list");
                return 0;
            }
        };
    }

    @Override
    public int getMinVersion() {
        return ANY_VERSION;
    }

    @Override
    public String successLog() {
        return "Listen idle add";
    }
}
