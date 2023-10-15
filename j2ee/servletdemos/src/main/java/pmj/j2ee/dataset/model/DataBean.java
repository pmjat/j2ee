package pmj.j2ee.dataset.model;

public class DataBean {
   public DataBean() {
       data = new DataSet();
   }

   public void setAdd(double x) {
       data.add(x);
   }

   public double getAverage() {
       return data.getAverage();
   }
   
   public double getMaximum() {
      return data.getMaximum();
   }

   public void setReset(boolean flag) {
       if ( flag )
           data.reset();
   }
   
   private final DataSet data;
   
}
