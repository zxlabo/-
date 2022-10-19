package com.算法题;

import android.util.ArrayMap;
import android.util.Log;
import android.util.SparseArray;

import java.util.HashMap;

public class _0_算法必会 {
    private final String TAG = "";

    private void sparseArrayStudy() {

        //  1-100  1-10 tong1 11-20
        HashMap<Object, Object> map = new HashMap<>();
        map.put(null, null);
        //声明
        SparseArray<String> sparseArray = new SparseArray<>();
        //增加元素，append方式
        sparseArray.append(0, "myValue");
        //增加元素，put方式
        sparseArray.put(1, "myValue");

        //int数组 0 1 23
        //value 0 1 23
        // 0 12
        // 8  0111
        //1\ key    hash&（2de n）
        //    & 111

        //删除元素，二者等同
        sparseArray.remove(1);
        sparseArray.delete(1);
        //修改元素，put或者append相同的key值即可
        sparseArray.put(1, "newValue");
        sparseArray.append(1, "newValue");
        //查找，遍历方式1
        for (int i = 0; i < sparseArray.size(); i++) {
            Log.d(TAG, sparseArray.valueAt(i));
        }
        //查找，遍历方式2
        for (int i = 0; i < sparseArray.size(); i++) {
            int key = sparseArray.keyAt(i);
            Log.d(TAG, sparseArray.get(key));
        }
    }

    private void arrayMapStudy() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
            ArrayMap<String, String> map = new ArrayMap<>();
            //增加
            map.put("xixi", "haha");
            //删除
            map.remove("xixi");
            //修改，put相同的key值即可
            map.put("xixi2", "haha");
            map.put("xixi2", "haha2");
            //查找，通过key来遍历
            for (String key : map.keySet()) {
                Log.d(TAG, map.get(key));
            }
        }
    }

}
