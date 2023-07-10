var user_id: number;
var time: String;
var newtime: String;
Page({

    /**
     * 页面的初始数据
     */
    data: {
        list: [],
        Timelist: []
    },

    /**
     * 生命周期函数--监听页面加载
     */
    onLoad() {
        // weighthistory
        user_id = wx.getStorageSync("user_id");
        console.log("获取到缓存的user_id为", user_id);
        wx.request({
            url: 'http://localhost:8888/weighthistory',
            method: 'GET',
            data: { userID: user_id },
            success: res => {
                console.log(res.data)
                this.setData({
                    list: res.data,
                })
                for (let i in res.data) {
                    time = res.data[i].time;
                    newtime = time.substring(0, 10)
                    console.log(newtime);
                    this.data.Timelist[i] = newtime;
                    this.setData({
                        Timelist: this.data.Timelist
                    })
                    console.log(this.data.Timelist);
                }
            },
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