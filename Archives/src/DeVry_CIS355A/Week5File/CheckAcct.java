package Week5File;

import javax.swing.*;

//written by Bohdan Stryk - Senior Professor - Devry University - Phoenix, AZ
//email: bstryk@phx.devry.edu
//CIS355A-61747 - Aug 2013

public class CheckAcct extends Account

{ // start class

	// attributes

	private String strName;

	private String strAddress;

	private String strCSZ;

	private String strCheckAcctNum;

	private String strCheckAcctType;

	private String strCheckAcctDep;

	private String strCheckAcctBal;

	public CheckAcct() {
	}

	public CheckAcct(String strPassName, String strPassAddress,
			String strPassCSZ, String strPassCheckAcctNum,
			String strPassCheckAcctType, String strPassCheckAcctDep,
			String strPassCheckAcctBal) { // start constructor
		super();

		strName = strPassName;

		strAddress = strPassAddress;

		strCSZ = strPassCSZ;

		strCheckAcctNum = strPassCheckAcctNum;

		strCheckAcctType = strPassCheckAcctType;

		strCheckAcctDep = strPassCheckAcctDep;

		strCheckAcctBal = strPassCheckAcctBal;

	} // end constructor

	public String getStrName()

	{ // start getStrName()

		return strName;

	} // end getStrName()

	public String openCost()

	{ // start openCost()

		return "\nThere is no charge to open the account - IT IS FREE"
				+ "\nYou also get to pick a FREE GIFT - YEH!!!!";

	} // end openCost()

} // end class