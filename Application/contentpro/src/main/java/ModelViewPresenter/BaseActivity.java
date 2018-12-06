package ModelViewPresenter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity<V,T extends Basepresenter<V> > extends AppCompatActivity {

    protected T presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter=createpresenter();
        presenter.attachView((V) this);
    }

    protected abstract T createpresenter();

    @Override
    protected void onDestroy() {
        presenter.detach();
        super.onDestroy();
    }
}
