package game.event;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean isUpKeyPressed = false;
    public boolean isDownKeyPressed = false;

    public boolean isLeftKeyPressed = false;

    public boolean isRightKeyPressed = false;

    public boolean isSpacePressed = false;

    /**
     * characterPressed[] : size 26 : each index represents characters 0 - A and 25 - Z
     */
    public  boolean characterPressed[] = new boolean[36];

    /**
     * characterPressed[] : size 26 : each index represents characters 0 - A and 25 - Z
     */
    public boolean numPresses[] = new boolean[10];


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

//        System.out.println("Time : "+System.currentTimeMillis());

        if(key == KeyEvent.VK_UP){
            isUpKeyPressed = true;
        }
        if(key == KeyEvent.VK_DOWN){
            isDownKeyPressed = true;
        }
        if(key == KeyEvent.VK_LEFT){
            isLeftKeyPressed = true;
        }
        if(key == KeyEvent.VK_RIGHT){
            isRightKeyPressed = true;
        }
        if(key == KeyEvent.VK_SPACE){
            isSpacePressed = true;
        }


        if(key == KeyEvent.VK_A){
            characterPressed[0] = true;
        }
        if(key == KeyEvent.VK_B){
            characterPressed[1] = true;
        }
        if(key == KeyEvent.VK_C){
            characterPressed[2] = true;
        }
        if(key == KeyEvent.VK_D){
            characterPressed[3] = true;
        }
        if(key == KeyEvent.VK_E){
            characterPressed[4] = true;
        }
        if(key == KeyEvent.VK_F){
            characterPressed[5] = true;
        }
        if(key == KeyEvent.VK_G){
            characterPressed[6] = true;
        }
        if(key == KeyEvent.VK_H){
            characterPressed[7] = true;
        }
        if(key == KeyEvent.VK_I){
            characterPressed[8] = true;
        }
        if(key == KeyEvent.VK_J){
            characterPressed[9] = true;
        }
        if(key == KeyEvent.VK_K){
            characterPressed[10] = true;
        }
        if(key == KeyEvent.VK_L){
            characterPressed[11] = true;
        }
        if(key == KeyEvent.VK_M){
            characterPressed[12] = true;
        }
        if(key == KeyEvent.VK_N){
            characterPressed[13] = true;
        }
        if(key == KeyEvent.VK_O){
            characterPressed[14] = true;
        }
        if(key == KeyEvent.VK_P){
            characterPressed[15] = true;
        }
        if(key == KeyEvent.VK_Q){
            characterPressed[16] = true;
        }
        if(key == KeyEvent.VK_R){
            characterPressed[17] = true;
        }
        if(key == KeyEvent.VK_S){
            characterPressed[18] = true;
        }
        if(key == KeyEvent.VK_T){
            characterPressed[19] = true;
        }
        if(key == KeyEvent.VK_U){
            characterPressed[20] = true;
        }
        if(key == KeyEvent.VK_V){
            characterPressed[21] = true;
        }
        if(key == KeyEvent.VK_W){
            characterPressed[22] = true;
        }
        if(key == KeyEvent.VK_X){
            characterPressed[23] = true;
        }
        if(key == KeyEvent.VK_Y){
            characterPressed[24] = true;
        }
        if(key == KeyEvent.VK_Z){
            characterPressed[25] = true;
        }

        /**
         * For number input
         */
        if(key == KeyEvent.VK_0){
            characterPressed[26] = true;
        }
        if(key == KeyEvent.VK_1){
            characterPressed[27] = true;
        }
        if(key == KeyEvent.VK_2){
            characterPressed[28] = true;
        }
        if(key == KeyEvent.VK_3){
            characterPressed[29] = true;
        }
        if(key == KeyEvent.VK_4){
            characterPressed[30] = true;
        }
        if(key == KeyEvent.VK_5){
            characterPressed[31] = true;
        }
        if(key == KeyEvent.VK_6){
            characterPressed[32] = true;
        }
        if(key == KeyEvent.VK_7){
            characterPressed[33] = true;
        }
        if(key == KeyEvent.VK_8){
            characterPressed[34] = true;
        }
        if(key == KeyEvent.VK_9){
            characterPressed[35] = true;
        }


    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

//        System.out.println("Time Released: "+System.currentTimeMillis());

        if(key == KeyEvent.VK_UP){
            isUpKeyPressed = false;
        }
        if(key == KeyEvent.VK_DOWN){
            isDownKeyPressed = false;
        }
        if(key == KeyEvent.VK_LEFT){
            isLeftKeyPressed = false;
        }
        if(key == KeyEvent.VK_RIGHT){
            isRightKeyPressed = false;
        }
        if(key == KeyEvent.VK_SPACE){
            isSpacePressed = false;
        }



        if(key == KeyEvent.VK_A){
            characterPressed[0] = false;
        }
        if(key == KeyEvent.VK_B){
            characterPressed[1] = false;
        }
        if(key == KeyEvent.VK_C){
            characterPressed[2] = false;
        }
        if(key == KeyEvent.VK_D){
            characterPressed[3] = false;
        }
        if(key == KeyEvent.VK_E){
            characterPressed[4] = false;
        }
        if(key == KeyEvent.VK_F){
            characterPressed[5] = false;
        }
        if(key == KeyEvent.VK_G){
            characterPressed[6] = false;
        }
        if(key == KeyEvent.VK_H){
            characterPressed[7] = false;
        }
        if(key == KeyEvent.VK_I){
            characterPressed[8] = false;
        }
        if(key == KeyEvent.VK_J){
            characterPressed[9] = false;
        }
        if(key == KeyEvent.VK_K){
            characterPressed[10] = false;
        }
        if(key == KeyEvent.VK_L){
            characterPressed[11] = false;
        }
        if(key == KeyEvent.VK_M){
            characterPressed[12] = false;
        }
        if(key == KeyEvent.VK_N){
            characterPressed[13] = false;
        }
        if(key == KeyEvent.VK_O){
            characterPressed[14] = false;
        }
        if(key == KeyEvent.VK_P){
            characterPressed[15] = false;
        }
        if(key == KeyEvent.VK_Q){
            characterPressed[16] = false;
        }
        if(key == KeyEvent.VK_R){
            characterPressed[17] = false;
        }
        if(key == KeyEvent.VK_S){
            characterPressed[18] = false;
        }
        if(key == KeyEvent.VK_T){
            characterPressed[19] = false;
        }
        if(key == KeyEvent.VK_U){
            characterPressed[20] = false;
        }
        if(key == KeyEvent.VK_V){
            characterPressed[21] = false;
        }
        if(key == KeyEvent.VK_W){
            characterPressed[22] = false;
        }
        if(key == KeyEvent.VK_X){
            characterPressed[23] = false;
        }
        if(key == KeyEvent.VK_Y){
            characterPressed[24] = false;
        }
        if(key == KeyEvent.VK_Z){
            characterPressed[25] = false;
        }

        /**
         * For number input
         */
        if(key == KeyEvent.VK_0){
            characterPressed[26] = false;
        }
        if(key == KeyEvent.VK_1){
            characterPressed[27] = false;
        }
        if(key == KeyEvent.VK_2){
            characterPressed[28] = false;
        }
        if(key == KeyEvent.VK_3){
            characterPressed[29] = false;
        }
        if(key == KeyEvent.VK_4){
            characterPressed[30] = false;
        }
        if(key == KeyEvent.VK_5){
            characterPressed[31] = false;
        }
        if(key == KeyEvent.VK_6){
            characterPressed[32] = false;
        }
        if(key == KeyEvent.VK_7){
            characterPressed[33] = false;
        }
        if(key == KeyEvent.VK_8){
            characterPressed[34] = false;
        }
        if(key == KeyEvent.VK_9){
            characterPressed[35] = false;
        }
    }
}