

<tr>
<td class="shopcharthead"><br></td>
<td class="shopcharthead"><app:storeMessage key="shoppingItems.text.onHand"/></td>
<td class="shopcharthead" align="center"><app:storeMessage key="shoppingItems.text.maxOrderQty"/></td>
<td class="shopcharthead"><app:storeMessage key="shoppingItems.text.orderQty"/></td>
  <%
  String showDistInventory = ShopTool.getShowDistInventoryCode(request);
  if(RefCodeNames.DIST_INVENTORY_DISPLAY.SHOW_FLAG.equals(showDistInventory) ||
     RefCodeNames.DIST_INVENTORY_DISPLAY.SHOW_QUANTITIES.equals(showDistInventory)) {
  %>
<td class="shopcharthead"><app:storeMessage key="shoppingItems.text.distInv"/></td>
  <% } %>
<td class="shopcharthead"><app:storeMessage key="shoppingItems.text.ourSkuNum"/></td>
<td class="shopcharthead"><app:storeMessage key="shoppingItems.text.productName"/></td>
<td class="shopcharthead"><app:storeMessage key="shoppingItems.text.size"/></td>
<td class="shopcharthead"><app:storeMessage key="shoppingItems.text.pack"/></td>
<td class="shopcharthead"><app:storeMessage key="shoppingItems.text.uom"/></td>
<td class="shopcharthead"><app:storeMessage key="shoppingItems.text.color"/></td>
<td class="shopcharthead"><app:storeMessage key="shoppingItems.text.price"/></td>
<td class="shopcharthead"><app:storeMessage key="shoppingItems.text.amount"/></td>
<% if (appUser.getUserAccount().isShowSPL()) { %>
<td class="shopcharthead"><app:storeMessage key="shoppingItems.text.spl"/></td>
<%} %>


</tr>
