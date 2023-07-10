// pages/detail/detail.ts
var datalist:[];
Page({

    /**
     * 页面的初始数据
     */
    data: {
        list :[],
        timelist:[]
    },

    /**
     * 生命周期函数--监听页面加载
     */
    onLoad (options:any) {
        
        let showdata = options.id
        console.log(showdata);

        var that = this
        wx.request({
            url: 'http://localhost:8888/foodforid', //仅为示例，并非真实的接口地址
            data: { foodID : showdata}  ,
            success (res) {
              console.log(res.data)
              that.setData({
                list : res.data, //将获取的数据赋值给data里的list
              })
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