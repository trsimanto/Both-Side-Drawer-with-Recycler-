package com.towhid.manurecycler;

public class MenuItems {
    String item;
    int icon;

    public MenuItems(String item, int icon) {
        this.item = item;
        this.icon = icon;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
