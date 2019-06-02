package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Controller {
    @FXML
    public ImageView imageView1;
    @FXML
    public ImageView imageView2;
    @FXML
    public ImageView imageView3;
    @FXML
    private Button start;
    @FXML
    private Label textLabel;
    @FXML
    private Button stop1;
    @FXML
    private Button stop2;
    @FXML
    private Button stop3;

    private Image[] images;
    private Thread iw1thread;
    private Thread iw2thread;
    private Thread iw3thread;
    private BanditRunnable iw1run;
    private BanditRunnable iw2run;
    private BanditRunnable iw3run;
    private int spinsAlive;

    public void initialize() {
        loadImages();
    }

    private void loadImages() {
        images = new Image[10];
        for (int i = 0; i < 10; i++) {
            String filename = "fruitspics\\fruits" + i + ".png";
            images[i] = new Image(new File(filename).toURI().toString());
        }

        imageView1.setImage(images[0]);
        imageView2.setImage(images[5]);
        imageView3.setImage(images[9]);

    }

    public void startEventHandler() {
        iw1run = new BanditRunnable(0, 100, imageView1);
        iw1thread = new Thread(iw1run);
        iw1thread.setDaemon(true);
        iw1thread.start();


        iw2run = new BanditRunnable(5, 120, imageView2);
        iw2thread = new Thread(iw2run);
        iw2thread.setDaemon(true);
        iw2thread.start();

        iw3run = new BanditRunnable(9, 140, imageView3);
        iw3thread = new Thread(iw3run);
        iw3thread.setDaemon(true);
        iw3thread.start();


        textLabel.setText("Running");
        stop1.setDisable(false);
        stop2.setDisable(false);
        stop3.setDisable(false);
        start.setDisable(true);



    }


    public void stop1EventHandler() {
        iw1thread.interrupt();
        stop1.setDisable(true);

    }

    public void stop2EventHandler() {
       iw2thread.interrupt();
        stop2.setDisable(true);
    }

    public void stop3EventHandler() {
        iw3thread.interrupt();
        stop3.setDisable(true);
    }

    private synchronized void aliveCount(boolean up) {
        if(up)
            spinsAlive++;
        else
            spinsAlive--;

        if(spinsAlive == 0) {
            start.setDisable(false);
            Platform.runLater(new Runnable() {
                                  @Override
                                  public void run() {
                                      if (imageView1.getImage() == imageView2.getImage() && imageView1.getImage() == imageView3.getImage()) {
                                          textLabel.setText("All 3 equals, you won the game!");}
                                      else if (imageView1.getImage() == imageView2.getImage()
                                              || imageView1.getImage() == imageView3.getImage()
                                              || imageView2.getImage() == imageView3.getImage()) {
                                          textLabel.setText("2 equals, close but not good enough"); }
                                      else {
                                          textLabel.setText("You loose");
                                      }
                                  }
                              }
            );}
    }


    public class BanditRunnable implements Runnable {
        private int i;
        private long sleepTime;
        private boolean running;
        private ImageView iw;
        private Lock newImageLock;




        public BanditRunnable(int i, long sleepTime, ImageView iw) {
            this.i = i;
            this.sleepTime = sleepTime;
            this.iw = iw;
            newImageLock = new ReentrantLock();
        }


        @Override
        public void run() {
            running = true;
            aliveCount(true);
            while (running) {
                newImageLock.lock();
               Random random = new Random();
                iw.setImage(images[random.nextInt(10)]);
                synchronized (this) {
                    try {
                        wait(sleepTime);
                    } catch (InterruptedException e) {
                        running = false;
                        aliveCount(false);
                    } finally {
                        newImageLock.unlock();
                    }
                }
            }
        }
            }
        }



