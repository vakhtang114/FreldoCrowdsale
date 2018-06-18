pragma solidity ^0.4.23;

contract DbgHelper {
    
    uint8 constant DBG_PRESALE_PERIOD_VALUE = 0;
    uint8 constant DBG_SALE_1_PERIOD_VALUE = 1;
    uint8 constant DBG_SALE_2_PERIOD_VALUE = 2;
    uint8 constant DBG_SALE_3_PERIOD_VALUE = 3;
    uint8 constant DBG_SALE_4_PERIOD_VALUE = 4;
    uint8 constant DBG_CROWDSALE_PERIOD_VALUE = 5;
    uint8 constant DBG_CLOSED_SALE_PERIOD_VALUE = 128;
    
    uint8 constant DBG_DISABLE = 254;
    
    uint8 dbgPeriodValue;
    
    constructor () public
    {
        dbgPeriodValue = DBG_PRESALE_PERIOD_VALUE;
    }

    function dbgStartPresale() public      {
        dbgPeriodValue = DBG_PRESALE_PERIOD_VALUE;
    }
    
    function dbgStartSaleOne() public      {
        dbgPeriodValue = DBG_SALE_1_PERIOD_VALUE;
    }
    
    function dbgStartSaleTwo() public  {
        dbgPeriodValue = DBG_SALE_2_PERIOD_VALUE;
    }
    
    function dbgStartSaleThree() public  {
        dbgPeriodValue = DBG_SALE_3_PERIOD_VALUE;
    }
    
     function dbgStartSaleFour() public  {
        dbgPeriodValue = DBG_SALE_4_PERIOD_VALUE;
    }
    
     function dbgStartCrowdsale() public  {
        dbgPeriodValue = DBG_CROWDSALE_PERIOD_VALUE;
    }
    
    
    function dbgCloseSale() public       {
        dbgPeriodValue = DBG_CLOSED_SALE_PERIOD_VALUE;
    }
    
    function dbgDisabled() public  {
        dbgPeriodValue = DBG_DISABLE;
    }
    
    
    function isDbgClosedSale() public view returns (bool)     {
        return dbgPeriodValue == DBG_CLOSED_SALE_PERIOD_VALUE;
    }
    
    
    function isDbgPresale() public view returns (bool)     {
        return dbgPeriodValue == DBG_PRESALE_PERIOD_VALUE;
    }
    
    function isDbgSaleOne() public view returns (bool)     {
        return dbgPeriodValue == DBG_SALE_1_PERIOD_VALUE;
    }
    
    function isDbgSaleTwo() public view returns (bool)     {
        return dbgPeriodValue == DBG_SALE_2_PERIOD_VALUE;
    }
    
    function isDbgSaleThree() public view returns (bool)     {
        return dbgPeriodValue == DBG_SALE_3_PERIOD_VALUE;
    }
    
    function isDbgSaleFour() public view returns (bool)     {
        return dbgPeriodValue == DBG_SALE_4_PERIOD_VALUE;
    }
    
    
    function isDbgCrowdsale() public view returns (bool)     {
        return dbgPeriodValue == DBG_CROWDSALE_PERIOD_VALUE;
    }
    
    function isDbgSaleOpened() public view returns (bool)
    {
        return (( DBG_PRESALE_PERIOD_VALUE <= dbgPeriodValue) && (dbgPeriodValue <= DBG_CROWDSALE_PERIOD_VALUE));
    }
    
    function isDbgEnabled() public view returns (bool)     {
        return dbgPeriodValue != DBG_DISABLE;
    }
    
    function isDbgDisabled() public  view returns (bool)     {
        return dbgPeriodValue == DBG_DISABLE;
    }
    
}
