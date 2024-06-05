package com.project1;

class LoadingBar {
    private int a;

    public void updateProgress(int a) {
        this.a = a;
        printLoadingBar();
    }

    private void printLoadingBar() {
        System.out.print("\r·ÎµùÁß: [");
        int numBars = a / 10;
        for (int i = 0; i < 10; i++) {
            if (i < numBars) {
                System.out.print("¡á");
            } else {
                System.out.print(" ");
            }
        }
        System.out.print("] " + a + "%");
    }
}

public class SogaeThread {
    public  void main(String[] args) {
        LoadingBar loadingBar = new LoadingBar();

        Thread loadingThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 100; i += 25) {
                    loadingBar.updateProgress(i);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        });

        loadingThread.start();

        try {
            loadingThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}