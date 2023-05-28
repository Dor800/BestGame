public class Position implements Comparable<Position>{
    private Integer xAxis;
    private Integer yAxis;

    protected Position (Integer xAxis,Integer yAxis){
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }

    public Integer getxAxis() {
        return xAxis;
    }

    public void setxAxis(Integer xAxis) {
        this.xAxis = xAxis;
    }

    public Integer getyAxis() {
        return yAxis;
    }

    public void setyAxis(Integer yAxis) {
        this.yAxis = yAxis;
    }



    @Override
    public int compareTo(Position otherPosition) {
        if (this.xAxis.equals(otherPosition.xAxis)) {
            return this.yAxis.compareTo(otherPosition.yAxis);
        } else {
            return this.xAxis.compareTo(otherPosition.xAxis);
        }
    }
}
