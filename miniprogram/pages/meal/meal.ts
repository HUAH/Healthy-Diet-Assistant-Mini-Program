// meal/meal.ts
Page({

    /**
     * 页面的初始数据
     */
    data: {
        list:[],
    },

    /**
     * 生命周期函数--监听页面加载
     */
    onLoad() {
        wx.request({
            url:'http://localhost:8888/meal',
            method:'GET',
            success: res => {
                console.log(res.data)
              this.setData({ 
                  list: res.data,
              })
            },
        })
    },
    gomealdetial(e:any){
        var mealID = e.currentTarget.dataset.id; 
        console.log(mealID);
        wx.navigateTo({
            url: '../mealdetial/mealdetial?mealID=' + mealID
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