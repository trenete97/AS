package com.junit.demo;


public class Interval {
		
		public int hi;
		public int mi;
		public int hf;
		public int mf;
		
		  
		 public Interval (int hii,int mii,int hfi,int mfi) {
		  if ((hii < 0 || hii > 24)||(hfi < 0 || hfi > 24))throw new ArithmeticException();
		  if ((mii < 0 || mii > 59)||(mfi < 0 || mfi > 59))throw new ArithmeticException();
		  if (hii > hfi || (hii == hfi && mii > mfi)) throw new ArithmeticException();
		  if ((hii == 24 && mii > 0)||(hfi == 24 && mfi > 0))throw new ArithmeticException();
		  hi = hii;
		  mi = mii;
		  hf = hfi;
		  mf = mfi;
		 }
		 public int temps (int hii,int mii,int hfi,int mfi) {
			 if ((hii < 0 || hii > 24)||(hfi < 0 || hfi > 24))throw new ArithmeticException();
			 if ((mii < 0 || mii > 59)||(mfi < 0 || mfi > 59))throw new ArithmeticException();
			 if ((hii == 24 && mii > 0)||(hfi == 24 && mfi > 0))throw new ArithmeticException();
			 if (hii > hfi || (hii == hfi && mii > mfi)) return (hii*60+mii)-(hfi*60+mfi);
			 return (hfi*60+mfi)-(hii*60+mii);
			 }
		 
		 public String periode (int hii,int mii,int hfi,int mfi) {
			if ((hii < 0 || hii > 24)||(hfi < 0 || hfi > 24))throw new ArithmeticException();
			if ((mii < 0 || mii > 59)||(mfi < 0 || mfi > 59))throw new ArithmeticException();
			if ((hii == 24 && mii > 0)||(hfi == 24 && mfi > 0))throw new ArithmeticException();
			if((hii >= 8 && (hii < 12 ||(hii == 12 && mii == 0)))&& (hfi >= 8 && (hfi < 12 ||(hfi == 12 && mfi == 0)))){    
				if (hii > hfi || (hii == hfi && mii > mfi)) return "Més d'un periode";
				else return "Matí";
			}
			else if(((hii > 12 || (hii == 12 && mii > 0)) && (hii < 20 ||(hii == 20 && mii == 0)))&& ((hfi > 12 || (hfi == 12 && mfi > 0)) && (hfi < 20 ||(hfi == 20 && mfi == 0)))){   
				if (hii > hfi || (hii == hfi && mii > mfi)) return "Més d'un periode";
				else return "Tarda";
			}
				
			else if(((hii > 20|| (hii == 20 && mii > 0)) && hii < 8)&& ((hfi > 20|| (hfi == 20 && mfi > 0)) && hfi < 8)){
				if (hii > hfi || (hii == hfi && mii > mfi)) return "Més d'un periode";
				else return "Nit";
			 }
			else return "Més d'un periode";
		}
}
