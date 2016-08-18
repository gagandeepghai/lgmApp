package com.losgatosmeat.restaurant.lgm;

import android.app.Activity;
import android.view.View;

public class UIUtils {
    public static <T extends View> T findView(View root, int id)      {
        return (T) root.findViewById(id); }

    public static <T extends View> T findView(Activity activity, int id)      {
        return (T) activity.getWindow().getDecorView().getRootView().findViewById(id); }

    //        Button button = UIUtils.findView(this, R.id.convert);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                RadioGroup grp = (RadioGroup) findViewById(R.id.options);
//                TextView text = (TextView) findViewById(R.id.main_input);
//                System.out.println("grp.getCheckedRadioButtonId(): " +grp.getCheckedRadioButtonId());
//                if(grp.getCheckedRadioButtonId() == R.id.Fahrenheit) {
//                    try{
//                        Double value = Double.parseDouble(text.getText().toString());
//                        value = (value * 1.8) + 32;
//                        text.setText(value.toString());
//                        System.out.println("value: " +value);
//                    } catch (Exception ex) {
//                        System.out.println("Invalid Number: " +text.getText());
//                    }
//                } else {
//                    try{
//                        Double value = Double.parseDouble(text.getText().toString());
//                        value = (value - 32) / 1.8;
//                        text.setText(value.toString());
//                        System.out.println("value: " +value);
//                    } catch (Exception ex) {
//                        System.out.println("Invalid Number: " +text.getText());
//                    }
//                }
//            }
//        });

//        RadioGroup grp = (RadioGroup) findViewById(R.id.orientation);
//        grp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup grp, int checkedId) {
//                switch (checkedId){
//                    case R.id.Fahrenheit:
//                        grp.setOrientation(LinearLayout.HORIZONTAL);
//                        break;
//                    case R.id.Celcius:
//                        grp.setOrientation(LinearLayout.VERTICAL);
//                        break;
//                }
//            }
//        });
}
