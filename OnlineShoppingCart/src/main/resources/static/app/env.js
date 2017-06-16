/**
 * 
 */
/**
 * 
 */
(function (window) {
  window.__env = window.__env || {};
  //var osUrl = cloudapps-b488.oslab.opentlc.com;

  // API url
  //window.__env.authserviceUrl = 'http://localhost:8001';
  window.__env.authserviceUrl = 'http://authservice.cloudapps-b488.oslab.opentlc.com/';
  window.__env.catalogueserviceUrl = 'http://catalogueservice.cloudapps-b488.oslab.opentlc.com/';
  window.__env.orderserviceUrl = 'http://orderservice.cloudapps-b488.oslab.opentlc.com/';
  window.__env.shippingserviceUrl = 'http://shippingservice.cloudapps-b488.oslab.opentlc.com/';

  // Base url
  window.__env.baseUrl = '/';

  // Whether or not to enable debug mode
  // Setting this to false will disable console output
  window.__env.enableDebug = true;
}(this));
