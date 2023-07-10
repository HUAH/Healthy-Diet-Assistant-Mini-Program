
// pages/me/me.ts
var imgurl: string;
var niCheng: string;
var user_id: number;
var openID: string;
Page({
    /**
     * 页面的初始数据
     */
    data: {
        list: [],
        touxiang: '/images/me_black.png',
        nicheng: '未登录',
        // weight:'',
        // targetweight: '',
        height: '',
        gender: '',
    },
    denglu() {
        var that = this
        var user_id;
        //-----------------------------------------------------------------------------
        wx.login({
            success: function (res) {
                console.log(res)
                if (res.code) {
                    console.log('通过login接口的code换取openid')
                    wx.request({
                        url: 'https://api.weixin.qq.com/sns/jscode2session',
                        data: {
                            //填上自己的小程序唯一标识
                            appid: 'wx3534d588c5011cfb',
                            //填上自己的小程序的 app secret
                            secret: '1fe8202eb54a9130d7916396e721f38a',
                            grant_type: 'authorization_code',
                            js_code: res.code
                        },
                        method: 'GET',
                        header: { 'content-type': 'application/json' },
                        success: function (openIdRes) {
                            console.info("登录成功返回的openId：" + openIdRes.data.openid);
                            openID = openIdRes.data.openid
                        },
                        fail: function (error) {
                            console.info("获取用户openId失败");
                            console.info(error);
                        }
                    })
                }
            }
        }),
            //-----------------------------------------------------------------------------
            console.log(openID);
        wx.getUserProfile({
            desc: '用于完善个人信息',
            success(res) {
                console.log(res)
                that.setData({
                    touxiang: res.userInfo.avatarUrl,
                    nicheng: res.userInfo.nickName,
                    isLogin: true
                })
                imgurl = res.userInfo.avatarUrl;
                niCheng = res.userInfo.nickName;



                wx.request({
                    url: 'http://localhost:8888/searchuser',
                    method: 'GET',
                    data: { imgurl: imgurl },
                    success: function (res) {
                        var user = res.data;
                        console.log(user)
                        that.setData({
                            weight: res.data.weight,
                            fweight: res.data.fweight,
                            BMI: res.data.bmi.toFixed(2)
                        })
                        if (res.data.userID != null) {
                            user_id = res.data.userID
                            wx.setStorageSync("user_id", user_id)
                            wx.setStorageSync("isLogin", true)
                            wx.setStorageSync("imgurl", res.data.imgurl)
                        } else {
                            wx.request({
                                url: 'http://localhost:8888/insertuser',
                                method: 'POST',
                                data: { imgurl: imgurl, nickname: niCheng },
                                header: { "content-type": "application/x-www-form-urlencoded" },
                                success: function () {
                                    wx.request({
                                        url: 'http://localhost:8888/searchuser',
                                        method: 'GET',
                                        data: { imgurl: imgurl },
                                        success: function (res) {
                                            user_id = res.data.userID
                                            wx.setStorageSync("user_id", user_id)
                                            wx.setStorageSync("isLogin", true)
                                            wx.setStorageSync("imgurl", res.data.imgurl)
                                        }
                                    })
                                }
                            })

                        }
                    }
                })
            }
        })
    },
    //点击事件 跳转页面
    gopagesetting() {
        wx.navigateTo({
            url: '/pages/setting/setting',
        })
    },
    gopagemedetail() {
        wx.navigateTo({
            url: '/pages/medetail/medetail',
        })
    },
    /**
     * 生命周期函数--监听页面加载
     */
    onLoad() {
    },

    /**
     * 生命周期函数--监听页面初次渲染完成
     */
    onReady() {

    },

    /**
     * 生命周期函数--监听页面显示
     */
    onShow() {
        user_id = wx.getStorageSync("user_id");
        console.log(user_id);
        wx.request({
            url: 'http://localhost:8888/getData',
            method: 'GET',
            data: { userID: user_id },
            success: res => {
                console.log(res.data)
                this.setData({
                    weight: res.data.weight,
                    BMI: res.data.bmi.toFixed(2),
                })
            },
        })
    },

    /**
     * 生命周期函数--监听页面隐藏
     */
    onHide() {

    },

    /**
     * 生命周期函数--监听页面卸载
     */
    onUnload() {

    },

    /**
     * 页面相关事件处理函数--监听用户下拉动作
     */
    onPullDownRefresh() {

    },

    /**
     * 页面上拉触底事件的处理函数
     */
    onReachBottom() {

    },

    /**
     * 用户点击右上角分享
     */
    onShareAppMessage() {

    }
})