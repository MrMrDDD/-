package ModelViewPresenter;

import java.lang.ref.WeakReference;

/**
 * P层是持有View 与  MODE
 * MODE由子类实现
 * @param <T>绑定的VIEW
 */
public class Basepresenter<T> {
    protected WeakReference<T> mViewRef;

    public void attachView(T view) {
        mViewRef = new WeakReference<>(view);
    }

    public void detach() {
        if (mViewRef != null) {
            mViewRef.clear();
            mViewRef = null;
        }
    }
}
