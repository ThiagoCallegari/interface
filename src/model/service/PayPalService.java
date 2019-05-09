package model.service;

public class PayPalService implements OnlinePaymentService {

	private static final double FEE_PERCENTAGE = 0.02;
	private static final double MONTHLY_INTEREST = 0.01;
	
	@Override
	public Double paymentFee(double amount) {
		return amount * FEE_PERCENTAGE;
	}
	
	@Override
	public Double interest(double amount, Integer months) {
		return amount * MONTHLY_INTEREST * months;
	}
}