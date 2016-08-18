package com.losgatosmeat.restaurant.lgm;

import java.util.ArrayList;
import android.util.Pair;
import java.util.List;

/**
 * Created by gghai on 8/17/16.
 */
public class MenuItemGroups {
    public String groupName;
    public final List<ItemWithPrice> children = new ArrayList<ItemWithPrice>();

    public MenuItemGroups(String groupName) {
        this.groupName = groupName;
    }
}
