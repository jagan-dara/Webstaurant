//package Common
//
//import Common.Enums.Gateway
//import geb.Browser
//import spock.lang.Shared
//
//class BaseUrlHolder {
//
//    /**
//     * Dynamically adjusted and not the same as initial config
//     */
//    @Shared
//    static browserConfig = new Browser().config.rawConfig
//
//    @Shared
//    static env = System.properties['geb.env']
//
//    static String buildGatewayUrl(Gateway gateway, boolean ignoreGateway = false) {
//        if (env in ['local8080', "local4200"]) {
//            if(gateway == Gateway.ADMIN_GATEWAY) {
//                return "http://localhost:8096"
//            } else if(gateway == Gateway.EMPLOYER_GATEWAY) {
//                return "http://localhost:8095"
//            } else if(gateway == Gateway.MEMBER_GATEWAY) {
//                return "http://localhost:8080"
//            } else if(gateway == Gateway.PROVIDER_GATEWAY) {
//                return "http://localhost:8093"
//            } else if(gateway == Gateway.CSR_GATEWAY){
//                return "http://localhost:8097"
//            }
//            return getNewBaseUrl()
//        }
//
//        if (env == 'localProxyDev') {
//            return gateway.value + getNewBaseAPIUrl()
//        }
//
//        if(ignoreGateway){
//            return gateway.value + getNewBaseUrl().toString().substring(getNewBaseUrl().toString().indexOf("-")+1, getNewBaseUrl().toString().length())
//        }
//
//        return gateway.value + getNewBaseUrl()
//    }
//
//    static String buildApiUrl() {
//        if (env in ['local8080', "local4200" ]) {
//            return getNewBaseAPIUrl()
//        }
//
//        return Gateway.SERVICE.value + getNewBaseAPIUrl()
//    }
//
//
//
//    static setBaseUrl(url){
//        browserConfig.baseUrl = url
//    }
//
//    static setBaseAPIUrl(url){
//        browserConfig.baseAPIUrl = url
//    }
//
//    static getNewBaseUrl(){
//        return browserConfig.baseUrl
//    }
//
//    static getNewBaseAPIUrl(){
//        return browserConfig.baseAPIUrl
//    }
//
//    static setPackageName(name){
//        browserConfig.packageName = name
//    }
//
//    static  getPackageName(){
//        return browserConfig.packageName
//    }
//
//    static switchOurBaseUrlBasedOnPackage(String packageName, boolean isSecondaryLocal = false){
//        setPackageName(packageName)
//
//        def initialConfig = new Browser().config.rawConfig
//        def initialBaseUrl = initialConfig.baseUrl
//
//        println("This is our package name "+packageName)
//
//        if (!initialBaseUrl.toString().contains("local")) {
//            setBaseUrl(buildBaseUrlByPackage(packageName, initialBaseUrl))
//        } else {
//            def port = isSecondaryLocal ? initialConfig.secondaryBasePort : initialConfig.basePort
//            def baseUrl = "${initialBaseUrl}:${port}"
//            def configApiUrl = initialConfig.baseAPIUrl ? initialConfig.baseAPIUrl : baseUrl
//            def baseApiUrl = configApiUrl.toString().contains("local") ? configApiUrl : buildBaseApiUrlByPackage(packageName, configApiUrl)
//            setBaseUrl(baseUrl)
//            setBaseAPIUrl(baseApiUrl)
//        }
//
//        return getNewBaseUrl().toString()
//    }
//
//    static buildBaseUrlByPackage(String packageName, String baseUrl) {
//        switch (packageName) {
//            case ~/^(?i).*Specs*/:
//                return "https://mail.$baseUrl"
//            case ~/^(?i).*MemberApp.*/:
//                return "https://member-$baseUrl"
//            case ~/^(?i).*providergateway.*/:
//                return "https://provider-$baseUrl"
//            case ~/^(?i).*choosebindportal.*/:
//                return "https://choosebind-$baseUrl"
//            case ~/^(?i).*prod.*/:
//                return "https://choosebind$baseUrl"
//            case ~/^(?i).*employerportal.*/:
//            case ~/^(?i).*EmployerGateway.*/:
//                return "https://employers-$baseUrl"
//            case ~/^(?i).*AdminPortal.*/:
//                return "https://admin-$baseUrl"
//            case ~/^(?i).*csrportal.*/:
//            case ~/^(?i).*CsrGateway.*/:
//            case ~/^(?i).*CsrApp.*/:
//                return "https://help-$baseUrl"
//            default:
//                return "https://member-$baseUrl"
//        }
//    }
//
//    static buildBaseApiUrlByPackage(String packageName, String baseUrl) {
//        switch (packageName) {
//            case ~/^(?i).*MemberApp.*/:
//                return "https://services-$baseUrl"
//            default:
//                return buildBaseUrlByPackage(packageName, baseUrl)
//        }
//    }
//}