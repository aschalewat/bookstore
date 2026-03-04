package com.aschalew.bookstore.model;

       import javax.xml.bind.annotation.XmlElement;
        import javax.xml.bind.annotation.XmlType;

@XmlType(name = "TrxInfo", propOrder = {"operatorTransactionId", "mobileNetworkOperatorTransactionId",
        "mobileNetworkOperatorName", "betAmount", "betDescription", "expectedWonAmount", "currency",
        "originalBetSlipNumber", "wonAmount", "bonus", "transactionDate", "playerMobileNumber",
        "betSlipNumber", "odds", "expectedBonus", "gameId", "shopId", "jackpot", "officeType",
        "status", "rsvd1", "rsvd2", "rsvd3", "rsvd4", "rsvd5"})
public class TransactionInfo {

    private String OperatorTransactionId;
    private String mobileNetworkOperatorTransactionId;
    private String mobileNetworkOperatorName;
    private Double betAmount;
    private String betDescription;
    private Double expectedWonAmount;
    private String currency;
    private String transactionDate;
    private String playerMobileNumber;
    private String betSlipNumber;
    private String originalBetSlipNumber;
    private Double odds;
    private Double expectedBonus;
    private String gameId;
    private String shopId;
    private boolean jackpot;
    private String officeType;
    private Status status;
    private Double wonAmount;
    private Double bonus;
    private String rsvd1;
    private String rsvd2;
    private String rsvd3;
    private String rsvd4;
    private String rsvd5;



    @XmlElement(name = "OprtTrxId")
    public String getOperatorTransactionId() {
        return OperatorTransactionId;
    }

    public void setOperatorTransactionId(String operatorTransactionId) {
        OperatorTransactionId = operatorTransactionId;
    }

    @XmlElement(name = "MnoTrxId")
    public String getMobileNetworkOperatorTransactionId() {
        return mobileNetworkOperatorTransactionId;
    }

    public void setMobileNetworkOperatorTransactionId(String mobileNetworkOperatorTransactionId) {
        this.mobileNetworkOperatorTransactionId = mobileNetworkOperatorTransactionId;
    }

    @XmlElement(name = "MnoName")
    public String getMobileNetworkOperatorName() {
        return mobileNetworkOperatorName;
    }

    public void setMobileNetworkOperatorName(String mobileNetworkOperatorName) {
        this.mobileNetworkOperatorName = mobileNetworkOperatorName;
    }

    @XmlElement(name = "BetAmt")
    public Double getBetAmount() {
        return betAmount;
    }

    public void setBetAmount(Double betAmount) {
        this.betAmount = betAmount;
    }

    @XmlElement(name = "BetDesc")
    public String getBetDescription() {
        return betDescription;
    }

    public void setBetDescription(String betDescription) {
        this.betDescription = betDescription;
    }

    @XmlElement(name = "ExpWonAmt")
    public Double getExpectedWonAmount() {
        return expectedWonAmount;
    }

    public void setExpectedWonAmount(Double expectedWonAmount) {
        this.expectedWonAmount = expectedWonAmount;
    }

    @XmlElement(name = "Ccy")
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @XmlElement(name = "TrxDtTm")
    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    @XmlElement(name = "PlyrCellNum")
    public String getPlayerMobileNumber() {
        return playerMobileNumber;
    }

    public void setPlayerMobileNumber(String playerMobileNumber) {
        this.playerMobileNumber = playerMobileNumber;
    }

    @XmlElement(name = "TktNum")
    public String getBetSlipNumber() {
        return betSlipNumber;
    }

    public void setBetSlipNumber(String betSlipNumber) {
        this.betSlipNumber = betSlipNumber;
    }

    @XmlElement(name = "Odds")
    public Double getOdds() {
        return odds;
    }

    public void setOdds(Double odds) {
        this.odds = odds;
    }

    @XmlElement(name = "ExpBonus")
    public Double getExpectedBonus() {
        return expectedBonus;
    }

    public void setExpectedBonus(Double expectedBonus) {
        this.expectedBonus = expectedBonus;
    }

    @XmlElement(name = "GameId")
    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    @XmlElement(name = "ShopId")
    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    @XmlElement(name = "Jackpot")
    public boolean isJackpot() {
        return jackpot;
    }

    public void setJackpot(boolean jackpot) {
        this.jackpot = jackpot;
    }

    @XmlElement(name = "OfficeType")
    public String getOfficeType() {
        return officeType;
    }

    public void setOfficeType(String officeType) {
        this.officeType = officeType;
    }

    @XmlElement(name = "Status")
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @XmlElement(name = "WonAmt")
    public Double getWonAmount() {
        return wonAmount;
    }

    public void setWonAmount(Double wonAmount) {
        this.wonAmount = wonAmount;
    }

    @XmlElement(name = "Bonus")
    public Double getBonus() {
        return bonus;
    }

    public void setBonus(Double bonus) {
        this.bonus = bonus;
    }

    public String getOriginalBetSlipNumber() {
        return originalBetSlipNumber;
    }

    @XmlElement(name = "OrgnTktNum")
    public void setOriginalBetSlipNumber(String originalBetSlipNumber) {
        this.originalBetSlipNumber = originalBetSlipNumber;
    }

    @XmlElement(name = "Rsvd1", required = true)
    public String getRsvd1() {
        return rsvd1;
    }

    public void setRsvd1(String rsvd1) {
        this.rsvd1 = rsvd1;
    }


    @XmlElement(name = "Rsvd2", required = true)
    public String getRsvd2() {
        return rsvd2;
    }

    public void setRsvd2(String rsvd2) {
        this.rsvd2 = rsvd2;
    }

    @XmlElement(name = "Rsvd3", required = true)
    public String getRsvd3() {
        return rsvd3;
    }

    public void setRsvd3(String rsvd3) {
        this.rsvd3 = rsvd3;
    }

    @XmlElement(name = "Rsvd4", required = true)
    public String getRsvd4() {
        return rsvd4;
    }

    public void setRsvd4(String rsvd4) {
        this.rsvd4 = rsvd4;
    }

    @XmlElement(name = "Rsvd5", required = true)
    public String getRsvd5() {
        return rsvd5;
    }

    public void setRsvd5(String rsvd5) {
        this.rsvd5 = rsvd5;
    }
}




