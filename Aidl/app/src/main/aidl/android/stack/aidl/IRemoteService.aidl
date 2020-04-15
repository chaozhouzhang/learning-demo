// IRemoteService.aidl
package android.stack.aidl;
parcelable User;
// Declare any non-default types here with import statements

interface IRemoteService {
    int getValue();
    User getUser(in String username);
}
