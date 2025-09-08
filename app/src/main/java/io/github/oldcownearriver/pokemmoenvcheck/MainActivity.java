package io.github.oldcownearriver.pokemmoenvcheck;

import android.os.Build;
import android.os.Bundle;
import android.os.Debug;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    private Button refresh;
    private TextView build_product_value,build_product_is_contains_sdk_value,
            build_hardware_value,build_hardware_is_contains_goldfish_value,build_hardware_is_contains_ranchu_value
            ,build_tags_value,build_tags_is_contains_test_keys_value
            ,system_app_superuser_apk_is_exists_value,system_xbin_su_is_exists_value
            ,is_debugger_connected_value,waiting_for_debugger_value;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setValue();
        setButton();
    }

    private void initView(){
        refresh = findViewById(R.id.button_refresh);
        build_product_value = findViewById(R.id.build_product_value);
        build_product_is_contains_sdk_value = findViewById(R.id.build_product_is_contains_sdk_value);
        build_hardware_value = findViewById(R.id.build_hardware_value);
        build_hardware_is_contains_goldfish_value = findViewById(R.id.build_hardware_is_contains_goldfish_value);
        build_hardware_is_contains_ranchu_value = findViewById(R.id.build_hardware_is_contains_ranchu_value);
        build_tags_value = findViewById(R.id.build_tags_value);
        build_tags_is_contains_test_keys_value = findViewById(R.id.build_tags_is_contains_test_keys_value);
        system_app_superuser_apk_is_exists_value = findViewById(R.id.system_app_superuser_apk_is_exists_value);
        system_xbin_su_is_exists_value = findViewById(R.id.system_xbin_su_is_exists_value);
        is_debugger_connected_value = findViewById(R.id.is_debugger_connected_value);
        waiting_for_debugger_value = findViewById(R.id.waiting_for_debugger_value);
    }

    private void setButton(){
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setValue();
            }
        });
    }

    private void setValue(){
        build_product_value.setText(Build.PRODUCT);
        build_product_is_contains_sdk_value.setText(Build.PRODUCT.contains("sdk")?getString(R.string.yes):getString(R.string.no));

        build_hardware_value.setText(Build.HARDWARE);
        build_hardware_is_contains_goldfish_value.setText(Build.HARDWARE.contains("goldfish")?getString(R.string.yes):getString(R.string.no));
        build_hardware_is_contains_ranchu_value.setText(Build.HARDWARE.contains("ranchu")?getString(R.string.yes):getString(R.string.no));

        build_tags_value.setText(Build.TAGS);
        build_tags_is_contains_test_keys_value.setText(Build.TAGS.contains("test-keys")?getString(R.string.yes):getString(R.string.no));

        system_app_superuser_apk_is_exists_value.setText(new File("/system/app/Superuser.apk").exists()?getString(R.string.yes):getString(R.string.no));
        system_xbin_su_is_exists_value.setText(new File("/system/xbin/su").exists()?getString(R.string.yes):getString(R.string.no));

        is_debugger_connected_value.setText(Debug.isDebuggerConnected()?getString(R.string.yes):getString(R.string.no));
        waiting_for_debugger_value.setText(Debug.waitingForDebugger()?getString(R.string.yes):getString(R.string.no));
    }

}
