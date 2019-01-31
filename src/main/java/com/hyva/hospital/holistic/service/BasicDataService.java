package com.hyva.hospital.holistic.service;

import com.hyva.hospital.holistic.entities.*;
import com.hyva.hospital.holistic.respositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BasicDataService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    CountryRepository countryRepository;
    @Autowired
    PosFormSetupRepository posFormSetupRepository;
    @Autowired
    PosStateRepository posStateRepository;
    @Autowired
    CategoriesRepository categoriesRepository;
    @Autowired
    PosCurrencyRepository posCurrencyRepository;
    @Autowired
    CityRepository cityRepository;
    @Autowired
    SmsConfiguratorRepository smsConfiguratorRepository;
    @Autowired
    UOMRepository uomRepository;
    @Autowired
    GeneralSettingsRepository generalSettingsRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    SMSServerRepository smsServerRepository;
    @Autowired
    ServicesRepository servicesRepository;

    public void insertBasicData() throws Exception {
        //============================================= User ======================================================================
        List<Users> userList = (List<Users>) userRepository.findAll();
        if (userList.isEmpty()) {
            Users userObj = new Users();
            userObj.setEmail("");
            userObj.setFirstName("admin");
            userObj.setUsername("admin");
            userObj.setPhoneNumber("");
//            userObj.setSecurityAnswer("");
//            userObj.setSecurityQuestion("");
//            userObj.setStatus("Active");
            userObj.setPassword("admin");
            userObj.setRetypepassword("admin");
            userObj.setFlagType("admin");
            userObj.setFlag('1');
            userRepository.save(userObj);


        }

    }

    public  void pushBasicData(){
        List<FormSetUp> formSetUpList = posFormSetupRepository.findAll();
        if (formSetUpList.isEmpty()) {
            insertFormSetUp("AppointmentNumber", "HLC", "00100", true, "AR","");
            insertFormSetUp("InvoiceNumber", "INV", "00000", true, "AR","");
        }

//    List<Country> countryList = countryRepository.findAll();
//    if (countryList.isEmpty()) {
//        insertCountryDate("India");
//        insertCountryDate("Europe");
//        insertCountryDate("Malaysia");
//        insertCountryDate("Indonesia");
//        insertCountryDate("Singapore");
//        insertCountryDate("Thailand");
//        insertCountryDate("USA");
//        insertCountryDate("England");
//        insertCountryDate("Australia");
//        insertCountryDate("Srilanka");
//        insertCountryDate("Pakistan");
//        insertCountryDate("Brunei");
//    }
//
//    List<State> stateList = posStateRepository.findAll();
//    if (stateList.isEmpty()) {
//        insertStateDate("Andra Pradesh","India");
//        insertStateDate("Telangana","India");
//        insertStateDate("Arunachal Pradesh","India");
//        insertStateDate("Assam","India");
//        insertStateDate("Bihar","India");
//        insertStateDate("Chhattisgarh","India");
//        insertStateDate("Goa","India");
//        insertStateDate("Gujarat","India");
//        insertStateDate("Haryana","India");
//        insertStateDate("Himachal Pradesh","India");
//        insertStateDate("Jammu and Kashmir","India");
//        insertStateDate("Jharkhand","India");
//        insertStateDate("Karnataka","India");
//        insertStateDate("Kerala","India");
//        insertStateDate("Madya Pradesh","India");
//        insertStateDate("Maharashtra","India");
//        insertStateDate("Manipur","India");
//        insertStateDate("Meghalaya","India");
//        insertStateDate("Mizoram","India");
//        insertStateDate("Nagaland","India");
//        insertStateDate("Orissa","India");
//        insertStateDate("Punjab","India");
//        insertStateDate("Rajasthan","India");
//        insertStateDate("Sikkim","India");
//        insertStateDate("Tamil Nadu","India");
//        insertStateDate("Uttaranchal","India");
//        insertStateDate("Uttar Pradesh","India");
//        insertStateDate("West Bengal","India");
//        insertStateDate("Andaman and Nicobar Islands","India");
//        insertStateDate("Chandigarh","India");
//        insertStateDate("Dadar and Nagar Haveli","India");
//        insertStateDate("Daman and Diu","India");
//
//
//    }


//     List<City> cityList = cityRepository.findAll();
//    if (cityList.isEmpty()) {
//        insertCityDate("Bengaluru","Karnataka","India");
//        insertCityDate("Afzalpur","Karnataka","India");
//        insertCityDate("Ainapur","Karnataka","India");
//        insertCityDate("Aland","Karnataka","India");
//        insertCityDate("Alur","Karnataka","India");
//        insertCityDate("Anekal","Karnataka","India");
//        insertCityDate("Ankola","Karnataka","India");
//        insertCityDate("Arsikere","Karnataka","India");
//        insertCityDate("Athani","Karnataka","India");
//        insertCityDate("Aurad","Karnataka","India");
//        insertCityDate("Bableshwar","Karnataka","India");
//        insertCityDate("Badami","Karnataka","India");
//        insertCityDate("Bagalkot","Karnataka","India");
//        insertCityDate("Bagepalli","Karnataka","India");
//        insertCityDate("Bailhongal","Karnataka","India");
//        insertCityDate("Bangarpet","Karnataka","India");
//        insertCityDate("Bantwal","Karnataka","India");
//        insertCityDate("Basavakalyan","Karnataka","India");
//        insertCityDate("Basavanabagewadi","Karnataka","India");
//        insertCityDate("Basavapatna","Karnataka","India");
//        insertCityDate("Belgaum","Karnataka","India");
//        insertCityDate("Bellary","Karnataka","India");
//        insertCityDate("Belthangady","Karnataka","India");
//        insertCityDate("Belur","Karnataka","India");
//        insertCityDate("Bhadravati","Karnataka","India");
//        insertCityDate("Bhalki","Karnataka","India");
//        insertCityDate("Bhatkal","Karnataka","India");
//        insertCityDate("Bidar","Karnataka","India");
//        insertCityDate("Bijapur","Karnataka","India");
//        insertCityDate("Biligi","Karnataka","India");
//        insertCityDate("Chadchan","Karnataka","India");
//        insertCityDate("Challakere","Karnataka","India");
//        insertCityDate("Chamrajnagar","Karnataka","India");
//        insertCityDate("Channagiri","Karnataka","India");
//        insertCityDate("Channapatna","Karnataka","India");
//        insertCityDate("Channarayapatna","Karnataka","India");
//        insertCityDate("Chickmagalur","Karnataka","India");
//        insertCityDate("Chikballapur","Karnataka","India");
//        insertCityDate("Chikkaballapur","Karnataka","India");
//        insertCityDate("Chikkanayakanahalli","Karnataka","India");
//        insertCityDate("Chikkodi","Karnataka","India");
//        insertCityDate("Chikmagalur","Karnataka","India");
//        insertCityDate("Chincholi","Karnataka","India");
//        insertCityDate("Chittapur","Karnataka","India");
//        insertCityDate("Chitradurga","Karnataka","India");
//        insertCityDate("Cowdahalli","Karnataka","India");
//        insertCityDate("Davanagere","Karnataka","India");
//        insertCityDate("Deodurga","Karnataka","India");
//        insertCityDate("Devangere","Karnataka","India");
//        insertCityDate("Devarahippargi","Karnataka","India");
//        insertCityDate("Dharwad","Karnataka","India");
//        insertCityDate("Doddaballapur","Karnataka","India");
//        insertCityDate("Gadag","Karnataka","India");
//        insertCityDate("Gangavathi","Karnataka","India");
//        insertCityDate("Gokak","Karnataka","India");
//        insertCityDate("Gowribdanpur","Karnataka","India");
//        insertCityDate("Gubbi","Karnataka","India");
//        insertCityDate("Gulbarga","Karnataka","India");
//        insertCityDate("Gundlupet","Karnataka","India");
//        insertCityDate(" H.B.Halli","Karnataka","India");
//        insertCityDate(" H.D. Kote","Karnataka","India");
//        insertCityDate("Haliyal","Karnataka","India");
//        insertCityDate("Harapanahalli","Karnataka","India");
//        insertCityDate("Hassan","Karnataka","India");
//        insertCityDate("Haveri","Karnataka","India");
//        insertCityDate("Hebri","Karnataka","India");
//        insertCityDate("Hirekerur","Karnataka","India");
//        insertCityDate("Hiriyur","Karnataka","India");
//
//    }



        List<ServiceCategories> categoriesList = categoriesRepository.findAll();
        if (categoriesList.isEmpty()) {
            insertCategoryDate("Ayurveda");
//            insertCategoryDate("Naturopathy");
//        insertCategoryDate("Unani");
            insertCategoryDate("Prophetic Medicine");
            insertCategoryDate("Consultation");
            insertCategoryDate("Nature Cure treatment");
//        insertCategoryDate("Yoga");
//        insertCategoryDate("Homeopathy");
//        insertCategoryDate("Acupuncture");
//        insertCategoryDate("Physiotherapy");
//        insertCategoryDate("Diet");
//        insertCategoryDate("nutrition");
    }


        List<UnitOfMeasurement> uomList = uomRepository.findAll();
        if (uomList.isEmpty()) {
            insertuom("ml");
            insertuom("gm");
            insertuom("no.");
            insertuom("mg");
        }

        List<Services> services = servicesRepository.findAll();
        if (services.isEmpty()) {
            insertservices("Abhyangam","Ayurveda",1400);
            insertservices("Avgaham","Ayurveda",1200);
            insertservices("greevavasthi","Ayurveda",500);
            insertservices("Januvasthi","Ayurveda",500);
            insertservices("Kadivasthi","Ayurveda",500);
            insertservices("Lepam Bandage","Ayurveda",700);
            insertservices("Naranga kizhi","Ayurveda",2000);
            insertservices("Naranga kizhi Half","Ayurveda",1000);
            insertservices("Nasyam","Ayurveda",350);
            insertservices("Njavarakizhi","Ayurveda",3000);
            insertservices("Pizhichil","Ayurveda",3600);
            insertservices("Podi Kizhi","Ayurveda",600);
            insertservices("Podi Kizhi Half","Ayurveda",450);
            insertservices("Shirodhara","Ayurveda",2000);
            insertservices("Steam bath","Ayurveda",400);
            insertservices("Thakra dhara","Ayurveda",1800);
            insertservices("Thalapothichil(Head message)","Ayurveda",1800);
            insertservices("Tharpanam","Ayurveda",1200);
            insertservices("Udwardhanam","Ayurveda",1800);
            insertservices("Utharavasthi","Ayurveda",1800);
            insertservices("Massage+ steam ","Nature Cure treatment ",1200);
            insertservices("Hip bath Jacuzzi","Nature Cure treatment",300);
            insertservices("Circular jet bath ","Nature Cure treatment",250);
            insertservices("Mud bath","Nature Cure treatment",500);
            insertservices("Steam","Nature Cure treatment",200);
            insertservices("Sauna","Nature Cure treatment",300);
            insertservices("Vibro massage/powder","Nature Cure treatment",800);
            insertservices("Cupping Therapy (Hijama)","Prophetic Medicine",1500);

        }

        List<Roles> rolesList = roleRepository.findAll();
        if (rolesList.isEmpty()) {
            insertRoles("User");
            insertRoles("Patient");
        }
        List<Settings> settingsList = generalSettingsRepository.findAll();
        if (settingsList.isEmpty()) {
            insertgeneral("Holistic Life Care","hlcecity@gmail.com","http://holisticlifecare.in/","","DMY");
        }



        List<Currency> currencyList = posCurrencyRepository.findAll();
        if (currencyList.isEmpty()) {
            getCurrencyObject("INR", "Rupee", "Indian Rupee", "Rs");
            getCurrencyObject("MYR", "Ringgit", "Malaysian ringgit", "RM");
            getCurrencyObject("BND", "Brunei Dollar", "Brunei Dollar", "B$");
            getCurrencyObject("IDR", "Ruphiah", "Indonesia Ruphiah", "Rp");
            getCurrencyObject("SGD", "Singapore Dollar", "Singapore Dollar", "S$");
            getCurrencyObject("THB", "Thai Baht", "Thai Baht", "B");
            getCurrencyObject("USD", "US Dollar", "US Dollar", "$");
            getCurrencyObject("EUR", "Euro", "Euro", "€");
            getCurrencyObject("GBP", "Pound", "Pound Sterling", "£");
        }
        List<SMSServer> smsServers = smsServerRepository.findAll();
        if (smsServers.isEmpty()) {
            getSmsServerObject("http://sms.hyvaitsolutions.com/api/v4/", "A71210d6e04ce8f4edaba269004814b74", "HVAGPS");
        }
    }

    public void insertFormSetUp(String typename, String typeprefix, String nextref, boolean include_date, String transactionType,String smsMessage) {
        FormSetUp c = new FormSetUp();
        c.setTypename(typename);
        c.setTypeprefix(typeprefix);
        c.setNextref(nextref);
        c.setTransactionType(transactionType);
        c.setInclude_date(include_date);
        c.setSmsId(addSmsConfigurator(smsMessage,"true"));
        posFormSetupRepository.save(c);
    }
    private Long addSmsConfigurator(String message,String enableSms){
        SmsConfigurator smsConfigurator=new SmsConfigurator();
        smsConfigurator.setMessage(message);
        smsConfigurator.setEnableSms(enableSms);
        smsConfiguratorRepository.save(smsConfigurator);
        return smsConfigurator.getSmsId();
    }


    public void getSmsServerObject(String smsUrl, String  apiKey, String senderId) {
        SMSServer smsServer = new SMSServer();
        smsServer.setSmsUrl(smsUrl);
        smsServer.setApiKey(apiKey);
        smsServer.setSenderId(senderId);
        smsServerRepository.save(smsServer);
    }

//    public void insertCountryDate(String countryName){
//        Country country=new Country();
//        country.setCountryName(countryName);
//        country.setStatus("Active");
//        countryRepository.save(country);
//    }
//
//    public void insertStateDate(String stateName,String countryName){
//        State state=new State();
//        state.setStateName(stateName);
//        state.setCountryName(countryName);
//        state.setStatus("Active");
//        posStateRepository.save(state);
//    }
//   public void insertCityDate(String cityName,String stateName,String countryName){
//        City city=new City();
//       city.setCityName(cityName);
//       city.setStateName(stateName);
//       city.setCountryName(countryName);
//       city.setStatus("Active");
//        cityRepository.save(city);
//    }

    public void insertCategoryDate(String Name){
        ServiceCategories serviceCategories =new ServiceCategories();
        serviceCategories.setName(Name);
        categoriesRepository.save(serviceCategories);
    }
    public void insertRoles(String name){
        Roles roles=new Roles();
        roles.setName(name);
        roleRepository.save(roles);
    }
    public void insertuom(String Name){
        UnitOfMeasurement unitOfMeasurement=new UnitOfMeasurement();
        unitOfMeasurement.setUnitOfMeasurementName(Name);
        unitOfMeasurement.setUnitOfMeasurementStatus("Active");
        uomRepository.save(unitOfMeasurement);
    }

    private void insertservices(String name,String categoryName,double price) {
        Services insertservices = new Services();
        insertservices.setName(name);
        insertservices.setPrice(price);
        ServiceCategories serviceCategories=categoriesRepository.findAllByName(categoryName);
        insertservices.setIdservicecategories(serviceCategories);
//        insertservices.setPrice(price);
        servicesRepository.save(insertservices);
    }


    public void insertgeneral(String companyName,String companyEmail,String companyLink, String googleAnalyticsID,String dateFormat){
        Settings settings=new Settings();
        settings.setCompanyName(companyName);
        settings.setCompanyEmail(companyEmail);
        settings.setCompanyLink(companyLink);
        settings.setGoogleAnalyticsID(googleAnalyticsID);
        settings.setDateFormat(dateFormat);
        generalSettingsRepository.save(settings);
    }


    public void getCurrencyObject(String currencyCode, String currencyDescription, String currencyName, String currencySymbol) {


        Currency curObj = new Currency();
        curObj.setCurrencyCode(currencyCode);
        curObj.setCurrencyDescription(currencyDescription);
        curObj.setCurrencyName(currencyName);
        curObj.setCurrencySymbol(currencySymbol);
        posCurrencyRepository.save(curObj);
    }

}


















