/**
 * 
 */
/**
 * 
 */
(function (window) {
  window.__env = window.__env || {};

  // API url
  //window.__env.authserviceUrl = 'http://localhost:8001';
  window.__env.authserviceUrl = 'http://authservice-shoppingcart.cloudapps-5614.oslab.opentlc.com/';
  window.__env.catalogueserviceUrl = 'http://catalogueservice-shoppingcart.cloudapps-5614.oslab.opentlc.com/';
  window.__env.orderserviceUrl = 'http://orderservice-shoppingcart.cloudapps-5614.oslab.opentlc.com/';
  window.__env.shippingserviceUrl = 'http://shippingservice-shoppingcart.cloudapps-5614.oslab.opentlc.com/';

  // Base url
  window.__env.baseUrl = '/';

  // Whether or not to enable debug mode
  // Setting this to false will disable console output
  window.__env.enableDebug = true;
}(this));
