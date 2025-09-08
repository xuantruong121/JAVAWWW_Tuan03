package iuh.fit.se.lab03jsp_session.beans;

import java.util.ArrayList;

public class CartBean {
    private ArrayList<CartItemBean> alCartItems = new ArrayList<>();
    private double dblOrderTotal;

    public int getLineItemCount() {
        return alCartItems.size();
    }

    public void deleteCartItem(String strItemIndex) {
        int iItemIndex = 0;
        try {
            iItemIndex = Integer.parseInt(strItemIndex);
            alCartItems.remove(iItemIndex - 1);
            calculateOrderTotal();
        } catch (NumberFormatException nfe) {
            System.out.println("Error while deleting cart item: " + nfe.getMessage());
        }
    }

    public void updateCartItem(String strItemIndex, String strQuantity) {
        double dblTotalCost = 0.0;
        double dblUnitCost = 0.0;
        int iQuantity = 0;
        int iItemIndex = 0;
        CartItemBean cartItem = null;
        try {
            iItemIndex = Integer.parseInt(strItemIndex);
            iQuantity = Integer.parseInt(strQuantity);
            if (iQuantity > 0) {
                cartItem = (CartItemBean) alCartItems.get(iItemIndex - 1);
                dblUnitCost = cartItem.getUnitCost();
                dblTotalCost = dblUnitCost * iQuantity;
                cartItem.setQuantity(iQuantity);
                cartItem.setTotalCost(dblTotalCost);
                calculateOrderTotal();
            }
        } catch (NumberFormatException nfe) {
            System.out.println("Error while updating cart: " + nfe.getMessage());
        }
    }

    public void addCartItem(String strModelNo, String strDescription, String strUnitCost, String strQuantity) {
        double dblTotalCost = 0.0;
        double dblUnitCost = 0.0;
        int iQuantity = 0;
        try {
            dblUnitCost = Double.parseDouble(strUnitCost);
            iQuantity = Integer.parseInt(strQuantity);
            if (iQuantity > 0) {
                dblTotalCost = dblUnitCost * iQuantity;
                CartItemBean cartItem = new CartItemBean();
                cartItem.setPartNumber(strModelNo);
                cartItem.setModelDescription(strDescription);
                cartItem.setUnitCost(dblUnitCost);
                cartItem.setQuantity(iQuantity);
                cartItem.setTotalCost(dblTotalCost);
                alCartItems.add(cartItem);
                calculateOrderTotal();
            }
        } catch (NumberFormatException nfe) {
            System.out.println("Error while parsing from String to primitive types: " + nfe.getMessage());
        }
    }

    public void addCartItem(CartItemBean cartItem) {
        alCartItems.add(cartItem);
        calculateOrderTotal();
    }

    public CartItemBean getCartItem(int iItemIndex) {
        CartItemBean cartItem = null;
        if (alCartItems.size() > iItemIndex) {
            cartItem = (CartItemBean) alCartItems.get(iItemIndex);
        }
        return cartItem;
    }

    public ArrayList<CartItemBean> getCartItems() {
        return alCartItems;
    }

    public double getOrderTotal() {
        return dblOrderTotal;
    }

    protected void calculateOrderTotal() {
        double dblTotal = 0.0;
        for (int counter = 0; counter < alCartItems.size(); counter++) {
            CartItemBean cartItem = (CartItemBean) alCartItems.get(counter);
            dblTotal += cartItem.getTotalCost();
        }
        setOrderTotal(dblTotal);
    }

    public void setOrderTotal(double dblOrderTotal) {
        this.dblOrderTotal = dblOrderTotal;
    }
}