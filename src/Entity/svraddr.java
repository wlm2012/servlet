package Entity;


public class svraddr {

    private String Msg;
    private String Status;
    private String EnName;
    private String TimeOut;
    private String Name;
    private String DTA;
    private String PartInst;
    private String Tenant;
    private String RetCode;
    private String Version;
    private String SvrName;
    private String ProtocolType;
    private String NodeId;
    public COM_HTTP COM_HTTP;
    private String PartId;
    private String PartVersion;

    public String getMsg() {
        return Msg;
    }

    public void setMsg(String msg) {
        Msg = msg;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getEnName() {
        return EnName;
    }

    public void setEnName(String enName) {
        EnName = enName;
    }

    public String getTimeOut() {
        return TimeOut;
    }

    public void setTimeOut(String timeOut) {
        TimeOut = timeOut;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDTA() {
        return DTA;
    }

    public void setDTA(String DTA) {
        this.DTA = DTA;
    }

    public String getPartInst() {
        return PartInst;
    }

    public void setPartInst(String partInst) {
        PartInst = partInst;
    }

    public String getTenant() {
        return Tenant;
    }

    public void setTenant(String tenant) {
        Tenant = tenant;
    }

    public String getRetCode() {
        return RetCode;
    }

    public void setRetCode(String retCode) {
        RetCode = retCode;
    }

    public String getVersion() {
        return Version;
    }

    public void setVersion(String version) {
        Version = version;
    }

    public String getSvrName() {
        return SvrName;
    }

    public void setSvrName(String svrName) {
        SvrName = svrName;
    }

    public String getProtocolType() {
        return ProtocolType;
    }

    public void setProtocolType(String protocolType) {
        ProtocolType = protocolType;
    }

    public String getNodeId() {
        return NodeId;
    }

    public void setNodeId(String nodeId) {
        NodeId = nodeId;
    }

    public svraddr.COM_HTTP getCOM_HTTP() {
        return COM_HTTP;
    }

    public void setCOM_HTTP(svraddr.COM_HTTP COM_HTTP) {
        this.COM_HTTP = COM_HTTP;
    }

    public String getPartId() {
        return PartId;
    }

    public void setPartId(String partId) {
        PartId = partId;
    }

    public String getPartVersion() {
        return PartVersion;
    }

    public void setPartVersion(String partVersion) {
        PartVersion = partVersion;
    }

    public static class COM_HTTP {
        private String IfKeepAlive;
        private String Port;
        private String QueryStr;
        private String HostName;
        private String URL;

        public String getIfKeepAlive() {
            return IfKeepAlive;
        }

        public void setIfKeepAlive(String ifKeepAlive) {
            IfKeepAlive = ifKeepAlive;
        }

        public String getPort() {
            return Port;
        }

        public void setPort(String port) {
            Port = port;
        }

        public String getQueryStr() {
            return QueryStr;
        }

        public void setQueryStr(String queryStr) {
            QueryStr = queryStr;
        }

        public String getHostName() {
            return HostName;
        }

        public void setHostName(String hostName) {
            HostName = hostName;
        }

        public String getURL() {
            return URL;
        }

        public void setURL(String URL) {
            this.URL = URL;
        }


    }

}


