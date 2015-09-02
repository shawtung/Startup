/* 	@Deprecated
    public LuckyMoney getLucymoney(LuckyOrder order) {
        LuckyMoney money = new LuckyMoney();
        long orderId = Long.parseLong(order.getOrderId());
        OrderInfo orderInfo = orderInfoMapper.getOrderInfo(orderId);//查询订单（状态已确认）
        if (orderInfo == null) {
            money.setAmount(0);
            money.setNum(0);
            return money;
        }
        long orderInfoId = orderInfo.getId();
        money = luckyMoneyMapper.findByOrderId(orderInfoId);//当前订单已经获得红包
        if (null != money) {
            return money;
        }

        long userId = orderInfo.getOrder_user_tid();
        money = luckyMoneyMapper.findByUserId(userId);//当前用户已经获得红包
        if (null != money) {
            money.setAmount(0);
            money.setNum(0);
            return money;
        }
        money = new LuckyMoney();
        List<OrderInfo> orderInfos = orderInfoMapper.getOrdersByUserId(userId);//确认是否只有一个订单
        money.setLucky_order_tid(orderId);
        money.setLucky_user_tid(userId);
        if (orderInfos.size() == 1) {
            luckMoney(money, orderInfo);
            UserInfo userInfo = userInfoMapper.getUserInfo(userId);
            double account = userInfo.getAccount();
            BillListInfo billListInfo = new BillListInfo();
            billListInfo.setAmount(money.getAmount() * money.getNum());
            billListInfo.setAccount_type_id(ACCOUNT_TYPE_ID);
            billListInfo.setChannel(1);
            billListInfo.setOid(orderInfoId);
            billListInfo.setOperator(1);
            billListInfo.setRemainder(account);
            billListInfo.setUser_tid(userId);
            billListInfo.setCreate_date(fromeFormat.format(new Date()));
            billListInfo.setRemark(REMARK);
            billListInfoMapper.save(billListInfo);
            money.setCreate_time(fromeFormat.format(new Date()));
            try {
                luckyMoneyMapper.save(money);
            } catch (Exception ex) {
                L.error(order.getOrderId(), ex);
            }
        } else {
            money.setAmount(0);
            money.setNum(0);
        }


        return money;
    }
*/