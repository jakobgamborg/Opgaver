/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package population;
public class DanishTown implements Comparable<DanishTown>{
    private String cityName;
    private int population2012;
    private int population2018;

    public DanishTown(String cityName, int population2012, int population2018) {
        this.cityName = cityName;
        this.population2012 = population2012;
        this.population2018 = population2018;
    }

    private int getDiff(){
        return population2018 - population2012;
    }

    @Override
    public String toString() {
        return "\n" + cityName + " dif:" + " " + getDiff();
    }

    @Override
    public int compareTo(DanishTown o) {
        int i = this.getDiff() - o.getDiff();
        if(i == 0){
            i = this.cityName.compareTo(o.cityName);
        }
        return i;
    }

}
