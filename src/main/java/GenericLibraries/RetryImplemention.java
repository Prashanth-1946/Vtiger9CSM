package GenericLibraries;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryImplemention implements IRetryAnalyzer
{
	int maxRetries=3;
	int count=0;
	
	@Override
	public boolean retry(ITestResult result) 
	{
		if(count<maxRetries)
		{
			count++;
			return true;
		}
		
		return false;
	}

}
