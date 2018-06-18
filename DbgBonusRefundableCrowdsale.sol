pragma solidity ^0.4.23;

import "./DbgHelper.sol";

contract DbgBonusRefundableCrowdsale is BonusRefundableCrowdsale, DbgHelper {

   constructor(address _wallet, address _reservedFundsWallet, ERC20 _token) public  
    BonusRefundableCrowdsale(_wallet, _reservedFundsWallet, _token)
    DbgHelper()
    {   
    }
    
    function onlyWhileOpen() internal   {
        
     if (isDbgEnabled())
     {
       require(isDbgSaleOpened());
       return;
     }
    
      super.onlyWhileOpen();
    }

    /**
   * @dev Checks whether the period in which the crowdsale is open has already elapsed.
   * @return Whether crowdsale period has elapsed
   */
    function hasClosed() public view returns (bool) {
    
      if (isDbgEnabled())
        return isDbgClosedSale();
    
      return super.hasClosed();
    }

    
    // @dev Checks if current period is presale period 
    // @return true if current period is pre sale.
    function isPresale() internal constant returns (bool) {
        if (isDbgEnabled())
         return isDbgPresale();
        
        return super.isPresale();
    }
  
      // @dev Checks if current period is Sale One period 
      // @return true if current period is pre sale.
      function isSaleOne() internal constant returns (bool) {
         if (isDbgEnabled())
            return isDbgSaleOne();
         return super.isSaleOne();
      }
  
  // @dev Checks if current period is Sale Two period 
  // @return true if current period is pre sale.
  function isSaleTwo() internal constant returns (bool) {
    if (isDbgEnabled())
        return isDbgSaleTwo();
    
    return super.isSaleTwo();
  }
  
  // @dev Checks if current period is Sale Three period 
  // @return true if current period is pre sale.
  function isSaleThree() internal constant returns (bool) {
      if (isDbgEnabled())
        return isDbgSaleThree();
      return super.isSaleThree();
  }
  
  // @dev Checks if current period is Sale Four period 
  // @return true if current period is pre sale.
  function isSaleFour() internal constant returns (bool) {
      if (isDbgEnabled())
          return isDbgSaleFour();
      return super.isSaleFour();
  }
}
