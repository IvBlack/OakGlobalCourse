package com.IVdev.advanced.SOLID.DIP;

public class Framework {
    public void save(IForm frm) {
        ISQL db = new MySQL();
        db.save(frm);
    }
}
