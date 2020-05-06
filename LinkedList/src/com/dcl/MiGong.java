package com.dcl;

/**
 * @author dcl
 * @date 2020/5/6 - 22:07
 */
public class MiGong {
    public static void main(String[] args) {
        //创建地图
        int[][] map = new int[8][7];
        for (int i = 0 ;i < 7;i++){
            map[0][i] = 1;
            map[7][i] = 1;
        }
        //设置墙体
        for (int i = 0 ; i < 8;i++){
            map[i][0] = 1;
            map[i][6] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;
        map[6][4] = 1;
        map[5][4] = 1;

        //打印地图
        for (int i=0;i < map.length;i++){
            for (int j = 0 ;j < map[0].length;j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }

        //探测法
        setWay(map,1,1);

        //打印探测路线
        System.out.println("-----------------------------");
        for (int i=0;i < map.length;i++){
            for (int j = 0 ;j < map[0].length;j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }

    /**
     * 回溯算法【探测法-递归】
     * 1.方法的出口是map[7][6] = 0;【如果小球到这个位置，成功】
     * 2.map[i][j]是小球的起始位置
     * 3.探测策略：下->右->上->左
     * 4.数字：1-->墙体  2-->该点为通路，可以走  3-->该点已经探测无法走通
     * @param map   地图
     * @param i     小球起始行
     * @param j     小球起始列
     * @return
     */
    public static boolean setWay(int[][] map,int i ,int j){
        if (map[6][5]==2){
            return true;
        }else {
            if (map[i][j] == 0){
                map[i][j] = 2;  //探测-假定当前的位置是可以走的,以当前的位置为起点，下右上左的探测
                if (setWay(map,i+1,j)){
                    return true; //如果下面的位置可以走，返回true
                }else if(setWay(map,i,j+1)){
                    return true; //如果下面的位置不能走，就走右边，右边可以走的话，返回true
                }else if(setWay(map,i-1,j)){
                    return true; //如果下左不能走，就走上边，如果上边可以走，就返回true
                }else if(setWay(map,i,j-1)){
                    return true; //如果下右上都不能走，就走左边，如果左边能走，就返回true
                }else{
                    //该点上下左右都不能走,将该点设为3-->表示这条路不通
                    map[i][j] = 3;
                    return false;
                }
            }else { //map[i][j]可能为1，2，3  1-->墙  2-->表示该点已经探测过了  3-->表示该点死路
                return false;
            }
        }
    }
}
