// pages/medetail/medetail.ts
var weight: number;
var fweight: number;
var height: number;
var old: number;
var radio: number;
var BMI: number;
var gender: number;

var user_id: number;
var isLogin: false;
Page({
    onLoad() {
        isLogin = wx.getStorageSync("isLogin");
        if (isLogin !== true) {
            wx.showModal({
                title: '请先登录',
                success(res) {
                    if (res.confirm) {
                        console.log('用户点击确定')
                        wx.reLaunch({
                            url: '/pages/me/me',
                        })
                    }
                }
            })
        }
        user_id = wx.getStorageSync("user_id");
        console.log("获取到缓存的user_id为", user_id);
    },
    data: {

    },
    gender(e: any) {
        gender = e.detail.value
        console.log(gender);

    },
    onChangeheight(event: any) {
        height = event.detail
        console.log(height);
    },
    onChangeweight(event: any) {
        weight = event.detail
        console.log(weight);
    },
    onChangefweight(event: any) {
        fweight = event.detail
        console.log(fweight);
    },
    onChangeold(event: any) {
        old = event.detail
        console.log(old);
    },
    onChangeBMI(event: any) {
        BMI = event.detail
        console.log(BMI);
    },
    save() {
        wx.request({
            url: 'http://localhost:8888/save',
            method: 'POST',
            data: { height: height, weight: weight, fweight: fweight, age: old, BMI: BMI, gender: gender, userID: user_id },
            header: { "content-type": "application/x-www-form-urlencoded" },
            success(res) {
                console.log(res.data)
                wx.showToast({
                    title: '保存成功',
                    icon: 'success',
                    duration: 2000
                })

                // let pages = getCurrentPages(); //获取当前页面js里面的pages里的所有信息。
                // let prevPage = pages[pages.length - 2];
                // prevPage.setData({  // 将我们想要传递的参数在这里直接setData。上个页面就会执行这里的操作。
                //     weight: weight,
                //     fweight:fweight,
                //     BMI:BMI
                // })
                //该部分执行后，会在上一个页面内执行setData操作，将我们选择好的数据保存下来。当我们返回去的时候，页面已经处理完毕，将选择的数据绑定到对应的参数上。

                wx.navigateBack({
                    delta: 1  // 返回上一级页面。
                })

                // wx.navigateBack({
                //     delta: 1,
                // })
            },
            fail(err) {
                console.error(err)
            }
        })
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