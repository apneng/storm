package storm;

import org.junit.Test;

public class Test01 {
/*	应纳个人所得税税额=应纳税所得额×适用税率-速算扣除数
			扣除标准3500元/月（2011年9月1日起正式执行）（工资、薪金所得适用）
			应纳税所得额=扣除三险一金后月收入-扣除标准
			全月应纳税所得额		税率			速算扣除数（元）
全月应纳税所得额不超过1500元		3%		0
全月应纳税所得额超过1500元至4500元
10%
105
全月应纳税所得额超过4500元至9000元
20%
555
全月应纳税所得额超过9000元至35000元
25%
1005
全月应纳税所得额超过35000元至55000元
30%
2755
全月应纳税所得额超过55000元至80000元
35%
5505
全月应纳税所得额超过80000元
45%
13505
*/
//	计算应缴纳的个人所得税
	public double suodeshui(double yuexin,double yishebao){
		//
		double suodeshui = 0;
		double gerensuodeer = yuexin -yishebao-3500 ;
		if(gerensuodeer<=0 ){
			gerensuodeer = 0;
			suodeshui = 0 ;
		}else if(gerensuodeer>0 && gerensuodeer<=1500){
			suodeshui = gerensuodeer*0.03;
		}else if(gerensuodeer>1500 && gerensuodeer<=4500){
			suodeshui = gerensuodeer*0.10-105;
		}else if(gerensuodeer>4500 && gerensuodeer<=9000){
			suodeshui = gerensuodeer*0.20-555;
		}else if(gerensuodeer>9000 && gerensuodeer<=35000){
			suodeshui = gerensuodeer*0.25-1005;
		}else if(gerensuodeer>35000 && gerensuodeer<=55000){
			suodeshui = gerensuodeer*0.30-2755;
		}else if(gerensuodeer>55000 && gerensuodeer<=80000){
			suodeshui = gerensuodeer*0.35-5505;
		}else if(gerensuodeer>80000){
			suodeshui = gerensuodeer*0.45-13505;
		}
		System.out.println("应纳税所得额"+gerensuodeer+"元");
		System.out.println("应纳税"+suodeshui+"元");
		System.out.println("实发薪资"+(yuexin-yishebao-suodeshui)+"元");
		return suodeshui;
	}

}
