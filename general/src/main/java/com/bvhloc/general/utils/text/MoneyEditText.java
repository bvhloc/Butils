package com.bvhloc.general.utils.text;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

/**
 * Created by Leon on 11/18/2016.
 */

public class MoneyEditText {

    public static void addMoneyWatcher(final EditText editText) {

        editText.addTextChangedListener(
                new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                        if (s.toString().length() == 0) {
                            return;
                        }

//                        editText.removeTextChangedListener(this);
//
//                        String cleanString = s.toString().replaceAll("[$,.]", "");
//
//                        double parsed = Double.parseDouble(cleanString);
                        //  String formatted = NumberFormat.getCurrencyInstance().format((parsed/100));
//                        String formatted = NumberFormat.getCurrencyInstance(Locale.US).format((parsed));
//
//                        //format to VNĐ
//                        String locale = Locale.getDefault().toString();
//                        String vndFormat;
//                        if (locale.equals(Constant.LOCALE_VIETNAMESE)) {
//                            vndFormat = formatted.replace("đ", "");
//                        } else {
//                            vndFormat = formatted.replace("$", "");
//                        }
//
//                        vndFormat = vndFormat.substring(0, vndFormat.indexOf("."));


                        editText.removeTextChangedListener(this);

                        String cleanString = s.toString().replaceAll("[$,.]", "");

                        if(!cleanString.equals("")){
                            long parsed = Long.parseLong(cleanString);

                            String formatted = MoneyFormatter.formatCurrency(parsed);

                            editText.setText(formatted);
                            editText.setSelection(formatted.length());
                        }else {
                            editText.setText("");
                        }

                        editText.addTextChangedListener(this);
                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                }

        );
    }
}
