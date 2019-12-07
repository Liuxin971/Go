package com.sx.ybj.pojo;

/**
 * @program: ybj
 * @description: 共享状态
 * @author: lwx
 * @create: 2019-06-17 13:28
 */
public class ShareData {
    Notebook notebook;
    int state;

    public Notebook getNotebook() {
        return notebook;
    }

    public void setNotebook(Notebook notebook) {
        this.notebook = notebook;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}