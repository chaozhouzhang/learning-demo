package android.stack.aidl;

import android.os.RemoteException;

/**
 * Created on 2020/4/10 14:13
 *
 * @author zhangchaozhou
 * @email 13760289294@139.com
 * @wechat 13760289294
 */
public class RemoteServiceImpl extends IRemoteService.Stub {
    @Override
    public int getValue() throws RemoteException {
        return 100;
    }

    @Override
    public User getUser(String username) throws RemoteException {
        User user = new User();
        user.setAge(18);
        user.setGender(0);
        user.setNickname("昵称");
        return user;
    }
}
