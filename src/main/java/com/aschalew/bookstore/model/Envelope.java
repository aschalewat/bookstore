package com.aschalew.bookstore.model;

        import javax.xml.bind.annotation.XmlAccessType;
        import javax.xml.bind.annotation.XmlAccessorType;
        import javax.xml.bind.annotation.XmlElement;
        import javax.xml.bind.annotation.XmlRootElement;
        import javax.xml.bind.annotation.XmlType;



@XmlRootElement(name = "rcems")
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(propOrder = {"message", "response", "responseAcknowledge", "digitalSignature"})
public class Envelope {
    private Message message;
    private Response response;
    private ResponseAcknowledge responseAcknowledge;
    private String digitalSignature;



    @XmlElement(name = "rcemsMsg")
    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    @XmlElement(name = "rcemsSgn")
    public String getDigitalSignature() {
        return digitalSignature;
    }

    public void setDigitalSignature(String digitalSignature) {
        this.digitalSignature = digitalSignature;
    }

    @XmlElement(name = "rcemsTrxSubResp")
    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    @XmlElement(name = "rcemsTrxSubReqAck")
    public ResponseAcknowledge getResponseAcknowledge() {
        return responseAcknowledge;
    }

    public void setResponseAcknowledge(ResponseAcknowledge responseAcknowledge) {
        this.responseAcknowledge = responseAcknowledge;
    }

    @XmlType(name="rcemsMsg")
    public static class Message {
        private OperatorDetail operatorDetail;
        private TransactionInfo transactionInfo;


        @XmlElement(name = "OprtDtl")
        public OperatorDetail getOperatorDetail() {
            return operatorDetail;
        }

        public void setOperatorDetail(OperatorDetail operatorDetail) {
            this.operatorDetail = operatorDetail;
        }

        @XmlElement(name = "TrxInfo")
        public TransactionInfo getTransactionInfo() {
            return transactionInfo;
        }

        public void setTransactionInfo(TransactionInfo transactionInfo) {
            this.transactionInfo = transactionInfo;
        }

        @XmlType(name="OprtDtl")
        public static class OperatorDetail {
            private String operatorCode;
            private String resultUrl;


            @XmlElement(name = "OprtCode")
            public String getOperatorCode() {
                return operatorCode;
            }

            public void setOperatorCode(String operatorCode) {
                this.operatorCode = operatorCode;
            }

            @XmlElement(name = "ResultUrl")
            public String getResultUrl() {
                return resultUrl;
            }

            public void setResultUrl(String resultUrl) {
                this.resultUrl = resultUrl;
            }
        }

    }


    @XmlType(name = "rcemsTrxSubResp")
    public static class Response {

        private String OperatorTransactionId;
        private String statusCode;

        @XmlElement(name = "OprtTrxId")
        public String getOperatorTransactionId() {
            return OperatorTransactionId;
        }

        public void setOperatorTransactionId(String operatorTransactionId) {
            OperatorTransactionId = operatorTransactionId;
        }

        @XmlElement(name = "TrxStsCode")
        public String getStatusCode() {
            return statusCode;
        }

        public void setStatusCode(String statusCode) {
            this.statusCode = statusCode;
        }
    }

    @XmlType(name = "rcemsTrxSubReqAck")
    public static class ResponseAcknowledge {

        private String statusCode;


        @XmlElement(name = "TrxStsCode")
        public String getStatusCode() {
            return statusCode;
        }

        public void setStatusCode(String statusCode) {
            this.statusCode = statusCode;
        }
    }

}





