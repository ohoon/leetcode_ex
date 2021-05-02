/*
1603.
Design Parking System
https://leetcode.com/problems/design-parking-system/
*/

class ParkingSystem {

    private final int[] status = new int[3];        // 주차 자리 현황
    
    public ParkingSystem(int big, int medium, int small) {
        this.status[0] = big;
        this.status[1] = medium;
        this.status[2] = small;
    }
    
    public boolean addCar(int carType) {
        return status[carType - 1]-- > 0;           // 주차 자리가 있으면 true. 해당 자리는 1 감소
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */

/*
Runtime: 6 ms, faster than 99.92% of Java online submissions for Design Parking System.
Memory Usage: 39.8 MB, less than 21.07% of Java online submissions for Design Parking System.
*/
