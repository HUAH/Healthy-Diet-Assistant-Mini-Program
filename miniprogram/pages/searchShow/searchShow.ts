// pages/searchShow/searchShow.ts
Page({

    /**
     * 页面的初始数据
     */
    data: {

    },

    /**
     * 生命周期函数--监听页面加载
     */
    onLoad(options: any) {
        let showdata = options.name
        console.log(showdata);
        var that = this
        wx.request({
            url: 'http://localhost:8888/classifyfood',
            data: { eigenvalue: showdata },
            success(res) {
                console.log(res.data)
                //   showdata = res.data
                that.setData({
                    list: res.data, //将获取的数据赋值给data里的list
                })
            }
        })

    },
    godetial(e:any){
        var id = e.currentTarget.dataset['id'];
        console.log("111111"+id)
        wx.navigateTo({
            url:'../detail/detail?id='+id
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