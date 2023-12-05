package com.education.ztu;

class  MyRunnable4 implements Runnable {
    private static int result = 0;

    private void updateResult() {
        synchronized (this) {
            System.out.print(result + " ");
            result++;
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            updateResult();
        }
    }
}
