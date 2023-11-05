package electricity_bill;
import java.io.*;
import java.util.*;
abstract class Plan
{
	protected double rate;
	abstract void getRate();
	public void calculateBill(int units)
	{
		System.out.println(units*rate);
	}
}
class DomesticPlan extends Plan
{
	public void getRate()
	{
		rate=3.50;
	}
}
class CommercialPlan extends Plan
{
	public void getRate()
	{
		rate=7.50;
	}
}
class InstitutionalPlan extends Plan
{
	public void getRate()
	{
		rate=5.50;
	}
}
class GetPlanFactory
{
	public Plan getPlan(String planType)
	{
		if(planType==null)
		{
			return null;
		}
		if(planType.equalsIgnoreCase("DOMESTICPLAN"))
		{
			return new DomesticPlan();
		}
		else if(planType.equalsIgnoreCase("COMMERCIALPLAN"))
		{
			return new CommercialPlan();
		}
		else if(planType.equalsIgnoreCase("INSTITUTIONALPLAN"))
		{
			return new InstitutionalPlan();
		}
		return null;
	}
}

public class Generate_bill {
	public static void main(String args[]) throws IOException
	{
		GetPlanFactory planFactory=new GetPlanFactory();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the name of plan");
		String planName=sc.next();
		System.out.println("Enter the number of units ");
		int units=sc.nextInt();
		Plan p=planFactory.getPlan(planName);
		System.out.println("Bill Amount for " +planName+ " of "+units+ " units is:");
		p.getRate();
		p.calculateBill(units);
	}
}
	