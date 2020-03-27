public class Door {
    public static int pCount = 0;
    public static boolean up = false;
    //        boolean down =false;
    public static boolean paused = true;
    public static StringBuilder str = new StringBuilder();
    public static String run(String events) {
        for (int i = 0; i < events.length(); i++) {
            if (pCount >= 5 || pCount <= 0) {
                paused = true;
            }
            switch (events.charAt(i)) {
                case '.':
                    checkStates();
                    break;
                case 'P':
                    up = !up;
                    paused = !paused;
                    checkStates();
                    break;
                case 'O':
                    up = !up;
                    checkStates();
                    break;
            }
        }
        return str.toString();
    }
    public static void checkStates(){
        if (paused){
        }else{
            if(up) pCount += 1;
            else pCount -= 1;
        }
        str.append(pCount);
    }
}

















//public class Door {
//    public static String run(String events) {
//        StringBuilder str = new StringBuilder();
//        int pCount = 0;
//        boolean up = false;
//        boolean down =false;
////      ...
////      000
////      ...P.......
////      00012345555
////      P.P..
////      12222
//
////        P.O....
////        1210000
//        for (int i = 0; i < events.length(); i++ ){
//            switch(events.charAt(i)){
//                case '.':
//
//                    if(up && pCount < 5){
//                        pCount ++;
//                    }
//                    else if(down && pCount>0){
//                        pCount --;
//                    }
//                    str.append(pCount);
//                    break;
//                case 'P':
//                    up = !up;
//                    if(up) {
//                        pCount ++;
//                    }
//                    if(pCount==5){
//                    down=true;
//                    }
//                    if(down) {
//                        pCount --;
//                    }
//                    str.append(pCount);
//                    break;
//                case 'O':
//                    if (up){
//                        down = true;
//                        up=false;
//                        pCount --;
//                    }
//                    else if (down){
//                        down = false;
//                        up = true;
//                        pCount++;
//                    }
//                    str.append(pCount);
//                    break;
//            }
//        }
//        return str.toString();
//    }
//}